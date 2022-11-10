package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.PermissionsTabModel;

import java.net.MalformedURLException;

public class StepDefinition {
    private final PermissionsTabModel permissionsTabModel = new PermissionsTabModel();

    public StepDefinition() throws MalformedURLException {
    }

    @Given("i am logged in")
    public void iAmLoggedIn() {
        permissionsTabModel.doLogin();
    }

    @And("i am on glass page")
    public void iAmOnGlassPage() {
        permissionsTabModel.openGlassDocumentation();
    }

    @When("i click on {string} tab")
    public void iClickOnTab(String tabName) {
        permissionsTabModel.clickOnTab(tabName);
    }

    @Then("under Any logged in user i will find {string}")
    public void underAnyLoggedInUserIWillFind(String permissionName) {
        Assertions.assertTrue(permissionsTabModel.isAnyUserPermissionPresent(permissionName));
    }

    @Then("under Any logged in user i will not find {string}")
    public void underAnyLoggedInUserIWillNotFind(String permissionName) {
        Assertions.assertFalse(permissionsTabModel.isAnyUserPermissionPresent(permissionName));
    }







//
//    BaseModel baseModel = new BaseModel();
//
//    public VersionWithGlass() throws MalformedURLException {
//    }
//
//    @Given("i am logged in")
//    public void iAmLoggedIn() {
//        baseModel.doLogin();
//    }
//
//    @Given("i am on glass page")
//    public void iAmOnGlassPage() {
//        baseModel.openGlassDocumentation();
//    }
//
//    @When("open the provided url for {string}")
//    public void openTheProvidedUrlFor(String path) {
//        baseModel.openPath(path);
//    }
//
//    @When("click on visible issue with provided name {string}")
//    public void clickOnVisibleIssueWithProvidedName(String arg0) {
//    }
//
//    @When("click on edit button")
//    public void clickOnEditButton() {
//    }
//
//    @When("select {string} under {string} menu point")
//    public void selectUnderMenuPoint(String arg0, String arg1) {
//    }
//
//    @When("click on {string} button")
//    public void clickOnButton(String arg0) {
//    }
//
//    @Then("issue with summary {string} is visible")
//    public void issueWithSummaryIsVisible(String arg0) {
//    }
}
