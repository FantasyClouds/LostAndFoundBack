package com.example.test1.controller;
import com.example.test1.dao.entity.Student;
import com.example.test1.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public interface TestController {
    @GetMapping("/data/students")
    public ResponseEntity<Response> getStudentList();
    public ResponseEntity<Response> addStudent(Map<String, Object> studentData);
    public ResponseEntity<Response> deleteStudent(@RequestBody List<Student> studentData);
    //public ResponseEntity<Response> searchStudentByName(List<Student> studentData);
    public ResponseEntity<Response> getFile(@RequestParam("file")MultipartFile fileData);

}
