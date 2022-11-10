package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.PropertyReader;
import utility.WebDriverFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseModel {
    @FindBy(id = "login-form-username")
    private WebElement loginInputUsername;

    @FindBy(id = "login-form-password")
    private WebElement loginInputPassword;

    @FindBy(id = "login-form-submit")
    private WebElement loginSubmitButton;

    private final By helpModalLocator = By.xpath("//div[@role='dialog']");

    protected WebDriver webDriver;

    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;

    public BaseModel() throws MalformedURLException {
        webDriver = WebDriverFactory.getInstance().getWebDriver();
        PageFactory.initElements(webDriver,this);
        shortWait = new WebDriverWait(webDriver, Duration.ofSeconds(Integer.parseInt(PropertyReader.getProperty("short_wait"))));
        longWait = new WebDriverWait(webDriver, Duration.ofSeconds(Integer.parseInt(PropertyReader.getProperty("long_wait"))));
    }

    public void quitSession() {
        WebDriverFactory.getInstance().quitWebDriver();
    }

    public void doLogin() {
        webDriver.get(PropertyReader.getProperty("base_url") + "/login.jsp");
        loginInputUsername.sendKeys(PropertyReader.getProperty("username"));
        loginInputPassword.sendKeys(PropertyReader.getProperty("password"));

        loginSubmitButton.click();
    }

    public void openPath(String path) {
        webDriver.get(PropertyReader.getProperty("base_url") + path);
    }

    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public void openGlassDocumentation() {
        webDriver.get(PropertyReader.getProperty("base_url") +
                "/projects/POK?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/general/schemes");
        maximizeWindow();
        closeHelpModal();
    }

    public void clickOnTab(String tabName) {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//header[@role='banner']/nav//*[text() = '%s']",tabName))));
        webDriver.findElement(By.xpath(String.format("//header[@role='banner']/nav//*[text() = '%s']",tabName))).click();
    }

    public void closeHelpModal() {
        longWait.until(ExpectedConditions.visibilityOfElementLocated(helpModalLocator));
        webDriver.findElement(helpModalLocator).findElement(By.xpath("//button/span[text() = 'Skip']")).click();
        longWait.until(ExpectedConditions.invisibilityOfElementLocated(helpModalLocator));
    }
}
