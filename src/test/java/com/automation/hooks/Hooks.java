package com.automation.hooks;

import com.automation.utils.DriverManager;
import com.automation.utils.LoggerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // This method will run before every scenario
    @Before
    public void setUp(Scenario scenario) {
        LoggerUtil.getLogger().info("Starting scenario: " + scenario.getName());
        DriverManager.getDriver();   // Open the browser
    }

    // This method will run after every scenario
    @After
    public void tearDown(Scenario scenario) {
        
        WebDriver driver = DriverManager.getDriver();

        // If the test fails, take a screenshot
        if (scenario.isFailed()) {
            LoggerUtil.getLogger().error("Scenario FAILED: " + scenario.getName());

            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
                LoggerUtil.getLogger().info("Screenshot taken for failed scenario");
            } catch (Exception e) {
                LoggerUtil.getLogger().error("Failed to take screenshot: " + e.getMessage());
            }
        } else {
            LoggerUtil.getLogger().info("Scenario PASSED: " + scenario.getName());
        }

        // Close the browser
        DriverManager.quitDriver();
        LoggerUtil.getLogger().info("Scenario finished: " + scenario.getName());
    }
}