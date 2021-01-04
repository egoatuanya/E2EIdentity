package gov.E2EIdentity.app.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.E2EIdentity.app.Pages.BasePage;
import gov.E2EIdentity.app.Pages.CarTaxCheckPage;
import gov.E2EIdentity.app.Support.WorldHelper;
import org.junit.Assert;

import java.util.List;


public class E2EIdentityTestSteps{
    private WorldHelper helper;
    private BasePage basePage;
    private CarTaxCheckPage landingPage;
    public E2EIdentityTestSteps(WorldHelper helper){this.helper = helper;}


    @Given("^I navigate to Car Tax Check Url:  \"([^\"]*)\"$")
    public void i_navigate_to_Car_Tax_Check_Url(String arg1) throws Throwable {
        landingPage = helper.getBasePage().goToHomePage();
    }

    @When("^I enter the car the registration number: \"([^\"]*)\"$")
    public void i_enter_the_car_the_registration_number(String reg1) throws Throwable {
        landingPage.enterValidReg1(reg1);


    }

    @When("^click Enter$")
    public void click_Enter() throws Throwable {
        landingPage.clickOnCarHistCheck();

    }

    @Then("^I am navigated to the vehicles details page with Url: \"([^\"]*)\"$")
    public void i_am_navigated_to_the_vehicles_details_page_with_Url(String detailsUrl) throws Throwable {
        String url = landingPage.getVehiclesDetailsUrl();
        Assert.assertEquals(url, detailsUrl);

    }

    @Then("^the following details are displayed$")
    public void the_following_details_are_displayed(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        boolean reg = landingPage.verifyVehicleDetails().contains(data.get(1).get(0));
        Assert.assertTrue(reg);
        boolean make = landingPage.verifyVehicleDetails().contains(data.get(1).get(1));
        Assert.assertTrue(make);
        boolean model = landingPage.verifyVehicleDetails().contains(data.get(1).get(2));
        Assert.assertTrue(model);
        boolean color = landingPage.verifyVehicleDetails().contains(data.get(1).get(3));
        Assert.assertTrue(color);
        boolean year = landingPage.verifyVehicleDetails().contains(data.get(1).get(4));
        Assert.assertTrue(year);
    }

    @Then("^an alert with error message \"([^\"]*)\" is displayed$")
    public void an_alert_with_error_message_is_displayed(String alertText) throws Throwable {
        landingPage.getAlertText(alertText);


    }



}
