package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
	
	String userName = null;
	String password = null;
	String fullName = null;
	String companyName = null;
	String email = null;
	String phone = null;
	String address = null;
	String city = null;
	String country = null;
	String state = null;
	String zip = null;
	
	
	@Test
	@Parameters({"username", "password", "fullName", "companyName", "email", "phone", "address", "city", "country", "state", "zip"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String country, String state, String zip) throws InterruptedException {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.selectCountryDropDown(country);
		addCustomerPage.clickSaveButton();
		
		dashboard.verifyProfilePage();
		dashboard.clickListCustomerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		BrowserFactory.tearDown();
		
	}
	
	@Test
	@Parameters({"username", "password", "fullName", "companyName", "email", "phone", "address", "city", "country", "state", "zip"})
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String country, String state, String zip) throws InterruptedException {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		dashboard.clickCustomerButton();
		dashboard.clickListCustomerButton();
		
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.selectCountryDropDown(country);
		addCustomerPage.clickSaveButton();
		
		dashboard.verifyProfilePage();
		dashboard.clickListCustomerButton();
		
		addCustomerPage.validateSearchBoxAndProfileButton();
				
		//BrowserFactory.tearDown();
		
	}

}
