package com.example.book_library.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.book_library.Model.Author;
import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.Storage.BookStorage;
import com.example.book_library.dto.AuthorForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final BookStorage bookStorage;
    private final AuthorStorage authorStorage;

    public Collection<Author> getAuthors() {
        return authorStorage.getAll();
    }

    public Integer getAouthorsCount() {
        return authorStorage.getAll().size();
    }

    public Author getByName(String firstName, String secondName) throws IllegalArgumentException {
        Author author = authorStorage.getByName(firstName, secondName);
        if(author == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        return author;
    }

    public void addAuthor(AuthorForm authorForm) {
        Author author = new Author(authorForm.getFirstName(), authorForm.getSecondName(), authorForm.getBirthday());
        authorStorage.addAuthor(author);
    }

    public Author geAuthor(Integer id) throws IllegalArgumentException {
        Author author = authorStorage.getById(id);
        if(author == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        return author;
    }

    
    public void removeAuthor(Integer id) {
        Author author = authorStorage.getById(id);
        bookStorage.removeByAuthor(author);

        authorStorage.removeAuthor(id);
    }
    
}
