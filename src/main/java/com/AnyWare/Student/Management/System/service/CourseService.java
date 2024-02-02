package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(int theId);

    Course save(Course theCourse);

    void deleteById(int theId);
}
