package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class IssueTypeModel extends BaseModel{
    public IssueTypeModel() throws MalformedURLException {
    }

    public boolean issueTypeIsPresentInDropdown(String issueType) {
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[@role='group']//*[text()='%s']", issueType))));
            return true;
        }catch (NoSuchElementException | StaleElementReferenceException ignored) {
            return false;
        }
    }
}
