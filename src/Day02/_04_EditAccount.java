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
    void editAccount(){

        WebElement editt = driver.findElement(editAccount);

        editt.click();

        WebElement Name = driver.findElement(name);

        Name.clear();

        Name.sendKeys("Fatih");

        WebElement Surname = driver.findElement(surName);

        Surname.clear();

        Surname.sendKeys("Terim");

        WebElement contine = driver.findElement(conTinue);

        contine.click();

        Tools.succesMessageAccount();

        WebElement ediT = driver.findElement(editAccount);

        ediT.click();

        WebElement name2 = driver.findElement(name);

        name2.clear();

        name2.sendKeys("Kamil");

        WebElement surname2 = driver.findElement(surName);

        surname2.clear();

        surname2.sendKeys("Yali");

        WebElement continue2 = driver.findElement(conTinue);

        continue2.click();

        Tools.succesMessageAccount();







    }


}
