package com.example.book_library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.Storage.BookStorage;
import com.example.book_library.dto.AuthorForm;
import com.example.book_library.dto.BookForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DefaultController {

    private final BookStorage bookStorage;
    private final AuthorStorage authorStorage;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("authorForm", new AuthorForm());
        model.addAttribute("booksCount", bookStorage.getAll().size());
        model.addAttribute("books", bookStorage.getAll());
        model.addAttribute("authors", authorStorage.getAll());
        return "index";
    }
    
}
