package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.dao.CourseRepository;
import com.AnyWare.Student.Management.System.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{
    private CourseRepository courseRepository;
    @Autowired
    public CourseServiceImp(CourseRepository theCourseRepository){
        courseRepository=theCourseRepository;
    }
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course>result=courseRepository.findById(theId);
        Course theCourse=null;
        if(result.isPresent()){
          theCourse=result.get();
        }else {
            throw new RuntimeException("Did not find the Course id "+theId);
        }
        return theCourse;
    }

    @Override
    public Course save(Course theCourse) {
        return courseRepository.save(theCourse);
    }
    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }
}
