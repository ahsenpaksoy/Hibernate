package com.tpe.hb06.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 { //one

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;

    private int grade;

    @OneToMany  //ilişki anotasyonları tablolar arasında ilişkinin kurulmasını sağlar:ilişki tablosu oluşturur.
    @JoinColumn(name = "student_id") //book tablosuna fk ekler
    //JOIN TABLE iptal, book tablosuna FK ekler:ZORUNLU
    //join column kullanılmazsa JOIN TABLE oluşturulur.
    private List<Book> bookList = new ArrayList<>(); //bir ogrencinin birden fazla kitabı olabilir.bu ogrencinin kitapları nelerdir

    //@OneToMany anotasyonu FK sutunu yeterli olmadıgı icin ilişkinin kurulması icin bir ilişki tablosu(3. tablo) olusturur
    //3. tablonun olusmasının engellenmesi icin @JoinColumn kullandık

    //many olan tarafta FK olusturmak yeterli ise 3. tabloya gerek yok

    //const

    public Student06() {
    }

    public Student06(Integer id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    //getter-setter


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
