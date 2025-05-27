package com.example.test1.controller;
import com.example.test1.dao.entity.Student;
import com.example.test1.util.Response;
import com.example.test1.util.ResponseCrud;
import com.example.test1.util.TimestampUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
    public ResponseEntity<Response<List<Student>>> getStudentList() {
        System.out.println("TestControllerImpl.getStudentList()");
        System.out.println(studentOperation.getStudentList().toString());
        Response<List<Student>> response = new Response();
        response.status = 200;
        response.msg = "获取成功";
        response.data = studentOperation.getStudentList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/data/studentsPost")
    public ResponseEntity<Response<String>> addStudent(@RequestBody Map<String, Object> studentData) {
        System.out.println("TestControllerImpl.addStudent()");
        System.out.println("StudentData = " + studentData);
        Random random = new Random();
        Long id = random.nextLong();
        String name = "默认";
        int age = 0;
        String sex = "男";
        String grade = "";
        int classs = 0;
        String date = "2021-01-01";

        Response response = new Response();
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
            grade = (String)studentData.get("grade");
        }
        if(studentData.containsKey("classs")) {
            classs = (Integer) studentData.get("classs");
        }
        if(studentData.containsKey("time")) {
            date = (String) studentData.get("time");
        }
        Student student = new Student(id, name, age, sex, grade, classs, date);
        studentOperation.addStudent(student);

        response.status = 200;
        response.msg = "添加成功";
        response.data = student;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/data/studentsDelete")
    public ResponseEntity<Response<String>> deleteStudent(@RequestBody List<Student> studentData) {
        System.out.println("studentData = " + studentData);
        System.out.println("Type: " + studentData.getClass());
        System.out.println("ElementType: " + studentData.get(0).getClass());
        System.out.println("TestControllerImpl.deleteStudent()");
        Response response = new Response();
        response.status = 200;
        response.msg = "删除成功";
        response.data = studentOperation.deleteStudent(studentData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Amis框架获取所有数据
    @GetMapping("/data/testForm")
    public ResponseEntity<Response<ResponseCrud<Student>>> testForm(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage) {
        System.out.println("TestControllerImpl.testForm() page=" + page + ", perPage=" + perPage);

        Response<ResponseCrud<Student>> response = new Response<>();
        // 获取分页数据
        List<Student> studentList = studentOperation.getStudentList(page, perPage);
        int total = studentOperation.getStudentCount();

        ResponseCrud responseCrud = new ResponseCrud();
        response.msg = "表格测试";
        response.status = 0;
        responseCrud.setRows(studentList);
        responseCrud.setCount(total);
        response.data = responseCrud;

        System.out.println("Response data: " + responseCrud);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Amis框架单个修改
    @PostMapping("/data/testForm/Alter/{Sno}")
    public ResponseEntity<Response<Boolean>> alterStudent(@PathVariable Long Sno, @RequestBody Map<String, Object> studentData) {
        Student student = new Student();
        boolean result = true;
        System.out.println("Alter Sno:" + Sno);
        student.setSno(Sno);
        student.setSname((String) studentData.get("Sname"));
        student.setSage((Integer) studentData.get("Sage"));
        student.setSsex((String) studentData.get("Ssex"));
        student.setGrade((String)studentData.get("Grade"));
        student.setClasss((Integer) studentData.get("Classs"));
        student.setEnrollmentTime((String) studentData.get("EnrollmentTime"));
        System.out.println("Alter student: ");
        for(String key : studentData.keySet()){
            System.out.println(key + " = " + studentData.get(key) + "KeyClass:" + studentData.get(key).getClass() + "Value: " + studentData.get(key) + "ValueClass:" + studentData.get(key).getClass());
        }
        if(!studentOperation.updateStudent(student)){
            result = false;
        }
        Response<Boolean> response = new Response<>();
        if(result){
            response.status = 0;
            response.msg = "修改成功";
        }
        else{
            response.status = 500;
            response.msg = "修改失败";
        }
        response.data = result;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Amis框架单个删除
    @PostMapping("/data/testForm/studentDeleteAmis/{Sno}")
    public ResponseEntity<Response<Boolean>> deleteStudentAmis(@PathVariable Long Sno) {
        System.out.println("Student delete request:" + Sno);
        Boolean result = true;
        if(!studentOperation.deleteStudentAmis(Sno)){
            result = false;
        }
        Response<Boolean> response = new Response<>();
        if(result){
            response.status = 0;
            response.msg = "删除成功";
        }
        else{
            response.status = 500;
            response.msg = "删除失败";
        }
        response.data = result;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Amis框架批量删除
    @PostMapping("/data/testForm/studentsDeleteAmis/{ids}")
    public void deleteStudentsAmis(@PathVariable Long[] ids) {
        System.out.println("TestControllerImpl.deleteStudentsAmis()");
        for (Long id : ids) {
            System.out.println("Student delete request:" + id);
        }
    }
    //Amis框架添加单个学生信息
    @PostMapping("/data/testForm/Add/{Sno}")
    public ResponseEntity<Response<Boolean>> addStudentAmis(@PathVariable Long Sno, @RequestBody Map<String, Object> studentData){
        Student student = new Student();
        System.out.println("StudentData:");
        for(String key : studentData.keySet()){
            System.out.println(key + ":" + studentData.get(key) + "Class:" + studentData.get(key).getClass());
        }
        boolean result = true;
        student.setSno(Sno);
        student.setSname((String) studentData.get("Sname"));
        student.setSage(Integer.parseInt((String) studentData.get("Sage")));
        student.setSsex((String) studentData.get("Ssex"));
        student.setGrade((String) studentData.get("Grade"));
        student.setClasss((Integer) studentData.get("Classs"));
        student.setEnrollmentTime(TimestampUtils.convertTimestamp((String) studentData.get("EnrollmentTime"), "UTC+8"));

        if(!studentOperation.addStudentAmis(student)){
            result = false;
        }
        Response<Boolean> response = new Response<>();
        if(result){
            response.status = 0;
            response.msg = "添加成功";
        }
        else {
            response.status = 500;
            response.msg = "添加失败";
        }
        response.data = result;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
