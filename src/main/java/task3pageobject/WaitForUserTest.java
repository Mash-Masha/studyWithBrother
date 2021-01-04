package task3pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForUserTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
    }

    @Test
    public void waiter(){
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();
        WebDriverWait waitUser=(new WebDriverWait(driver,10));
        if (waitUser.until(ExpectedConditions.presenceOfElementLocated(By.id("loading"))).isDisplayed())
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
