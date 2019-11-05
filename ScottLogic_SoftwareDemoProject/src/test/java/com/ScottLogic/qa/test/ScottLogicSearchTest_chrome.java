package com.ScottLogic.qa.test;

import org.testng.annotations.AfterMethod;
/***
 * 
 * @author Emmanuel A
 *
 */
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ScottLogic.qa.base.TestBase;
import com.ScottLogic.qa.pages.ScottLogicSearchPage;
import com.ScottLogic.qa.pages.ScottLogicSearchResultPage;

public class ScottLogicSearchTest_chrome extends TestBase {
	ScottLogicSearchPage slsp;
	ScottLogicSearchResultPage slsrp;

	public ScottLogicSearchTest_chrome(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		String browserType="chrome";
		initialise(browserType);
		//initialiseRemote(browserType);
		slsp = new ScottLogicSearchPage();
		slsrp = new ScottLogicSearchResultPage();		
	}

	@Test
	public void scottLogicSearchTest1(){		 
		System.out.println("Enter scottLogicSearchTest1 ");
		slsp.goToGooglePage();		 	
		slsp.doSearch("Scott Logic");	
		//driver.get("https://www.google.co.uk/search?q=HomeOffice");		 
		slsrp.navigateAndScreenShot("Scott Logic");
		System.out.println("Exit scottLogicSearchTest1 ");


	}

	@Test
	public void scottLogicSearchTest2(){
		 
		System.out.println("Enter scottLogicSearchTest2 ");
		slsp.goToGooglePage();		 
		slsp.doSearch("Scott Logic");		
		slsrp.verifyText("Scott Logic");
		System.out.println("Exit scottLogicSearchTest2 ");

	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
