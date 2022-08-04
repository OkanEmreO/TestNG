package SoftSkills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Automation {

    By order = By.linkText("Order History");
    By empty = By.cssSelector("#content > p");

    By full = By.cssSelector("#content > p");

    By myAccount = By.cssSelector("#top-links > ul > li.dropdown > a");

    By logouTT = By.linkText("Logout");


    public static WebDriver driver;

    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicİslemleri() {
        System.out.println("Driver start ....");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));// sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // bütün webElement için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

    }

    @Test
    public void LogginTest() throws InterruptedException {
        WebElement inputEmail=driver.findElement(By.id("input-email"));
        TimeUnit.SECONDS.sleep(2);
        inputEmail.sendKeys("emreo@gmail.com");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        TimeUnit.SECONDS.sleep(2);
        inputPassword.sendKeys("55555555");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Login']"));
        TimeUnit.SECONDS.sleep(2);
        loginBtn.click();
    }

    @Test (dependsOnMethods = {"LogginTest"})
    public void getOrderHistory() throws InterruptedException {
        WebElement orderHistory = driver.findElement(order);
        TimeUnit.SECONDS.sleep(2);
        orderHistory.click();

        WebElement emptyBox = driver.findElement(empty);
        TimeUnit.SECONDS.sleep(2);

        WebElement fullBox = driver.findElement(full);

        if (fullBox.getText().contains("Your shopping cart is full")){
            System.out.println("You have past transactions." + fullBox.getText());
            Assert.assertTrue(fullBox.getText().contains("Your shopping cart is full"));
        } else if (emptyBox.getText().contains("Your shopping cart is empty!")) {
            System.out.println("You have no past transactions." + emptyBox.getText());
            Assert.assertTrue(emptyBox.getText().contains("Your shopping cart is empty!"));
        }

        TimeUnit.SECONDS.sleep(2);

        WebElement mylogOut = driver.findElement(myAccount);

        mylogOut.click();

        WebElement mymenu = driver.findElement(By.cssSelector("#top-links > ul"));

        Select menu = new Select(mymenu);

        menu.selectByVisibleText("Logout");

    }

    @AfterClass
    public void Bitisİslemler(){
        System.out.println("Driver stop ....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }




}
