import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginLogoutTest {
    private WebDriver driver;

    @Before
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
        Assert.assertTrue(icon.getText().equals("Selenium Test"));
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


        Assert.assertTrue(link.isDisplayed());
        Assert.assertTrue(link2.isDisplayed());
        Assert.assertTrue(link3.isDisplayed());
        Assert.assertTrue(link4.isDisplayed());
        Assert.assertTrue(link5.isDisplayed());
        Assert.assertTrue(input.size() > 0);
        Assert.assertTrue(css.isDisplayed());
        Assert.assertTrue(xpath.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
