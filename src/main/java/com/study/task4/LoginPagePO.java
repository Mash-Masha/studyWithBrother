package com.study.task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePO {
    private WebDriver driver;

    public LoginPagePO(WebDriver driver) {
        this.driver=driver;
    }


    private By emailField=By.xpath("//input[@name='login']");
    private By passwordField=By.xpath("//input[@name='password']");
    private By signUpButton=By.xpath("//input[@class='button m-green auth__enter']");
    private By headingLoginPage=By.xpath("//p[@class='auth-soc-h']");
    private By headingLogin=By.xpath("//span[@class='uname']");


    public String getHeadingLoginPage() {
        return driver.findElement(headingLoginPage).getText();
    }

    public String getHeadingLogin() {
        return driver.findElement(headingLogin).getText();
    }


    public LoginPagePO typeLogin() {
        driver.findElement(emailField).sendKeys("seleniumtests@tut.by");
        return this;
    }

    public LoginPagePO typePassword() {
        driver.findElement(passwordField).sendKeys("123456789zxcvbn");
        return this;
    }

    public LoginPagePO clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new LoginPagePO(driver);
    }

    public LoginPagePO loginWithInvalidCreds() {
        typeLogin();
        typePassword();
        clickSignUpButton();
        return new LoginPagePO(driver);
    }

}

