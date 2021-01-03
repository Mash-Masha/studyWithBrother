package task3pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RefreshTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
    }

    @Test
    public void refreshPage(){
        driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();
        Actions actions=new Actions(driver);
        if(driver.findElement(By.xpath("//div[text()=='50%']")).isDisplayed())
            actions.sendKeys(Keys.F5).build().perform();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
