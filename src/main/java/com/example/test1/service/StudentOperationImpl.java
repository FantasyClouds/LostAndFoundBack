package com.example.test1.service;
import com.example.test1.dao.Dao;
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

    //获取分页数据
    @Transactional
    public List<Student> getStudentList(int page, int perPage){
        System.out.println("TestServiceImpl.getStudentList(page=" + page + ", perPage=" + perPage + ")");
        int offset = (page - 1) * perPage;
        return dao.getStudentList(offset, perPage);
    }

    //获取学生总数
    @Transactional
    public int getStudentCount(){
        System.out.println("TestServiceImpl.getStudentCount()");
        return dao.getStudentCount();
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
            if (student.getSno() == null) {
                System.out.println("Student with name " + student.getSname() + " has null id and cannot be deleted.");
                return false;
            }
        }

        dao.deleteStudents(data);
        System.out.println("now All:" + dao.getStudentList());
        return true;
    }

    //Amis框架单个修改学生
    @Transactional
    public int updateStudent(Student student){
        if(dao.updateStudent(student)){
            return 0;
        }
        return 1;
    }
    //Amis框架删除单个学生
    @Transactional
    public boolean deleteStudentAmis(Long id) {
        if(dao.deleteStudentAmis(id)){
            return true;
        }
        return false;
    }
    //Amis框架添加单个学生
    @Transactional
    public boolean addStudentAmis(Student student){
        if(dao.addStudentAmis(student)){
            return true;
        }
        return false;
    }

    @Transactional
    public List<Student> searchStudent(Long sno, String name, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd){
        System.out.println("TestServiceImpl.searchStudent()");
        if(isAnd == null){
            return dao.getStudentList();
        }
        else if(sno == null && (name == null || name.isEmpty()) && (ssex == null || ssex.isEmpty()) && (grade == null || grade.isEmpty()) && classs == null){
            return dao.getStudentList();
        }
        return dao.searchStudent(sno, name, sage, ssex, grade, classs, isAnd);
    }
}
