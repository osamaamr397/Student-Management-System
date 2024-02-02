package com.AnyWare.Student.Management.System.controller;

import com.AnyWare.Student.Management.System.entity.Course;
import com.AnyWare.Student.Management.System.entity.Teacher;
import com.AnyWare.Student.Management.System.service.CourseService;
import com.AnyWare.Student.Management.System.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    @Autowired
    public CourseController(CourseService theCourseService){
        courseService=theCourseService;
    }
    @GetMapping("/list")
    public String listCourses(Model theModel){
        //get the employees from db
        List<Course> theCourses=courseService.findAll();
        //add to the spring model
        theModel.addAttribute("courses",theCourses);
        return "courses/list-courses";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("CourseId")int theId, Model theModel){
        //get the course from the service
        Course theCourse=courseService.findById(theId);
        //set course in the model to prepopulate the form
        theModel.addAttribute("course",theCourse);
        //send over to oor form
        return "courses/course-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel){
        //create the model attribute to bind from data
        Course theCourse=new Course();
        //add to course to spring mvc model
        theModel.addAttribute("course",theCourse);
        return "courses/course-form";

    }
    @PostMapping("/save")
    public String SaveCourse(@ModelAttribute("course")Course theCourse){
        //save the course
        courseService.save(theCourse);
        //use a redirect to prevent duplicate submission
        return "redirect:/courses/list";
    }
    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("courseId")int theId){
        //delete the course
        courseService.deleteById(theId);
        //redirect to courses/list
        return "redirect:/courses/list";
    }

}
