package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface Dao{
    List<Student> getStudentList();

    //获取分页学生
    List<Student> getStudentList(int offset, int perPage);

    //获取学生总数
    int getStudentCount();

    public List<Student> searchByName(String name);

    public void addStudent(Student student);

    public void deleteStudents(List<Student> studentList);

    //Amis框架单个修改学生信息
    public boolean updateStudent(Student student);

    //Amis框架单个删除学生信息
    public boolean deleteStudentAmis(Long id);
    //Amis框架添加单个学生信息
    public boolean addStudentAmis(Student student);
    //Amis框架查询学生信息
    public List<Student> searchStudent(Long sno, String sname, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd);
}
