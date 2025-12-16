package com.BookStore.bookstore_management.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "books")
public class BookStore {
    @Id
    private String id;

    private String Book_title;
    private String Author;
    private String Genere;
    private String ISBN;
    private double Price;
    private String Description;
    private int StockQuantity;
    private String img_url;

}
