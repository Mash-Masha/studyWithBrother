package com.study.task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Utils {

    public static void takeScreen(WebDriver webdriver) {
        TakesScreenshot takeScreen=((TakesScreenshot) webdriver);
        File screenFile=takeScreen.getScreenshotAs(OutputType.FILE);
        String fileName=new Date().toString().replace(":","").replace(" ","")+".png";
        try {
            FileUtils.moveFile(screenFile, new File("./screenshots/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
