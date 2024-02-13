package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    RoleDto findByName(String name);

}
