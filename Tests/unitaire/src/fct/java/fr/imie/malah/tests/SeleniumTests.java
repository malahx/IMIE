package fr.imie.malah.tests;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SeleniumTests {

    private static final String BROWSER_PATH = "/usr/bin/chromium";

    public static SeleniumTests instance;

    public static SeleniumTests getInstance() {
        if (instance == null || instance.driver == null) {
            synchronized (SeleniumTests.class) {
                instance = new SeleniumTests();
            }
        }
        return instance;
    }

    private WebDriver driver;

    private SeleniumTests() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(BROWSER_PATH);

        Map<String, Object> chromePrefs = new HashMap<>();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(service, options);
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
