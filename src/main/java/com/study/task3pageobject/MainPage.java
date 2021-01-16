package com.study.task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    private By logInButton=By.xpath("//div[@class='b-auth-i']//a[@class='enter']");
    public By emailField=By.xpath("//div[@class='b-hold']//input[@type='text']");
    public By passwordField=By.xpath("//div[@class='b-hold']//input[@type='password']");
    public By signInButton=By.xpath("//div[@class='b-hold']//input[@type='submit']");
    public By heading=By.xpath("//div[@class='b-auth-title']");
    public By expectedText=By.xpath("//span[@class='uname']");


    public String getExpectedText() {
        return driver.findElement(expectedText).getText();
    }


    public MainPage clickLoginButton() {
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

    public MainPage clickSignUpButton() {
        driver.findElement(signInButton).click();
        return new MainPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();

    }

    public MainPage loginWithCreds(String login, String password) {
        typeLogin(login);
        typePassword(password);
        clickSignUpButton();
        WebDriverWait wait=(new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(expectedText));
        return new MainPage(driver);
    }

}