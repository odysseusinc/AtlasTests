import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions
//        (plugin = {"json:target/cucumber.json"},
        (plugin = {"pretty"},
                 glue = {"odysseusAT"}
//                 , tags = {"@dev_new_t"}
//                , tags = {"not @qds"}//"not @ds and not @qds"}
                    , tags = {"@0407"}
                )

public class RunCucumberTest {
    }
