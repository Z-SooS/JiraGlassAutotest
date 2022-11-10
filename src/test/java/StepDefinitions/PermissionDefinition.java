package StepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobject.PermissionsTabModel;

import java.net.MalformedURLException;

public class PermissionDefinition {
    private final PermissionsTabModel permissionsTabModel = new PermissionsTabModel();

    public PermissionDefinition() throws MalformedURLException {
    }

    @Then("under Any logged in user i will find {string}")
    public void underAnyLoggedInUserIWillFind(String permissionName) {
        Assertions.assertTrue(permissionsTabModel.isAnyUserPermissionPresent(permissionName));
    }

    @Then("under Any logged in user i will not find {string}")
    public void underAnyLoggedInUserIWillNotFind(String permissionName) {
        Assertions.assertFalse(permissionsTabModel.isAnyUserPermissionPresent(permissionName));
    }
}
