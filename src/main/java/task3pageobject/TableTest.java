package task3pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {
    public WebDriver driver;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
    }

    @Test
    public void tableSortAndSearch() {
        WebElement select=driver.findElement(By.xpath("//select//option[@value='10']"));
        if (!select.isSelected())
            select.click();
        assertTrue(select.isSelected());
        driver.findElement(By.xpath("//table[@id='example']"));
        TablePage tablePage=new TablePage(driver);
        System.out.println("Rows number is " + tablePage.getRows().size());
        assertEquals(10, tablePage.getRows().size());
        List<Employee> allExpectedRows=new ArrayList<Employee>();
        allExpectedRows.add(new Employee("A. Cox", "Junior Technical Author", "San Francisco"));
        allExpectedRows.add(new Employee("B. Greer", "Software Engineer", "London"));
        allExpectedRows.add(new Employee("B. Williamson", "Integration Specialist", "New York"));
        List<EmployeeInfo> employeeInfoFromPage=tablePage.getEmployeeInfo(tablePage.getRows());
        assertEquals(allExpectedRows, tablePage.selectEmloyeeByAgeAndSalary(employeeInfoFromPage));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}


