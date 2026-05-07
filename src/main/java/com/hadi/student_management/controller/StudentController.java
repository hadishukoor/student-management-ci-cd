package com.hadi.student_management.controller;

import com.hadi.student_management.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add-student")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Student student) {
        students.add(student);
        return "redirect:/students";
    }
}
