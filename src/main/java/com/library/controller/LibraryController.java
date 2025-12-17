package com.library.controller;

import com.library.Book;
import com.library.Library;
import com.library.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    private Library library;

    public LibraryController() {
        library = new Library();
        // Add some dummy data
        library.addBook(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(102, "1984", "George Orwell"));
        library.registerUser(new User(1, "Alice"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", library.getBooks());
        model.addAttribute("newBook", new Book(0, "", ""));
        return "index";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book) {
        library.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id) {
        // Simplified: Assume User 1 is always the borrower for this demo
        library.borrowBook(1, id);
        return "redirect:/";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable int id) {
        // Simplified: Assume User 1 is always the returner
        library.returnBook(1, id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        library.removeBook(id);
        return "redirect:/";
    }
}
