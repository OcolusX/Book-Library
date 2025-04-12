package com.example.book_library.services;

import org.springframework.stereotype.Service;

import com.example.book_library.Model.Author;
import com.example.book_library.Storage.AuthorStorage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class AuthorService {

    private final AuthorStorage authorStorage;

    public void addAuthor(Author author) {
        authorStorage.addAuthor(author);
    }
    
}
