package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> findAll();

    Quiz findById(int theId);

    Quiz save(Quiz theQuiz);

    void deleteById(int theId);
    Quiz update(Quiz theQuiz);
}
