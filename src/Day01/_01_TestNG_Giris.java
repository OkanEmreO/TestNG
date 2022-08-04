package Day01;

import org.testng.annotations.Test;

public class _01_TestNG_Giris {





    // Eğer test metodlarına sıralama verilmezse, alfabetik sırasına göre çalışır.

    @Test(priority = 1) // priority sıralama yapar; Anlama annotation yani rotasyon sağlar.
    void webSitesiniAc(){
        System.out.println("Driver tanımlandı ve web sitesi acıldı.");
    }
    @Test(priority = 2)
    void loginTestIsleminiYap(){
        System.out.println("Login test işlemleri yapıldı.");
        // yeşil tik hatalı assertion yok demektir.
    }

    @Test(priority = 3)
    void driverKApat(){
        System.out.println("Driver kapatıldı ve çıkıldı");
    }
}
