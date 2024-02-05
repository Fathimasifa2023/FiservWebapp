package com.qa.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.webapp.utils.Constants;
import com.qa.webapp.utils.ElementUtil;

public class HomePage {
	
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	//private by locators - yahoo
	private By logoId = By.id("ybar-logo");
	private By searchBarId = By.id("ybar-sbq");
	private By searchButton = By.id("ybar-search");
	
	
	//public page const....
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	public String getHomePageUrl(String  url) {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, url);
	}
	
	public boolean isLogoExist() {
		return eleutil.doIsDisplayed(logoId);
	}	
	
	public boolean isSearchBarExist() {
		return eleutil.doIsDisplayed(searchBarId);
	}	
	
	//public page actions
	public String getHomePageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.HOME_PAGE_TITLE);
	}
	

	public SearchResultsPage doSearch(String searchTerm) {
		eleutil.waitForElementToBeVisible(searchBarId, Constants.DEFAULT_TIME_OUT).sendKeys(searchTerm);
		eleutil.doClick(searchButton);
		eleutil.waitForPageLoad(Constants.DEFAULT_TIME_OUT);
		return new SearchResultsPage(driver);
	}


}
