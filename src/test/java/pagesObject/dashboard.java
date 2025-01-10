package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dashboard {
    WebDriver driver;

    public dashboard(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    By sidebarUsers = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/a");
    By usersData = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/ul/li[1]/a");
    By addUserButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div[1]/div/a");
    By createUserButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/form/div[5]/button");
    By inputName = By.id("name");
    By inputUsername = By.id("username");
    By inputEmail = By.id("email");
    By inputPass = By.id("password");
    By inputPassConfirm = By.id("password_confirmation");
    By selectRole = By.id("role");
    By successMessage = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/div");
    By errorMessage;

    public WebDriverWait driverWait(){
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        return wait;
    }

    public void setErrorMessage(String teks){
        this.errorMessage = By.xpath("//p[text()='" + teks + "']");
    }

    public void clickSidebarUsers(){
        WebElement element = driver.findElement(sidebarUsers);
        element.click();
    }

    public void clickUsersData(){
        WebElement element = driver.findElement(usersData);
        element.click();
        WebDriverWait wait = driverWait();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[1]/h1"))
        );
    }

    public void clickAddUserButton(){
        WebElement element = driver.findElement(addUserButton);
        element.click();

        WebDriverWait wait = driverWait();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[1]/h1"))
        );
    }

    public void fillData(String name, String username, String email, String pass, String passConfirm){
        WebElement nameElement = driver.findElement(inputName);
        WebElement usernameElement = driver.findElement(inputUsername);
        WebElement emailElement = driver.findElement(inputEmail);
        WebElement passElement = driver.findElement(inputPass);
        WebElement passConfirmElement = driver.findElement(inputPassConfirm);
        WebElement roleElement = driver.findElement(selectRole);
        Select dropRole = new Select(roleElement);

        nameElement.sendKeys(name);
        usernameElement.sendKeys(username);
        emailElement.sendKeys(email);
        passElement.sendKeys(pass);
        passConfirmElement.sendKeys(passConfirm);
        dropRole.selectByValue("user");
    }

    public void clickCreateUserButton(){
        WebElement element = driver.findElement(createUserButton);
        element.click();
    }

    public void getSuccessMessage(){
        WebDriverWait wait = driverWait();

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage)
        );
    }

    public void getErrorMessage(String teks){
        WebDriverWait wait = driverWait();
        setErrorMessage(teks);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessage)
        );
    }
}
