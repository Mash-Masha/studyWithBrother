package task3pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import task4.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest extends BaseTest {

    @Test
    public void tableSortAndSearch() {
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
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
}


