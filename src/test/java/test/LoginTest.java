package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driverTest;
	
	
	String userName = null;
	String password = null;
	
	@Test
	@Parameters({"username","password" }) //order matters
	public void validUserShouldBeAbleToLogin(String userName, String password) throws InterruptedException {
		
		driverTest = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driverTest, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driverTest, DashboardPage.class);
		dashboard.verifyDashboardElement();
		
		BrowserFactory.tearDown();
		
	}

}
