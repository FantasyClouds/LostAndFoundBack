package com.example.test1.controller;
import com.example.test1.dao.entity.Student;
import com.example.test1.util.Response;
import com.example.test1.util.ResponseCrud;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public interface TestController {
    @GetMapping("/data/students")
    public ResponseEntity<Response<List<Student>>> getStudentList();
    public ResponseEntity<Response<String>> addStudent(Map<String, Object> studentData);
    public ResponseEntity<Response<String>> deleteStudent(@RequestBody List<Student> studentData);
    //Amis获取学生列表
    public ResponseEntity<Response<ResponseCrud<Student>>> testForm(@RequestParam(defaultValue = "1") int page,
                                                          @RequestParam(defaultValue = "10") int perPage);
    //Amis修改单个学生
    public ResponseEntity<Response<Boolean>> alterStudent(@PathVariable Long id, @RequestBody Map<String, Object> studentData);
    //Amis删除单个学生
    public ResponseEntity<Response<Boolean>> deleteStudentAmis(@PathVariable Long id);
    //Amis添加单个学生
    public ResponseEntity<Response<Boolean>> addStudentAmis(@PathVariable Long id, @RequestBody Map<String, Object> studentData);
    //public ResponseEntity<Response> searchStudentByName(List<Student> studentData);


}
