package stepdef;

import config.env;
import pagesObject.dashboard;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesObject.loginAdmin;

public class addUser extends env {
    @Given("^User is in aksamedia admin page$")
    public void userIsInAksamediaAdminPage() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(admin_url);

        loginAdmin admin = new loginAdmin(driver);
        admin.adminPage();
    }

    @When("^User login as admin$")
    public void userLoginAsAdmin() {
        loginAdmin admin = new loginAdmin(driver);

        admin.loginAsAdmin(env_username, env_password);
        admin.clickBtnLogin();
    }

    @And("^User click users menu on sidebar$")
    public void userClickUsersMenuOnSidebar() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickSidebarUsers();
    }

    @And("^User click users data$")
    public void userClickUsersData() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickUsersData();
    }

    @And("^User click add user button$")
    public void userClickAddUserButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickAddUserButton();
    }

    @And("^User fill (.*), (.*), (.*), (.*), and (.*)$")
    public void userFillData(String name, String username, String email, String pass, String passConfirm) {
        dashboard dashboard = new dashboard(driver);

        dashboard.fillData(name, username, email, pass, passConfirm);
    }

    @And("^User click create button$")
    public void userClickCreateButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickCreateUserButton();
    }

    @Then("^User got success message$")
    public void userGotSuccessMessage() {
        dashboard dashboard = new dashboard(driver);

        dashboard.getSuccessMessage();
    }

    @Then("^User got (.*) email message$")
    public void userGotErrorEmailMessage(String teks) {
        dashboard dashboard = new dashboard(driver);

        dashboard.getErrorMessage(teks);
    }

    @Then("^User got (.*) password message$")
    public void userGotErrorPasswordMessage(String teks) {
        dashboard dashboard = new dashboard(driver);

        dashboard.getErrorMessage(teks);
    }
}
