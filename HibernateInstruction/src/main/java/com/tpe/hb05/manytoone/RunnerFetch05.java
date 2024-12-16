package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:1002 olan ogrenciyi getirelim
        Student05 student = session.get(Student05.class,1002);
        System.out.println(student);
        System.out.println(student.getUniversity());

        //id:11 olan üniversitenin tüm öğrencilerini listeleyelim.HQL ile
        //java kodları ile bu task i yapamam cunku universite class ı icerisinde ogrenci ile ilgili bir bilgi yok.
        String hql = "SELECT s FROM Student05 s WHERE s.university = 11";
        List<Student05> resultList = session.createQuery(hql, Student05.class).getResultList();
        for (Student05 s:resultList){
            System.out.println(s);
        }
        //university.getStudents() ile bu işlemi yapamıyoruz -- Tek yonlu ilişki : ancak sorgu yazarak yapabiliyoruz.Tek yonlu ilişki kurdugumuz icin

        //öğrencilerin isimlerini, notlarını ve
        // üniversitelerinin isimlerini yazdıralım
        String hql2="SELECT s.name, s.grade, s.university.name FROM Student05 s";
        List<Object[]> resultList2=session.createQuery(hql2).getResultList(); //farklı data tipleri geldigi icin object[] yaptık
        for (Object[] o:resultList2){
            System.out.println(Arrays.toString(o));
        }

        // s.university.name -> university student ın field ı.burdan name i getir diyoruz
        //hibernate student ve university tablosunu birlestirdi

        session.close();
        sf.close();



    }
}
