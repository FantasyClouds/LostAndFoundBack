package com.example.test1.dao.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "studentinternalid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentInternalId;

    @Column(name = "sno", unique = true, nullable = false)
    private Long sno;

    @Column(name = "sname")
    private String sname;

    @Column(name = "sage")
    private int sage;

    @Column(name = "ssex")
    private String ssex;

    @Column(name = "grade")
    private String grade;

    @Column(name = "classs")
    private int classs;

    @Column(name = "enrollmenttime")
    private String enrollmentTime;

    public Student() {}

    public Student(Long id, String sname, int age, String sex, String grade, int classs, String enrollmentTime) {
        this.sno = id;
        this.sname = sname;
        this.sage = age;
        this.ssex = sex;
        this.grade = grade;
        this.classs = classs;
        this.enrollmentTime = enrollmentTime;
    }
    @JsonProperty("Sno")
    public Long getSno() { return sno; }
    public void setSno(Long sno) { this.sno = sno; }
    @JsonProperty("Sname")
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    @JsonProperty("Sage")
    public int getSage() { return sage; }
    public void setSage(int age) { this.sage = age; }
    @JsonProperty("Ssex")
    public String getSsex() { return ssex; }
    public void setSsex(String sex) { this.ssex = sex; }
    @JsonProperty("Grade")
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    @JsonProperty("Classs")
    public int getClasss() { return classs; }
    public void setClasss(int classs) { this.classs = classs; }
    @JsonProperty("EnrollmentTime")
    public String getEnrollmentTime() { return enrollmentTime; }
    public void setEnrollmentTime(String enrollmentTime) { this.enrollmentTime = enrollmentTime; }
    @JsonProperty("StudentInternalId")
    public Long getStudentInternalId() { return studentInternalId; }
    public void setStudentInternalId(Long studentInternalId) { this.studentInternalId = studentInternalId; }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", grade=" + grade +
                ", classs=" + classs +
                ", enrollmentTime='" + enrollmentTime + '\'' +
                '}';
    }
}
;