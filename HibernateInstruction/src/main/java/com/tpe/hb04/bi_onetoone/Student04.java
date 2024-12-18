package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;

    private int grade;

    //mappedBy ogrenci ile gunluk arasında birebir ilişki var yeniden kurmaya gerek yok diyor.iki yonlu ilişki kurmuş olduk
    //ilişki diger tarafta kuruluyor sen sadece takip et diyor.Diary tarafında olusturuldu zaten

    //mappedBy diary04 classındaki studentın değerine göre eşleştirme yapar
    //student tablosuna fazladan FK eklemez!!!
    //mappedBy kullanılmazsa her iki tabloda FK eklenir.
    @OneToOne(mappedBy = "student") //bu ilişki zaten diary04 tarafında kuruldu.iki tabloyada FK eklemeye gerek yok
    private Diary04 diary;//one   //baska bir sınıfın objesini field olarak ekledigimizde ikisi arasında ilişki kuruyoruz

    //Student icinde bir gunluk field ına ihtiyacımız var.Nasıl gunlukten ogrenciye ulasabiliyorsak gunlukten de ogrenciye
    //bu sekilde ulasabiliriz.Bir class ın icine baska bir class ın objesini field olarak ekledigimizde bu iki classı(objeyi)
    //ilişkilendirmis oluyoruz.Bu ilişkiyi hibernate soylemek icinde @OneToOne kullandık.Bu anotasyon Student04 tablosuna diary_id
    //seklinde FK sutunu ekleyecek.bu ilişki zaten diary04 tarafında kuruldu.iki tabloyada FK eklemeye gerek yok.
    //mappedBy diyecekki bu ilişki zaten Diary04 classında student field ında kurulu bu ilişkiyi eşleştir takip edeceksin
    //diyor.

    //const
    public Student04() {
    }

    public Student04(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter-setter


    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
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
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
        //toString methodlarında ilişkili objeleri kullanıyorsak en azından birinde olmaması gerekir.
        //O yuzden burdan diary yi sildik.Cunku silmezsek hata vericek
    }
}