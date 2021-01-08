package task4;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginLogoutTestPF {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");
    }

    @Test
    public void LoginLogoutTest() {
        MainPagePF mainPagePF=PageFactory.initElements(driver, MainPagePF.class);
        mainPagePF.goLoginPage();
        LoginPagePF loginPagePF=PageFactory.initElements(driver,LoginPagePF.class);
        File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen,new File("./screenschot/screenPF.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(loginPagePF.getHeadingLoginPage(),"Войти как пользователь");
        loginPagePF.loginWithInvalidCreds("seleniumtests@tut.by","123456789zxcvbn");
        assertEquals(loginPagePF.getHeadingLogin(), "Selenium Test");
        mainPagePF.logOut();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

