package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.utils.DriverManager;
import com.automation.utils.LoggerUtil;

public class FlipkartHomePage {

    WebDriver driver = DriverManager.getDriver();

    // Locator for search box
    By searchBox = By.name("q");

    // Method to open Flipkart
    public void openFlipkart() {
        driver.get("https://www.flipkart.com/");
        LoggerUtil.getLogger().info("Opened Flipkart homepage");
    }

    // Method to search product
    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchBox).submit();
        LoggerUtil.getLogger().info("Searched for product: " + productName);
    }
}