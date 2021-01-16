package com.study.task3pageobject;

import org.junit.jupiter.api.Test;
import com.study.task4.BaseTest;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertTest extends BaseTest {
    public AlertMainPage alertMainPage;
    public Alert alert;


    @Test
    public void acceptConfirmBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonConfirm();
        alert=driver.switchTo().alert();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.accept();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertEquals(alertMainPage.getMessage(), "You pressed OK!");
    }

    @Test
    public void dismissConfirmBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonConfirm();
        alert=driver.switchTo().alert();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.dismiss();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertTrue(alertMainPage.getMessage().equals("You pressed Cancel!"));

    }

    @Test
    public void alertBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonPromt();
        alert=driver.switchTo().alert();
        alert.sendKeys("Mary");
        alert.accept();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertTrue(alertMainPage.getMessagePromt().equals("You have entered 'Mary' !"));
    }

}
