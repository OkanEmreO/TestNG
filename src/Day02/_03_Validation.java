package Day02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/*  Newsletter  üyelik işlemini, üye ise ,
     üyelikten çıkma, değilse ekleme şeklinde yapınız
 */

public class _03_Validation extends GenelWebDriver {

    By Link = By.linkText("Newsletter");

    By OnAnsWer= By.cssSelector("label>input[value='1']");

    By ConTinuE=By.cssSelector("[value='Continue']");

    By OffAnswer = By.cssSelector("label>input[value='0']");


    @Test(priority = 1)
    void subscribeOn ()  {
        wait.until(ExpectedConditions.elementToBeClickable(Link));
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

        wait.until(ExpectedConditions.elementToBeClickable(Link));
        WebElement getNewLetter = driver.findElement(Link);

        getNewLetter.click();

        WebElement offClick = driver.findElement(OffAnswer);
        offClick.click();


        WebElement conTinue = driver.findElement(ConTinuE);

        conTinue.click();

        Tools.successMessageValidation();

    }




    @Test(priority = 3)
    void subscribeChangeOnorOff ()  {

        wait.until(ExpectedConditions.elementToBeClickable(Link));
        WebElement getNewLetter = driver.findElement(Link);

        getNewLetter.click();

        WebElement onClick = driver.findElement(OnAnsWer);

        WebElement offClick = driver.findElement(OffAnswer);


        if (onClick.equals("No"))
            offClick.click();
        else if (offClick.equals("Yes")) {
            onClick.click();
        }

        WebElement conTinue = driver.findElement(ConTinuE);

        conTinue.click();

        Tools.successMessageValidation();
    }


}
