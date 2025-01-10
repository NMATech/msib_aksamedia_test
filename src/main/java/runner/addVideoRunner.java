package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/add-videos.feature",
        glue = "stepdef",
        tags = "@addVideo",
        plugin = {"pretty", "html:target/add-video-report.html"}
)

public class addVideoRunner {
}
