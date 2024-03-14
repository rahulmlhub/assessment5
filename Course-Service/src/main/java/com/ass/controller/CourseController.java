package com.ass.controller;

import com.ass.config.AuthorProxy;
import com.ass.entity.Course;
import com.ass.payload.Author;
import com.ass.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-course")
public class CourseController {

//    @Autowired
    private final CourseService courseService;
    private final AuthorProxy authorProxy;

    public CourseController(CourseService courseService, AuthorProxy authorProxy) {
        this.courseService = courseService;
        this.authorProxy = authorProxy;
    }

    @GetMapping("/getAuthor/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){

        Author authorById = authorProxy.getAuthorById(authorId);

        return  ResponseEntity.ok(authorById);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(courseId,course), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);

        return new ResponseEntity<>("Delete Successful !..", HttpStatus.OK);
    }



}
