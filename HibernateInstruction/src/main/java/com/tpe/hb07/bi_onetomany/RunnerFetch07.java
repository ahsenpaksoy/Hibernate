package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:101 olan kitabı getirelim
        Book07 book = session.get(Book07.class,101);
        System.out.println(book);
        //bu kitabın sahibi olan ogrenciyi gorelim
        System.out.println(book.getStudent()); //kitabı isteyince yanında ogrenciyi de getirdi.iki sorgu yazmaya,database e gitmeye gerek kalmadı.

        //id:1002 olan öğrencinin kitaplarını getirelim
        Student07 student = session.get(Student07.class,1002);
        System.out.println(student.getBookList()); //cift yonlu ilişki ile tekrar sorgu yazmadan, database e gidip kitapları getirdi.

        //db de değişikliklerin kalıcı olması için transaction gereklidir.
        Transaction t =session.beginTransaction();

        //book07 tablosunda tüm kayıtları silelim
        String hql="DELETE FROM Book07";
        int deletedBooks=session.createQuery(hql).executeUpdate();
        System.out.println("Silinen kitap sayısı: "+deletedBooks);

        //student07 tablosunda tüm kayıtları silelim
        String hql2="DELETE FROM Student07";
        int deletedStudents=session.createQuery(hql2).executeUpdate();
        System.out.println("Silinen ogrenci sayısı : " + deletedStudents);

        //İsmi Sefiller olan kitabı HQL ile silelim.
        String hql3 = "DELETE FROM Book07 b WHERE b.name = 'Sefiller'";
        int deleted = session.createQuery(hql3).executeUpdate();
        System.out.println("Silinen kayıt sayısı : " + deleted);


        t.commit();
        session.close();
        sf.close();


    }
}
