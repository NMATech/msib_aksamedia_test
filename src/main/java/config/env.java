package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class env {
    protected WebDriver driver;
    protected String admin_url = "https://msib.aksamedia.com/admin-panel";
    protected String env_username = "superadmin";
    protected String env_password = "password";
}
