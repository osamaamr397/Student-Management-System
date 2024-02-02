package com.AnyWare.Student.Management.System.controller;

import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Quiz;
import com.AnyWare.Student.Management.System.entity.Teacher;
import com.AnyWare.Student.Management.System.service.CourseService;
import com.AnyWare.Student.Management.System.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizController {
    private QuizService quizService;
    private CourseService courseService;
    @Autowired
    public QuizController(QuizService theQuizService,CourseService theCourseService){
        quizService=theQuizService;
        courseService=theCourseService;
    }
    @GetMapping("/list")
    public String listTeacher(Model theModel){
        //get the employees from db
        List<Quiz> theQuizzes=quizService.findAll();
        //add to the spring model
        theModel.addAttribute("quizzes",theQuizzes);
        return "quizzes/list-quizzes";
    }
    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel){
        //create the model attribute to bind from data
        Quiz theQuiz=new Quiz();
        //add to quiz to spring mvc model
        theModel.addAttribute("quiz",theQuiz);
        //add courses
        List<Course>theCourses=courseService.findAll();
        theModel.addAttribute("courses",theCourses);
        return "quizzes/quiz-form";

    }
    @GetMapping("/showFormForUpdate")

    public String showFormForUpdate(@RequestParam("quizId")int theId, Model theModel){
        //get the quiz from the service
        Quiz theQuiz=quizService.findById(theId);
        //set quiz in the model to prepopulate the form
        theModel.addAttribute("quiz",theQuiz);
        //send over to oor form
        return "quizzes/quiz-form";
    }
    @PostMapping("/save")
    public String SaveQuiz(@ModelAttribute("quiz")Quiz theQuiz){
        //save the quiz
        quizService.save(theQuiz);
        //use a redirect to prevent duplicate submission
        return "redirect:/quizzes/list";
    }
    @GetMapping("/delete")
    public String deleteQuiz(@RequestParam("quizId")int theId){
        //delete the quiz
        quizService.deleteById(theId);
        //redirect to quizzes/list
        return "redirect:/quizzes/list";
    }
}
