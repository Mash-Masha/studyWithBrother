package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {
    private WebDriver driver;


    public LoginPagePO(WebDriver driver) {
        this.driver=driver;
    }

    private By heading2=By.xpath("//span[text()='Selenium Test']");
    private By link=By.xpath("//span[@class='uname']");
    private By heading3=By.xpath("//a[text()='Войти']");


    public String getHeading2() {return driver.findElement(heading2).getText();}

    public void setHeading2(By heading2) {this.heading2=heading2;}
    public String getHeading3(){return driver.findElement(heading3).getText();}

    public LoginPagePO clickLink() {
        driver.findElement(link).click();
        return new LoginPagePO(driver);
    }


    public LoginPagePO clickLogoutButton() {
        WebElement logoutButton=driver.findElement(By.xpath("//a[text()='Выйти']"));
        if(!logoutButton.isSelected())
            logoutButton.click();
        return new LoginPagePO(driver);
    }
    public LoginPagePO logOut(){
        this.clickLink();
        this.clickLogoutButton();
        return new LoginPagePO(driver);
    }
}
