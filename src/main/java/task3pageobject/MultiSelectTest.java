package task3pageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MultiSelectTest {
    private  WebDriver driver;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }



    @Test
    public  void isSelectedRows() {
        WebElement isSelect= driver.findElement(By.xpath("//option[text()='California']"));
        if(!isSelect.isSelected())
                isSelect.click();
        Assert.assertTrue(isSelect.isSelected());
        WebElement isSelect2= driver.findElement(By.xpath("//option[text()='Florida']"));
        if(!isSelect2.isSelected())
            isSelect2.click();
        Assert.assertTrue(isSelect2.isSelected());
        WebElement isSelect3= driver.findElement(By.xpath("//option[text()='Florida']"));
        if(!isSelect3.isSelected())
            isSelect3.click();
        Assert.assertTrue(isSelect3.isSelected());

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
