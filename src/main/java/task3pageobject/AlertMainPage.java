package task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertMainPage {
    private WebDriver driver;

    public AlertMainPage(WebDriver driver) {
        this.driver=driver;
    }

    private By confirmBoxButton=By.xpath("//button[@onclick='myConfirmFunction()']");
    private By promtBoxButton=By.xpath("//button[@onclick='myPromptFunction()']");


    public AlertMainPage clickButton() {
        driver.findElement(confirmBoxButton).click();
        return new AlertMainPage(driver);
    }

    public AlertMainPage clickButton2() {
        driver.findElement(promtBoxButton).click();
        return new AlertMainPage(driver);
    }
}

