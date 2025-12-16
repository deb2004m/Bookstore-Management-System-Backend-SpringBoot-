package com.BookStore.bookstore_management.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BookStore.bookstore_management.api.Model.BookStore;
import com.BookStore.bookstore_management.api.Repository.BookstoreRepository;

@Component
public class BookstoreService {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    public void saveBook(BookStore book) {
        bookstoreRepository.save(book);
    }

    public List<BookStore> getAllBooks() {
        return bookstoreRepository.findAll();
    }

    public Optional<BookStore> findById(String id) {
        return bookstoreRepository.findById(id);
    }

    public void deleteById(String id) {
        bookstoreRepository.deleteById(id);

    }

}
