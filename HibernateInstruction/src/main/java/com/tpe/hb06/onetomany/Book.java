package com.tpe.hb06.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book { //many

    @Id
    private Integer book_id;
    private String name;

    //@ManyToOne
    //private Student06 student;

    //join(ilişki) tablosu yaparız.
    //Eger onetomany varsa FK ogrenci tablosuna ekleyemeyiz.book tablosuna ekleriz.onetomany yada manytoone ilişkide
    //FK yı many tarafa ekleriz.
    //onetomany yada manytoone ilişkide  iki secenek var.many olan tarafa FK ekleriz yada yeni bir tablo olustururuz

    //const

    public Book() {
    }

    public Book(Integer book_id, String name) {
        this.book_id = book_id;
        this.name = name;
    }

    //getter-setter

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
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                '}';
    }
}
