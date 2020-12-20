import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import task3pageobject.MainPage;
import task3pageobject.SignInPage;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
     static WebDriver driver;
    public MainPage mainPage;

     @Before
     public void setUp(){
         System.setProperty("webdriver.chrome.driver", "C:\\javalessons\\driver\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get("https://www.tut.by/");
         mainPage=new MainPage(driver);
     }



    @Test
    public void signInTest(){
        mainPage.clickLoginButton();
        String heading =mainPage.getHeadingText();
        Assert.assertEquals("Вход",heading);
    }
    @Test
    public void signUpTest(){
         mainPage.clickLoginButton();
        SignInPage signInPage =mainPage.loginWithInvalidCreds("seleniumtests@tut.by","123456789zxcvbn");
        String expectedTextSignUp=signInPage.getExpectedText();
        Assert.assertEquals("Selenium Test" ,expectedTextSignUp);

    }

    @Test
    public void signUpTest2(){
         mainPage.clickLoginButton();
         SignInPage signInPage=mainPage.loginWithInvalidCreds("seleniumtests2@tut.by","123456789zxcvbn");
         String expectedSignUpTest=signInPage.getExpectedText();
         Assert.assertTrue(expectedSignUpTest.equals("Selenium Test"));

    }


    @After
    public void tearDown(){
         driver.quit();
    }
}
