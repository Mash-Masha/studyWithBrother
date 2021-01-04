package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPagePO {
    private WebDriver driver;

    public MainPagePO(WebDriver driver) {
        this.driver=driver;
    }

    private By loginButton=By.xpath("//a[@class='enter']");
    private By headingLogout=By.xpath("//a[text()='Войти']");
    private By userLink=By.xpath("//span[@class='uname']");

    public By getLoginButton() {return loginButton;}

    public By getUserLink() {return userLink;}

    public String getHeadingLogout() {return driver.findElement(headingLogout).getText();}


    public MainPagePO clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPagePO(driver);
    }

    public MainPagePO goLoginPage() {
        this.clickLoginButton();
        return new MainPagePO(driver);
    }

    public MainPagePO clickUserLink() {
        driver.findElement(userLink).click();
        return new MainPagePO(driver);
    }

    public MainPagePO clickLogoutButton() {
        WebElement logoutButton=driver.findElement(By.xpath("//a[text()='Выйти']"));
        if (!logoutButton.isSelected()) {
            logoutButton.click();
        }
        return new MainPagePO(driver);
    }

    public MainPagePO logOut() {
        this.clickUserLink();
        this.clickLogoutButton();
        return new MainPagePO(driver);
    }


}