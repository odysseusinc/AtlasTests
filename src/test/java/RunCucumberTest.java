import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports" },
                 glue = {"odysseusAT"}
//                , tags = {"@estimations"}
                )

public class RunCucumberTest {
    }
