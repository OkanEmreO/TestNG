package Day02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.

 */

public class _02_Subscribe extends GenelWebDriver {


   By Link = By.linkText("Newsletter");

   By OnAnsWer= By.cssSelector("label>input[value='1']");

   By ConTinuE=By.cssSelector("[value='Continue']");

   By OffAnswer = By.cssSelector("label>input[value='0']");




    @Test(priority = 1)
    void subscribeOn ()  {
        WebElement getNewLetter = driver.findElement(Link);

        getNewLetter.click();

        WebElement onClick = driver.findElement(OnAnsWer);
        onClick.click();


        WebElement conTinue = driver.findElement(ConTinuE);

        conTinue.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    void subscribeOff() {
        WebElement getNewLetter = driver.findElement(Link);

        getNewLetter.click();

        WebElement offClick = driver.findElement(OffAnswer);
        offClick.click();


        WebElement conTinue = driver.findElement(ConTinuE);

        conTinue.click();

        Tools.successMessageValidation();

    }
}
