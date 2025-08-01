package com.example.test1.controller;
import com.example.test1.dao.entity.Student_;
import com.example.test1.util.Response;
import com.example.test1.util.ResponseCrud;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public interface TestController_ {
    @GetMapping("/data/students")
    public ResponseEntity<Response<List<Student_>>> getStudentList();
    @PostMapping("/data/studentsPost")
    public ResponseEntity<Response<String>> addStudent(@RequestBody Map<String, Object> studentData);
    @PostMapping("/data/studentsDelete")
    public ResponseEntity<Response<String>> deleteStudent(@RequestBody List<Long> studentData);

    //Amis修改单个学生
    @PostMapping("/data/testForm/Alter/{StudentInternalId}")
    public ResponseEntity<Response<Boolean>> alterStudent(@PathVariable Long id,
                                                          @RequestBody Map<String, Object> studentData);
    //Amis删除单个学生
    @PostMapping("/data/testForm/studentDeleteAmis/{Sno}")
    public ResponseEntity<Response<Boolean>> deleteStudentAmis(@PathVariable Long id);

    //Amis删除多个学生
    @PostMapping("/data/testForm/studentsDeleteAmis")
    public ResponseEntity<Response<Boolean>> deleteStudentsAmis(@RequestBody List<Long> requestBody);

    //Amis添加单个学生
    @PostMapping("/data/testForm/Add/{Sno}")
    public ResponseEntity<Response<Boolean>> addStudentAmis(@PathVariable Long id,
                                                            @RequestBody Map<String, Object> studentData);
    //Amis查找学生，包括分页和获取全体学生
    @GetMapping("/data/testForm/search")
    public ResponseEntity<Response<ResponseCrud<Student_>>> searchStudent(
            @RequestParam(required = false) Long sno,
            @RequestParam(required = false) String sname,
            @RequestParam(required = false) Integer sage,
            @RequestParam(required = false) String ssex,
            @RequestParam(required = false) String grade,
            @RequestParam(required = false) Integer classs,
            @RequestParam(required = false) Boolean isAnd,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer perPage);
}
