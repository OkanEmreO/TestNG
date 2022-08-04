package Day03;
/*
    Senaryo;
    1-Siteyi açınız
    2- Adress Ekleyiniz.
    3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
    4- En son eklenen adresi siliniz.
*/

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends GenelWebDriver {

    By adress = By.linkText("Address Book");
    By newAdress = By.linkText("New Address");
    By nameArea = By.id("input-firstname");
    By surName = By.id("input-lastname");
    By adress1= By.id("input-address-1");
    By cityArea = By.id("input-city");
    By postNumber = By.id("input-postcode");
    By countryArea = By.xpath("//select/option[@value='5']");
    By yesSelect = By.xpath("//input[@value='1' or checked='checked']");
    By conTinue = By.cssSelector("[type='submit']");


    @Test
    void adressEkle(){

        WebElement adres = driver.findElement(adress);
        adres.click();

        WebElement yeniAdres = driver.findElement(newAdress);
        yeniAdres.click();

        WebElement name = driver.findElement(nameArea);
        name.sendKeys("Ahmet");

        WebElement soyİsim = driver.findElement(surName);
        soyİsim.sendKeys("kel");

        WebElement ilkAdres = driver.findElement(adress1);
        ilkAdres.sendKeys("555 Street");

        WebElement sehir = driver.findElement(cityArea);
        sehir.sendKeys("İstanbul");

        WebElement postaBox = driver.findElement(postNumber);
        postaBox.sendKeys("34000");


        int ulkeSayı =(int) (Math.random()*253);

        /*WebElement ulkeAlani = driver.findElement(By.xpath("//select/option[@value='"+ulkeSayı+"']"));
         ulkeAlani isimli element cok uzun oldu ve bulması sıkıntılı. O yüzden altta ki elementi kullanıyoruz.Yani State

       ulkeAlanı.click();*/

        WebElement Country = driver.findElement(By.id("input-country"));

        Select menu = new Select(Country);

        menu.selectByIndex(ulkeSayı);

        WebElement State = driver.findElement(By.id("input-zone"));

        Select menu2 = new Select(State);
        System.out.println("menu2.getOptions().size() 1 = " + menu2.getOptions().size());

        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("[id='input-zone']>option"))));
        // bu elemanın bayatlamış hali gidene kadar bekle
        // sistemi yakalamak gerekiyor

        menu2.selectByIndex(3);
        // burası hata verebilir cünkü ülke kısmını random aldığımız'dan dolayı sehir kısmı boş gelebiliyor
        // yani ülkenin sehir sayısı mesela 2 ise sistem göremediği için hata veriyor diyebiliriz

        WebElement evetAnswer = driver.findElement(yesSelect);
        evetAnswer.click();

        WebElement devam = driver.findElement(conTinue);

        devam.click();

        Tools.succesMessageAddress();

    }

    @Test(dependsOnMethods = {"adressEkle"})
    void editAddress(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement sonEdit = editAll.get(editAll.size()-1); // sonuncu edit
        System.out.println("editAll"+ editAll.size());
        sonEdit.click();

        WebElement isim = driver.findElement(nameArea);
        isim.clear();
        isim.sendKeys("Mehmet");

        WebElement soyisim = driver.findElement(surName);
        soyisim.clear();
        soyisim.sendKeys("Yılmaz");

        WebElement cnt = driver.findElement(conTinue);
        cnt.click();

        Tools.succesMessageAddress();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List <WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        WebElement sonDelete = deleteAll.get(deleteAll.size()-2);
        sonDelete.click();

        Tools.succesMessageAddress();
    }

}
