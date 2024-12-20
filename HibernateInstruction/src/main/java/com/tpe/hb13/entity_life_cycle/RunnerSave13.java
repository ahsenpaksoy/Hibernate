package com.tpe.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1=new Student13("Jack",99);//-->Transient durumda:DB de karşılığı yok, kalıcı değil
        Student13 student2=new Student13("Harry",99);//-->Transient:DB de karşılığı yok, kalıcı değil


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        //Bi entity persisted durumuna geldiginde artık Hibernate tarafından yonetiliyor.Hibernate in session ında
        //1. seviye cache e alınmıs session tarafından yonetiliyor demektir.
        session.save(student1);//-->persisted/managed:DB de bir satıra karşılık gelir:kalıcı
        student1.setName("Sherlock"); //persisted durumdayken session icinde ismini degistirdik Sherlock oldu.
        //Bu nesnede degişiklik yaptıgımızda hibernate bu degişikligi artık takip ediyor.

        session.save(student2);//persisted
        student2.setGrade(111);

        session.evict(student2);//entityi sessiondan detach eder.parametrede verilen ogrenciyi takipten cıkarır.
                                //Yapılan degişiklikler uygulama icinde kaldı DB e aktarılmadı.
        student2.setName("Ali");

        session.update(student2);//persisted - Student2 yi yeniden persisted duruma ceker.update detach edilmiş nesneyi tekrar baglar

        //uygulamada : student2:7,Ali,111
        //tabloda: 7, Harry, 99

        transaction.commit();
        session.close();

        student1.setName("Ahmet");//-->detached:DB de bir satıra karşılık gelir
        //session ı kapattıktan sonra ismini degiştirdim fakat ogrenciyi kaydetti guncelledi fakat ismi yine Sherlock olarak kaldı.
        //session kapandıgında dışına cıktıgımızda entity artık session dan ayrılmıstır,cache den ayrılmıstır.Hibernate artık yonetemez takip edemez.
        //detach durumda DB de bir karsiligi var fakat Hibernate tarafından yapılan degişiklikler aktarılmıyor.

        Session session2=sf.openSession();
        Transaction transaction2=session2.beginTransaction();

        //detached moddaki bir objeyi tekrar persisted durumuna alabiliriz.Yeni bir session acıp update methoduyla yapılır.

        session2.update(student1);//entitynin yeniden sessiona bağlanmasını sağlar:persisted
        student1.setGrade(10);                          //DB deki karşılığını uygulamanın icindeki objeye gore günceller
        //3,Ahmet,10

        transaction2.commit();
        session2.close();
        sf.close();


    }
}