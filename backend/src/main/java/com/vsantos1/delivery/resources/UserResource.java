package com.vsantos1.delivery.resources;


import com.vsantos1.delivery.dtos.UserDTO;
import com.vsantos1.delivery.model.User;
import com.vsantos1.delivery.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserResource {

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getById(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }
    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @GetMapping("/users/me")
    public ResponseEntity<User> getByToken(@RequestHeader String Authorization) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.loadUserByToken(Authorization));
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> update(@PathVariable("user_id") Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, userDTO));
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable("user_id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

