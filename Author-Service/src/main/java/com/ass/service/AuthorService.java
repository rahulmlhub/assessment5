package com.ass.service;

import com.ass.entity.Author;

public interface AuthorService {

    Author saveAuthor(Author author);
    Author updateAuthor(Long authorId,Author author);
    String deleteAuthor(Long authorId);
    Author getAuthorById(Long authorId);
}
