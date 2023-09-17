package com.ketan.hibernateinheritancemapping.tableperclass.services.interfaces;

import com.ketan.hibernateinheritancemapping.dtos.StudentDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;

import java.util.List;

public interface IStudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id) throws NotFoundException;
    StudentDto updateStudentById(Long id, StudentDto studentDto) throws NotFoundException;
    void deleteStudentById(Long id) throws NotFoundException;
    List<StudentDto> getAllStudents();
}
