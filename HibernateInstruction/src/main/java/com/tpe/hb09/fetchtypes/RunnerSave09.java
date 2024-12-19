package com.tpe.hb09.fetchtypes;

import com.tpe.hb08.manytomany.Course;
import com.tpe.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {

        Student09 student1 = new Student09(1001,"Ali",70);
        Student09 student2 = new Student09(1002,"Veli",70);
        Student09 student3 = new Student09(1003,"Can",70);
        Student09 student4 = new Student09(1003,"Deniz",70);

        Book09 book1=new Book09(11,"A Book");
        Book09 book2=new Book09(22,"B Book");
        Book09 book3=new Book09(33,"C Book");
        Book09 book4=new Book09(44,"D Book");
        Book09 book5=new Book09(55,"E Book");

        //ilişkinin kurulması için book tarafından set edilmeli.ilişkinin sahibi olan taraf book.student map le diyor.
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        //deniz kaydedilmemiş kitabı olmadıgı icin
        //ÖNEMLİ: cascadeType:ALL ilişki sahibi olmayan tarafta kullanılırsa
        //iki tarafta da set edilmeli
//        student1.getBookList().add(book1);
//        student1.getBookList().add(book2);
        //burada cascadeType ın işlevini yerine getirebilmesi icin eger diger taraftan kullanıldıysa student
        //tarafından da ilişkinin set edilmesi gerekir.

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);


        transaction.commit();
        session.close();
        sf.close();

    }
}
