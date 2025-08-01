
package com.example.test1.service;


import com.example.test1.dao.entity.Student_;

import java.util.List;

public interface StudentOperation_ {
    public List<Student_> getStudentList();

    public void addStudent(Student_ student);

    //获取分页数据
    public List<Student_> getStudentList(int page, int perPage);

    //获取学生总数
    public int getStudentCount();

    public boolean deleteStudent(List<Student_> data);
    //Amis框架单个更新学生
    public int updateStudent(Student_ student);

    //Amis框架单个删除学生
    public boolean deleteStudentAmis(Long id);

    //Amis框架添加单个学生
    public boolean addStudentAmis(Student_ student);

    //Amis框架搜索学生
    public List<Student_> searchStudent(Long sno, String name, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd);
}
