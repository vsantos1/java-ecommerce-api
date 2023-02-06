package com.vsantos1.delivery.services;

import com.vsantos1.delivery.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
