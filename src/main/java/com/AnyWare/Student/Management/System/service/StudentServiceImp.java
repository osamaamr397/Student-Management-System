package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.dao.StudentRepository;
import com.AnyWare.Student.Management.System.dao.TeacherRepository;
import com.AnyWare.Student.Management.System.entity.Quiz;
import com.AnyWare.Student.Management.System.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    StudentServiceImp(StudentRepository theStudentRepository){
        studentRepository=theStudentRepository;
    }
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {

        Optional<Student> result=studentRepository.findById(theId);
        Student theStudent=null;
        if(result.isPresent()){
            theStudent=result.get();
        }else {
            throw new RuntimeException("Did not find the Student id "+theId);
        }
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {
        return studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
