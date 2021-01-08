package task3pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    static WebDriver driver;
    public MainPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.tut.by/");
        mainPage=new MainPage(driver);
    }


    @Test
    public void signInTest() {
        mainPage.clickLoginButton();
        String heading=mainPage.getHeadingText();
        assertEquals("Вход", heading);
    }

    @Test
    public void signUpTest() {
        mainPage.clickLoginButton();
        SignInPage signInPage=mainPage.loginWithInvalidCreds("seleniumtests@tut.by", "123456789zxcvbn");
        String expectedTextSignUp=signInPage.getExpectedText();
        assertEquals("Selenium Test", expectedTextSignUp);

    }

    @Test
    public void signUpTest2() {
        mainPage.clickLoginButton();
        SignInPage signInPage=mainPage.loginWithInvalidCreds("seleniumtests2@tut.by", "123456789zxcvbn");
        String expectedSignUpTest=signInPage.getExpectedText();
        assertTrue(expectedSignUpTest.equals("Selenium Test"));

    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
