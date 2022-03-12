package testcases;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailureTest() {
		
		test = report.startTest("LoginFailureTest");

		LoginPage login = new LoginPage();
		login.LoginFunction("abcd@gmail.com", "Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));

		String ActualMsg = ErrorMsg.getText();
		String ExpectedMsg = "The email or password you have entered is invalid.";

		Assert.assertEquals(ActualMsg, ExpectedMsg);

		report.endTest(test);
	}

	@Test
	public void LoginSuccessTest() {
		
		test = report.startTest("LoginSuccessTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("nishantjohrii@gmail.com", "Abc@1234567890");
		
		report.endTest(test);
	}
	
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("ParameterizedTest");
		
		
		LoginPage login = new LoginPage();
		
		report.endTest(test);
		login.LoginFunction(UserNameVal, PasswordVal);
		
		report.endTest(test);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void ExternalDataTest() {
		
		test = report.startTest("ExternalDataTest");
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		report.endTest(test);
		
	}
	
	

}
