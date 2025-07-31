
package com.example.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

@TableName("student")
public class Student {

    @TableId(type = IdType.AUTO)
    private Long student_internal_id;

    @TableField
    private Long sno;

    @TableField
    private String sname;

    @TableField
    private int sage;

    @TableField
    private String ssex;

    @TableField
    private String grade;

    @TableField
    private int classs;

    @TableField
    private String enrollment_time;

    public Student() {}

    public Student(Long id, String sname, int age, String sex, String grade, int classs, String enrollmentTime) {
        this.sno = id;
        this.sname = sname;
        this.sage = age;
        this.ssex = sex;
        this.grade = grade;
        this.classs = classs;
        this.enrollment_time = enrollment_time;
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
    public String getEnrollmentTime() { return enrollment_time; }
    public void setEnrollmentTime(String enrollmentTime) { this.enrollment_time = enrollmentTime; }
    @JsonProperty("StudentInternalId")
    public Long getStudentInternalId() { return student_internal_id; }
    public void setStudentInternalId(Long studentInternalId) { this.student_internal_id = studentInternalId; }

    @Override
    public String toString() {
        return "Student{" +
                "StudentInternalId=" + student_internal_id +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", grade=" + grade +
                ", classs=" + classs +
                ", enrollmentTime='" + enrollment_time + '\'' +
                '}';
    }
}
;