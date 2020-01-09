package com.sda.HRProject.service;

import com.sda.HRProject.model.Role;
import com.sda.HRProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        List<Role> roleList = new ArrayList<>();
        roleRepository.findAll().forEach(c -> {
            roleList.add(c);
        });
        return roleList;
    }

    public List<Role> findByRole(String username) {
        return roleRepository.findByRole(username);
    }

    public Role findById(Integer id) {
        Optional<Role> roleById = roleRepository.findById(id);
        if (roleById.isPresent()) {
            Role role = roleById.get();
            return role;
        } else {
            System.out.println("Role with id: " + id + " not found!");
        }
        return null;
    }

    public List<Role> addRole(Role role) {
        roleRepository.save(role);
        List<Role> roleList = new ArrayList<>();
        roleRepository.findAll().forEach(c -> {
            roleList.add(c);
        });
        return roleList;
    }

    public List<Role> updateRole(Integer id, Role role) {
        Optional<Role> roleById = roleRepository.findById(id);
        if (roleById.isPresent()) {
            Role role1 = roleById.get();
            role1.setRole(role.getRole());
            roleRepository.save(role1);
            List<Role> roleList = new ArrayList<>();
            roleRepository.findAll().forEach(c -> {
                roleList.add(c);
            });
            return roleList;
        } else {
            System.out.println("Role with id: " + id + " not found!");
        }
        return null;
    }

    public List<Role> deleteRole(Integer id) {
        Optional<Role> roleById = roleRepository.findById(id);
        if (roleById.isPresent()) {
            roleRepository.deleteById(id);
            List<Role> roleList = new ArrayList<>();
            roleRepository.findAll().forEach(c -> {
                roleList.add(c);
            });
            return roleList;
        } else {
            System.out.println("Role with id: " + id + " not found!");
        }
        return null;
    }

    public long count() {
        return roleRepository.count();
    }


}
