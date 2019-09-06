import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions

        (plugin = {"pretty", "json:target/cucumber.json"},
                glue = {"atlastests"}
                , tags = {"not @ds and not @qds"}
//                    , tags = {"@impre"}
        )

public class RunCucumberTest {
}
