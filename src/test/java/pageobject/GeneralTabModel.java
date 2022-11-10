package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class GeneralTabModel extends BaseModel{
    public GeneralTabModel() throws MalformedURLException {
    }

    public String getWorkflowSchemeForIssueType(String issueType) {
        By schemeLocator = By.xpath(String.format("//span[text()='%s']/ancestor::tr//span[contains(text(),'POK:')]",issueType));
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(schemeLocator));
            return webDriver.findElement(schemeLocator).getText();
        }  catch (TimeoutException | NoSuchElementException | StaleElementReferenceException ignored) {return null;}
    }

    public boolean isValueVisibleInSummary(String value) {
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//h3[text()='Basic Summary']/parent::div/parent::div//*[text()='%s']",value))));
            return true;
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException ignored) {return false;}
    }
}
