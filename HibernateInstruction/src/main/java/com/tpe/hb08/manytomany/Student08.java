package com.tpe.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student08")
public class Student08 {

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;

    private int grade;

    //JOIN TABLE olusturulması icin @manytomany anotasyonu yeterli.Default degerler ile tablonun ismi olusturulur.
    //Talonun icine Student tablosundaki PK sutunu ve Course tablosundaki PK sutunundan referans alan iki tane
    //FK sutunu eklenir.Bu sutunların isimleri de varsayılan olarak olusturulur.
    //@JoinTable anotasyonunu join table daki sutun isimlerini veya tablonun isimlerini degiştirmek istersek kullanabiliriz.
    //@JoinColumns FK kısıtlamasının eklendigi sutun.İcinde bulundugumuz tablonun(Student08) PK sinsen gelen degerleri referans alır.
    //inverseJoinColumns ilişkinin diger tarafındaki FK sutunu.Degerlerini course tablosundaki PK dan alıcak.

    @ManyToMany//ilişkiyi kurar.nasıl mumkunse o sekilde kurar:JOIN TABLE olusturulur.
    @JoinTable(name = "student08_course", joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns ={@JoinColumn(name = "course_id")} )//opsiyonel
    private List<Course> courseList=new ArrayList<>();

    //const
    public Student08() {
    }

    public Student08(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter-setter

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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
        //Hem ogrencide kurs listesi olur toString metodunda hemde course un toString metodunda
        //ogrenci listesi olursa bir ogrencyi yada bir course u yazdırmak istedigimizde surekli
        //birbirlerini cagırdıkları icin stack over flow oluyordu.O yuzden birinden vazgecmeliyiz.
        //Burda course listesini almadık.
    }
}


