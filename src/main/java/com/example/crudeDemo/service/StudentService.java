package com.example.crudeDemo.service;


import com.example.crudeDemo.entity.Student;
import com.example.crudeDemo.repository.StudentRepository;
import org.hibernate.sql.ast.tree.expression.SqlTuple;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentResponse=studentRepository.save(studentReq);
        return studentResponse;
    }


    public Student getStudent(Long id){
        Optional<Student> studentResponse= studentRepository.findByIdAndDeletedFalse(id);
        if(studentResponse.isPresent()){
            return studentResponse.get();
        }
        else {
            return null;
        }
    }
    public List<Student> getAllStudents() {
        List<Student> studentList=studentRepository.findByDeletedIsFalse();
        return studentList;
    }


    public Student updateStudent(Long id, Student studentReq) {

        Optional<Student> exitstingstudent = studentRepository.findByIdAndDeletedFalse(id);

        if (exitstingstudent.isEmpty()) {
            return  null;
        }
            Student student = exitstingstudent.get();

            student.setName(studentReq.getName());
            student.setEmail(studentReq.getEmail());
            student.setAge(studentReq.getAge());
            student.setRoll_no(studentReq.getRoll_no());
            student.setSubject(studentReq.getSubject());
            student.setDeleted(false);
            return studentRepository.save(student);

    }

    public Boolean deleteStudent(Long id) {

        Boolean isStudent = studentRepository.existsById(id);

        if (isStudent) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Boolean softDelete(Long id){
        Optional<Student> exitstingstudent =studentRepository.findByIdAndDeletedFalse(id);
        if(exitstingstudent.isEmpty()){
            return  false;
        }
        Student studentToSave=exitstingstudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
//      1.End point Listion
//      2.Business Logic
//      3. Interect with database
//      4. Response back to client
}
