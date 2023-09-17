package com.ketan.hibernateinheritancemapping.singletable.services.interfaces;

import com.ketan.hibernateinheritancemapping.dtos.UserDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id) throws NotFoundException;
    UserDto updateUserById(Long id, UserDto userDto) throws NotFoundException;
    void deleteUserById(Long id) throws NotFoundException;
    List<UserDto> getAllUsers();
}
