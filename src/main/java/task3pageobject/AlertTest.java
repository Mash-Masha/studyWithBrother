package task3pageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    private WebDriver driver;
    public AlertMainPage alertMainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\javalessons\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        alertMainPage=new AlertMainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
    }

    @Test
    public void acceptConfirmBox() {
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButton();
        try {
            Alert alert=driver.switchTo().alert();
            Thread.sleep(3000);
            alert.accept();
            WebElement message=driver.findElement(By.xpath("//p[@id='confirm-demo']"));
            Assert.assertTrue(message.getText().equals("You pressed OK!"));
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void dismissConfirmBox() {
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButton();
        try {
            Alert alert=driver.switchTo().alert();
            Thread.sleep(3000);
            alert.dismiss();
            WebElement message=driver.findElement(By.xpath("//p[@id='confirm-demo']"));
            Assert.assertTrue(message.getText().equals("You pressed Cancel!"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void alertBox() {
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButton2();
        try {
            Alert alert=driver.switchTo().alert();
            alert.sendKeys("Mary");
            Thread.sleep(3000);
            alert.accept();
            WebElement message=driver.findElement(By.xpath("//p[@id='prompt-demo']"));
            Assert.assertTrue(message.getText().equals("You have entered 'Mary' !"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
