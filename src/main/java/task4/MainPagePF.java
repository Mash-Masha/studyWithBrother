package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePF {
    private WebDriver driver;

    public MainPagePF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@class='enter']")
    WebElement loginButton;
    @FindBy(xpath="//span[@class='uname']")
    WebElement userLink;
    @FindBy(xpath="//a[text()='Выйти']")
    WebElement logoutButton;

    public MainPagePF goLoginPage() {
        loginButton.click();
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
