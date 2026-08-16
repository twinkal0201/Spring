package com.example.crudeDemo.service;


import com.example.crudeDemo.DTOs.CreateStudentRequestDTO;
import com.example.crudeDemo.DTOs.CreateStudentResponseDTO;
import com.example.crudeDemo.DTOs.UpdateStudentReqDTO;
import com.example.crudeDemo.DTOs.UpdateStudentResDTO;
import com.example.crudeDemo.entity.Student;
import com.example.crudeDemo.exception.DublicateRuntimeEXception;
import com.example.crudeDemo.exception.ResourceNotFoundException;
import com.example.crudeDemo.repository.StudentRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq){
        Student student= mapToCreateEntity(studentReq);
        if(emailExists(student)){
            throw new DublicateRuntimeEXception("Email already exists.");
        }

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        Student studentResponse=studentRepository.save(student);
        return mapToCreateDto(studentResponse);
    }


    public CreateStudentResponseDTO getStudent(Long id){
        Student student=studentRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(()->new ResolutionException("Student with id "+id+" not found."));
        return mapToCreateDto(student);
    }

    public List<CreateStudentResponseDTO> getAllStudents() {
        List<Student> studentList=studentRepository.findByDeletedIsFalse();
        return studentList.stream().map(this::mapToCreateDto).toList();
    }


    public UpdateStudentResDTO updateStudent(Long id, UpdateStudentReqDTO studentReq) {

        Student exitstingstudent = studentRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("student with id "+id+" not found"));

        exitstingstudent.setName(studentReq.getName());
        exitstingstudent.setAge(studentReq.getAge());
        exitstingstudent.setRoll_no(studentReq.getRoll_no());
        exitstingstudent.setSubject(studentReq.getSubject());
        exitstingstudent.setDeleted(false);
        exitstingstudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent= studentRepository.save(exitstingstudent);

        return mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {

        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("student with id "+id+" not found."));


        studentRepository.delete(studentToBeDeleted);

    }

    public void softDelete(Long id){
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("student with id "+id+" not found."));


        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToCreateEntity(CreateStudentRequestDTO studentRequestDTO){
        Student student=new Student();

        student.setName(studentRequestDTO.getName());
        student.setSubject(studentRequestDTO.getSubject());
        student.setRoll_no(studentRequestDTO.getRoll_no());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setDeleted(false);

        return  student;
    }

    private CreateStudentResponseDTO mapToCreateDto(Student student){
        CreateStudentResponseDTO responseDTO=new CreateStudentResponseDTO();

        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setId(student.getId());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setRoll_no(student.getRoll_no());
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMeassge("Student saved successfully");

        return responseDTO;

    }

    private UpdateStudentResDTO mapToUpdateDto(Student student){

        UpdateStudentResDTO responseDTO=new UpdateStudentResDTO();

        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setId(student.getId());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setRoll_no(student.getRoll_no());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMeassge("Student updated successfully");
        return responseDTO;
    }
    private boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
//      1.End point Listion
//      2.Business Logic
//      3. Interect with database
//      4. Response back to client
}
