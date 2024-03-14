package com.ass.service.impl;

import com.ass.entity.Author;
import com.ass.repo.AuthorRepo;
import com.ass.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    Environment environment;
  private final  AuthorRepo repo;

    public AuthorServiceImpl(AuthorRepo repo) {
        this.repo = repo;
    }

    @Override
    public Author saveAuthor(Author author) {
        return repo.save(author);
    }

    @Override
    public Author updateAuthor(Long authorId, Author author) {

        Optional<Author> byId = repo.findById(authorId);
        if (byId.isPresent()){
            Author author1 = byId.get();
            author1.setAuthorName(author.getAuthorName());
            author1.setEmailId(author.getEmailId());
            return repo.save(author1);
        }else {
            throw new RuntimeException("Author is not present ");
        }
    }

    @Override
    public String deleteAuthor(Long authorId) {
        Optional<Author> byId = repo.findById(authorId);
        if (byId.isPresent()){
            Author author1 = byId.get();
            repo.delete(author1);
            return "Author Deleted Successful !..";
        }else {
            throw new RuntimeException("Author is not present ");
        }
    }

    @Override
    public Author getAuthorById(Long authorId) {
        Optional<Author> byId = repo.findById(authorId);
        if (byId.isPresent()){
            Author author = byId.get();
//            author.setPort(environment.getProperty("local."));
//            int port = Integer.parseInt(environment.getProperty("local.server.port"));
//            author.setPort(port);
            return author;
        }else {
            throw new RuntimeException("Author is not present ");
        }
    }
}
