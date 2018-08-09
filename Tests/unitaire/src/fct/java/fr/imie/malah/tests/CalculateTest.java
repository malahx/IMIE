package fr.imie.malah.tests;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculateTest {

    private WebDriver driver;

    @After
    public void tearDown() {
        SeleniumTests.getInstance().quit();
    }

    @Given("^A running platform$")
    public void aRunningPlatform() {
        driver = SeleniumTests.getInstance().getDriver();
    }

    @When("^The user opens <([^>]+)>$")
    public void theUserOpensThe_link(String link) {
        driver.navigate().to(link);
    }

    @Then("^The front page is displayed$")
    public void theFrontPageIsDisplayed() {
        assertThat(driver.getTitle()).isEqualTo("CalculerSonIMC, calcul de l'IMC et portail sur l'obésité");
    }

    @When("^The user clicks on Calculate$")
    public void theUserClicksOnCalculate() {
        driver.findElement(new By.ByLinkText("JE CALCULE MON IMC !")).click();
    }

    @Then("^The IMC form is displayed$")
    public void theIMCFormIsDisplayed() {
        assertThat(driver.getTitle()).isEqualTo("Calcul de l'IMC, faites le test - CalculerSonIMC");
    }

    @When("^The user selects the <(\\d+)>'s gender$")
    public void theUserSelectsWomenGender(int gender) {
        new Select(driver.findElement(new By.ById("sexe"))).selectByIndex(gender);
    }

    @And("^The user fill the height box with <(\\d+)>$")
    public void theUserFillTheHeightBoxWith(int height) {
        WebElement taille = driver.findElement(new By.ById("taille"));
        taille.clear();
        taille.sendKeys(String.valueOf(height));
    }

    @And("^The user fill the weight box with <(\\d+)>$")
    public void theUserFillTheWeightBoxWith(int weight) {
        WebElement poids = driver.findElement(new By.ById("poids"));
        poids.clear();
        poids.sendKeys(String.valueOf(weight));
    }

    @And("^The user fill the age box with <(\\d+)>$")
    public void theUserFillTheAgeBoxWith(int age) {
        WebElement ageEl = driver.findElement(new By.ById("age"));
        ageEl.clear();
        ageEl.sendKeys(String.valueOf(age));
    }

    @Then("^The IMC result box is displayed$")
    public void theIMCResultBoxIsDisplayed() {
        driver.findElement(new By.ById("calcul")).click();
    }

    @And("^The calculated IMC is <([^>]+)>$")
    public void theCalculatedIMCIs(String imc) {
        WebElement result = driver.findElement(new By.ById("resultat")).findElements(new By.ByTagName("p")).get(0).findElement(new By.ByTagName("strong")).findElement(new By.ByTagName("span"));

        assertThat(result.getText()).isEqualTo(imc);
    }
}
