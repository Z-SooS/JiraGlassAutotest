package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class PermissionsTabModel extends BaseModel{

    public PermissionsTabModel() throws MalformedURLException {
    }

    @FindBy(xpath = "//tr//*[contains(text(), 'Any logged')]/ancestor::td/following-sibling::td//ul")
    private WebElement anyLoggedInUserPermissionsElement;

    public boolean isAnyUserPermissionPresent(String permissionName) {
        shortWait.until(ExpectedConditions.visibilityOf(anyLoggedInUserPermissionsElement));
        try {
            anyLoggedInUserPermissionsElement.findElement(By.xpath(String.format(".//li[text() = '%s']",permissionName)));
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException ignored) {
            return false;
        }
    }
}
