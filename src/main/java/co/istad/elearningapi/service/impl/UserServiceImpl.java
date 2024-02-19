package co.istad.elearningapi.service.impl;

import co.istad.elearningapi.dto.UserCreationDto;
import co.istad.elearningapi.mapper.UserMapper;
import co.istad.elearningapi.model.Role;
import co.istad.elearningapi.model.User;
import co.istad.elearningapi.repository.RoleRepository;
import co.istad.elearningapi.repository.UserRepository;
import co.istad.elearningapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void createNew(UserCreationDto userCreationDto) {

        User user = userMapper.fromUserCreationDto(userCreationDto);
        user.setIsDeleted(false);
        user.setIsVerified(false);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Email is already existed!");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Username is already existed!");
        }

        Set<Role> roles = new HashSet<>();
        userCreationDto.roleNames().forEach(name -> {
            Role role = roleRepository.findByName(name)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Invalid role!"
                    ));
            roles.add(role);
        });

        user.setRoles(roles);
        userRepository.save(user);
    }
}
