package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./Screenshot",screenshotName+".png"));
	
}	
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {

		screenshotName = screenshotName + ".png";
		String directory = "./Screenshot";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + screenshotName));
		String destination = directory + screenshotName;

		return destination;

	}
public static int getrowcount(String path,String sheetName) throws IOException {
	File file = new File(path);
	FileInputStream inputStream = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	XSSFSheet sheet = wb.getSheet(sheetName);
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	return rowCount;
}

}
