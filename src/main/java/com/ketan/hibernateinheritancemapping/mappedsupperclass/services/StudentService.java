package com.ketan.hibernateinheritancemapping.mappedsupperclass.services;

import com.ketan.hibernateinheritancemapping.dtos.StudentDto;
import com.ketan.hibernateinheritancemapping.exceptions.NotFoundException;
import com.ketan.hibernateinheritancemapping.mappedsupperclass.models.Student;
import com.ketan.hibernateinheritancemapping.mappedsupperclass.repositories.StudentRepository;
import com.ketan.hibernateinheritancemapping.mappedsupperclass.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("msStudentService")
public class StudentService implements IStudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentDto convertStudentToStudentDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .attendance(student.getAttendance())
                .psp(student.getPsp())
                .build();
    }

    private Student convertStudentDtoToStudent(StudentDto studentDto, Student student){
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAttendance(studentDto.getAttendance());
        student.setPsp(studentDto.getPsp());
        return student;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = convertStudentDtoToStudent(studentDto, new Student());
        Student savedStudent = studentRepository.save(student);
        return convertStudentToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long id) throws NotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return convertStudentToStudentDto(student);
        } else throw new NotFoundException("Student with id " + id + " not found");
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto studentDto) throws NotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = convertStudentDtoToStudent(studentDto, optionalStudent.get());
            Student savedStudent = studentRepository.save(student);
            return convertStudentToStudentDto(savedStudent);
        } else {
            throw new NotFoundException("Student with id " + id + " not found");
        }
    }

    @Override
    public void deleteStudentById(Long id) throws NotFoundException {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else throw new NotFoundException("Student with id " + id + " not found");
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students) {
            studentDtos.add(convertStudentToStudentDto(student));
        }
        return studentDtos;
    }
}
