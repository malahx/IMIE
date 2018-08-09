package fr.imie.malah.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html"},
        glue = {"src/test/java/fr/imie/malah/tests"}
)
public class CucumberRunnerTest {
}
