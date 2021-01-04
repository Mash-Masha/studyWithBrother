package task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class LoginPagePF {
    private WebDriver driver;

    public LoginPagePF(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath="//input[@name='login']")
    WebElement emailField;
    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath="//input[@value='Войти']")
    WebElement signUpButton;
    @FindBy(xpath="//span[text()='Selenium Test']")
    WebElement headingLoginPage;

    public String getHeadingLoginPage() {
        return headingLoginPage.getText();
    }

    public WebElement getEmailField() {return emailField;}

    public WebElement getPasswordField() {return passwordField;}

    public WebElement getSignUpButton() {return signUpButton;}


    public LoginPagePF typeLogin(String login) {
        emailField.sendKeys(login);
        return this;
    }

    public LoginPagePF typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPagePF clickSignUpButton() {
        signUpButton.click();
        return new LoginPagePF(driver);
    }

    public LoginPagePF loginWithInvalidCreds(String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        this.clickSignUpButton();
        return new LoginPagePF(driver);
    }

    public static void takeScreen(WebDriver webdriver, String fileWithScreen) {
        TakesScreenshot takeScreen=((TakesScreenshot) webdriver);
        File screenFile=takeScreen.getScreenshotAs(OutputType.FILE);
        File destFile=new File(fileWithScreen);
        try {
            FileUtils.copyFile(screenFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}