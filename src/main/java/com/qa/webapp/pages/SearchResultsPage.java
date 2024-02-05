package com.qa.webapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.webapp.utils.Constants;
import com.qa.webapp.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By links = By.cssSelector("h3.title>a");

	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	public String getSearchResultsPageTitle() {
		return eleutil.waitForTitleContains(Constants.DEFAULT_TIME_OUT, Constants.SEARCH_RESULTS_PAGE_TITLE);
	}
	
	public List<String> getAllLinksText(){
		return eleutil.getLinksTextList(links);
		
		
	}		

}
