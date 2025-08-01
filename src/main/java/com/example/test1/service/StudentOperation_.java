package com.example.test1.service;
import com.example.test1.dao.StudentDaoImpl_;
import com.example.test1.dao.entity.Student_;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentOperation_ {
    @Resource
    private final StudentDaoImpl_ studentDao;

    @Autowired
    public StudentOperation_(StudentDaoImpl_ studentDao_) {
        this.studentDao = studentDao_;
    }
    public List<Student_> getStudentList(){
        System.out.println("TestServiceImpl.getStudentList()");
        return studentDao.getStudentList();
    }

    //获取分页数据
    public List<Student_> getStudentList(int page, int perPage){
        System.out.println("TestServiceImpl.getStudentList(page=" + page + ", perPage=" + perPage + ")");
        int offset = (page - 1) * perPage;
        return studentDao.getStudentList(offset, perPage);
    }

    //获取学生总数
    public int getStudentCount(){
        System.out.println("TestServiceImpl.getStudentCount()");
        return studentDao.getStudentCount();
    }

    public void addStudent(Student_ student){
        System.out.println("TestServiceImpl.addStudent()");
        studentDao.addStudent(student);
    }

    public boolean deleteStudent(List<Student_> data){
        System.out.println("TestServiceImpl.deleteStudent()");
        System.out.println("data: " + data);

        for (Student_ student : data) {
            if (student.getSno() == null) {
                System.out.println("Student with name " + student.getSname() + " has null id and cannot be deleted.");
                return false;
            }
        }

        studentDao.deleteStudents(data);
        System.out.println("now All:" + studentDao.getStudentList());
        return true;
    }

    //Amis框架单个修改学生
    public int updateStudent(Student_ student){
        if(studentDao.updateStudent(student)){
            return 0;
        }
        return 1;
    }
    //Amis框架删除单个学生
    public boolean deleteStudentAmis(Long id) {
        if(studentDao.deleteStudentAmis(id)){
            return true;
        }
        return false;
    }
    //Amis框架添加单个学生
    public boolean addStudentAmis(Student_ student){
        if(studentDao.addStudentAmis(student)){
            return true;
        }
        return false;
    }

    public List<Student_> searchStudent(Long sno, String name, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd){
        System.out.println("TestServiceImpl.searchStudent()");
        if(isAnd == null){
            return studentDao.getStudentList();
        }
        else if(sno == null && (name == null || name.isEmpty()) && (ssex == null || ssex.isEmpty()) && (grade == null || grade.isEmpty()) && classs == null){
            return studentDao.getStudentList();
        }
        return studentDao.searchStudent(sno, name, sage, ssex, grade, classs, isAnd);
    }
}
