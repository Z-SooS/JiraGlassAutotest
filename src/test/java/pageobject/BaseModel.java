package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.PropertyReader;
import utility.WebDriverFactory;

import java.net.MalformedURLException;

public class BaseModel {
    @FindBy(id = "login-form-username")
    private WebElement loginInputUsername;

    @FindBy(id = "login-form-password")
    private WebElement loginInputPassword;

    @FindBy(id = "login-form-submit")
    private WebElement loginSubmitButton;

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
}
