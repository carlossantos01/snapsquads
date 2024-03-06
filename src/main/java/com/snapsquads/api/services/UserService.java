package com.snapsquads.api.services;

import com.snapsquads.api.domains.user.User;
import com.snapsquads.api.domains.user.UserDTO;
import com.snapsquads.api.domains.user.exceptions.UserNotFoundException;
import com.snapsquads.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User insert(UserDTO userDTO){
        User newUser = new User(userDTO);
        this.userRepository.save(newUser);
        return newUser;
    }

    public User getById(String id){
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
