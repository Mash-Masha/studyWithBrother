package task3pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.tut.by/");
    }

    @ParameterizedTest
    @CsvSource({
            "seleniumtests@tut.by, 123456789zxcvbn",
            "seleniumtests2@tut.by, 123456789zxcvbn"})

    public void loginWithCorrectCredentials(String email, String password) {

        MainPage mainPage=new MainPage(driver);
        mainPage.clickLoginButton();
        try {
            Thread.sleep(3000);
        } /*explicit wait*/ catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.loginWithInvalidCreds(email, password);
        WebDriverWait wait=(new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Selenium Test']")));


    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
