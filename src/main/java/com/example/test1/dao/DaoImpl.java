package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImpl implements Dao {
    private final StudentRepository studentRepository;

    @Autowired
    public DaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }
    @Override
    public List<Student> searchByName(String name){
        return studentRepository.searchStudentByName(name);
    }
    @Override
    public void addStudent(Student student){
        System.out.println("DaoImpl addStudent");
        System.out.println("Student: " + student.toString());
        studentRepository.save(student);
    }
    @Override
    public void deleteStudents(List<Student> studentList){
        studentRepository.deleteAll(studentList);
    }
}
