package com.BookStore.bookstore_management.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.bookstore_management.api.Model.BookStore;
import com.BookStore.bookstore_management.api.Service.BookstoreService;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookstoreService bookstoreService;

    private Map<String, BookStore> books = new HashMap<>();

    @GetMapping("/books")
    public ResponseEntity<BookStore> getAllBooks() {
        List<BookStore> all = bookstoreService.getAllBooks();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<BookStore> addBooks(@RequestBody BookStore myBook) {
        try {
            bookstoreService.saveBook(myBook);
            return new ResponseEntity<>(myBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookStore> getBookById(@PathVariable String id) {
        Optional<BookStore> books = bookstoreService.findById(id);
        if (books.isPresent()) {
            return new ResponseEntity<>(books.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookStore> updateBookstoreById(@PathVariable String id, @RequestBody BookStore newbook) {
        BookStore old = bookstoreService.findById(id).orElse(null);
        if (old != null) {
            old.setBook_title(
                    newbook.getBook_title() != null && !newbook.getBook_title().equals("") ? newbook.getBook_title()
                            : old.getBook_title());
            old.setAuthor(newbook.getAuthor() != null && !newbook.getAuthor().equals("") ? newbook.getAuthor()
                    : old.getAuthor());
            old.setISBN(newbook.getISBN() != null && !newbook.getISBN().equals("") ? newbook.getISBN() : old.getISBN());
            old.setPrice(newbook.getPrice() != 0.0 ? newbook.getPrice() : old.getPrice());
            old.setDescription(
                    newbook.getDescription() != null && !newbook.getDescription().equals("") ? newbook.getDescription()
                            : old.getDescription());
            old.setGenere(newbook.getGenere() != null && !newbook.getGenere().equals("") ? newbook.getGenere()
                    : old.getGenere());
            old.setStockQuantity(newbook.getStockQuantity() != 0 ? newbook.getStockQuantity() : old.getStockQuantity());
            bookstoreService.saveBook(old);
            return new ResponseEntity<>(old, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        bookstoreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
