package com.example.book_library.Storage;

import java.util.Collection;

import com.example.book_library.Model.Author;

public interface AuthorStorage {
    
    public Author addAuthor(Author author);
    public Collection<Author> getAll();
    public Author getById(int id);
    public Author getByName(String firstName, String secondName);
    public void removeAuthor(int id);

}
