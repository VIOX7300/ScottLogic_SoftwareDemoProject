package com.ScottLogic.qa.pages;

import java.util.List;
/***
 * 
 * @author Emmanuel A
 *
 */



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ScottLogic.qa.base.TestBase;

public class ScottLogicSearchPage extends TestBase {
	
	public WebDriverWait wait;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	 
	@FindBy(xpath="//*[@id='tsf']/div[2]/div/div[2]/div[2]/div/center/input[1]")
	private WebElement searchButton;
	
	public ScottLogicSearchPage(){
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,30);
	}
	public void goToGooglePage(){
		driver.get(prop.getProperty("url"));
	}
	
	public ScottLogicSearchResultPage doSearch(String text){
		searchBox.sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));		 
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='sbtc']"));	 
		for(int i= 0; i<list.size(); i++){			 
			if(list.get(i).getText().equalsIgnoreCase(text)){
				list.get(i).click();
				break;
			}
		}
		
	 	
		return new ScottLogicSearchResultPage();		
	}

}
