package task3pageobject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import task4.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "seleniumtests@tut.by, 123456789zxcvbn",
            "seleniumtests2@tut.by, 123456789zxcvbn"})

    public void loginWithCorrectCredentials(String email, String password) {
        driver.get("https://www.tut.by/");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLoginButton();
        assertEquals(mainPage.getHeadingText(), "Вход");
        try {
            Thread.sleep(3000);
        } /*explicit wait*/ catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.loginWithCreds(email, password);
        mainPage.explicitWait();
        assertEquals(mainPage.getExpectedText(), "Selenium Test");
    }
}