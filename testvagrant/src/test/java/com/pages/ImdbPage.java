package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbPage extends BasePage {

	
	
	@FindBy(id="suggestion-search") WebElement searchBox;
	@FindBy(xpath="//*[@class='searchResult--const__img']/following-sibling::div[1]") WebElement searchResult;
	@FindBy(xpath="//*[text()='Release date']/parent::*//ul/descendant::a") WebElement releaseDate;
	
	@FindBy(xpath="//*[text()='Country of origin']/parent::*//ul/descendant::a") WebElement country;

	public void enterMovieNameInSearchBox(String name){
		searchBox.sendKeys(name);
		searchResult.click();
	}
	
	public String getReleaseDate(){
		
		return releaseDate.getText().trim();
	}
	
	public String getCountryName(){
		
		return country.getText().trim();
	}
	
}
