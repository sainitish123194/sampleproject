package utility;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.ImdbPage;
import com.pages.WikiPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	ExtentReports report;
	public static ExtentTest test;
	ExtentTest extentTest;
	
	@BeforeClass
	public void setup() throws InterruptedException {

	//	System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\HP\\eclipse-workspace\\Amazon_Testing_Framework\\Driver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		report = Extentfactory.getInstance();
		test = report.startTest("Moovie Validations");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.get("https://www.imdb.com/");
		
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Web Application opened");
		
	}

	 
	public void navigateTo(String url){
		driver.navigate().to(url);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
