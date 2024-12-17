package com.tpe.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "courseList") //JOIN TABLE kurar:ismi course_t_student08:joın table a gerek yok diger taraftan takip et,eslestir
    private List<Student08> studentList=new ArrayList<>();

    //mappedBy diger tarafta ilişkiyi kuran field ın ismiyle map lenir.Ogrenci kursları verildiginde Course tablosu da tersini
    //okuyacak.Yani bu kursun ogrencilerini belirtecek.Tekrar joın table a gerek yok diger taraftan eslestir.

    //const

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter-setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
