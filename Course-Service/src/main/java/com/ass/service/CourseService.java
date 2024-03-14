package com.ass.service;

import com.ass.entity.Course;

public interface CourseService {

    Course createCourse(Course course);
    Course updateCourse(Long  id ,Course course);
    String deleteCourse(Long  id);

}
