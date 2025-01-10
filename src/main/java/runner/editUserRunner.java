package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/edit-user.feature",
        glue = "stepdef",
        tags = "@editUser",
        plugin = {"pretty", "html:target/edit-user-report.html"}
)

public class editUserRunner {
}
