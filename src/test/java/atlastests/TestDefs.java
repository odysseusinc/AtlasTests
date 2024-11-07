package atlastests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class TestDefs {
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
        Configuration.headless = Boolean.parseBoolean(getDataProperties("headless"));
        Configuration.fileDownload = FOLDER;//settings for files downloading process
        System.setProperty("chromeoptions.prefs","intl.accept_languages=EN");

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

    @After
    public void closingDriver() throws IOException {
        if (hasWebDriverStarted()) {
            getWebDriver().quit();
        }
        FileUtils.deleteDirectory(new File("build/downloads"));//clear downloaded files(default selenide foalder)
    }
}
