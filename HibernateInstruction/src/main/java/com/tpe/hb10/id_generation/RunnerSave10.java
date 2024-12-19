package com.tpe.hb10.id_generation;

import com.tpe.hb09.fetchtypes.Book09;
import com.tpe.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1=new Student10();
        student1.setName("Jack");

        Student10 student2=new Student10();
        student2.setName("Harry");

        Student10 student3=new Student10();
        student3.setName("Sherlock");

        Student10 student4=new Student10();
        student4.setName("Sherlock");

        Student10 student5=new Student10();
        student5.setName("Sherlock");

        Student10 student6=new Student10();
        student6.setName("Sherlock");

        Student10 student7=new Student10();
        student7.setName("Sherlock");


        Student10 student8=new Student10();
        student8.setName("Sherlock");

        Student10 student9=new Student10();
        student9.setName("Sherlock");

        Student10 student10=new Student10();
        student10.setName("Sherlock");

        Student10 student11=new Student10();
        student11.setName("Sherlock");



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student10.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        //1000-1001-1002-1003-1004-1005-1006-1007-1008-1009-1010
        //1011-1012-1013....-1020
        //1021-...
        //1030
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(student6);
        session.save(student7);
        session.save(student8);
        session.save(student9);
        session.save(student10);
        session.save(student11);



        transaction.commit();
        session.close();
        sf.close();
    }
}
