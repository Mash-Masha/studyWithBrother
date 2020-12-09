import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test2{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\javalessons\\driver\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tut.by");

       WebElement link= driver.findElement(By.linkText("Войти"));
       WebElement link2=driver.findElement(By.partialLinkText("Лукашенко"));
       WebElement link3=driver.findElement(By.name("str"));
       WebElement link4=driver.findElement(By.className("topbar__link"));
       WebElement link5=driver.findElement(By.id("authorize"));
       WebElement input=driver.findElement(By.tagName("input"));
       WebElement css=driver.findElement(By.cssSelector("div.ip-holder input#search_from_str"));
       WebElement xpath=driver.findElement(By.xpath("//input[@id='search_from_str']"));

        driver.quit();


    }


    }


