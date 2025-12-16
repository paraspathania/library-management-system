package com.library;

import java.util.ArrayList;

public class User {
    private int userID;
    private String name;
    private ArrayList<Book> borrowedBooks; // List to keep track of books borrowed by the user

    // Constructor
    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook(); // Mark the book as borrowed
    }

    // Method to return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook(); // Mark the book as returned
    }

    // Display user details and their borrowed books
    public void displayUser() {
        System.out.println("User ID: " + userID + ", Name: " + name);
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed currently.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(" - " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
