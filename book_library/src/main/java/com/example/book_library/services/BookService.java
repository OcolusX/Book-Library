package com.example.book_library.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;
import com.example.book_library.Storage.BookStorage;
import com.example.book_library.dto.BookForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final AuthorService authorService;
    private final BookStorage bookStorage;

    public Collection<Book> getBooks() {
        return bookStorage.getAll();
    }

    public Integer getBooksCount() {
        return bookStorage.getAll().size();
    }

    public void addBook(BookForm bookForm) throws IllegalArgumentException {
        String[] authorName = bookForm.getAuthor().split(" ");
        Author author = authorService.getByName(authorName[0], authorName[1]);
        Book book = new Book(
            bookForm.getTitle(),
            bookForm.getYear(),
            bookForm.getPages(),
            author
        );
        bookStorage.addBook(book);
    }

    public Book getBook(Integer id) throws IllegalArgumentException {
        Book book = bookStorage.getById(id);
        if(book == null) {
            throw new IllegalArgumentException("Книга не найдена");
        }
        return book;
    }

    public Book getBook(String title) throws IllegalArgumentException{
        Book book = bookStorage.getByTitle(title);
        if(book == null) {
            throw new IllegalArgumentException("Книга не найдена");
        }
        return book;
    }

    public void removeBook(Integer id) {
        bookStorage.removeBook(id);
    }

}
