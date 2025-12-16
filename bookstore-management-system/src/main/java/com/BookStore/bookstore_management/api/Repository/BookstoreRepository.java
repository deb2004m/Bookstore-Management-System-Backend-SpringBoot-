package com.BookStore.bookstore_management.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookStore.bookstore_management.api.Model.BookStore;

public interface BookstoreRepository extends MongoRepository<BookStore, String> {

}
