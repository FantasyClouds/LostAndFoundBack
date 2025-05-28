package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //查询所有学生
    @Override
    @Query("select s from Student s ORDER BY s.sno ASC ")
    List<Student> findAll();

    @Query("select s from Student s where s.sname like %?1%")
    List<Student> findByName(@Param("sname") String sname);

    @Query("SELECT s FROM Student s WHERE s.sname = :keyword ")
    List<Student> searchStudentByName(@Param("keyword") String keyword);

    //根据传入的内部id查找，通过参数修改。
    @Modifying
    @Query("UPDATE Student s SET s.sno = :sno, s.sname = :sname, s.sage = :sage, s.ssex = :ssex, " +
            "s.grade = :grade, s.classs = :classs, s.enrollmentTime = :enrollmentTime WHERE s.studentInternalId = :studentInternalId")
    int updateStudentById(@Param("studentInternalId") Long studentInternalId,
                          @Param("sno") Long sno,
                          @Param("sname") String sname,
                          @Param("sage") int sage,
                          @Param("ssex") String ssex,
                          @Param("grade") String grade,
                          @Param("classs") int classs,
                          @Param("enrollmentTime") String enrollmentTime);

    //根据id删除某学生
    @Query("DELETE FROM Student s WHERE s.sno = :sno")
    @Modifying
    int deleteStudentById(@Param("sno") Long sno);

    //分页查找
    @Query(value = "SELECT * FROM student ORDER BY sno ASC LIMIT :perPage OFFSET :offset", nativeQuery = true)
    List<Student> findAllWithPagination(@Param("offset") int offset, @Param("perPage") int perPage);

    //统计总数
    @Query("SELECT COUNT(s) FROM Student s")
    long countAll();
    //按照学号查询
    @Query("SELECT s FROM Student s WHERE s.sno = :sno")
    List<Student> findStudentBySno(@Param("sno") Long sno);
    //根据姓名查询
    @Query("SELECT s FROM Student s WHERE s.sname = :sname")
    List<Student> findStudentBySname(@Param("sname") String sname);
    //根据年龄查询
    @Query("SELECT s FROM Student s WHERE s.sage = :sage")
    List<Student> findStudentBySage(@Param("sage") int sage);
    //根据性别查询
    @Query("SELECT s FROM Student s WHERE s.ssex = :ssex")
    List<Student> findStudentBySsex(@Param("ssex") String ssex);
    //根据班级查询
    @Query("SELECT s FROM Student s WHERE s.classs = :classs")
    List<Student> findStudentByClasss(@Param("classs") int classs);
    //根据年级查询
    @Query("SELECT s FROM Student s WHERE s.grade = :grade")
    List<Student> findStudentByGrade(@Param("grade") String grade);
}
