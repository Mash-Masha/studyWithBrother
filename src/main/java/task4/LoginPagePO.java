package task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

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

    public static void takeScreen(WebDriver webdriver, String fileWithScreen) {
        TakesScreenshot takeScreen=((TakesScreenshot) webdriver);
        File screenFile=takeScreen.getScreenshotAs(OutputType.FILE);
        File destFile=new File(fileWithScreen);
        try {
            FileUtils.copyFile(screenFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

