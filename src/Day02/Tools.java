package Day02;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Utils.GenelWebDriver.driver;

public class Tools {



    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList){
        for (int i = 0; i< menuExpectedList.size();i++)
            Assert.assertEquals(menuExpectedList.get(i),menuActualList.get(i).getText(),"Karşılaştırma Sonucu ");


    }

    public static void successMessageValidation(){
        WebElement conTroll = GenelWebDriver.driver.findElement(By.xpath("//*[@id='account-account']/div[1]"));

        Assert.assertTrue(conTroll.getText().contains("Success: Your newsletter subscription has been successfully updated!"));
    }

    public static void succesMessageAccount(){

        WebElement contRol = driver.findElement(By.xpath("//*[@id='account-account']/div[1]"));

        Assert.assertTrue(contRol.getText().contains("Success: Your account has been successfully updated."));
    }
}
