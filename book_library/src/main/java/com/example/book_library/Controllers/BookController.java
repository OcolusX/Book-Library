package com.example.book_library.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;
import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.Storage.BookStorage;

import com.example.book_library.dto.BookForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookStorage bookStorage;
    private final AuthorStorage authorStorage;

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute BookForm bookForm) {
        String[] authorName = bookForm.getAuthor().split(" ");
        Author author = authorStorage.getByName(authorName[0], authorName[1]);
        if(author == null) {
            return "redirect:/";
        }
        Book book = new Book(
            bookForm.getTitle(),
            bookForm.getYear(),
            bookForm.getPages(),
            author
        );
        bookStorage.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/getBook{id}")
    public String getBook(@RequestParam("id") Integer id, Model model) {
        Book book = bookStorage.getById(id);
        model.addAttribute("book", book);

        return "book";
    }

    @PostMapping("/removeBook{id}")
    public String postMethodName(@RequestParam("id") Integer id) {
        bookStorage.removeBook(id);
        
        return "redirect:/";
    }

    @GetMapping("/getByTitle{title}")
    public String getByTitle(@RequestParam("title") String title, Model model) {
        Book book = bookStorage.getByTitle(title);
        if(book == null) {
            return "redirect:/";
        }

        model.addAttribute("book", book);
        return "book";
    }
    
}
