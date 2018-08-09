package fr.imie.malah.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculateTest {

    @Given("^A running platform$")
    public void aRunningPlatform() {
        //TODO
    }

    @When("^The user opens <(\\w+)>$")
    public void theUserOpensThe_link(String link) {
        //TODO
    }

    @Then("^The front page is displayed$")
    public void theFrontPageIsDisplayed() {
        //TODO
    }

    @When("^The user clicks on Calculate$")
    public void theUserClocksOnCalculate() {
        //TODO
    }

    @Then("^The IMC form is displayed$")
    public void theIMCFormIsDisplayed() {
        //TODO
    }

    @When("^The user selects <(\\w+)> gender$")
    public void theUserSelectsWomenGender(String gender) {
        //TODO
    }

    @And("^The user fill the height box with <(\\d+)>$")
    public void theUserFillTheHeightBoxWith(int height) {
        //TODO
    }

    @And("^The user fill the weight box with <(\\d+)>$")
    public void theUserFillTheWeightBoxWith(int weight) {
        //TODO
    }

    @And("^The user fill the age box with <(\\d+)>$")
    public void theUserFillTheAgeBoxWith(int age) {
        //TODO
    }

    @Then("^The IMC result box is displayed$")
    public void theIMCResultBoxIsDisplayed() {
        //TODO
    }

    @And("^The calculated IMC is <(\\d+)>$")
    public void theCalculatedIMCIs(int imc) {
        //TODO
        System.out.print("____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
    }
}
