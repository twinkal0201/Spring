package com.example.crudeDemo.controller;

import com.example.crudeDemo.DTOs.CreateStudentRequestDTO;
import com.example.crudeDemo.DTOs.CreateStudentResponseDTO;
import com.example.crudeDemo.DTOs.UpdateStudentReqDTO;
import com.example.crudeDemo.DTOs.UpdateStudentResDTO;
import com.example.crudeDemo.entity.Student;
import com.example.crudeDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO student) {
        CreateStudentResponseDTO createStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }

    @GetMapping("{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){
        CreateStudentResponseDTO studentResponse=studentService.getStudent(id);

        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentList=studentService.getAllStudents();

        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public  ResponseEntity<UpdateStudentResDTO> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentReqDTO studentReq){
        UpdateStudentResDTO updateStudentResDTO=studentService.updateStudent(id,studentReq);

        return ResponseEntity.ok(updateStudentResDTO);

    }

    @DeleteMapping
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<Boolean> softDelete(@PathVariable Long id){
        studentService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
