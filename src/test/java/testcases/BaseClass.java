package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	
	 XSSFWorkbook wbook;
	 XSSFSheet sheet;
	 
	public static ExtentReports report;
	public static ExtentTest test;	
	 
	 
	 @BeforeTest
	 public void DataSetUP() throws IOException {
		 
		 FileInputStream fis = new FileInputStream("exceldata.xlsx");
		 
		 wbook = new XSSFWorkbook(fis);
		 sheet = wbook.getSheet("Sheet1");
		 
		 report = new ExtentReports("ExtentReport.html");
	 }
	 
	 @AfterTest
	 public void  DataTearDown() throws IOException {
		 
		 wbook.close();
		 report.flush();
		 report.close();
	 }
	
	@BeforeMethod
	public void SetUp(Method method) {

		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void TearDown() {
		report.endTest(test);
		driver.quit();
	}

}
