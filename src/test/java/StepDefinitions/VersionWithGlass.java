package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.BaseModel;

import java.net.MalformedURLException;

public class VersionWithGlass {

    BaseModel baseModel = new BaseModel();

    public VersionWithGlass() throws MalformedURLException {
    }

    @Given("i am logged in")
    public void iAmLoggedIn() {
        baseModel.doLogin();
    }

    @Given("i am on glass page")
    public void iAmOnGlassPage() {
        baseModel.openPath("/projects/POK?selectedItem=com.metainf.jira.plugin:glass-project-documentation#/home/general/versions");
    }

    @When("open the provided url for {string}")
    public void openTheProvidedUrlFor(String path) {
        baseModel.openPath(path);
    }

    @When("click on visible issue with provided name {string}")
    public void clickOnVisibleIssueWithProvidedName(String arg0) {
    }

    @When("click on edit button")
    public void clickOnEditButton() {
    }

    @When("select {string} under {string} menu point")
    public void selectUnderMenuPoint(String arg0, String arg1) {
    }

    @When("click on {string} button")
    public void clickOnButton(String arg0) {
    }

    @Then("issue with summary {string} is visible")
    public void issueWithSummaryIsVisible(String arg0) {
    }
}
