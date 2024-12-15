package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Student03;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 {//ONE

    @Id
    private Integer id;

    private String name;

    @OneToOne//diary04 ile t_student04 arasında 1-1 ilişki kurulmasını sağlar
    //bunun için diary e FK ekler: default ismi : student_id
    //Birebir ilişkide sadece bir tabloya FK sutununun eklenmesi yeterli
    @JoinColumn(name ="std_id",unique = true )//OPSİYONEL(isim değiştirme, constraint ekleme vs.)
    private Student04 student;//günlük hangi öğrenciye ait : ONE


    //getter-setter

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "student: "+student+
                '}';
    }
}