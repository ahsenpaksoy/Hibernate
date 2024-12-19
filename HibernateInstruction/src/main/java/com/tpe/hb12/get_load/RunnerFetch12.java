package com.tpe.hb12.get_load;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı

   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı

 */
public class RunnerFetch12 {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student12.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //get
        System.out.println("---------------get metodundan önce");
        Student12 student=session.get(Student12.class,1);
        System.out.println("---------------get metodundan sonra");
        System.out.println("ID : "+student.getId());
        System.out.println("Öğrencinin adı: "+student.getName());


        //load
        System.out.println("---------------load metodundan önce");
        Student12 student2=session.load(Student12.class,2);
        System.out.println("---------------load metodundan sonra");

        //printStudent(Student12 student){
        // birçok kod
        //
        // student.name
        // };

        //obj.printStudent(student2);

        System.out.println("ID : "+student2.getId());
        System.out.println("Öğrencinin adı: "+student2.getName());


        //tabloda olmayan bir kayıt için kullanılırsa
        //get
        Student12 student3=session.get(Student12.class,100);//null
        if (student3!=null){

            System.out.println(student3.getName());
        }else {
            System.out.println("Öğrenci bulunamadı!");
        }

        //load
        try {
            Student12 student4=session.load(Student12.class,200);
            System.out.println(student4);
        }catch (ObjectNotFoundException e){
            System.out.println("Öğrenci bulunamadı!");
        }



        session.close();
        sf.close();
    }
}