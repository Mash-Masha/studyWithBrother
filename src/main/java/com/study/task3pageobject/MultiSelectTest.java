package com.study.task3pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.study.task4.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSelectTest extends BaseTest {

    @Test
    public void selectedRows() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement selectCalifornia=driver.findElement(By.xpath("//option[text()='California']"));
        selectCalifornia.isSelected();
        selectCalifornia.click();
        assertTrue(selectCalifornia.isSelected());
        WebElement selectFlorida=driver.findElement(By.xpath("//option[text()='Florida']"));
        selectFlorida.isSelected();
        selectFlorida.click();
        assertTrue(selectFlorida.isSelected());
        WebElement selectTexas=driver.findElement(By.xpath("//option[text()='Texas']"));
        selectTexas.isSelected();
        selectTexas.click();
        assertTrue(selectTexas.isSelected());

    }
}
