package com.ketan.hibernateinheritancemapping.joinedtable.services;

import com.ketan.hibernateinheritancemapping.dtos.UserDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.joinedtable.models.User;
import com.ketan.hibernateinheritancemapping.joinedtable.repositories.UserRepository;
import com.ketan.hibernateinheritancemapping.joinedtable.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("jtUserService")
public class UserService implements IUserService {
    private UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private UserDto convertUserToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    private User convertUserDtoToUser(UserDto userDto, User user){
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = convertUserDtoToUser(userDto, new User());
        User savedUser = userRepository.save(user);
        return convertUserToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return convertUserToUserDto(user);
        } else throw new NotFoundException("User with id " + id + " not found");
    }

    @Override
    public UserDto updateUserById(Long id, UserDto userDto) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = convertUserDtoToUser(userDto, optionalUser.get());
            User savedUser = userRepository.save(user);
            return convertUserToUserDto(savedUser);
        } else throw new NotFoundException("User with id " + id + " not found");
    }

    @Override
    public void deleteUserById(Long id) throws NotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else throw new NotFoundException("User with id " + id + " not found");
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(convertUserToUserDto(user));
        }
        return userDtos;
    }
}
