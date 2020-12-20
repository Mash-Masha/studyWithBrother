package task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    private By logInButton= By.xpath("//div[@class='b-auth-i']//a[@class='enter']");
    public By emailField=By.xpath("//div[@class='b-hold']//input[@type='text']");
    public By passwordField=By.xpath("//div[@class='b-hold']//input[@type='password']");
    public By signInButton=By.xpath("//div[@class='b-hold']//input[@type='submit']");
    public By heading=By.xpath("//div[text()='Вход']");

    public By getLogInButton() { return logInButton; }

    public By getEmailField() { return emailField; }

    public By getPasswordField() { return passwordField; }

    public By getSignInButton() { return signInButton; }



    public MainPage clickLoginButton(){
        driver.findElement(logInButton).click();
        return new MainPage(driver);
    }
    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeLogin(String login) {
        driver.findElement(emailField).sendKeys(login);
        return this;
    }

    public SignInPage clickSignUpButton() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();

    }

    public SignInPage loginWithInvalidCreds(String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        this.clickSignUpButton();
        return new SignInPage(driver);
    }

}











