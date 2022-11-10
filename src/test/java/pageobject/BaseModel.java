package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.PropertyReader;
import utility.WebDriverFactory;

import java.net.MalformedURLException;
import java.util.List;

public class BaseModel {
    @FindBy(id = "login-form-username")
    private WebElement loginInputUsername;

    @FindBy(id = "login-form-password")
    private WebElement loginInputPassword;

    @FindBy(id = "login-form-submit")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//header[@role='banner']/nav")
    private List<WebElement> tabContainers;

    protected WebDriver webDriver;

    public BaseModel() throws MalformedURLException {
        webDriver = WebDriverFactory.getInstance().getWebDriver();
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
    }

    public void clickOnTab(String tabName) {
        for (WebElement navbar : tabContainers) {
            try {
                navbar.findElement(By.xpath(String.format("//span[text() = '%s'",tabName)));
                break;
            } catch (NotFoundException ignored) {}
        }
        throw new NotFoundException("No such element exists in tabs: " + tabName);
    }
}
