package com.example.book_library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book_library.Model.Book;

import com.example.book_library.dto.BookForm;
import com.example.book_library.services.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute BookForm bookForm) {
        try {
            bookService.addBook(bookForm);
            return "redirect:/";
        }
        catch(IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }

    @GetMapping("/getBook{id}")
    public String getBook(@RequestParam("id") Integer id, Model model) {
        try {
            Book book = bookService.getBook(id);
            model.addAttribute("book", book);
            return "book";
        }
        catch(IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }

    // TODO: добавить обработку исключения
    @PostMapping("/removeBook{id}")
    public String removeBook(@RequestParam("id") Integer id) {
        bookService.removeBook(id);
        return "redirect:/";
    }

    @GetMapping("/getByTitle{title}")
    public String getByTitle(@RequestParam("title") String title, Model model) {
        try {
            Book book = bookService.getBook(title);
            model.addAttribute("book", book);
            return "book";
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }
    
}
