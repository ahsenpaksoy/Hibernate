package com.tpe.hb01.basicannotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Employee {

    @Id
    private Long id;

    private String name;

    private Double salary;//%50$

    @Transient //Database de bu field a karsilik bir sutun olusmasini engeller. field in tabloya eklenmesini istemiyorsak kullaniyoruz
    private Double bonus;//50
    //bonusun tabloda yer almasina gerek yok

 //   @Lob //Large Object:bu sutunda buyuk boyutta dataların saklanmasini saglar.resim video ses gibi
 //   private byte[] image;
    //daha cok reference ini yolunu gosterme tercih edilir yukleme yapmaktan ziyade

    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}
