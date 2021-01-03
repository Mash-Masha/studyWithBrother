package task4;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginLogoutTestPO {
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");
        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("C:\\screenshot\\screenshot2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LoginLogoutTest(){
        MainPagePO mainPagePO=new MainPagePO(driver);
        mainPagePO.clickLoginButton();
        Assert.assertEquals(mainPagePO.getHeading(),"Войти как пользователь");
        mainPagePO.loginWithInvalidCreds("seleniumtests@tut.by","123456789zxcvbn");
        Assert.assertEquals(mainPagePO.getHeading2(),"Selenium Test");
        mainPagePO.logOut();
        Assert.assertEquals(mainPagePO.getHeading3(),"Войти");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
