package task3pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task4.BaseTest;

public class WaitForUserTest extends BaseTest {

    @Test
    public void waiter(){
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();
        WebDriverWait waitUser=(new WebDriverWait(driver,10));
        waitUser.until(ExpectedConditions.presenceOfElementLocated(By.id("loading"))).isDisplayed();
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();
    }
}
