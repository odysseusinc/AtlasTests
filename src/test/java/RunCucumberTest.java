import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
//        (plugin = {"json:target/cucumber.json"},
        (plugin = {"pretty"},
                 glue = {"atlastests"}
//                 , tags = {"@estimp"}
                , tags ="@local"//"not @ds and not @qds"}
//                    , tags = {"@exp"}
                )

public class RunCucumberTest {

    }
