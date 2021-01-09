package task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver=driver;
    }

    public static void takeScreen(WebDriver webdriver, String filePath) {
        TakesScreenshot takeScreen=((TakesScreenshot) webdriver);
        File screenFile=takeScreen.getScreenshotAs(OutputType.FILE);
        File destFile=new File(filePath);
        try {
            FileUtils.copyFile(screenFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

