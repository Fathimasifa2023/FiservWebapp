package com.qa.webapp.tests;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.webapp.base.BaseTest;
import com.qa.webapp.utils.Constants;
import com.qa.webapp.utils.Errors;

public class SearchResultsPageTest extends BaseTest {
	

	@BeforeClass
	public void searchPageSetup() {
		searchResultsPage=homePage.doSearch(getSearchTerm());
		String actTitle = searchResultsPage.getSearchResultsPageTitle();	
		String expectedTitle = getSearchTerm()+ Constants.SEARCH_RESULTS_PAGE_TITLE;
		Assert.assertEquals(actTitle, expectedTitle, Errors.SEARCH_RESULTS_PAGE_TITLE_MISMATCHED);
	}
	
	public String getSearchTerm() {
		return prop.getProperty("searchTerm");
	}
	
	
	@Test
	public void SearchPageResultsTest() {
		
		List<String> list =  searchResultsPage.getAllLinksText();
		boolean isPresent = false;
		
		String[] searchTerms = getSearchTerm().split(" ");
		
		for (String searchLinkText : list) {
			for (String searchTerm : searchTerms) {
				if (searchLinkText.contains(searchTerm))
					isPresent = searchLinkText.contains(searchTerm);				
			}
		}
		Assert.assertTrue(isPresent,"Search Results are not matching with the given "+ Arrays.toString(searchTerms));
	}
	
	
}
