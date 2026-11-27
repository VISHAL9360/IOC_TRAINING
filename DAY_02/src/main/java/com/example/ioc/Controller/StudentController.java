package com.example.ioc.Controller;

import com.example.ioc.Model.Student;
import com.example.ioc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return service.getAllStudents();
    }

    @GetMapping("/students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno") int rollno) {
        return service.getStudentByRollNo(rollno);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student std) {
        return service.addStudent(std);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student std) {
        return service.updateStudent(std);
    }

    @PutMapping("/students/{rno}")
    public Student updateStudentByRollNo(@PathVariable("rno") int rollno, @RequestBody Student std) {
        std.setRno(rollno);
        return service.updateStudent(std);
    }

    @PatchMapping("/students/{rno}")
    public Student patchStudent(@PathVariable("rno") int rollno, @RequestBody Student std) {
        return service.patchStudent(rollno, std);
    }

    @DeleteMapping("/students/{rno}")
    public String deleteById(@PathVariable("rno") int rollno) {
        return service.deleteStudentByRollNo(rollno);
    }
}
