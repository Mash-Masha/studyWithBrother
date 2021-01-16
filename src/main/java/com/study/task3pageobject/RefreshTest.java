package com.study.task3pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.study.task4.BaseTest;

import java.util.regex.Pattern;

public class RefreshTest extends BaseTest {

    @Test
    public void refreshPageTest() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();
        WebElement sizeText=driver.findElement(By.xpath("//div[text()='50%']"));
        String count=sizeText.getText();
        ExpectedConditions.textMatches(By.xpath("//div[text()='50%']"), Pattern.compile(count));
        driver.navigate().refresh();

    }

}
