package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setMarks(updatedStudent.getMarks());
            return repository.save(existingStudent);
        }
        return null;
    }

    public List<Student> getStudentsBelowMarks(int marks) {
        return repository.findByMarksLessThan(marks);
    }

    public List<Student> getStudentsGreaterMarks(int marks) {
        return repository.findByMarksGreaterThan(marks);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}