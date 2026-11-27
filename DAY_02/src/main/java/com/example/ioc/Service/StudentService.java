package com.example.ioc.Service;

import com.example.ioc.Model.Student;
import com.example.ioc.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentByRollNo(int rollno) {
        return repository.findById(rollno).orElse(null);
    }

    public Student addStudent(Student std) {
        return repository.save(std);
    }

    public Student updateStudent(Student std) {
        return repository.save(std);
    }

    public Student patchStudent(int rollno, Student std) {
        Student existing = repository.findById(rollno).orElse(null);
        if (existing != null) {
            if (std.getName() != null) {
                existing.setName(std.getName());
            }
            if (std.getTech() != null) {
                existing.setTech(std.getTech());
            }
            return repository.save(existing);
        }
        return null;
    }

    public String deleteStudentByRollNo(int rollno) {
        if (repository.existsById(rollno)) {
            repository.deleteById(rollno);
            return "deleted";
        }
        return "not found";
    }
}
