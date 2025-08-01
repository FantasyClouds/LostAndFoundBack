package com.example.test1.dao;

import com.example.test1.dao.entity.Student_;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentDao_ {
    List<Student_> getStudentList();

    //获取分页学生
    List<Student_> getStudentList(int offset, int perPage);

    //获取学生总数
    int getStudentCount();

    public List<Student_> searchByName(String name);

    public void addStudent(Student_ student);

    public void deleteStudents(List<Student_> studentList);

    //Amis框架单个修改学生信息
    public boolean updateStudent(Student_ student);

    //Amis框架单个删除学生信息
    public boolean deleteStudentAmis(Long id);
    //Amis框架添加单个学生信息
    public boolean addStudentAmis(Student_ student);
    //Amis框架查询学生信息
    public List<Student_> searchStudent(Long sno, String sname, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd);
}
