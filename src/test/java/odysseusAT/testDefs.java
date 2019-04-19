package odysseusAT;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class testDefs {
    public static String getDataProperties(String param) throws Exception {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), "UTF-8"));
        return props.getProperty(param);
    }

    @Before
    public void chromeDriver() {
        String testmode, browserURL;
        try {
            Configuration.timeout = 30000;

            testmode = getDataProperties("test.mode");

            switch(testmode) {
                case "local":
                    browserURL = getDataProperties("test.browser");
                    if (!browserURL.equals("") && !browserURL.isEmpty()) {
                        System.setProperty("webdriver.chrome.driver", browserURL);
                    } else {
                        throw new Exception("Error local browser property");
                    }
                    break;
                case "remote":
                    Configuration.browser = "chrome";
                    browserURL = getDataProperties("test.browser");
                    if (!browserURL.equals("") && !browserURL.isEmpty()) {

                        Configuration.remote = browserURL;

                        // Разрешаем VNC
                        ChromeOptions capabilities = new ChromeOptions();
                        capabilities.setCapability("enableVNC", true);
                    } else {
                        throw new Exception("Error remote browser property");
                    }
                    break;
                default:
                    throw new Exception("Error test mode");
            }
        } catch (Exception e) {
            throw new AssertionError("Error settings", e);
        }
    }
}
