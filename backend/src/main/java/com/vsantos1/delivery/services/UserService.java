package com.vsantos1.delivery.services;

import com.vsantos1.delivery.dtos.UserDTO;
import com.vsantos1.delivery.jwt.JwtAuthenticationFilter;
import com.vsantos1.delivery.model.Permission;
import com.vsantos1.delivery.model.User;
import com.vsantos1.delivery.repositories.PermissionRepository;
import com.vsantos1.delivery.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public UserService(UserRepository userRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.userRepository = userRepository;

        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }


    public User execute(UserDTO userDTO) {

        try {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            User user = new User();
            mapper.map(userDTO, user);
            Permission userP = permissionRepository.findById(2L).orElseThrow(() -> new RuntimeException("Permission not found"));
            List<Permission> permissions = new ArrayList<>();
            permissions.add(userP);
            user.setPermissions(permissions);
            return userRepository.save(user);

        } catch (Exception e) {
            // TODO: handle exception properly
            throw new RuntimeException("Email already exists");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found");


    }
}
