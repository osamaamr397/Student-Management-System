package com.AnyWare.Student.Management.System.controller;

import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Student;
import com.AnyWare.Student.Management.System.entity.Teacher;
import com.AnyWare.Student.Management.System.service.CourseService;
import com.AnyWare.Student.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")

public class StudentController {
    private StudentService studentService;
    private CourseService courseService;
    @Autowired
    public StudentController(StudentService theStudentService,CourseService theCourseService){
        studentService=theStudentService;
        courseService=theCourseService;
    }
    @GetMapping("/list")
    public String listStudent(Model theModel){
        //get the students from db
        List<Student> theStudents=studentService.findAll();
        //add to the spring model
        theModel.addAttribute("students",theStudents);
        return "students/list-students";
    }
    @GetMapping("/ListAllCourses")
    public String listCourses(Model theModel){
        List<Course>theCourses=courseService.findAll();
        List<Student> theStudents=studentService.findAll();
        theModel.addAttribute("students",theStudents);
        theModel.addAttribute("courses",theCourses);
        return "students/courses";
    }
    @PostMapping("/attach")
    public String attach(@RequestParam("studentId")int theStudentId, @RequestParam("courseId")int theCourseId, Model theMode){
        Student theStudent=studentService.findById(theStudentId);
        Course theCourse=courseService.findById(theCourseId);
        theStudent.addCourse(theCourse);
        theCourse.addStudent(theStudent);
        courseService.save(theCourse);
        return "students/courses";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId")int theId, Model theModel){
        //get the student from the service
        Student theStudent=studentService.findById(theId);
        //set teacher in the model to prepopulate the form
        theModel.addAttribute("student",theStudent);
        //send over to oor form
        return "students/student-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel){
        //create the model attribute to bind from data
        Student theStudent=new Student();
        //add to teacher to spring mvc model
        theModel.addAttribute("student",theStudent);
        return "students/student-form";

    }
    @PostMapping("/save")
    public String SaveStudent(@ModelAttribute("student")Student theStudent){
        //save the student
        studentService.save(theStudent);
        //use a redirect to prevent duplicate submission
        return "redirect:/students/list";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId")int theId){
        //delete the student
        studentService.deleteById(theId);
        //redirect to student/list
        return "redirect:/students/list";
    }

}
