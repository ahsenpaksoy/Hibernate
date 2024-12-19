package com.tpe.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
1)  First Level Cache ---> first level onbellek
            * nesne için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            * nesne için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * second level cache ile kullanılabilir
            * aynı sorgunun sonucu cache e alınır.

 */
public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student11.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();


        System.out.println("************************************1 idli öğrenci için ilk get işlemi");
        Student11 student=session.get(Student11.class,1);
        System.out.println(student);//DB den gelir ogrenci

        session.clear();//cachei temizler.cache temiizlendigi icin yeniden database den getirdi.


        System.out.println("************************************1 idli öğrenci için ikinci kez get işlemi");
        Student11 student2=session.get(Student11.class,1);
        System.out.println(student2);//1.level cache den gelir

        session.close();//cache temizlendi

        //1. seviye cache ayni session icinde calisir
        //2. seviye cache session lar arasında da alısveris yapar.Cunku 2. seviye cache aynı sessionfactory icinde calısır


        Session session2=sf.openSession();

        System.out.println("************************************1 idli öğrenci için farklı sessionda get işlemi");
        Student11 student3=session2.get(Student11.class,1);
        System.out.println(student3);//ogrenci 2.level cash den gelir
//
//        System.out.println("************************************1 idli öğrenci için farklı sessionda 2.kez get işlemi");
//        Student11 student4=session2.get(Student11.class,1);
//        System.out.println(student4);

        session2.close();
        sf.close();


    }
}