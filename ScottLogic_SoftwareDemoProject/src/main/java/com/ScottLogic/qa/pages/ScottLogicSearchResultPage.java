package com.ScottLogic.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ScottLogic.qa.base.TestBase;
/***
 * 
 * @author Emmanuel A
 *
 */

public class ScottLogicSearchResultPage extends TestBase {
	 
	@FindBy(xpath="//a/h3[contains(text(),'Scott Logic')]")
	
	private List<WebElement> searchResults;
	
	public ScottLogicSearchResultPage(){
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> getResults(){
		return this.searchResults;
		
	}
	
	public void printList(){
		for(int i=0; i<getResults().size();i++){
			System.out.println(searchResults.get(i).getText());
		}
	}
	
	public void getScreenShot(int screenNumber){
		System.out.println("Enter getScreenShot.....");
		String filePath = System.getProperty("user.dir")+"//ScreenShots//"+screenNumber+".png";
		 
		File targetFile = new File(filePath);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, targetFile);			 

		} catch (IOException e) {
			e.printStackTrace();
		}	
	 
	}
	
	 
	
	public void navigateAndScreenShot(String SearchText){
		for(int i=0; i<getResults().size();i++){
			if(getResults().get(i).getText().contains(SearchText)){
				getResults().get(i).click();
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getScreenShot(i);
				//get screen shoot and navigate back
				driver.navigate().back();
			}
			
		}
		
		
	}
	
	
	public void verifyText(String text){
		for(int i=0; i<getResults().size();i++){			 
			Assert.assertTrue((getResults().get(i).getText().contains("Scott Logic")));
		}	
		
	}
	

}
