package com.tpe.hb01.basicannotations;

//hedef:
//dataları persist(kalıcı) etmek için bu classa karşılık bir tablo gerekli
//tablonun sütunları:id,name,grade
//create table student(id int, name varchar...)
//hibernate(ORM) bizim için bu hedefi otomatik olarak yapar.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student.class ismi ile aynı
@Table(name = "t_student")  //tablonun ismini kendimiz verebiliriz.OPSİYONEL
         // varlık, kalıcı hale getirdigimiz nesne
//!!! Javaca konuşurken bu sınıfı belirtirken Student,
//SQLce konuşurken t_student kullanırız.

public class Student { //kalici hale getirmek istedigimiz dataların oldugu class

    @Id  //id sütununa PK kısıtlamasının eklenmesini sağlar. Id anotasyonu ile diger sutunlara da eklenebilir.// sutun ismi onemli degil.bir sutuna pk eklenmesini saglar
    //@Column(name = "std_id")  //sutun ismini kendimiz de verebiliriz bu sekilde.
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50) //default:varchar(255) //sutun isimlerini de bu sekilde degistirebiliriz.not null ve unique ekledik ayrıca
    private String name; //not null
    private int grade;

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

    //toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
