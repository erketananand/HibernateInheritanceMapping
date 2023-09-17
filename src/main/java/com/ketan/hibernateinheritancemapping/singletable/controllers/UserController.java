package com.ketan.hibernateinheritancemapping.singletable.controllers;

import com.ketan.hibernateinheritancemapping.dtos.UserDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.singletable.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("stUserController")
@RequestMapping("/singleTable/user")
public class UserController {

    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable("id") Long id, @RequestBody UserDto userDto) throws NotFoundException {
        return userService.updateUserById(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) throws NotFoundException {
        userService.deleteUserById(id);
    }
}
