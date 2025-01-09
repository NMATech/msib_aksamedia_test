package stepdef;

import config.env;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addUser extends env {
    @Given("^User is in aksamedia admin page$")
    public void userIsInAksamediaAdminPage() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(admin_url);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait driverWait = new WebDriverWait(driver, duration);

        driverWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/section/div/div/div/div/div[2]/form/div[4]/button"))
        );
    }

    @When("^User login as admin$")
    public void userLoginAsAdmin() {
        driver.findElement(By.id("name")).sendKeys(env_username);
        driver.findElement(By.id("Password")).sendKeys(env_password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div/div/div/div[2]/form/div[4]/button"));
    }

    @And("^User click users menu on sidebar$")
    public void userClickUsersMenuOnSidebar() {
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/a")).click();
    }

    @And("^User click users data$")
    public void userClickUsersData() {
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[10]/ul/li[1]/a")).click();
    }

    @And("^User click add user button$")
    public void userClickAddUserButton() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div[1]/div/a")).click();
    }

    @And("^User fill (.*), (.*), (.*), (.*), and (.*)$")
    public void userFillData() {

    }

    @And("^User click create button$")
    public void userClickCreateButton() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/form/div[5]/button")).click();
    }

    @Then("^User got success message$")
    public void userGotSuccessMessage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/div"));
    }

    @Then("^User got (.*) email message$")
    public void userGotErrorEmailMessage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/div/p[1]"));
    }

    @Then("^User got (.*) password message$")
    public void userGotErrorPasswordMessage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/section/div[2]/div/div/div/div/p[1]"));
    }
}
