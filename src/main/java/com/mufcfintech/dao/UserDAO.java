package com.mufcfintech.dao;

import com.mufcfintech.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
