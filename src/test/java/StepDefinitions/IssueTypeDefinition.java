package StepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobject.IssueTypeModel;

import java.net.MalformedURLException;

public class IssueTypeDefinition {
    private final IssueTypeModel issueTypeModel = new IssueTypeModel();

    public IssueTypeDefinition() throws MalformedURLException {
    }

    @Then("issue types list contains {string}")
    public void issueTypesListContains(String issueType) {
        Assertions.assertTrue(issueTypeModel.issueTypeIsPresentInDropdown(issueType));
    }
}
