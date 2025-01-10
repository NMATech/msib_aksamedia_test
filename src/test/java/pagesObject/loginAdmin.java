package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginAdmin {
    WebDriver driver;

    public loginAdmin(WebDriver driver){
        this.driver = driver;
    }

    // locator
    By inputName = By.id("name");
    By inputPass = By.id("Password");
    By loginButton = By.xpath("//*[@id=\"app\"]/section/div/div/div/div/div[2]/form/div[4]/button");

    public void adminPage(){
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait driverWait = new WebDriverWait(driver, duration);

        driverWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/section/div/div/div/div/div[2]/form/div[4]/button"))
        );
    }

    public void loginAsAdmin(String name, String pass){
        WebElement nameElement = driver.findElement(inputName);
        WebElement passElement = driver.findElement(inputPass);

        nameElement.sendKeys(name);
        passElement.sendKeys(pass);
    }

    public void clickBtnLogin(){
        WebElement btn = driver.findElement(loginButton);

        btn.click();
    }
}
