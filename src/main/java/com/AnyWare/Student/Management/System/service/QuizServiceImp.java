package com.AnyWare.Student.Management.System.service;

import com.AnyWare.Student.Management.System.dao.CourseRepository;
import com.AnyWare.Student.Management.System.dao.QuizRepository;
import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImp implements QuizService{
    private QuizRepository quizRepository;
    @Autowired
    QuizServiceImp(QuizRepository theQuizRepository){
        quizRepository=theQuizRepository;
    }
    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findById(int theId) {
        Optional<Quiz> result=quizRepository.findById(theId);
        Quiz theQuiz=null;
        if(result.isPresent()){
            theQuiz=result.get();
        }else {
            throw new RuntimeException("Did not find the quiz id "+theId);
        }
        return theQuiz;
    }

    @Override
    public Quiz save(Quiz theQuiz) {
        return quizRepository.save(theQuiz);
    }

    @Override
    public void deleteById(int theId) {
        quizRepository.deleteById((theId));
    }

    @Override
    public Quiz update(Quiz theQuiz) {
        return quizRepository.save(theQuiz);
    }
}
