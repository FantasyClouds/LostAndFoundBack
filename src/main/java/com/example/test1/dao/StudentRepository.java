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
    List<Student> findAll();

    @Query("select s from Student s where s.sname like %?1%")
    List<Student> findByName(@Param("sname") String sname);

    @Query("SELECT s FROM Student s WHERE s.sname = :keyword ")
    List<Student> searchStudentByName(@Param("keyword") String keyword);

    //根据传入的id查找，通过参数修改。
    @Modifying
    @Query("UPDATE Student s SET s.sname = :sname, s.sage = :sage, s.ssex = :ssex, s.grade = :grade, s.classs = :classs, s.enrollmentTime = :enrollmentTime WHERE s.sno = :sno")
    int updateStudentById(@Param("sno") Long sno, @Param("sname") String sname, @Param("sage") int sage, @Param("ssex") String ssex, @Param("grade") String grade, @Param("classs") int classs, @Param("enrollmentTime") String enrollmentTime);

    //根据id删除某学生
    @Query("DELETE FROM Student s WHERE s.sno = :sno")
    @Modifying
    int deleteStudentById(@Param("sno") Long sno);

    //分页查找
    @Query(value = "SELECT * FROM student LIMIT :perPage OFFSET :offset", nativeQuery = true)
    List<Student> findAllWithPagination(@Param("offset") int offset, @Param("perPage") int perPage);

    //统计总数
    @Query("SELECT COUNT(s) FROM Student s")
    long countAll();
}
