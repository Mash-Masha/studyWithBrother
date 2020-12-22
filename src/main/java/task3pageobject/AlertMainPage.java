package task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertMainPage {
    private WebDriver driver;
    public AlertMainPage(WebDriver driver) {
       setDriver(driver); }

    public WebDriver getDriver() { return driver; }

    public void setDriver(WebDriver driver) { this.driver=driver; }

    private By button=By.xpath("//button[@onclick='myConfirmFunction()']");
    private By button2=By.xpath("//button[@onclick='myPromptFunction()']");

    public By getButton() { return button; }

    public By getButton2() { return button2; }

    public AlertMainPage clickButton() {
        driver.findElement(button).click();
        return new AlertMainPage(driver);
    }
    public AlertMainPage clickButton2(){
        driver.findElement(button2).click();
        return new AlertMainPage(driver);
    }
}

