package com.example.test1.controller;
import com.example.test1.dao.entity.Student_;
import com.example.test1.service.StudentOperation_;
import com.example.test1.util.Response;
import com.example.test1.util.ResponseCrud;
import com.example.test1.util.TimestampUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController_ {

    @Autowired
    private StudentOperation_ studentOperation;


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
        Student_ student = new Student_(id, name, age, sex, grade, classs, date);
        studentOperation.addStudent(student);

        response.status = 200;
        response.msg = "添加成功";
        response.data = student;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/data/studentsDelete")
    public ResponseEntity<Response<String>> deleteStudent(@RequestBody List<Long> studentData) {
        System.out.println("studentData = " + studentData);
        System.out.println("Type: " + studentData.getClass());
        System.out.println("ElementType: " + studentData.get(0).getClass());
        System.out.println("TestControllerImpl.deleteStudent()");
        Response response = new Response();
        response.status = 200;
        response.msg = "删除成功";
        // response.data = studentOperation.deleteStudent(studentData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Amis框架单个修改
    @PostMapping("/data/testForm/Alter/{StudentInternalId}")
    public ResponseEntity<Response<Boolean>> alterStudent(@PathVariable Long StudentInternalId, @RequestBody Map<String, Object> studentData) {
        Student_ student = new Student_();
        boolean result = true;
        System.out.println("Alter StudentInternalId:" + StudentInternalId);
        student.setStudentInternalId(StudentInternalId);
        student.setSno(((Integer)studentData.get("Sno")).longValue());
        student.setSname((String) studentData.get("Sname"));
        student.setSage((Integer) studentData.get("Sage"));
        student.setSsex((String) studentData.get("Ssex"));
        student.setGrade((String)studentData.get("Grade"));
        student.setClasss((Integer) studentData.get("Classs"));
        student.setEnrollmentTime((String) studentData.get("EnrollmentTime"));
        System.out.println("Alter student: " + student);
        if(studentOperation.updateStudent(student) != 0){
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
    @PostMapping("/data/testForm/studentsDeleteAmis")
    public ResponseEntity<Response<Boolean>> deleteStudentsAmis(@RequestBody List<Long> studentIds) {
        System.out.println("TestControllerImpl.deleteStudentsAmis()");
        boolean result = true;
        System.out.println("studentIds = " + studentIds);
        for (Long id : studentIds) {
            System.out.println("Student delete request:" + id);
            if(!studentOperation.deleteStudentAmis(id)) {
                result = false;
            }
        }
        Response<Boolean> response = new Response<>();
        if(result) {
            response.status = 0;
            response.msg = "批量删除成功";
        } else {
            response.status = 500;
            response.msg = "部分删除失败";
        }
        response.data = result;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Amis框架添加单个学生信息
    @PostMapping("/data/testForm/Add/{Sno}")
    public ResponseEntity<Response<Boolean>> addStudentAmis(@PathVariable Long Sno, @RequestBody Map<String, Object> studentData){
        Student_ student = new Student_();
        System.out.println("StudentData:");
        for(String key : studentData.keySet()){
            System.out.println(key + ":" + studentData.get(key) + "Class:" + studentData.get(key).getClass());
        }
        boolean result = true;
        student.setSno(Sno);
        student.setSname((String) studentData.get("Sname"));
        student.setSage((Integer) studentData.get("Sage"));
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
    //Amis搜索
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
            @RequestParam(defaultValue = "10") Integer perPage) {
        System.out.println("TestControllerImpl.searchStudent()");
        System.out.println(String.format("Search params - sno: %s, sname: %s, sage: %s, ssex: %s, grade: %s, classs: %s, isAnd: %s, page: %s, perPage: %s",
                sno, sname, sage, ssex, grade, classs, isAnd, page, perPage));

        // Validate pagination parameters
        if (page < 1) page = 1;
        if (perPage < 1) perPage = 10;

        Response<ResponseCrud<Student_>> response = new Response<>();
        List<Student_> studentList = studentOperation.searchStudent(sno, sname, sage, ssex, grade, classs, isAnd);
        int total = studentList.size();

        // Apply pagination
        int fromIndex = (page - 1) * perPage;
        if (fromIndex >= total) {
            fromIndex = 0;
            page = 1;
        }
        int toIndex = Math.min(fromIndex + perPage, total);
        List<Student_> pagedList = studentList.subList(fromIndex, toIndex);

        ResponseCrud responseCrud = new ResponseCrud();
        response.msg = "搜索结果";
        response.status = 0;
        response.data = responseCrud;
        responseCrud.setRows(pagedList);
        responseCrud.setCount(total);
        System.out.println("total:" + total + ", showing " + pagedList.size() + " items (page " + page + ")");

        return new ResponseEntity<>(response, HttpStatus.OK);


    }

}
