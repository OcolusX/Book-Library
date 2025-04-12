package com.example.book_library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;
import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.Storage.MapAuthorStorage;
import com.example.book_library.dto.AuthorForm;
import com.example.book_library.services.AuthorService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorStorage authorStorage;

    
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute AuthorForm authorForm) {
        Author author = new Author(authorForm.getFirstName(), authorForm.getSecondName(), authorForm.getBirthday());
        authorStorage.addAuthor(author);
        return "redirect:/";
    }

    @GetMapping("/getAuthor{id}")
    public String getMethodName(@RequestParam("id") Integer id, Model model) {
        Author author = authorStorage.getById(id);
        model.addAttribute("author", author);

        return "author";
    }
    

}
