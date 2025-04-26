package com.example.book_library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book_library.Model.Author;
import com.example.book_library.dto.AuthorForm;
import com.example.book_library.services.AuthorService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute AuthorForm authorForm) {
        authorService.addAuthor(authorForm);
        return "redirect:/";
    }

    @GetMapping("/getAuthor{id}")
    public String getAuthor(@RequestParam("id") Integer id, Model model) {
        try {
            Author author = authorService.geAuthor(id);
            model.addAttribute("author", author);
            return "author";
        }
        catch(IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }

    @PostMapping("/removeAuthor{id}")
    public String removeAuthor(@RequestParam("id") Integer id) {
        authorService.removeAuthor(id);
        return "redirect:/";
    }
    
    

}
