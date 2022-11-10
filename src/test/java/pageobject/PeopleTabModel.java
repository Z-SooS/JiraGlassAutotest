package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class PeopleTabModel extends BaseModel{
    public PeopleTabModel() throws MalformedURLException {
    }

    public boolean isUserPresent(String userFullName) {
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[@class='role-member-card']//p[@title = '%s']",userFullName))));
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException ignored) {
            return false;
        }
    }
}
