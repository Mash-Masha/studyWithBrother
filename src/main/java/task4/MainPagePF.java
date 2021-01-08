package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPagePF{
    private WebDriver driver;

    public MainPagePF(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath="//a[@class='enter']")
    WebElement loginButton;
    @FindBy(xpath="//span[@class='uname']")
    WebElement userLink;
    @FindBy(xpath="//a[text()='Выйти']")
    WebElement logoutButton;
    @FindBy(xpath="//a[text()='Войти']")
    WebElement headingLogin;

    public String getHeadingLogin() {return headingLogin.getText();}

    public WebElement getLoginButton() {return loginButton;}

    public WebElement getUserLink() {return userLink;}

    public WebElement getLogoutButton() {return logoutButton;}



    public MainPagePF clickLoginButton() {
        loginButton.click();
        return new MainPagePF(driver);
    }

    public MainPagePF goLoginPage(){
        this.clickLoginButton();
        return new MainPagePF(driver);
    }

    public LoginPagePF clickUserLink() {
        userLink.click();
        return new LoginPagePF(driver);
    }

    public LoginPagePF clickLogoutButton() {
            logoutButton.click();
        return new LoginPagePF(driver);
    }

    public LoginPagePF logOut() {
       clickUserLink();
       clickLogoutButton();
        return new LoginPagePF(driver);
    }
}
