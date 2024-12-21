package com.tpe.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*TASK 1:Student-Course-Instructor entitylerini oluşturun.
        Student-Course:M-M
        Course-Instructor:M-1
        Student: id:auto generated,name,grade,courseList(öğrenci geldiğinde kursu da gelsin)

        Course:id,name,credit,studentList,instructor(course kaydedilince instructor da kaydedilsin)

        Instructor:id:auto generated,name,courses

        TASK 2:5'er tane objeyi kaydedin

        TASK 3:id:100 olan öğrenciyi ve kurs listesini getirin
        TASK 4:id:11 olan kursu ve öğrenci listesini getirin
        TASK 5:id:1 olan instructorı getirin
        TASK 6:HQL sorguları çalıştırın:
*/
public class RunnerSave {
    public static void main(String[] args) {

        //Student Objeleri

        Student student1 = new Student("Ali",88);
        Student student2 = new Student("Ferit",75);
        Student student3 = new Student("Şaban",89);
        Student student4 = new Student("İsmail",77);
        Student student5 = new Student("Necmi",99);


        //Course Objeleri

        Course course1 = new Course(11, "Hibernate", 4);
        Course course2 = new Course(12, "Advanced Java", 5);
        Course course3 = new Course(13, "Spring Boot", 3);
        Course course4 = new Course(14, "JDBC", 3);
        Course course5 = new Course(15, "SQL", 5);


        ///Instructor Objeleri
        Instructor instructor1 = new Instructor();
        instructor1.setName("Mahmut");

        Instructor instructor2 = new Instructor();
        instructor2.setName("Ekrem");

        Instructor instructor3 = new Instructor();
        instructor3.setName("Semra");

        Instructor instructor4 = new Instructor();
        instructor4.setName("Avni");

        Instructor instructor5 = new Instructor();
        instructor5.setName("Akil");

        //Java objelerini eslestiriyoruz
        course1.setInstructor(instructor1); //FK sutununa instructor 1 in id sini ekler
        //instructor1.getCourses().add(course1); //ikiside aynı sey.bu satıra gerek yok.mappedBy ile halledecek

        course2.setInstructor(instructor1);
        course3.setInstructor(instructor2);
        course4.setInstructor(instructor3);
        course5.setInstructor(instructor4);

        student1.getCourses().add(course1);
        //course1.getStudentList().add(student1);Bunu yapmaya gerek yok mappedBy hazır ilişkiyi kullanarak olusturur.
        student1.getCourses().add(course2);

        student2.getCourses().add(course2);
        student2.getCourses().add(course3);
        student2.getCourses().add(course4);

        student3.getCourses().add(course4);

        student4.getCourses().add(course4);
        student4.getCourses().add(course2);


        Configuration configuration = new Configuration().configure().
                      addAnnotatedClass(Student.class).
                      addAnnotatedClass(Course.class).
                      addAnnotatedClass(Instructor.class);
        SessionFactory sf=configuration.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(course5);

//inst a kurs lari eklemedim cunku otomatik eşleştirilecek----Kurs kaydedice instructor ını da kaydedecek
        //instructor5 kaydedilmeyecek cunku dersi yok

        transaction.commit();
        session.close();
        sf.close();


    }
}
