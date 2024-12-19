package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //student getirelim: Burada fetch type lazy(onetomany) davrandı
        Student09 student=session.get(Student09.class,1001);
        System.out.println(student.getBookList());

        //book getirelim:EAGER(manytoone)
        Book09 book=session.get(Book09.class,11);
        System.out.println(book);
        System.out.println(book.getStudent());


        session.close();
        sf.close();

        //System.out.println(student.getBookList());
        //System.out.println(book.getStudent());

    }
}
