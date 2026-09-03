package com.automation.stepdefs;

import com.automation.pages.FlipkartHomePage;
import com.automation.pages.SearchResultsPage;
import com.automation.utils.LoggerUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchSteps {

    FlipkartHomePage homePage = new FlipkartHomePage();
    SearchResultsPage resultsPage = new SearchResultsPage();

    @Given("user is on Flipkart homepage")
    public void user_is_on_flipkart_homepage() {
        homePage.openFlipkart();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        homePage.searchProduct(product);
    }

    @Then("search results should be displayed for {string}")
    public void search_results_should_be_displayed_for(String product) {
        boolean result = resultsPage.isSearchResultDisplayed(product);

        if (!result) {
            LoggerUtil.getLogger().error("Assertion Failed: Results not found for " + product);
            throw new AssertionError("Results not found for " + product);
        }
    }
}