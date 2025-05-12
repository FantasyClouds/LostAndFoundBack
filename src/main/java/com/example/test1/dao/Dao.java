package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface Dao{
    List<Student> getStudentList();

    public List<Student> searchByName(String name);

    void addStudent(Student student);

    void deleteStudents(List<Student> studentList);
}
