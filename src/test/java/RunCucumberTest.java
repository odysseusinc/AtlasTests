import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
//        (plugin = {"json:target/cucumber.json"},
        (plugin = {"pretty"},
                 glue = {"atlastests"}
                , tags ="not @qds and not @local and not @profiles and not @eunomia and not @synPUF23m and not @ds and not @1107 and not @ohdsi and not @costutil"//"not @ds and not @qds"}
                , features = {"src/test/resources/atlastests"}
                )

public class RunCucumberTest {

    }
