package com.tpe.hb07.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {//many:ilişkinin sahibi

    @Id
    private Integer book_id;
    private String name;

    @ManyToOne //ilişkiyi kurar:book tablosuna FK ekler.cok olandan tek olana
    //@JoinColumn --> opsiyonel
    private Student07 student; //bu kitap hangi ogrenciye ait.kitaptan da ogrenciye ulasabiliriz

    //Cift yonlu ilişkide student ile book arasındaki ilişkide her iki entity ye diger entity yi field olarak ekliyoruz.
    //Book class ına student field ını ekliyoruz,book classına book listesini (bookList) ekliyoruz.
    //Student class ında @OneToMany anotasyonu Book classında @ManyToOne anotasyonu kullanılıyor.@ManyToOne kullanınca
    //ilişkinin kurulabilmesi icin bir FK sutunu eklenecek.Many olan tarafa FK sutunu eklenmesi yeterli.
    //Student(one olan) tablosunda @OneToMany kullanıldıgında joın table olusturuyor.Buna gerek yok ilişki zaten diger
    //tarafta kurulmus.mappedBy ile eslestirme yapar.

    //const
    public Book07() {
    }

    public Book07(Integer book_id, String name) {
        this.book_id = book_id;
        this.name = name;
    }

    //getter-setter

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
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
        return "Book07{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                '}';
    }
}