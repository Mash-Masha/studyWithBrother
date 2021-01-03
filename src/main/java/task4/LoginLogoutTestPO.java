package task4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }

    @Test
    public void LoginLogoutTest(){
        MainPagePO mainPagePO=new MainPagePO(driver);
        mainPagePO.clickLoginButton();
        mainPagePO.takeScreen(driver,"C:\\screenschot\\screnschot2.png");
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
