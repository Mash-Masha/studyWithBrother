package task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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
        LoginPagePO loginPagePO=new LoginPagePO(driver);
        loginPagePO.takeScreen(driver, "C:\\screenschot\\screen2.png");
        assertEquals(loginPagePO.getHeadingLoginPage(), "Войти как пользователь");
        loginPagePO.loginWithInvalidCreds("seleniumtests@tut.by", "123456789zxcvbn");
        assertEquals(loginPagePO.getHeadingLogin(), "Selenium Test");
        mainPagePF.logOut();
        assertEquals(mainPagePF.getHeadingLogout(), "Войти");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

