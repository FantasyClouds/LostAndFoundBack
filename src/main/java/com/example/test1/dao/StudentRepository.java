package com.example.test1.dao;

import com.example.test1.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    @Query("select s from Student s where s.name like %?1%")
    List<Student> findByName(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.name = :keyword ")
    List<Student> searchStudentByName(@Param("keyword") String keyword);
}
