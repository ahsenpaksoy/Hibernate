package com.tpe.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner13 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        Student13 student = session.get(Student13.class,1); //bu entity persisted moddadır.hibernate tarafından yonetiliyor demek
        student.setName("Mehmet");//1,Mehmet,99

        session.delete(student);//persisted durumdaki entity yi ogrenciyi removed yapar.db de karsılıgı yok.Tamamen ogrenciyi siler

        transaction.commit();
        session.close();
        sf.close();

        //Hibernate default olarak first level cache ile calısır.Entity objelerini first level cache de tutar,
        //ayırana kadar session ı kapatana kadar


    }
}
