package co.istad.elearningapi.controller;

import co.istad.elearningapi.dto.RoleDto;
import co.istad.elearningapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{name}")
    RoleDto findByName(@PathVariable String name) {
        return roleService.findByName(name);
    }

}
