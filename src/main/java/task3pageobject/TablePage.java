package task3pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver=driver;
    }

    public List<WebElement> getRows() {
        List<WebElement> allRows=driver.findElements(By.xpath(".//tbody//tr"));
        return allRows;
    }


    public List<EmployeeInfo> getEmployeeInfo(List<WebElement> allRows) {
        List<EmployeeInfo> employeeInfo=new ArrayList<>();
        for (WebElement employee : allRows) {
            String name=employee.findElement(By.xpath("./td[1]")).getText();
            String possition=employee.findElement(By.xpath("./td[2]")).getText();
            String office=employee.findElement(By.xpath("./td[3]")).getText();
            int age=Integer.parseInt(employee.findElement(By.xpath("./td[4]")).getText());
            String startDate=employee.findElement(By.xpath("./td[5]")).getText();
            String tempSalary=employee.findElement(By.xpath("./td[6]")).getText();
            tempSalary=tempSalary.substring(1, tempSalary.length() - 2).replaceAll(",", "");
            int salary=Integer.parseInt(tempSalary);
            employeeInfo.add(new EmployeeInfo(name, possition, office, age, salary, startDate));
        }
        return employeeInfo;
    }


    public List<Employee> selectEmloyeeByAgeAndSalary(List<EmployeeInfo> employeeInfo) {
        List<Employee> selectEmployees=new ArrayList<>();
        for (EmployeeInfo employ : employeeInfo) {
            if (employ.getAge() > 40 && employ.getSalary() < 400000) {
                selectEmployees.add(new Employee(employ.getName(), employ.getPossition(), employ.getOffice()));
            }
        }
        return selectEmployees;
    }
}