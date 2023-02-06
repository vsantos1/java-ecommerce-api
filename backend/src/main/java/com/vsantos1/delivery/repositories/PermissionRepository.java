package com.vsantos1.delivery.repositories;

import com.vsantos1.delivery.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByDescription(String description);
}
