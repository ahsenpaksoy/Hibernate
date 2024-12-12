package com.tpe.hb02.embeddable;

import javax.persistence.Embeddable;
/*
@Embeddable Anotasyonu
@Embeddable, gömülü bir bileşen sınıfını tanımlamak için kullanılır.
Bu sınıf bir entity değildir; yalnızca bir entity'nin bir parçası olarak kullanılır.
@Embeddable sınıfı bağımsız bir tablo oluşturmaz.
Veritabanında, bu sınıfın alanları ana entity'nin
alanlarıyla aynı tabloya eklenir.

@Embedded Anotasyonu
@Embedded, bir entity içinde @Embeddable sınıfın kullanılacağını belirtir.
Entity, @Embedded sınıfın özelliklerini kendi özellikleri gibi kabul eder
 ve veritabanı tablosunda bunları ayrı sütunlar olarak saklar.

Kullanım Senaryoları:
Bir entity'deki adres, iletişim bilgileri vb.
gibi bir grup alanı(field) düzenli bir şekilde modellemek için uygundur.
 */
@Embeddable//gömülebilir
public class Address {

    //Address class i ayrı bir tablo(entity) degil.İcerisindeki field lardan bir sutun olusturulup Address objesinin
    //kullanıldıgı tabloya gomulmesini istedik.

    //Bir entity icerisinde baska bir sınıfın(entity olmayan) field larını sutun olarak gormek istersek @Embeddable
    //anotasyonu ile bu class ın gomulebilir bir class oldugunu gosterip @Embedded anotasyonu ile gomme işlemini gerceklestirebiliyoruz.
    //@Embedded anotasyonu opsiyonel kullanımı zorunlu degil.

    private String street;
    private String city;
    private String country;
    private String zipcode;

    //paramsiz const yok
    public Address() {
    }

    //paramli const
    public Address(String street, String city, String country, String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    //getter-setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    //toString

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
