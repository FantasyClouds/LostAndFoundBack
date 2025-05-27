package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImpl implements Dao {
    private final StudentRepository studentRepository;

    @Autowired
    public DaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }

    //获取分页数据
    @Override
    public List<Student> getStudentList(int offset, int perPage){
        return studentRepository.findAllWithPagination(offset, perPage);
    }

    //获取学生总数
    @Override
    public int getStudentCount(){
        return (int)studentRepository.countAll();
    }

    @Override
    public List<Student> searchByName(String name){
        return studentRepository.searchStudentByName(name);
    }
    @Override
    public void addStudent(Student student){
        System.out.println("DaoImpl addStudent");
        System.out.println("Student: " + student.toString());
        studentRepository.save(student);
    }
    @Override
    public void deleteStudents(List<Student> studentList){
        studentRepository.deleteAll(studentList);
    }

    //Amis框架单个修改学生信息
    public boolean updateStudent(Student student){
        try{
            studentRepository.updateStudentById(student.getSno(), student.getSname(), student.getSage(), student.getSsex(), student.getGrade(), student.getClasss(), student.getEnrollmentTime());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //Amis框架单个删除学生信息
    public boolean deleteStudentAmis(Long id){
        try{
            studentRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //Amis框架添加单个学生信息
    public boolean addStudentAmis(Student student){
        try{
            System.out.println(student.toString());
            studentRepository.save(student);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
