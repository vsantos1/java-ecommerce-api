package com.vsantos1.delivery.repositories;

import com.vsantos1.delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
}
