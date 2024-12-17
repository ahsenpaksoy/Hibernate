package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //db de değişikliklerin kalıcı olması için transaction gereklidir
        Transaction t =session.beginTransaction();

        // !!! Kitab bilgisi(ilişkisi) olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir
        // 2.yol ) Cascade:CascadeType.REMOVE / orphanRemoval

        //FK olan tablo child diyebiliriz.
        //ilişkiyi koparmamız gerekiyor.once child sonra parent silinecek
        //orphanRemoval sadece onetomany anotasyonunda var.


        //id:1002 olan öğrenciyi silelim:Cascade:CascadeType.REMOVE / orphanRemoval aynı. İkisi de aynı işi yapar.
        Student07 student = session.get(Student07.class,1002); //silmek icin entity nin kendisi gerekli.o yuzden ogrenciyi getirdik once.
        session.delete(student);
        //delete methodu silmek istedigimiz objeyi alıyor.Oncelikle ogrenciyi obje olarak almamız gerekiyor


        //id:1001 olan öğrencinin kitap listesinden ilkini silelim
        Student07 student2=session.get(Student07.class,1001);
        student2.getBookList().remove(0);//1001: 101,102-->102
        student2.getBookList().set(0,null); //1001: 102 --> null
        //orphanRemoval collectiondan bir eleman silinir veya null yapılırsa
        // referansı olmayan bu nesneyi tablodan da siler

        //orphanRemoval ı hangi durumlarda kullanmalıyıza ornekler
        //1-std-book-->std kitabı iade etti-->listeden kaldırdık-->tablodan silmemeliyiz->bu durumda orphanRemoval:false olmalı
        //2-müşteri-sipariş-->sipariş listesi(1,2,3)
        //                 -->siparişi iptal(1)-->sipariş listesi(2,3)
        //müşterinin oluşturduğu siparişi tabloda tutmaya gerek var mı--orphanRemoval:true


        t.commit();
        session.close();
        sf.close();

    }
}
