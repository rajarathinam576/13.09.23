package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static  WebDriver driver;
	public static  void browser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;

		default:
			System.out.println("please check browser input");
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		}
	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	public static void passValue(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public static WebElement findingElement(String locator,String value) {
		switch (locator) {
		case "id":
			WebElement element = driver.findElement(By.id(value));
			return element;
		case "name":
			WebElement element2 = driver.findElement(By.name(value));
            return element2;
		case "xpath":
			WebElement element3 = driver.findElement(By.xpath(value));
			return element3;
		default:
			System.out.println("please check the findelements");
			break;
		}
		return null ;
	}
	public void navigate(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public  void navigateRefresh() {
		driver.navigate().refresh();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public static void windowMax() {
		driver.manage().window().maximize();
}
	
public void screenshot (File destFile) throws IOException {
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotAs, destFile);
}


// [Data Driven]
// Accessing Input Stream from a file
public static FileInputStream accessFileStream(String filePath) throws FileNotFoundException {
	File file = new File(filePath);
	FileInputStream inputStream = new FileInputStream(file);
	return inputStream;
}

// Passing Output Stream to a file
public FileOutputStream outputStreamFile(String filePath) throws FileNotFoundException {
	File file = new File(filePath);
	FileOutputStream outputstream = new FileOutputStream(file);
	return outputstream;
}

// Access the workbook by InputStream
public static Workbook accessWorkBook(String format, FileInputStream fileStream) throws IOException {
	if (format.equals("xlx")) {
		Workbook workbook = new HSSFWorkbook(fileStream);
		return workbook;
	} else if (format.equals("xlsx")) {
		Workbook workbook = new XSSFWorkbook(fileStream);
		return workbook;
	} else {
		System.out.println("Enter xlx or xlsx format");
		return null;
	}
}


public void dropDownValue (String value, WebElement element) {
	Select select = new Select(element);
	select.selectByValue(value);
}
public void windowHandles (String window) {
	String windowHandle = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	for(String window1 :windowHandles) {
		if(!window1.equals(windowHandle)) {
			driver.switchTo().window(window1);
		}
	}
}
	
public static  void quit() {
	driver.quit();
}
public static void Click(WebElement element) {
	element.click();
}

// Get Attribute Value
public String AttributeValue(WebElement element, String attributeName) {
	String attributeValue = element.getAttribute(attributeName);
	return attributeValue;
}

// Retrieve a data from a Sheet
public static String retriveDataFromSheet(Workbook workBook, String sheetName, int rowNum, int cellNum) {
	Cell cell = workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	CellType cellType = cell.getCellType();
	switch (cellType) {
	case STRING:
		// if(cellType.equals("STRING")) {
		String stringCellValue = cell.getStringCellValue();
		return stringCellValue;
	case NUMERIC:
		// } else if(cellType.equals("NUMERIC")) {
		if (DateUtil.isCellDateFormatted(cell)) {
		     java.util.Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
			String format2 = format.format(dateCellValue);
			return format2;
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long number = (long) numericCellValue;
			String string = Long.toString(number);
			return string;
		}
	case BOOLEAN:
		// } else if(cellType.equals("BOOLEAN")) {
		boolean booleanCellValue = cell.getBooleanCellValue();
		String string2 = Boolean.toString(booleanCellValue);
		return string2;
	// } else {
	default:
		return null;
	}
}

	// Actions
	public void clickMousePointer(WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
}

}
