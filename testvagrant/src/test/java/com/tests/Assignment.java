package com.tests;


import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.ImdbPage;
import com.pages.WikiPage;


import utility.TestBase;

public class Assignment extends TestBase{
	//WebDriver driver;


	
	public  String releaseDateFromWiki;

	public  String releaseDateFromImdb;

	public  String countyNameFromWiki;

	public  String countyNameFromImdb;
	
	
	 WikiPage wikiPage=new WikiPage();
	 ImdbPage imdbpage=new ImdbPage();
    @BeforeMethod
    public void init(){
    	 wikiPage=new WikiPage();
    	 imdbpage=new ImdbPage();
    }
	
	@Test
	public void validateMovieDetails() throws Exception{
		imdbpage.enterMovieNameInSearchBox("Pushpa The");
		releaseDateFromImdb=imdbpage.getReleaseDate();
		countyNameFromImdb=imdbpage.getCountryName();
		 
		navigateTo("https://www.wikipedia.org/");
		wikiPage.enterMovieNameInSearchBox("Pushpa The");
		releaseDateFromWiki=wikiPage.getReleaseDate();
		countyNameFromWiki=wikiPage.getCountryName();
		
		releaseDateFromImdb=releaseDateFromImdb.replace(",", "");
		releaseDateFromWiki=releaseDateFromWiki.replace(",", "");
		List<String> date1=Arrays.asList(releaseDateFromImdb.split(" +"));
		releaseDateFromImdb=date1.get(1)+" "+date1.get(0)+" "+date1.get(2);
		
		Assert.assertEquals(countyNameFromImdb, countyNameFromWiki);
		Assert.assertEquals(releaseDateFromImdb, releaseDateFromWiki);
		
	}
	
	
}
