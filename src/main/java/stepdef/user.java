package stepdef;

import config.env;
import pagesObject.dashboard;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesObject.loginAdmin;

public class user extends env {
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

    @And("User click action button on user data that want to edit")
    public void userClickActionButtonOnUserDataThatWantToEdit() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickUsersActionBtn();
    }

    @And("User click edit button")
    public void userClickEditButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickEditLink();
    }

    @And("^User edit user's (.*) to writer$")
    public void userEditUsersRole(String role) {
        dashboard dashboard = new dashboard(driver);

        dashboard.editUserRole(role);
    }

    @And("User click update button")
    public void userClickUpdateButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickUpdateUserButton();
    }

    @And("^User edit user's (.*) with invalid email format$")
    public void userEditUsersEmail(String email) {
        dashboard dashboard = new dashboard(driver);

        dashboard.editUserEmail(email);
    }

    @And("^User edit user's (.*) and (.*)$")
    public void userEditUsersNameAndUsername(String name, String username) {
        dashboard dashboard = new dashboard(driver);

        dashboard.editUserNameAndUsername(name, username);
    }

    @And("^User edit user's profile$")
    public void userEditUsersProfile() {
        dashboard dashboard = new dashboard(driver);

        dashboard.updateProfile();
    }

    @And("User fill form with empty data")
    public void userFillFormWithEmptyData() {
        dashboard dashboard = new dashboard(driver);

        dashboard.editUserDataWithEmptyData();
    }

    @Then("^User got (.*) message$")
    public void userGotSuccessMessage(String teks) {
        dashboard dashboard = new dashboard(driver);

        dashboard.getSuccessMessage(teks);
    }

    @Then("^User got (.*) form message$")
    public void userGotErrorFormMessage(String teks) {
        dashboard dashboard = new dashboard(driver);

        dashboard.getErrorMessage(teks);
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

    @And("User click galleries menu on sidebar")
    public void userClickGalleriesMenuOnSidebar() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickSidebarGalleries();
    }

    @And("User click video")
    public void userClickVideo() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickVideoMenu();
    }

    @And("User click add video button")
    public void userClickAddVideoButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickAddVideoBtn();
    }

    @And("User click save button")
    public void userClickSaveButton() {
        dashboard dashboard = new dashboard(driver);

        dashboard.clickSaveBtnVid();
    }

    @And("^User fill (.*) video$")
    public void userFillTitleVideo(String title) {
        dashboard dashboard = new dashboard(driver);

        dashboard.fillTitleVid(title);
    }

    @And("^User fill (.*) video desc$")
    public void userFillDescVideoDesc(String desc) {
        dashboard dashboard = new dashboard(driver);

        dashboard.fillDescVid(desc);
    }

    @And("^User fill (.*) video link$")
    public void userFillUrlVideoLink(String url) {
        dashboard dashboard = new dashboard(driver);

        dashboard.fillUrlVid(url);
    }
}
