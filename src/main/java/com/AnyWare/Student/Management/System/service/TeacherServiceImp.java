package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.dao.TeacherRepository;
import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImp(TeacherRepository theTeacherRepository){
        teacherRepository=theTeacherRepository;
    }
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result=teacherRepository.findById(theId);
        Teacher theTeacher=null;
        if(result.isPresent()){
            theTeacher=result.get();
        }else {
            throw new RuntimeException("Did not find the teacher id "+theId);
        }
        return theTeacher;
    }

    @Override
    public Teacher save(Teacher theTeacher) {
        return teacherRepository.save(theTeacher);
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }
}
