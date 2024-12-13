package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;

    private int grade;

    private LocalDateTime createOn;

    //icinde oldugum sınıf tablo many olan kısım.many student one university
    @ManyToOne //t_student05 ile university tablosu arasında M-1 ilişki kurar
               //t_student05 tablosuna FK ekleyerek ilişkiyi kurar:university_id
    private University university;//ONE

    //const
    public Student05() {
    }

    public Student05(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    //manytoone ilişkide many olan tarafa FK eklenir

    //getter-setter


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    @PrePersist//kalıcı hale getirmeden önce bu metod çağrılacak!!!
    //bu metod student objem veritabanına kayıt edilmeden hemen önce çağrılsın
    public void setCreateOn() {
        this.createOn = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}