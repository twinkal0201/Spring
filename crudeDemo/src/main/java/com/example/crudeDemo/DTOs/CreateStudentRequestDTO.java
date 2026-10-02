package com.example.crudeDemo.DTOs;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {


    @NotBlank(message = "name can not be empty.")
    @Size(min=2,max = 50,message = "student name must be within 2 to 50 charactor long.")
    private String name;

    @NotNull(message = "age are required.")
    @Min(value = 18,message = "student must be 18 year old.")
    private int age;

    @NotBlank(message = "subject are required.")
    private String subject;

    @NotBlank(message = "email can not be empty.")
    @Email(message = "student email must be valid.")
    private String email;

    @NotNull(message = "roll no is required.")
    private int roll_no;


    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
