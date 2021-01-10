package task3pageobject;

import org.junit.jupiter.api.Test;
import task4.BaseTest;

public class AlertTest extends BaseTest {
    public AlertMainPage alertMainPage;
    public AlertPage alertPage;


    @Test
    public void acceptConfirmBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonConfirm();
        alertPage=new AlertPage(driver);
        alertPage.alertAccept();
    }

    @Test
    public void dismissConfirmBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonConfirm();
        alertPage=new AlertPage(driver);
        alertPage.alertDismiss();
    }

    @Test
    public void alertBox() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        alertMainPage=new AlertMainPage(driver);
        alertMainPage.clickButtonPromt();
        alertPage=new AlertPage(driver);
        alertPage.alertPromt();

    }

}
