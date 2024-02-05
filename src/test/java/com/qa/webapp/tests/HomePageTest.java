package com.qa.webapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.webapp.base.BaseTest;
import com.qa.webapp.utils.Constants;
import com.qa.webapp.utils.Errors;

public class HomePageTest extends BaseTest {
	

	
	@Test(priority = -1)
	public void homePageUrlTest() {
		String url = prop.getProperty("url").trim();
		homePage.getHomePageUrl(url);
		System.out.println("login page url : " + url);
		Assert.assertEquals(url, Constants.HOME_PAGE_URL, Errors.HOME_PAGE_ERROR_MESSG_NOT_DISPLAYED);
	}
	
	@Test
	public void homePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		System.out.println("page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.HOME_PAGE_TITLE, Errors.HOME_PAGE_TITLE_MISMATCHED);
	}	
	
	@Test
	public void logoTest() {
		Assert.assertTrue(homePage.isLogoExist());
	}
	
	@Test
	public void searchTest() {
		Assert.assertTrue(homePage.isSearchBarExist());
		homePage.doSearch(prop.getProperty("searchTerm").trim());
	}	
	
}
