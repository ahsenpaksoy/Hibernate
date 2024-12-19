package com.tpe.hb10.id_generation;

import javax.persistence.*;

/*
id degerlerini otomatik olarak generate etmek istersek hibernate de 4 strateji var:
IDENTITY:1 den başlar 1er artırarak id leri generate eder.
TABLE:id üretmek için tablo oluşturur,EN YAVAŞ, bu sebeple pek tercih edilmez
SEQUENCE:id set oluşturur,başlangıç değeri verebiliriz,HIZLIDIR
AUTO:Kullanılan DB ye göre stratejiyi belirler
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)
 */
@Entity
public class Student10 {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //deger otomatik olarak uretilir
//    private Integer id;

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE) //kontrol bizde ayarları biz vericez
    @SequenceGenerator(name = "sequence",
            sequenceName = "idsequence",//default ismi:hibernate_sequence
            initialValue = 1000,//default:1
            allocationSize = 10)//id setinde kaç adet id olacak, default:50

    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    //getter-setter

    public Integer getId() {
        return id;
    }

/*    public void setId(Integer id) { //id otomatik uretilecegi icin burda gerek yok
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
