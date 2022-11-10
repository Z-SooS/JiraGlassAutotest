package utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    private static final WebDriverFactory INSTANCE = new WebDriverFactory();
    private WebDriver webDriver;

    public static WebDriverFactory getInstance() {
        return INSTANCE;
    }

    public WebDriver getWebDriver() throws MalformedURLException {
        if (webDriver != null) return webDriver;
        return createWebDriver();
    }

    public void quitWebDriver() {
        webDriver.quit();
        webDriver = null;
    }

    private WebDriver createWebDriver() throws MalformedURLException {
        final String BROWSER = PropertyReader.getProperty("browser");
        final String PASSWORD = System.getProperty("password");

        DesiredCapabilities capability = new DesiredCapabilities();
        if ("firefox".equals(BROWSER)) {
            capability.setBrowserName("firefox");
        } else {
            capability.setBrowserName("chrome");
        }
        capability.setPlatform(Platform.LINUX);
        webDriver = new RemoteWebDriver(
                new URL("https://selenium:" + PASSWORD + "@seleniumhub.codecool.metastage.net/wd/hub"), capability);

        return webDriver;
    }
}
