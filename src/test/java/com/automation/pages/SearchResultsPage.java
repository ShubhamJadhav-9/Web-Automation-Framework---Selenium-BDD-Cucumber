package com.automation.pages;

import org.openqa.selenium.WebDriver;
import com.automation.utils.DriverManager;
import com.automation.utils.LoggerUtil;

public class SearchResultsPage {

    WebDriver driver = DriverManager.getDriver();

    // Check if search results are displayed
    public boolean isSearchResultDisplayed(String productName) {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        String product = productName.toLowerCase();

        boolean isDisplayed = currentUrl.contains(product.replace(" ", "+")) ||
                              currentUrl.contains(product.replace(" ", "%20")) ||
                              currentUrl.contains(product);

        if (isDisplayed) {
            LoggerUtil.getLogger().info("Search results are displayed for: " + productName);
        } else {
            LoggerUtil.getLogger().error("Search results NOT found for: " + productName);
        }

        return isDisplayed;
    }
}