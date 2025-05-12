package com.example.test1.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "姓名", nullable = false)
    private String name;

    @Column(name = "年龄")
    private int age;

    @Column(name = "性别")
    private String sex;

    @Column(name = "年级")
    private int grade;


    private int classs;
    private String time;

    public Student() {}
    public Student(/*Long id,*/ String name, int age, String sex, int grade, int classs, String time) {
        //this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
        this.classs = classs;
        this.time = time;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
    public int getClasss() { return classs; }
    public void setClasss(int classs) { this.classs = classs; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                ", classs=" + classs +
                ", time='" + time + '\'' +
                '}';
    }
}
