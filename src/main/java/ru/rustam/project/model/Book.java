package ru.rustam.project.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 ch")
    @NotEmpty(message = "Title cant be empty")
    private String title;
    @Size(min = 2, max = 30, message = "Author must be between 2 and 30 ch")
    @NotEmpty(message = "Author cant be empty")
    private String author;
    @Min(value = 1500, message = "Year should not be over 1500 year")
    @NotEmpty(message = "year cant be empty")
    private int year;
    private int id;
    private int id_owner;

    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
