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
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;
    private CourseService courseService;
    @Autowired
    public TeacherController(TeacherService theTeacherService,CourseService theCourseService){
    teacherService=theTeacherService;
    courseService=theCourseService;
    }

    @GetMapping("/list")
    public String listTeacher(Model theModel){
        //get the teacher from db
        List<Teacher> theTeachers=teacherService.findAll();
        //add to the spring model
        theModel.addAttribute("teachers",theTeachers);
        return "teachers/list-teachers";
    }
    @GetMapping("/ListAllCourses")
    public String listCourses(Model theModel){
        List<Course>theCourses=courseService.findAll();
        List<Teacher> theTeachers=teacherService.findAll();
        theModel.addAttribute("teachers",theTeachers);
        theModel.addAttribute("courses",theCourses);
        return "teachers/courses";
    }
    @PostMapping("/attach")
    public String attach(@RequestParam("teacherId")int theTeacherId,@RequestParam("courseId")int theCourseId,Model theMode){
        Teacher theTeacher=teacherService.findById(theTeacherId);
        Course theCourse=courseService.findById(theCourseId);
        theTeacher.addCourse(theCourse);
        theCourse.setTeacher(theTeacher);
        courseService.save(theCourse);
        return "teachers/courses";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("teacherId")int theId, Model theModel){
        //get the teacher from the service
        Teacher theTeacher=teacherService.findById(theId);
        //set teacher in the model to prepopulate the form
        theModel.addAttribute("teacher",theTeacher);
        //send over to oor form
        return "teachers/teacher-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel){
        //create the model attribute to bind from data
        Teacher theTeacher=new Teacher();
        //add to teacher to spring mvc model
        theModel.addAttribute("teacher",theTeacher);
        return "teachers/teacher-form";

    }
    @PostMapping("/save")
    public String SaveTeacher(@ModelAttribute("teacher")Teacher theTeacher){
        //save the teacher
        teacherService.save(theTeacher);
        //use a redirect to prevent duplicate submission
        return "redirect:/teachers/list";
    }
    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam("teacherId")int theId){
        //delete the teacher
        teacherService.deleteById(theId);
        //redirect to teacher/list
        return "redirect:/teachers/list";
    }

}
