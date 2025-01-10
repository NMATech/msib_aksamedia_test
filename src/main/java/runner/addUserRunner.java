package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/add-user.feature",
        glue = "stepdef",
        tags = "@addUser",
        plugin = {"pretty", "html:target/add-user-report.html"}
)

public class addUserRunner {
}
