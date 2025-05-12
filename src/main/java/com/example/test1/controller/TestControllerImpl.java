package com.example.test1.controller;
import com.example.test1.dao.entity.Student;
import com.example.test1.util.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.example.test1.service.StudentOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestControllerImpl implements TestController {

    @Autowired
    private StudentOperation studentOperation;

    @GetMapping("/data/students")
    public ResponseEntity<Response> getStudentList() {
        System.out.println("TestControllerImpl.getStudentList()");
        System.out.println(studentOperation.getStudentList().toString());
        Response response = new Response();
        response.code = 200;
        response.message = "获取成功";
        response.data = studentOperation.getStudentList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/data/studentsPost")
    public ResponseEntity<Response> addStudent(@RequestBody Map<String, Object> studentData) {
        System.out.println("TestControllerImpl.addStudent()");
        System.out.println("StudentData = " + studentData);
        Random random = new Random();
        Long id = random.nextLong();
        String name = "默认";
        int age = 0;
        String sex = "男";
        int grade = 0;
        int classs = 0;
        String date = "2021-01-01";

        Response response = new Response();/*
        if(studentData.containsKey("id")) {
            id = Long.parseLong(studentData.get("id").toString());
        }*/
        if(studentData.containsKey("name")) {
            name = (String) studentData.get("name");
        }
        if(studentData.containsKey("age")) {
            age = (Integer) studentData.get("age");
        }
        if(studentData.containsKey("sex")) {
            sex = (String) studentData.get("sex");
        }
        if(studentData.containsKey("grade")) {
            grade = (Integer) studentData.get("grade");
        }
        if(studentData.containsKey("classs")) {
            classs = (Integer) studentData.get("classs");
        }
        if(studentData.containsKey("time")) {
            date = (String) studentData.get("time");
        }
        Student student = new Student(/*id, */name, age, sex, grade, classs, date);
        studentOperation.addStudent(student);

        response.code = 200;
        response.message = "添加成功";
        response.data = student;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/data/studentsDelete")
    public ResponseEntity<Response> deleteStudent(@RequestBody List<Student> studentData) {
        System.out.println("studentData = " + studentData);
        System.out.println("Type: " + studentData.getClass());
        System.out.println("ElementType: " + studentData.get(0).getClass());
        System.out.println("TestControllerImpl.deleteStudent()");
        Response response = new Response();
        response.code = 200;
        response.message = "删除成功";
        response.data = studentOperation.deleteStudent(studentData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
