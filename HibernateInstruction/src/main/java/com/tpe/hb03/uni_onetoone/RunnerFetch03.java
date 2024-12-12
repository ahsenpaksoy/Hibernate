package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:1001 olan öğrenciyi getirelim
        Student03 student=session.get(Student03.class,1001);

        //id:11 olan günlüğü getirelim
        Diary diary = session.get(Diary.class,11);

        System.out.println("*************************************");
        System.out.println(student);
        System.out.println("*************************************");
        System.out.println(diary);
        System.out.println("*************************************");

        //id:11 olan günlük kime ait
        System.out.println(diary.getStudent());//tekrar DB ye gitmeye gerek yok


        //id:1002 olan öğrencinin günlüğü hangisidir
        Student03 student2=session.get(Student03.class,1002);
        //student2.getDiary() -->java kodları ile ulaşamıyoruz fakat DB den ulaşabilirim
        String diaryname = (String) session.createSQLQuery("SELECT name FROM diary WHERE std_id=1002").uniqueResult();
        System.out.println(diaryname);

        //PROBLEM: sorgu yazmadan diaryden studenta , studentdan diarye ulaşmak istersem?
        //uni_directional(tek yönlü) : Diary  -> Student
        //bi_directional (çift yönlü) : Diary <-> Student(veritabanında birşey değişmez)






        session.close();
        sf.close();

    }
}