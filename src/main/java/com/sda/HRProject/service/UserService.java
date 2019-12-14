package com.sda.HRProject.service;

import com.sda.HRProject.converter.UserConverter;
import com.sda.HRProject.dto.UserDto;
import com.sda.HRProject.model.User;
import com.sda.HRProject.repository.UserRepository;
import com.sda.HRProject.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDto> findAll(Integer page, Integer size) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> userDB = userRepository.findAll(PageRequest.of(page, size)).getContent();
        for (User user : userDB) {
            userDtos.add(UserConverter.convert(user));
        }
        return userDtos;
    }

    public User findById(Integer id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            User user = userById.get();
            return user;
        } else {
            throw new UserNotFoundException(String.format("No user found with the id: %s!", id));
        }
    }

    public User findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UserNotFoundException(String.format("No user found with the username: %s!", userName));
        }
        return user;
    }

    public List<User> findByFirstName(String firstName) {
        List<User> userList = userRepository.findByFirstName(firstName);
        if (userList.isEmpty()) {
            throw new UserNotFoundException(String.format("No users found with the first name: %s!", firstName));
        }
        return userList;
    }

    public List<User> findByLastName(String lastName) {
        List<User> userList = userRepository.findByLastName(lastName);
        if (userList.isEmpty()) {
            throw new UserNotFoundException(String.format("No users found with the last name: %s!", lastName));
        }
        return userList;
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(String.format("No user found with the email: %s!", email));
        }
        return user;
    }

    public List<User> addUser(User user) {
        List<User> userList = new ArrayList<>();
        user.setPassword(user.getPassword());
        userRepository.save(user);
        userRepository.findAll().forEach(c -> {
            userList.add(c);
        });
        return userList;
    }

    public List<User> updateUser(Integer id, User user) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            User user1 = userById.get();
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            user1.setUserType(user.getUserType());
            userRepository.save(user1);
            List<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(c -> {
                userList.add(c);
            });
            return userList;
        } else {
            throw new UserNotFoundException(String.format("No user found with the id: %s!", id));
        }
    }

    public List<User> deleteUser(Integer id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            userRepository.deleteById(id);
            List<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(c -> {
                userList.add(c);
            });
            return userList;
        } else {
            throw new UserNotFoundException(String.format("No user found with the id: %s!, id"));
        }
    }

    public long count() {
        return userRepository.count();
    }
}
