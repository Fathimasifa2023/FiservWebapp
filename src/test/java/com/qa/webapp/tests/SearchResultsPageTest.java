package com.qa.webapp.tests;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.webapp.base.BaseTest;
import com.qa.webapp.utils.Constants;
import com.qa.webapp.utils.Errors;


public class SearchResultsPageTest extends BaseTest {
	
	public static final Logger log = Logger.getLogger(SearchResultsPageTest.class);
	
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
		boolean isPresent = true;
		String haslink = null;
		String actLink = null;
		int nthLink = 0;
		
		String[] searchTerms = getSearchTerm().split(" ");
		
		for (int i=0;i<list.size();i++) {
			haslink  = list.get(i);
			for (String searchTerm : searchTerms) {
				if (haslink.contains(searchTerm))
					isPresent = isPresent && haslink.contains(searchTerm);				
			}
			
			if(isPresent) {
				actLink = haslink;
				nthLink = i;
			}
				
		}
		
		Assert.assertTrue(isPresent,"Search Results are not matching with the given "+ Arrays.toString(searchTerms));		
		log.info("The " + Arrays.toString(searchTerms) + " Present in the " + nthLink +  " => " + actLink );
		
	}	
	
}
