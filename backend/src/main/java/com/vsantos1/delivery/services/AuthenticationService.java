package com.vsantos1.delivery.services;

import com.vsantos1.delivery.dtos.AuthDTO;
import com.vsantos1.delivery.dtos.TokenDTO;
import com.vsantos1.delivery.dtos.UserDTO;
import com.vsantos1.delivery.jwt.JwtService;
import com.vsantos1.delivery.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 365L; // 1 YEAR

    private final UserService userService;


    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenDTO register(UserDTO userDTO) {


        User user = userService.execute(userDTO);

        return new TokenDTO(accessToken(user), "", issuedAt(), expirationDate());

    }

    public TokenDTO authenticate(AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authDTO.getEmail(), authDTO.getPassword());
        authenticationManager.authenticate(auth);

        UserDetails user = userService.loadUserByUsername(authDTO.getEmail());

        return new TokenDTO(accessToken(user), "", issuedAt(), expirationDate());
    }

    public String accessToken(UserDetails user) {
        return jwtService.generateToken(user);
    }

    public Date expirationDate() {
        return new Date(issuedAt().getTime() + EXPIRATION_TIME);
    }

    public Date issuedAt() {
        return new Date();
    }
}
