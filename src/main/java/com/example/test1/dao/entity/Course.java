package com.example.test1.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @Column(name = "course_internal_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_internal_id;

    @Column(name = "cno", unique = true, nullable = false)
    private Integer cno;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "course_credit")
    private String course_credit;

    public Course() {}

    public Course(Integer cno, String course_name, String course_credit) {
        this.cno = cno;
        this.course_name = course_name;
        this.course_credit = course_credit;
    }

    @JsonProperty("cno")
    public int getCourse_internal_id() { return course_internal_id; }
    public void setCourse_internal_id(int course_internal_id) { this.course_internal_id = course_internal_id; }
    @JsonProperty("course_name")
    public String getCourse_name() { return course_name; }
    public void setCourse_name(String course_name) { this.course_name = course_name; }
    @JsonProperty("course_credit")
    public String getCourse_credit() { return course_credit; }
    public void setCourse_credit(String course_credit) { this.course_credit = course_credit; }

    @Override
    public String toString() {
        return "Course{" +
                "course_internal_id=" + course_internal_id +
                ", cno=" + cno +
                ", course_name='" + course_name + '\'' +
                ", course_credit='" + course_credit + '\'' +
                '}';
    }
}
