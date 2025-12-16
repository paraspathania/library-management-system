package com.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private Book book;
    private User user;

    @Before
    public void setUp() {
        library = new Library();
        book = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald");
        user = new User(101, "Alice");
        library.addBook(book);
        library.registerUser(user);
    }

    @Test
    public void testBorrowBook() {
        // Initially, the book should not be borrowed
        assertFalse(book.isBorrowed());

        // Borrow the book
        boolean success = library.borrowBook(101, 1);

        // Assertions
        assertTrue("Borrowing should be successful", success);
        assertTrue("Book should be marked as borrowed", book.isBorrowed());
        assertTrue("User should have the borrowed book", user.getBorrowedBooks().contains(book));
    }

    @Test
    public void testReturnBook() {
        // Borrow first
        library.borrowBook(101, 1);
        assertTrue(book.isBorrowed());

        // Return the book
        boolean success = library.returnBook(101, 1);

        // Assertions
        assertTrue("Returning should be successful", success);
        assertFalse("Book should optionally be available", book.isBorrowed());
        assertFalse("User should not have the borrowed book", user.getBorrowedBooks().contains(book));
    }
}
