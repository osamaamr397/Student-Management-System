package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.entity.Student;
import com.AnyWare.Student.Management.System.entity.Teacher;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
