package com.ass.service.impl;

import com.ass.entity.Course;
import com.ass.repo.CourseRepo;
import com.ass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo repo;

    @Override
    public Course createCourse(Course course) {
      return   repo.save(course);

    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> byId = repo.findById(id);
        if (byId.isPresent()){
            Course course1 = byId.get();
            course1.setCourseName(course.getCourseName());
            course1.setAvailability(course.isAvailability());
            course1.setDuration(course.getDuration());
            return repo.save(course1);
        }else {
            throw new RuntimeException("Course is not present");
        }
    }

    @Override
    public String deleteCourse(Long id) {
        Optional<Course> byId = repo.findById(id);
        if (byId.isPresent()) {
            Course course1 = byId.get();
            repo.delete(course1);
            return "Course is Delete Succesfull !..";
        }else {
            throw new RuntimeException("Course is not present");
        }
    }
}
