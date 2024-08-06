package com.fordfoundation.salesforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;




public class SF_Mailing_State 

{
	 WebDriver driver;
	 XSSFWorkbook wb;
	 XSSFSheet sheet;
	 XSSFRow row;
	 XSSFCell cell;

	 FileOutputStream outputstream;
	 String country_val;
	 List<WebElement> mailing_state;
	 
	 String inputFile = "C:\\Users\\kravikumar\\Downloads\\SF-Country.xlsx";
	 String outputFile = ".\\Result\\Result_file.xlsx";
	 
	//Given any account name, have to open and kept
	 By account_locator = By.xpath("(//a[@title='Aloena Pinas | Account'])[1]");
	
	int row_num = -1;
	int col_num = -1;
	
	@BeforeTest
	public void initialSetup() throws InterruptedException, FileNotFoundException {
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://fordfoundation--training.sandbox.my.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		By username_locator = By.id("username");
		By password_locator = By.id("password");
		By submit_locator = By.id("Login");
		
		driver.findElement(username_locator).sendKeys("k.ravikumar.srvcprvdr@fordfoundation.org.training");
		driver.findElement(password_locator).sendKeys("Welcome@1440320");
		driver.findElement(submit_locator).click();
		Thread.sleep(5000);
		
		
		driver.findElement(account_locator).click();
		
		Thread.sleep(5000);
		
		By accountinfo_locator =  By.xpath("//a[text()='Contact Info']");
		driver.findElement(accountinfo_locator).click();
		
		
	    By mailingadress_edit = By.xpath("//span[@class='inline-edit-trigger-icon slds-button__icon slds-button__icon_hint']");
		driver.findElement(mailingadress_edit).click();
		
		WebElement country_field =  driver.findElement(By.xpath("//input[@autocomplete='country']"));
		
		 js.executeScript("arguments[0].scrollIntoView(true);", country_field);
		 js.executeScript("arguments[0].click();", country_field);
		  
		 
		 Thread.sleep(5000); 
		 
		 wb = new XSSFWorkbook();
		 sheet = wb.createSheet("Result_sheet");
		 
	}
	
	
	
	
	@Test(dataProvider = "CountryName")
	public void getState(String country) throws InterruptedException, IOException
	{
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 country_val = country;
		 System.out.println("Country: "+country_val);
		 
		WebElement hh= driver.findElement(By.xpath("//lightning-base-combobox-item//span//span[text()='"+country_val+"']"));
				       js.executeScript("arguments[0].click();", hh);
		 
		Thread.sleep(5000);
		
		
		WebElement state = driver.findElement(By.xpath("(//input[@name='province'])[1]"));
		js.executeScript("arguments[0].click();", state);
		
		Thread.sleep(5000);
		
		mailing_state = driver.findElements(By.xpath("//input[@aria-label='Mailing State/Province']//..//following::div[2]//lightning-base-combobox-item"));

		Thread.sleep(5000);
		
		System.out.println(mailing_state.size());
		
		
		for(WebElement ele : mailing_state)
		{

 			Thread.sleep(200);
			String value = ele.getText();
			System.out.println(value);
		
		}
		
	}
	

	
	@AfterMethod
	public void writeToExcelFile() throws IOException {
		row_num = row_num + 1;
		
		for(int m=0; m<1; m++) {

		row = sheet.createRow(row_num);
		cell = row.createCell(0);
		cell.setCellValue(country_val);
		
		for(int i=0;i < mailing_state.size(); i++)
		{
	
			cell = row.createCell(i+1);
			String stateVal = mailing_state.get(i).getText();
			cell.setCellValue(stateVal);
			
		}
		
		}
			
	}
	
	
	
	
	@AfterTest
	public void finalWrite() throws IOException {
		 outputstream = new FileOutputStream(outputFile);
		 wb.write(outputstream);
		 System.out.println("Data written successfully");
		 outputstream.close();
    
	}
	
	
	
	



	@DataProvider(name="CountryName")
	public String[] countryNameProvider() throws IOException {
		
		FileInputStream fis = new FileInputStream(inputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("Last row number " +(lastRowNum));
		
		String[] data = new String[lastRowNum];
		
		int colNum = 0;
		
		
		for(int rowNum=0; rowNum <lastRowNum ; rowNum++)
		{
			data[rowNum]= sheet.getRow(rowNum+1).getCell(colNum).getStringCellValue();
		}
		
		//print the array
		for(int i=0;i<data.length;i++)
		{
			System.out.println(data[i]);
		}
		System.out.println("-------------------------------");
		
		return data;
		
	}
	
	
	/*
	
	@AfterMethod
	public void writeToExcelFile1() throws IOException {
		
		row_num = row_num + 1;
		
		col_num = col_num + 1;
	    // Create the first row for the country values
		if(col_num==0)
	    row = sheet.createRow(0); // First row (index 0)

	 	    for (int i = 0; i < 1; i++) {
	        cell = row.createCell(col_num); // Create cell for each column (start from 1 to leave the first column)
	        cell.setCellValue(country_val); // Set the country value
	    }

	    // Fill in the state values starting from the second row
	    for (int i = 0; i < mailing_state.size(); i++) {
	        String stateVal = mailing_state.get(i).getText();
	        row = sheet.createRow(i+1); // Create a new row for each state value (start from row index 1)
	        cell = row.createCell(col_num); // Fill the second column (index 1)
	        cell.setCellValue(stateVal); // Set the state value
	    }
	}
	
	*/


}








