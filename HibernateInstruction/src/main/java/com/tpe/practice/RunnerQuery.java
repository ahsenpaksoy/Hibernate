package com.tpe.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerQuery {
    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Instructor.class);

        SessionFactory sf =configuration.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction =session.beginTransaction();

        //TASK 3:id:100 olan öğrenciyi ve kurs listesini getirin
        Student student = session.get(Student.class,100); //student ı isteyince cours larda, instructor larda gelir
        System.out.println(student); //MS-MC : fetch type:EAGER
        System.out.println(student.getCourses()); //MC-1I:fetch type:default olarak:EAGER zaten
        System.out.println("-------------------------------------------------------------------------");

        //Task 4: id:11 olan kursu ve ogrenci listesini getirin
        Course course = session.get(Course.class,11);
        System.out.println(course);
        System.out.println(course.getStudentList());

        //TASK 5: id:3 olan instructor ı getirin
        Instructor instructor = session.get(Instructor.class,3); //simdi DB e gitti id:3 olanı getirdi
        System.out.println(instructor);

        //TASK 6:HQL sorguları çalıştırın:
        //1. Tüm Öğrencilerin Adlarını ve Notlarını Listeleme
        System.out.println("--------------------------------------------------------------------------------");
        String hql = "SELECT s.name,s.grade FROM Student s"; //s bir student objesi
        List<Object[]> students = session.createQuery(hql).getResultList();
        students.forEach(t-> System.out.println(Arrays.toString(t)));

        //2. Advanced Java Kursuna Kaydolan Öğrencilerin(adv java kursunun listesindeki ogrenciler) Adlarını Listeleme
        System.out.println("----------------------------------------------------------------");
        String hql2="SELECT s.name FROM Course c JOIN c.studentList s WHERE c.name='Advanced Java'";
        List<String> names=session.createQuery(hql2).getResultList();
        names.forEach(t-> System.out.println(t));

        // 3. Ali'nin Aldığı Kursların İsimlerini Listeleme:ÖDEV-hql ile


        transaction.commit();
        session.close();
        sf.close();


    }

}
