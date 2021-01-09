package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePF {
    private WebDriver driver;

    public LoginPagePF(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath="//input[@name='login']")
    WebElement emailField;
    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath="//input[@class='button m-green auth__enter']")
    WebElement signUpButton;
    @FindBy(xpath="//p[@class='auth-soc-h']")
    WebElement headingLoginPage;
    @FindBy(xpath="//span[@class='uname']")
    WebElement headingLogin;


    public String getHeadingLogin() {
        return headingLogin.getText();
    }


    public String getHeadingLoginPage() {
        return headingLoginPage.getText();
    }


    public LoginPagePF typeLogin(String login) {
        emailField.sendKeys(login);
        return this;
    }

    public LoginPagePF typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPagePF clickSignUpButton() {
        signUpButton.isSelected();
        signUpButton.click();
        return new LoginPagePF(driver);
    }


    public LoginPagePF loginWithInvalidCreds(String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        this.clickSignUpButton();
        return new LoginPagePF(driver);
    }


}
