package com.example.test1.service;
import com.example.test1.dao.Dao;
import com.example.test1.dao.StudentRepository;
import com.example.test1.dao.entity.Student;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentOperationImpl implements StudentOperation {
    @Resource
    private final Dao dao;

    @Autowired
    public StudentOperationImpl(Dao dao) {
        this.dao = dao;
    }
    @Transactional
    public List<Student> getStudentList(){
        System.out.println("TestServiceImpl.getStudentList()");
        return dao.getStudentList();
    }
    @Transactional
    public void addStudent(Student student){
        System.out.println("TestServiceImpl.addStudent()");
        dao.addStudent(student);
    }
    @Transactional
    public boolean deleteStudent(List<Student> data){
        System.out.println("TestServiceImpl.deleteStudent()");
        System.out.println("data: " + data);

        for (Student student : data) {
            if (student.getId() == null) {
                System.out.println("Student with name " + student.getName() + " has null id and cannot be deleted.");
                return false;
            }
        }

        dao.deleteStudents(data);
        System.out.println("now All:" + dao.getStudentList());
        return true;
    }


}
