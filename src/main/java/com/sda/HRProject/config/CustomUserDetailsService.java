package com.sda.HRProject.config;

import com.sda.HRProject.model.Role;
import com.sda.HRProject.model.User;
import com.sda.HRProject.service.RoleService;
import com.sda.HRProject.service.UserService;
import com.sda.HRProject.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(String.format("Username %s not found!", userName));
        }
        String password = user.getPassword();

        List<Role> roles = user.getRoleList();

        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorityList.add(grantedAuthority);
        }
        UserDetails userDetails = new CustomUserDetails(userName, password, authorityList
                , user.getIdUser(), user.getFirstName(), user.getLastName());
        return userDetails;
    }
}
