package task4;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginLogoutTestPF {
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");
    }



    @Test
    public void LoginLogoutTest(){
        MainPagePF mainPagePF=PageFactory.initElements(driver,MainPagePF.class);
        mainPagePF.clickLoginButton();
        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("C:\\screenshot\\screenshot1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(mainPagePF.getHeading(),"Войти как пользователь");
        mainPagePF.loginWithInvalidCreds("seleniumtests@tut.by","123456789zxcvbn");
        Assert.assertEquals(mainPagePF.getHeading2(),"Selenium Test");
        mainPagePF.logOut();
        Assert.assertEquals(mainPagePF.getHeading3(),"Войти");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

