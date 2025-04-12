package com.example.book_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorForm {
    private String firstName;
    private String secondName;
    private int birthday;
}
