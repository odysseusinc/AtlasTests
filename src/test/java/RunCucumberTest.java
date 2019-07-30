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
//                 , tags = {"@estimp"}
                , tags = {"not @ds and not @qds"}
//                    , tags = {"@characterization"}
                )

public class RunCucumberTest {
    public static String getDataProperties(String param) throws Exception {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), "UTF-8"));
        return props.getProperty(param);
    }
    }
