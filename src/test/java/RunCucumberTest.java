import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions

        (plugin = {"pretty", "json:target/cucumber.json"},
                glue = {"atlastests"}
//                , tags = {"not @ds and not @qds"}
                    , tags = {"@login"}
        )

public class RunCucumberTest {
}
