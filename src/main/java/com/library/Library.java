package com.library;

import java.util.ArrayList;
import java.util.HashMap;

/* 
 * 1. Books List
 * 2. addBook
 * 3. displayBooks
 * 4.showBorrowedBooks
 * 5. returnBook
 * 6. borrowBook
 */

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    // Map of userID to list of borrowed book IDs (for quick tracking)
    private HashMap<Integer, ArrayList<Integer>> borrowedBooksMap;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        borrowedBooksMap = new HashMap<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Remove a book from the library by bookID
    public void removeBook(int bookID) {
        books.removeIf(book -> book.getBookID() == bookID);
        System.out.println("Book with ID " + bookID + " removed.");
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    // Borrow a book: user borrows a book by IDs
    public boolean borrowBook(int userID, int bookID) {
        User user = findUserByID(userID);
        Book book = findBookByID(bookID);
        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return false;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return false;
        }

        user.borrowBook(book);
        borrowedBooksMap.putIfAbsent(userID, new ArrayList<>());
        borrowedBooksMap.get(userID).add(bookID);
        System.out.println(user.getName() + " borrowed " + book.getTitle());
        return true;
    }

    // Return a book: user returns a book by IDs
    public boolean returnBook(int userID, int bookID) {
        User user = findUserByID(userID);
        Book book = findBookByID(bookID);
        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return false;
        }
        if (!book.isBorrowed()) {
            System.out.println("Book was not borrowed.");
            return false;
        }

        user.returnBook(book);
        if (borrowedBooksMap.containsKey(userID)) {
            borrowedBooksMap.get(userID).remove((Integer) bookID);
        }
        System.out.println(user.getName() + " returned " + book.getTitle());
        return true;
    }

    // Search books by title
    public void searchBookByTitle(String title) {
        System.out.println("Search results for title \"" + title + "\":");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.displayBook();
            }
        }
    }

    // Search books by author
    public void searchBookByAuthor(String author) {
        System.out.println("Search results for author \"" + author + "\":");
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.displayBook();
            }
        }
    }

    // View all books
    public void viewBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            book.displayBook();
        }
    }

    // View all users
    public void viewUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            user.displayUser();
        }
    }

    // Find a user by userID
    private User findUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    // Find a book by bookID
    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }
}
