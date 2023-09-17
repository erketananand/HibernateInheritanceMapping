package com.ketan.hibernateinheritancemapping.mappedsupperclass.controllers;

import com.ketan.hibernateinheritancemapping.dtos.StudentDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.mappedsupperclass.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("msStudentController")
@RequestMapping("/mappedSupperClass/student")
public class StudentController {
    private StudentService studentService;
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable("id") Long id) throws NotFoundException {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) throws NotFoundException {
        return studentService.updateStudentById(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) throws NotFoundException {
        studentService.deleteStudentById(id);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

}
