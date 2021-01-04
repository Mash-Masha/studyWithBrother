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
    WebElement headingLogOut;

    public String getHeadingLogout() {return headingLogOut.getText();}

    public WebElement getLoginButton() {return loginButton;}

    public WebElement getUserLink() {return userLink;}

    public WebElement getLogoutButton() {return logoutButton;}

    public WebElement getHeadingLogOut() {return headingLogOut;}


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
        if (!logoutButton.isSelected())
            logoutButton.click();
        return new LoginPagePF(driver);
    }
    public LoginPagePF logOut() {
        this.clickUserLink();
        this.clickLogoutButton();
        return new LoginPagePF(driver);
    }
}
