package task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

   private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver=driver;
    }
    public By expectedText =By.xpath("//span[text()='Selenium Test']");

    public String getExpectedText() {
        return driver.findElement(expectedText).getText();
    }

}
