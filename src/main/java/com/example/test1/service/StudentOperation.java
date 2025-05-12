package com.example.test1.service;


import com.example.test1.dao.entity.Student;

import java.util.List;

public interface StudentOperation {
    public List<Student> getStudentList();
    public void addStudent(Student student);
    public boolean deleteStudent(List<Student> data);
}
