package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class dashboard {
    WebDriver driver;

    public dashboard(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    By sidebarUsers = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/a");
    By sidebarGalleries = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[7]/a");
    By usersData = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/ul/li[1]/a");
    By videoMenu = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[7]/ul/li[2]/a");
    By addUserButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div[1]/div/a");
    By createUserButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/form/div[5]/button");
    By updateUserButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/form/div[4]/button");
    By addVideoButton = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div[1]/a");
    By inputName = By.id("name");
    By inputUsername = By.id("username");
    By inputEmail = By.id("email");
    By inputPass = By.id("password");
    By inputPassConfirm = By.id("password_confirmation");
    By selectRole = By.id("role");
    By inputPhoto = By.id("photo");
    By inputTitleVid = By.id("title");
    By inputDescVid = By.xpath("//*[@id=\"description\"]/div[1]/p");
    By inputUrlVid = By.id("url");
    By saveButtonVid = By.xpath("//*[@id=\"form-posts\"]/div[4]/button");
    By userButtonAction = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div[2]/table/tbody/tr[1]/td[6]/div");
    By editLink = By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/a");
    By successMessage;
    By errorMessage;

    public WebDriverWait driverWait(){
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        return wait;
    }

    public void setSuccessMessage(String teks){
        this.successMessage = By.xpath("//div[text()='" + teks + "']");
    }

    public void setErrorMessage(String teks){
        this.errorMessage = By.xpath("//p[text()='" + teks + "']");
    }

    public void clickSidebarUsers(){
        WebElement element = driver.findElement(sidebarUsers);
        element.click();
    }

    public void clickSidebarGalleries(){
        WebElement element = driver.findElement(sidebarGalleries);
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

    public void clickVideoMenu(){
        WebElement element = driver.findElement(videoMenu);
        element.click();

        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(addVideoButton)
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

    public void clickUsersActionBtn(){
        WebElement element = driver.findElement(userButtonAction);
        element.click();
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(editLink)
        );
    }
    public void clickEditLink(){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(editLink)
        );
        WebElement element = driver.findElement(editLink);
        element.click();
    }

    public void clickAddVideoBtn(){
        WebElement element = driver.findElement(addVideoButton);
        element.click();
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[1]/h1"))
        );
    }

    public void editUserRole(String role){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(selectRole)
        );
        WebElement roleElement = driver.findElement(selectRole);
        Select dropRole = new Select(roleElement);
        dropRole.selectByValue(role);
    }

    public void editUserEmail(String email){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(inputEmail)
        );
        WebElement emailElement = driver.findElement(inputEmail);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void editUserNameAndUsername(String name, String username){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(inputName)
        );
        WebElement nameElement = driver.findElement(inputName);
        WebElement usernameElement = driver.findElement(inputUsername);

        nameElement.clear();
        usernameElement.clear();
        nameElement.sendKeys(name);
        usernameElement.sendKeys(username);
    }

    public void editUserDataWithEmptyData(){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(inputName)
        );
        WebElement nameElement = driver.findElement(inputName);
        WebElement usernameElement = driver.findElement(inputUsername);
        WebElement emailElement = driver.findElement(inputEmail);

        nameElement.clear();
        usernameElement.clear();
        emailElement.clear();
    }

    public void updateProfile(){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(inputPhoto)
        );
        WebElement inputFile = driver.findElement(inputPhoto);
        String path = new File("src/test/resources/file/alterego.png").getAbsolutePath();
        inputFile.sendKeys(path);
    }

    public void clickUpdateUserButton(){
        WebElement element = driver.findElement(updateUserButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void fillTitleVid(String title){
        WebElement element = driver.findElement(inputTitleVid);
        element.sendKeys(title);
    }

    public void fillDescVid(String desc){
        WebElement element = driver.findElement(inputDescVid);
        element.sendKeys(desc);
    }

    public void fillUrlVid(String url){
        WebElement element = driver.findElement(inputUrlVid);
        element.sendKeys(url);
    }

    public void clickSaveBtnVid(){
        WebDriverWait wait = driverWait();
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(saveButtonVid)
        );
        WebElement element = driver.findElement(saveButtonVid);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void getSuccessMessage(String teks){
        WebDriverWait wait = driverWait();
        setSuccessMessage(teks);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage)
        );
        driver.quit();
    }

    public void getErrorMessage(String teks){
        WebDriverWait wait = driverWait();
        setErrorMessage(teks);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessage)
        );
        driver.quit();
    }
}
