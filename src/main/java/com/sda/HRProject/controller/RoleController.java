package com.sda.HRProject.controller;

import com.sda.HRProject.model.Role;
import com.sda.HRProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/all")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping(value = "/findByName/{name}")
    public List<Role> findByUsername(@PathVariable(name = "name") String username) {
        return roleService.findByRole(username);
    }

    @GetMapping(value = "/{id}")
    public Role findById(@PathVariable(name = "id") Integer id) {
        return roleService.findById(id);
    }

    @PostMapping(value = "")
    public List<Role> addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PutMapping(value = "/{id}")
    public List<Role> updateRole(@PathVariable(name = "id") Integer id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping(value = "/{id}")
    public List<Role> deleteRole(@PathVariable(name = "id") Integer id) {
        return roleService.deleteRole(id);
    }

    @GetMapping(value = "/count")
    public long count() {
        return roleService.count();
    }
}
