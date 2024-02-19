package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.RegisterDto;

import java.util.Map;

public interface AuthService {

    Map<String, Object> register(RegisterDto registerDto);

}
