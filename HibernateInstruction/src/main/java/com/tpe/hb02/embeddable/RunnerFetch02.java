package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().addAnnotatedClass(Student02.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:1002 olan öğrencinin tüm bilgilerini görelim
        //get,sql ve hql kullanabiliriz.session methodları yeterli oldugu icin bunu kullanıyoruz
        //id ye gore degil isme gore filtreleme isteseydi sql ve hql kullanıcaktık.
        Student02 student=session.get(Student02.class,1002);
        System.out.println(student);

        //get methodu ogrencinin tamamını tum sutunlarını getirir.
        //Student02 nin toString methoduna id,name ve grade i ekledigimiz icin yazdırdıgımızda sadece bunları gorduk.

        //öğrencinin adresini görelim
        System.out.println(student.getAddress()); //adresini yazdırdık


        session.close();
        sf.close();

        //fetch icin transaction a gerek yok
    }
}