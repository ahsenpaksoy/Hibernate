package com.tpe.practice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "p_student")
public class Student {

    @Id
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_generator",sequenceName = "seq_std",initialValue = 100,allocationSize = 3)
    private Integer id;

    @Column(name = "student_name",nullable = false,length = 50)
    private String name;

    private Integer grade;

    @ManyToMany(fetch = FetchType.EAGER) //ilişkiyi kurabilmek icin join table olusturur
    private Set<Course> courses = new HashSet<>();

    //const
    public Student() {
    }//hibernate fetch işlemlerinde bunu kullanır

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    //getter-setter


    public Integer getId() {
        return id;
    }

   // public void setId(Integer id) {
    //    this.id = id;
   // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}

