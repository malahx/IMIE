package fr.imie.malah.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.containingText;

public class CalculateFluentLeniumTest extends FluentCucumberTest {

    public CalculateFluentLeniumTest() {
        initFluent(SeleniumTests.getInstance().getDriver());
    }

    @Given("^FLUENT A running platform$")
    public void aRunningPlatform() {
    }

    @When("^FLUENT The user opens <([^>]+)>$")
    public void theUserOpensThe_link(String link) {
        goTo(link);
    }

    @Then("^FLUENT The front page is displayed$")
    public void theFrontPageIsDisplayed() {
        assertThat(window().title()).isEqualTo("CalculerSonIMC, calcul de l'IMC et portail sur l'obésité");
    }

    @When("^FLUENT The user clicks on Calculate$")
    public void theUserClicksOnCalculate() {
        find("a", containingText("JE CALCULE MON IMC !")).click();
    }

    @Then("^FLUENT The IMC form is displayed$")
    public void theIMCFormIsDisplayed() {
        assertThat(window().title()).isEqualTo("Calcul de l'IMC, faites le test - CalculerSonIMC");
    }

    @When("^FLUENT The user selects the <(\\d+)>'s gender$")
    public void theUserSelectsWomenGender(int gender) {
        $("#sexe").fillSelect().withIndex(gender);
    }

    @And("^FLUENT The user fill the height box with <(\\d+)>$")
    public void theUserFillTheHeightBoxWith(int height) {
        $("#taille").fill().withText(String.valueOf(height));
    }

    @And("^FLUENT The user fill the weight box with <(\\d+)>$")
    public void theUserFillTheWeightBoxWith(int weight) {
        $("#poids").fill().withText(String.valueOf(weight));
    }

    @And("^FLUENT The user fill the age box with <(\\d+)>$")
    public void theUserFillTheAgeBoxWith(int age) {
        $("#age").fill().withText(String.valueOf(age));
    }

    @Then("^FLUENT The IMC result box is displayed$")
    public void theIMCResultBoxIsDisplayed() {
        $("#calcul").click();
    }

    @And("^FLUENT The calculated IMC is <([^>]+)>$")
    public void theCalculatedIMCIs(String imc) {
        assertThat($("#resultat").$("p").first().$("span").textContents().get(0)).isEqualTo(imc);
    }

}
