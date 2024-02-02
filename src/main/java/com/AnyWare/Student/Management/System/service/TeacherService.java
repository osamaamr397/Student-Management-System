package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(int theId);

    Teacher save(Teacher theTeacher);

    void deleteById(int theId);

}
