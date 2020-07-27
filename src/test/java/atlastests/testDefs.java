package atlastests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class testDefs {
    public static String getDataProperties(String param) throws Exception {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), StandardCharsets.UTF_8));
        return props.getProperty(param);
    }

    @Before
    public void chromeDriver() throws Exception {
        String browserURL = getDataProperties("test.browser");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).
                savePageSource(false));
        try {
            Configuration.timeout = 30000;
            switch (getDataProperties("test.mode")) {
                case "mac":
                    break;
                case "local":
                    System.setProperty("webdriver.chrome.driver", browserURL);
                    break;
                case "remote":
                    String remoteBrowser = getDataProperties("remote.browser");
                    Configuration.browser = remoteBrowser == null ? "chrome" : remoteBrowser;
                    Configuration.remote = browserURL;

                    ChromeOptions capabilities = new ChromeOptions();
                    capabilities.setCapability("enableVNC", true);
                    break;
                default:
                    throw new Exception("Error test mode");
            }
        } catch (Exception e) {
            throw new AssertionError("Error in settings property", e);
        }
    }
}
