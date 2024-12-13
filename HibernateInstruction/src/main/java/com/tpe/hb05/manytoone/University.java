package com.tpe.hb05.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {

    @Id
    private Integer id;

    private String name;

    //paramsiz const

    public University() {
    }

    //paramli const

    public University(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}




