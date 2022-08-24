package com.movietime.mongodb.repositories;

import com.movietime.mongodb.models.EnumRole;
import com.movietime.mongodb.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(EnumRole roleName);
}
