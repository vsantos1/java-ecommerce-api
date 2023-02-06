package com.vsantos1.delivery.resources;

import com.vsantos1.delivery.dtos.AuthDTO;
import com.vsantos1.delivery.dtos.TokenDTO;
import com.vsantos1.delivery.dtos.UserDTO;
import com.vsantos1.delivery.model.User;
import com.vsantos1.delivery.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticationResource {

    private final AuthenticationService authenticationService;

    public AuthenticationResource(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;

    }

    @PostMapping("/register")
    public ResponseEntity<TokenDTO> register(@RequestBody @Valid UserDTO userDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthDTO authDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authenticationService.authenticate(authDTO));
    }
}
