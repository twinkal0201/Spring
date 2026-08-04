package com.example.crudeDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private long id;
    private int roll_no;
    private String name;
    private int age;
    private String subject;
    private String email;
    private boolean deleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
