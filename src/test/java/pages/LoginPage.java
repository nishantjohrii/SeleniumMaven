package pages;

import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	
	////// WebElement ////////////////
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement Login;
	
	@FindBy(xpath = "//input[@name='user_login']")
	WebElement EmailAddress;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath = "//*[@class='rememberMe']")
	WebElement RememberMe;
	
	@FindBy(xpath = "//*[@name='btn_login']")
	WebElement LoginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//////////// functions/////////////////////

	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
		Login.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully");
		
		EmailAddress.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter Email Address", "Email entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on Remember Me", "clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login button clicked successfully");
		
	}
	

}
