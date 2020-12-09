import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\javalessons\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tut.by/");
    }
}
