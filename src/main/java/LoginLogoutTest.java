
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginLogoutTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");
    }

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//div[@class='b-auth-i']/a")).click();
        driver.findElement(By.xpath("//input[@type='text' and @name='login']")).sendKeys("seleniumtests@tut.by");
        driver.findElement(By.xpath("//div[@class='b-hold']/input[2]")).sendKeys("123456789zxcvbn");
        WebElement button=driver.findElement(By.xpath("//div[@class='b-hold']//input[@value='Войти']"));
        button.submit();
        WebElement icon=driver.findElement(By.xpath("//span[@class='uname']"));
        assertTrue(icon.getText().equals("Selenium Test"));
    }

    @Test
    public void checkByLocatorsTest() {
        WebElement link=driver.findElement(By.linkText("Войти"));
        WebElement link2=driver.findElement(By.partialLinkText("Лукашенко"));
        WebElement link3=driver.findElement(By.name("str"));
        WebElement link4=driver.findElement(By.className("topbar__link"));
        WebElement link5=driver.findElement(By.id("authorize"));
        List<WebElement> input=driver.findElements(By.tagName("input"));
        WebElement css=driver.findElement(By.cssSelector("div.ip-holder input#search_from_str"));
        WebElement xpath=driver.findElement(By.xpath("//input[@id='search_from_str']"));

        assertTrue(link.isDisplayed());
        assertTrue(link2.isDisplayed());
        assertTrue(link3.isDisplayed());
        assertTrue(link4.isDisplayed());
        assertTrue(link5.isDisplayed());
        assertTrue(input.size() > 0);
        assertTrue(css.isDisplayed());
        assertTrue(xpath.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
