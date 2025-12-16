package com.BookStore.bookstore_management.api.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookStore.bookstore_management.api.Model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
