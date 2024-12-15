package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1=new Student04();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(100);

        Student04 student2=new Student04();
        student2.setId(1002);
        student2.setName("Harry");  //Harry nin gunlugu yok zorunlu degil
        student2.setGrade(90);

        Student04 student3=new Student04();
        student3.setId(1003);
        student3.setName("Fred");
        student3.setGrade(95);

        Diary04 diary1=new Diary04();
        diary1.setId(11);
        diary1.setName("Jack's Diary");

        Diary04 diary2=new Diary04();
        diary2.setId(22);
        diary2.setName("Fred's Diary");

        Diary04 diary3=new Diary04();
        diary3.setId(33);
        diary3.setName("X's Diary");

        //ilişkinin sahibi olan tablo(class) tarafından set etmeliyiz
        //ilişki gunluk tarafındaki FK sutunuyla olusturuluyorsa gunluge ogrenciyi set etmeliyiz
        //Eger gunluge ogrenciyi set etmezsek gunluk tablosunfaki FK sutunu bos kalır ve satırlar arasındaki ilişki kurulamaz
        //bunu yapmak zorunlu.
        diary1.setStudent(student1); //FK sutununa ogrencinin id si eklensin
        diary2.setStudent(student3);

        //student1.setDiary(diary1); -->mappedBy ile bu işlem otomatik olarak yapılıyor zorunlu degil

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        transaction.commit();
        session.close();
        sf.close();



    }
}
