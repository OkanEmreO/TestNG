package Day02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */

public class _04_EditAccount extends GenelWebDriver {

    By editAccount = By.linkText("Edit Account");

    By name = By.id("input-firstname");

    By surName = By.id("input-lastname");

    By conTinue = By.cssSelector("[type='submit']");

    @Test
    void EditAccount(){

        editAccount("Ahmet","Demir");
        Tools.Bekle(2);
        editAccount("Okan","Emre");
    }




    @Test
    void editAccount(String ad,String soyad){

        WebElement editt = driver.findElement(editAccount);

        editt.click();

        WebElement Name = driver.findElement(name);

        Name.clear();

        Name.sendKeys(ad);

        WebElement Surname = driver.findElement(surName);

        Surname.clear();

        Surname.sendKeys(soyad);

        WebElement contine = driver.findElement(conTinue);

        contine.click();

        Tools.succesMessageAccount();


    }


}
