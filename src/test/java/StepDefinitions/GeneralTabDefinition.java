package StepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobject.GeneralTabModel;

import java.net.MalformedURLException;

public class GeneralTabDefinition {
    private final GeneralTabModel generalTabModel= new GeneralTabModel();

    public GeneralTabDefinition() throws MalformedURLException {
    }

    @Then("the workflow scheme for {string} is {string}")
    public void theWorkflowSchemeForIs(String issueType, String expectedScheme) {
        Assertions.assertEquals(generalTabModel.getWorkflowSchemeForIssueType(issueType), expectedScheme);
    }

    @Then("basic summary contains {string}")
    public void basicSummaryContains(String valueToFind) {
        Assertions.assertTrue(generalTabModel.isValueVisibleInSummary(valueToFind));
    }
}
