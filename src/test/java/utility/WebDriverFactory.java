package utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        final String TESTLOCATION = PropertyReader.getProperty("selenium_location");
        final String BROWSER =PropertyReader.getProperty("browser");
        if (TESTLOCATION != null) {
            final String PASSWORD = PropertyReader.getProperty("password");
            DesiredCapabilities capability = new DesiredCapabilities();
            if ("firefox".equals(BROWSER)) {
                capability.setBrowserName("firefox");
            } else {
                capability.setBrowserName("chrome");
            }
            capability.setPlatform(Platform.LINUX);
            webDriver = new RemoteWebDriver(
                    new URL("https://selenium:" + PASSWORD + "@" + PropertyReader.getProperty("selenium_location") + "/wd/hub"), capability);
        } else {
            if (BROWSER.equals("firefox")) {
                webDriver = new FirefoxDriver();
            } else  {
                webDriver = new ChromeDriver();
            }
        }

        return webDriver;
    }
}
