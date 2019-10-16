import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
//        (plugin = {"json:target/cucumber.json"},
        (plugin = {"pretty"},
                 glue = {"atlastests"}
//                 , tags = {"@estimp"}
                , tags ={"not @qds and not @local and not @owndatatestsfromproperty"}//"not @ds and not @qds"}
//                    , tags = {"@exp"}
                )

public class RunCucumberTest {

    }
