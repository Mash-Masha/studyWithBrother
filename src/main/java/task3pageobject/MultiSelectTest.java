package task3pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSelectTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }


    @Test
    public void isSelectedRows() {
        WebElement isSelectCalifornia=driver.findElement(By.xpath("//option[text()='California']"));
        if (!isSelectCalifornia.isSelected())
            isSelectCalifornia.click();
        assertTrue(isSelectCalifornia.isSelected());
        WebElement isSelectFlorida=driver.findElement(By.xpath("//option[text()='Florida']"));
        if (!isSelectFlorida.isSelected())
            isSelectFlorida.click();
        assertTrue(isSelectFlorida.isSelected());
        WebElement isSelectTexas=driver.findElement(By.xpath("//option[text()='Texas']"));
        if (!isSelectTexas.isSelected())
            isSelectTexas.click();
        assertTrue(isSelectTexas.isSelected());

    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
