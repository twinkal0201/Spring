package com.example.crudeDemo.controller;

import com.example.crudeDemo.entity.Student;
import com.example.crudeDemo.service.StudentService;
import org.apache.catalina.connector.Response;
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

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResponse=studentService.getStudent(id);
        if (studentResponse==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=studentService.getAllStudents();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Student> updatreStudent(@PathVariable Long id,@RequestBody Student studentReq){
        Student studentResp=studentService.updateStudent(id,studentReq);

        if (studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record deleted");
    }

    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<Boolean> softDelete(@PathVariable Long id){
        Boolean isDeletd=studentService.softDelete(id);
        return ResponseEntity.ok(true);
    }
}
