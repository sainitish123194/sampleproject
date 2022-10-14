package com.pages;

import org.openqa.selenium.support.PageFactory;

import utility.TestBase;

public class BasePage extends TestBase {
	
	public BasePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	

}
