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
                 glue = {"atlastests"}
//                 , tags = {" @chun"}
                , tags = {"not @qds"}//"not @ds and not @qds"}
//                    , tags = {"@exp"}
                )

public class RunCucumberTest {
    }
