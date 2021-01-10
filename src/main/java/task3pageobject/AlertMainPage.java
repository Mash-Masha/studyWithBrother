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
    private By message=By.xpath("//p[@id='confirm-demo']");
    private By messagePromt=By.xpath("//p[@id='prompt-demo']");


    public AlertMainPage clickButtonConfirm() {
        driver.findElement(confirmBoxButton).click();
        return new AlertMainPage(driver);
    }

    public AlertMainPage clickButtonPromt() {
        driver.findElement(promtBoxButton).click();
        return new AlertMainPage(driver);
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

    public String getMessagePromt() {
        return driver.findElement(messagePromt).getText();
    }

}

