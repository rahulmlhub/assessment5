package com.ass.controller;

import com.ass.entity.Author;
import com.ass.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api-author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
   private Environment environment;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId, @RequestBody Author author){
        return new ResponseEntity<>(authorService.updateAuthor(authorId,author), HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){

        Author authorById = authorService.getAuthorById(authorId);
//        authorById.setPort(environment.getProperty("local.server.port"));
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        System.out.println("port: "+port);

        return new ResponseEntity<>(authorById, HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long authorId){
       authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("Author Deleted Successful !..", HttpStatus.OK);
    }

}
