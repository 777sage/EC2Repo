package com.revature.testng;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.revature.dao.Service;
import com.revature.selenium.LoginPage;
import com.revature.selenium.SettingsPage;

//test if settings save after tab change
//test if settings save after refresh
//test if settings save after logout/login
//test if settings save between sessions
//test if settings save between vp and trainer
//test if reset button works between tab change
//test if reset saves between sessions

public class SalesforceSettingsTest {
	WebDriver driver;
	LoginPage lp;
	SettingsPage sp;
	String trainerUsername;
	String trainerPassword;
	Service service;
	ChromeOptions options;
	//FirefoxOptions options;
	//note: reset button does not work
	//refreshing page loses save and update buttons
	
	
	@BeforeMethod
	public void beforeMethod() {
		options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
		options.addArguments("--start-maximized");
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver(options);
		
//		options = new FirefoxOptions().addArguments("C:\\Users\\Sameer\\AppData\\Local\\Google\\Chrome\\User Data");
//		File firefox = new File("src/test/resources/geckodriver.exe");
//		
//		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
//		
//		driver = new FirefoxDriver(options);
		
		
		
		lp = new LoginPage();
		sp = new SettingsPage();
	}

	@AfterMethod
	public void afterMethod() {
		 driver.close();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
	
	@Ignore
	@Test(priority = 0)
	public void settingsButtonsWorks() {
		System.out.println("settingsButtonsWorks()");
		lp.loginAsTrainer(driver);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		sp.changeToSettings(driver);
		String settingsURL = sp.getURL(driver);
		assertEquals(settingsURL, "https://dev.assignforce.revaturelabs.com/settings");
	}
	
	//check if save button works between tab change
	@Test(priority = 1)
	public void settingsSaveBetweenTabs() { 
		try {
			System.out.println("settingsSaveBetweenTabs()");
			lp.loginAsVp(driver);
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			sp.nap(5000);
			sp.changeToSettings(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sp.ngModels(driver);
			//settings page entries
			sp.timelineTrainersPerPageEntryVP(driver);
			sp.nap(1000);
//			sp.reportsOutgoingGradsEntryVP(driver);
//			sp.reportsCandidateIncomingEntryVP(driver);
//			sp.defaultBatchLocationEntryVP(driver);
//			sp.minimumBatchSizeEntryVP(driver);
//			sp.maximumBatchSizeEntryVP(driver);
//			sp.defaultBatchLengthEntryVP(driver);
//			sp.minimumDayBetweenTrainerBatchesEntryVP(driver);
//			sp.clickSave(driver);
			//Service.updateTest("settingsSaveBetweenTabs", "Success");
		}catch(Error e) {
			//Service.updateTest("settingsSaveBetweenTabs", "Failed");
			System.out.println(e.getMessage());
		}
		//change to different tab then back
		sp.changeToOverview(driver);
		sp.nap(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sp.changeToSettings(driver);
		sp.nap(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//sp.ngModels(driver);
		//sp.timelineTrainersPerPageEntryVP(driver);
		//sp.nap(1000);
		
		//check values
		//get values from page
		//assert true if they are all equals
		//sp.testClass(driver);
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}
	

}
