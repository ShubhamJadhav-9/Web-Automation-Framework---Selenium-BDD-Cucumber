package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {

    // ThreadLocal is used so that parallel tests don't conflict
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // This method will return the WebDriver (browser)
    public static WebDriver getDriver() {

        if (driver.get() == null) {

            // Get browser name from system property or config file
            String browser = System.getProperty("browser");

            if (browser == null || browser.trim().isEmpty()) {
                browser = PropertiesReader.getProperty("browser");
            }

            if (browser == null || browser.trim().isEmpty()) {
                browser = "chrome";   // default browser
            }

            browser = browser.toLowerCase().trim();
            LoggerUtil.getLogger().info("Launching browser: " + browser);

            // Open Chrome browser
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                driver.set(new ChromeDriver(options));
            }
            // Open Firefox browser
            else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                driver.set(new FirefoxDriver(options));
            }
            // Default to Chrome if browser name is wrong
            else {
                LoggerUtil.getLogger().warn("Browser not supported. Opening Chrome by default.");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }

            // Common settings for the browser
            WebDriver drv = driver.get();
            drv.manage().window().maximize();
            drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver.get();
    }

    // This method will close the browser
    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
                LoggerUtil.getLogger().info("Browser closed successfully");
            } catch (Exception e) {
                LoggerUtil.getLogger().error("Error while closing browser: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}