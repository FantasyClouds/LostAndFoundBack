package com.example.test1.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test1.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.test1.dao.mapper.StudentMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao {
    private final StudentMapper studentMapper;

    @Autowired
    public DaoImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getStudentList(){
        return studentMapper.selectList(null);
    }

    //获取分页数据
    @Override
    public List<Student> getStudentList(int offset, int perPage){
        Page<Student> page = new Page<>(offset / perPage + 1, perPage);
        IPage<Student> result = studentMapper.selectPage(page, null);
        return result.getRecords();
    }

    //获取学生总数
    @Override
    public int getStudentCount(){
        return (int)studentMapper.selectCount(null).longValue();
    }

    @Override
    public List<Student> searchByName(String name){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("sname", name);
        return studentMapper.selectList(wrapper);
    }
    @Override
    public void addStudent(Student student){
        System.out.println("DaoImpl addStudent");
        System.out.println("Student: " + student.toString());
        studentMapper.insert(student);
    }
    @Override
    public void deleteStudents(List<Student> studentList){
        if(studentList == null || studentList.isEmpty()) {
            return;
        }
        List<Long> ids = new ArrayList<>();
        for(Student student : studentList) {
            ids.add(student.getStudentInternalId());
        }
        studentMapper.deleteBatchIds(ids);
    }

    //Amis框架单个修改学生信息
    public boolean updateStudent(Student student){
        try{
            return studentMapper.updateById(student) > 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //Amis框架单个删除学生信息
    public boolean deleteStudentAmis(Long sno){
        try{
            return studentMapper.deleteById(sno) > 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //Amis框架添加单个学生信息
    public boolean addStudentAmis(Student student){
        try{
            System.out.println(student.toString());
            return studentMapper.insert(student) > 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Student> searchStudent(Long sno, String sname, Integer sage, String ssex, String grade, Integer classs, Boolean isAnd){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        if(isAnd){
            if(sno != null){
                wrapper.eq("sno", sno);
            }
            if(sname != null && !sname.isEmpty()){
                wrapper.like("sname", sname);
            }
            if(sage != null){
                wrapper.eq("sage", sage);
            }
            if(ssex != null && !ssex.isEmpty()){
                wrapper.eq("ssex", ssex);
            }
            if(grade != null && !grade.isEmpty()){
                wrapper.eq("grade", grade);
            }
            if(classs != null){
                wrapper.eq("classs", classs);
            }
        }else{
            if(sno != null){
                wrapper.or().eq("sno", sno);
            }
            if(sname != null && !sname.isEmpty()){
                wrapper.or().like("sname", sname);
            }
            if(sage != null){
                wrapper.or().eq("sage", sage);
            }
            if(ssex != null && !ssex.isEmpty()){
                wrapper.or().eq("ssex", ssex);
            }
            if(grade != null && !grade.isEmpty()){
                wrapper.or().eq("grade", grade);
            }
            if(classs != null){
                wrapper.or().eq("classs", classs);
            }
        }
        List<Student> result = studentMapper.selectList(wrapper);
        System.out.println(result.toString());
        return result;
    }
}
