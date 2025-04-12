package com.example.book_library.services;

import org.springframework.stereotype.Service;

import com.example.book_library.Storage.BookStorage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class BookService {
    
    private final BookStorage bookStorage;


}
