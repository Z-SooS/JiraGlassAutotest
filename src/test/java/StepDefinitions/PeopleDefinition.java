package StepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobject.PeopleTabModel;

import java.net.MalformedURLException;

public class PeopleDefinition {
    private final PeopleTabModel peopleTabModel = new PeopleTabModel();

    public PeopleDefinition() throws MalformedURLException {
    }

    @Then("under user i find {string}")
    public void issueTypesListContains(String userFullName) {
        Assertions.assertTrue(peopleTabModel.isUserPresent(userFullName));
    }
}
