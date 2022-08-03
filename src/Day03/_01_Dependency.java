package Day03;

/*
   interviewlarda sorulan bir konu : testlere öncelikleri nasıl verirsin ?
   priority, dependecy;   Nasıl kullanırsın ?
   1- priority =1 gibi sıralı rakamlar vererek bununla çalışma sırasını belirtirim.
   2- dependOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
    bir metodu direkt çalıştırdığınızda kendinden önce bağımlı 1  metod var ise ototmaitk onları
    önce çağırıp sonra kendisi çalışır. Fakat 2 veya daha fazla tane var ise bağımlı olduğu metod
    ozaman çalışamaz.
 */

import org.checkerframework.checker.units.qual.Temperature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {


    @Test
    void startCar(){
        System.out.println("Car started");
    }

    @Test(dependsOnMethods = {"startCar"}) // bu testin çalışması, startCar'ın hatasız calışmasına bağımlı
    void driveCar(){
        System.out.println("car drive");
        Assert.fail();// fail yaparak hata verdiriyorum, diğer kodlar bu koda bağımlı olduğu
        // icin otomatik olarak pasif kalıyor ve run yaptırmıyor.Yani diğer kodlar bağımlı
    }

    @Test(dependsOnMethods = {"startCar","driveCar"}) // bu testin calısması icin verilen 2 testin hatasız bitmesi lazım
    void parkCar(){
        System.out.println("car parked");
    }

    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true) // alwaysRun herzaman calıs anlamına gelir.Yani ne olursa olsun calıs
    void stopCar(){
        System.out.println("car stop");
    }

}
