import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");

        driver.findElement(By.xpath("//div[@class='b-auth-i']/a")).click();
        driver.findElement(By.xpath("//input[@type='text' and @name='login']")).sendKeys("seleniumtests@tut.by");
        driver.findElement(By.xpath("//div[@class='b-hold']/input[2]")).sendKeys("123456789zxcvbn");
        WebElement button = driver.findElement(By.xpath("//div[@class='b-hold']//input[@value='Войти']"));
        button.submit();


        driver.quit();

    }
}
