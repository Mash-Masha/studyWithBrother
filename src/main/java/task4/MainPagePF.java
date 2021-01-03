package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPagePF extends LoginPagePF{
    private WebDriver driver;

    public MainPagePF(WebDriver driver) {
        super(driver);
        this.driver=driver;}

    @FindBy(xpath="//a[@class='enter']")
    WebElement loginButton;
    @FindBy(xpath="//input[@name='login']")
    WebElement emailField;
    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath="//input[@value='Войти']")
    WebElement signUpButton;
    @FindBy(xpath="//p[@class='auth-soc-h']")
    WebElement heading;

    public void setLoginButton(WebElement loginButton) {
        this.loginButton=loginButton;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField=emailField;
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField=passwordField;
    }

    public void setSignUpButton(WebElement signUpButton) {
        this.signUpButton=signUpButton;
    }

    public void setHeading(WebElement heading) {
        this.heading=heading;
    }

    public WebElement getLoginButton() {return loginButton;}

    public WebElement getEmailField() {return emailField;}

    public WebElement getPasswordField() {return passwordField;}

    public WebElement getSignUpButton() {return signUpButton;}

    public String getHeading() {return heading.getText();}



    public MainPagePF clickLoginButton(){
        loginButton.click();
        return new MainPagePF(driver);
    }
    public MainPagePF typeLogin(String login){
        emailField.sendKeys(login);
        return this;
    }
    public MainPagePF typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPagePF clickSignUpButton(){
        signUpButton.click();
        return new LoginPagePF(driver);
    }

    public LoginPagePF loginWithInvalidCreds(String login, String pasword) {
        this.typeLogin(login);
        this.typePassword(pasword);
        this.clickSignUpButton();
        return  new LoginPagePF(driver);
    }

}
