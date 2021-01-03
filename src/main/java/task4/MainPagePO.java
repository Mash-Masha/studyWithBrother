package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePO extends LoginPagePO {
    private WebDriver driver;

    public MainPagePO(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By loginButton=By.xpath("//a[@class='enter']");
    private By emailField=By.xpath("//input[@name='login']");
    private By passwordField=By.xpath("//input[@name='password']");
    private By signUpButton=By.xpath("//input[@value='Войти']");
    private By heading=By.xpath("//p[@class='auth-soc-h']");

    public By getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(By loginButton) {
        this.loginButton=loginButton;
    }

    public By getEmailField() {
        return emailField;
    }

    public void setEmailField(By emailField) {
        this.emailField=emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(By passwordField) {
        this.passwordField=passwordField;
    }

    public By getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(By signUpButton) {
        this.signUpButton=signUpButton;
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }

    public void setHeading(By heading) {
        this.heading=heading;
    }

    public MainPagePO clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPagePO(driver);
    }

    public MainPagePO typeLogin(String login) {
        driver.findElement(emailField).sendKeys(login);
        return this;
    }

    public MainPagePO typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPagePO clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new LoginPagePO(driver);
    }

    public LoginPagePO loginWithInvalidCreds(String login, String pasword) {
        this.typeLogin(login);
        this.typePassword(pasword);
        this.clickSignUpButton();
        return new LoginPagePO(driver);
    }

}