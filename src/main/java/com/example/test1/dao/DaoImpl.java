package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
            studentRepository.updateStudentById(student.getStudentInternalId(), student.getSno(), student.getSname(),
                    student.getSage(), student.getSsex(), student.getGrade(), student.getClasss(), student.getEnrollmentTime());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //Amis框架单个删除学生信息
    public boolean deleteStudentAmis(Long sno){
        try{
            studentRepository.deleteStudentById(sno);
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
    public List<Student> searchStudent(Long sno, String sname, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd){
        List<Student> studentList = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();
        if(isAnd){
            if(sno!= null){
                studentList = studentRepository.findStudentBySno(sno);
            }
            if(sname != null && !sname.isEmpty()){
                studentList2 = studentRepository.findStudentBySname(sname);
                if(studentList.isEmpty()){
                    studentList = studentRepository.findStudentBySname(sname);
                }
                else studentList.retainAll(studentList2);
            }
            if(sage != null){
                studentList2 = studentRepository.findStudentBySage(sage);
                if(studentList.isEmpty()){
                    studentList = studentRepository.findStudentBySage(sage);
                }
                else studentList.retainAll(studentList2);
            }
            if(ssex != null && !ssex.isEmpty()){
                studentList2 = studentRepository.findStudentBySsex(ssex);
                if(studentList.isEmpty()){
                    studentList = studentRepository.findStudentBySsex(ssex);
                }
                else studentList.retainAll(studentList2);
            }
            if(grade != null && !grade.isEmpty()){
                studentList2 = studentRepository.findStudentByGrade(grade);
                if(studentList.isEmpty()){
                    studentList = studentRepository.findStudentByGrade(grade);
                }
                else studentList.retainAll(studentList2);
            }
            if(classs != null){
                studentList2 = studentRepository.findStudentByClasss(classs);
                if(studentList.isEmpty()){
                    studentList = studentRepository.findStudentByClasss(classs);
                }
                else studentList.retainAll(studentList2);
            }
        }
        else{
             if(sno != null){
                 studentList = studentRepository.findStudentBySno(sno);
             }
             if(sname != null && !sname.isEmpty()){
                 studentList2 = studentRepository.findStudentBySname(sname);
                 studentList.addAll(studentList2);
             }
             if(sage != null){
                 studentList2 = studentRepository.findStudentBySage(sage);
                 studentList.addAll(studentList2);
             }
             if(ssex != null && !ssex.isEmpty()){
                 studentList2 = studentRepository.findStudentBySsex(ssex);
                 studentList.addAll(studentList2);
             }
             if(grade != null && !grade.isEmpty()){
                 studentList2 = studentRepository.findStudentByGrade(grade);
                 studentList.addAll(studentList2);
             }
             if(classs != null){
                 studentList2 = studentRepository.findStudentByClasss(classs);
                 studentList.addAll(studentList2);
             }
        }
        System.out.println(studentList.toString());
        return studentList;
    }
}
