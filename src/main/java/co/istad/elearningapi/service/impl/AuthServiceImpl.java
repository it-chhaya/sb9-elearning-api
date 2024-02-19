package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.RegisterDto;
import co.istad.elearningapi.dto.UserCreationDto;
import co.istad.elearningapi.mapper.UserMapper;
import co.istad.elearningapi.service.AuthService;
import co.istad.elearningapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;
    private final UserService userService;

    @Transactional
    @Override
    public Map<String, Object> register(RegisterDto registerDto) {

        if (!registerDto.password().equals(registerDto.confirmedPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Password doesn't match");
        }

        UserCreationDto userCreationDto = userMapper.mapRegisterDtoToUserCreationDto(registerDto);
        userService.createNew(userCreationDto);

        return Map.of(
                "message", "Please check email and verify",
                "email", registerDto.email()
        );
    }

}
