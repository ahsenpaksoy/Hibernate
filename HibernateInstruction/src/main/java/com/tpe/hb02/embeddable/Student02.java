package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id//id sütununa PK kısıtlamasının eklenmesini sağlar
    //@Column(name = "std_id")
    private Integer id; //id sutununda 0, null olması icin wrapper kullandık

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;//not null, sadece tek bir isim mevcut olabilir

    private int grade;

//    private String street;
//    private String city;
//    private String country;
//    private String zipcode;

    @Embedded//gömülü:OPSİYONEL
    private Address address;

    //paramsiz const:hibernate fetch işlemlerinde default const kullanır.
    public Student02() {
    }

    //paramli const
    public Student02(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    //getter-setter

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
/*
Java'da @Embeddable ve @Embedded anotasyonları, Java Persistence API (JPA) ile birlikte kullanılarak, bir sınıfı başka
bir entity sınıfına gömme (embed) özelliği sağlar. Bu anotasyonlar, veritabanı tablolarında ayrı tablolar oluşturmadan,
bir entity sınıfının içindeki alanları tek bir tabloya eşleştirmenize olanak tanır.
 */
