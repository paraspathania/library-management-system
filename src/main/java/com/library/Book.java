package com.library;
/*
 * All the things related to a books
 * 1. Name
 * 2. Author
 * 3. isBorrowed
 */
public class Book{
 private int bookID;
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor
    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // By default, book is available
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Mark the book as borrowed
    public void borrowBook() {
        isBorrowed = true;
    }

    // Mark the book as returned
    public void returnBook() {
        isBorrowed = false;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author +
            ", " + (isBorrowed ? "Currently Borrowed" : "Available"));
    }
}