package com.AnyWare.Student.Management.System.dao;

import com.AnyWare.Student.Management.System.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer>{
}
