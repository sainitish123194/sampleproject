package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiPage extends BasePage {

	@FindBy(id="searchInput") WebElement searchBox;
	@FindBy(xpath="//*[@class='suggestions-dropdown']/child::a[1]") WebElement sugeetion;
	@FindBy(xpath="//table[@class='infobox vevent']/descendant::*[text()='Release date']/parent::*/following-sibling::td//li") WebElement releaseDate;
	
	@FindBy(xpath="//table[@class='infobox vevent']/descendant::*[text()='Country']/following-sibling::td") WebElement country;
	
	
	public void enterMovieNameInSearchBox(String name){
		searchBox.sendKeys(name);
		sugeetion.click();
	}
	
	public String getReleaseDate(){
		
		return releaseDate.getText().trim();
	}
	

	public String getCountryName(){
		
		return country.getText().trim();
	}
}
