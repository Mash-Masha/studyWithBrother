package task3pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertPage {
    private WebDriver driver;
    public Alert alert;
    public MainPage mainPage;

    public AlertPage(WebDriver driver) {
        this.driver=driver;
    }




    public void threadSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void alertAccept() {
        alert=driver.switchTo().alert();
        threadSleep();
        alert.accept();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertEquals(alertMainPage.getMessage(), "You pressed OK!");
    }

    public void alertDismiss() {
        alert=driver.switchTo().alert();
        alert.dismiss();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertTrue(alertMainPage.getMessage().equals("You pressed Cancel!"));

    }


    public void alertPromt() {
        alert=driver.switchTo().alert();
        alert.sendKeys("Mary");
        threadSleep();
        alert.accept();
        AlertMainPage alertMainPage=new AlertMainPage(driver);
        assertTrue(alertMainPage.getMessagePromt().equals("You have entered 'Mary' !"));

    }


}
