package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePF {
    private WebDriver driver;

    public LoginPagePF(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath="//span[text()='Selenium Test']")
    WebElement heading2;
    @FindBy(xpath="//span[@class='uname']")
    WebElement link;
    @FindBy(xpath="//a[text()='Войти']")
    WebElement heading3;
    @FindBy(xpath="//a[text()='Выйти']")
    WebElement logoutButton;

    public String getHeading2() {
        return heading2.getText();
    }

    public String getHeading3() {
        return heading3.getText();
    }

    public void setHeading2(WebElement heading2) {
        this.heading2=heading2;
    }

    public WebElement getLink() {
        return link;
    }

    public void setLink(WebElement link) {
        this.link=link;
    }

    public void setHeading3(WebElement heading3) {
        this.heading3=heading3;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(WebElement logoutButton) {
        this.logoutButton=logoutButton;
    }

    public LoginPagePF clickLink() {
        link.click();
        return new LoginPagePF(driver);
    }


    public LoginPagePF clickLogoutButton() {
        if (!logoutButton.isSelected())
            logoutButton.click();
        return new LoginPagePF(driver);
    }

    public LoginPagePF logOut() {
        this.clickLink();
        this.clickLogoutButton();
        return new LoginPagePF(driver);
    }

}