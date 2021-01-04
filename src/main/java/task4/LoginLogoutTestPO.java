package task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginLogoutTestPO {
    public WebDriver driver;
    public MainPagePO mainPagePO;


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
        mainPagePO=new MainPagePO(driver);
        mainPagePO.goLoginPage();
        LoginPagePO loginPagePO=new LoginPagePO(driver);
        loginPagePO.takeScreen(driver, "C:\\screenschot\\screen1.png");
        assertEquals(loginPagePO.getHeadingLoginPage(), "Войти как пользователь");
        loginPagePO.loginWithInvalidCreds("seleniumtests@tut.by", "123456789zxcvbn");
        assertEquals(loginPagePO.getHeadingLogin(), "Selenium Test");
        mainPagePO.logOut();
        assertEquals(mainPagePO.getHeadingLogout(), "Войти");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
