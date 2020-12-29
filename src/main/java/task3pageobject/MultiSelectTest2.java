package task3pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiSelectTest2 {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

    }


    @Test
    public void multiSelectTest() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        List<WebElement> tableRows=driver.findElements(By.xpath("//select[@id='multi-select']//option"));
        Actions multiSelect=new Actions(driver);
        multiSelect.keyDown(Keys.CONTROL).click(tableRows.get(0)); /*ппочему-то не выделяет первую строку ,которую кликаю*/
        multiSelect.click(tableRows.get(4));
        multiSelect.click(tableRows.get(1)).keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//div[@class='panel-body']//button[text()='Get All Selected']")).click();



    }

    @After
    public void tearDown() {
        driver.quit();

    }


}
