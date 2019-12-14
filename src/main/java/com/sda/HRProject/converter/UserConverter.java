package com.sda.HRProject.converter;

import com.sda.HRProject.dto.UserDto;
import com.sda.HRProject.model.User;

public class UserConverter {
    public static UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setIdUser(user.getIdUser());
        userDto.setUsername(user.getUsername());
        userDto.setPassword("******");
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUserType(user.getUserType());
        return userDto;
    }

    public static User convertBack(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUserType(user.getUserType());
        return user;
    }
}
