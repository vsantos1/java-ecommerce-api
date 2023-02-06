package com.vsantos1.delivery.services;

import com.vsantos1.delivery.dtos.UserDTO;
import com.vsantos1.delivery.jwt.JwtAuthenticationFilter;
import com.vsantos1.delivery.jwt.JwtService;
import com.vsantos1.delivery.model.Permission;
import com.vsantos1.delivery.model.User;
import com.vsantos1.delivery.repositories.PermissionRepository;
import com.vsantos1.delivery.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder, ModelMapper mapper, JwtService jwtService) {
        this.userRepository = userRepository;

        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.jwtService = jwtService;
    }


    public User execute(UserDTO userDTO) {

        try {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            User user = new User();
            mapper.map(userDTO, user);
            Permission userPerm = permissionRepository.findByDescription("ROLE_USER");
            List<Permission> permissions = new ArrayList<>();
            permissions.add(userPerm);
            user.setPermissions(permissions);

            // TODO: change this to dynamic
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
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

    public User update(Long id, UserDTO userDTO) {
        User user = findById(id);

        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            userDTO.setPassword(user.getPassword());
        }

        mapper.map(userDTO, user);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User loadUserByToken(String authorization) {
        String token = authorization.substring(7);
        return this.userRepository.findUserByEmail(jwtService.extractUsername(token));
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public Page<User> findAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }
}
