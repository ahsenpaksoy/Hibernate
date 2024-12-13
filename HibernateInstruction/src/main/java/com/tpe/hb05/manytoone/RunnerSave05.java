package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student1=new Student05();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(100);

        Student05 student2=new Student05();
        student2.setId(1002);
        student2.setName("Harry");
        student2.setGrade(90);

        Student05 student3=new Student05();
        student3.setId(1003);
        student3.setName("Fred");
        student3.setGrade(95);

        University university=new University(11,"TPE University");

        student1.setUniversity(university);
        student2.setUniversity(university);

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(university);

        transaction.commit();
        session.close();
        sf.close();



    }
}
