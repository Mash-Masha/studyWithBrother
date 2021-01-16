package com.study.task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePO {
    private WebDriver driver;

    public MainPagePO(WebDriver driver) {
        this.driver=driver;
    }

    private By loginButton=By.xpath("//a[@class='enter']");
    private By userLink=By.xpath("//span[@class='uname']");
    private By logoutButton=By.xpath("//a[@class='button wide auth__reg']");


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
        driver.findElement(logoutButton).isSelected();
        driver.findElement(logoutButton).click();
        return new MainPagePO(driver);
    }

    public String getHeadingLogout() {
        return driver.findElement(loginButton).getText();
    }

    public MainPagePO logOut() {
        clickUserLink();
        clickLogoutButton();
        return new MainPagePO(driver);
    }


}