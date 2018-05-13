package com.revature.selenium;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SettingsPage {
	String timelineTrainersPerPage;
	String reportsOutgoingGrads;
	String reportsCandidatesIncoming;
	String defaultBatchLocation;
	String minimumBatchSize;
	String maximumBatchSize;
	String defaultBatchLength;
	String minimumDayBetweenTrainerBatches;
	Vector<Integer> rngarr;
	List<WebElement> settingElements = new ArrayList<WebElement>();
	//List<WebElement> settingElements = new ArrayList<WebElement>();

	public SettingsPage() {
		try {
			Properties props = new Properties();
			InputStream in = new FileInputStream("src/main/resources/util.properties");
			props.load(in);
			timelineTrainersPerPage = props.getProperty("timelineTrainersPerPage");
			reportsOutgoingGrads = props.getProperty("reportsOutgoingGrads");
			reportsCandidatesIncoming = props.getProperty("reportsCandidatesIncoming");
			defaultBatchLocation = props.getProperty("defaultBatchLocation");
			minimumBatchSize = props.getProperty("minimumBatchSize");
			maximumBatchSize = props.getProperty("maximumBatchSize");
			defaultBatchLength = props.getProperty("defaultBatchLength");
			minimumDayBetweenTrainerBatches = props.getProperty("minimumDayBetweenTrainerBatches");
			randomNumGen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void randomNumGen() {
		rngarr = new Vector<>();
		Random rand = new Random();
		int rand_int;
		// generate random numbers for settings page
		for (int i = 0; i < 7; i++) {
			rand_int = rand.nextInt(100);
			rngarr.add(rand_int);
		}
		// add random value for dropdown menu
		rand_int = rand.nextInt(183) + 14;
		rngarr.add(rand_int);
		System.out.println("Random numbers are: " + rngarr);
	}
	
	
	public void nap(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//
	public void ngModels(WebDriver driver) {
		settingElements = new ArrayList<WebElement>();
		settingElements = driver.findElements(By.tagName("input"));
		// fetch each element's attribute
		for (int i = 0; i < settingElements.size(); i++) {
			System.out.println(settingElements.get(i).getAttribute("ng-model"));

		}
	}

	public void findSettingsPage(WebDriver driver) {
		driver.get("https://dev.assignforce.revaturelabs.com/settings");
	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// changes page via click
	public void changeToSettings(WebDriver driver) {
		driver.findElement(
				By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[8]/a/span/span"))
				.click();
	}

	public void changeToOverview(WebDriver driver) {
		driver.findElement(
				By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[1]/a/span/span"))
				.click();

	}

	// send key value should be from external file
	public void timelineTrainersPerPageEntryTrainer(WebDriver driver) {
		System.out.println("Value: " + driver.findElement(By.id("input_2")).getText());
		driver.findElement(By.id("input_2")).clear();
		driver.findElement(By.id("input_2")).sendKeys("5");

	}

	/*
	 * Populate Settings Page with RNG values
	 */

	// List<WebElement> things = new ArrayList<WebElement>();
	// things = browser.findElements(By.tagName("ng-model"));
	// for(int i=0; i<things.size(); i++)
	// {
	// if(things.get(i).getAttribute(""))
	// }

	// testing
	public void timelineTrainersPerPageEntryVP(WebDriver driver) {
//		System.out.println(driver.findElement(By.tagName("ng-model")));//.getAttribute("ng-model"));
		//System.out.println(driver.findElement(By.id("input_3")).getAttribute("ng-model"));	
		
		
		//System.out.println(things);
		//settingElements.add(driver.findElement(By.tagName("ng-model")).getAttribute("ng-model"));
		
//		System.out.println(driver.findElement(By.tagName(settingElements.get(0))));
//		driver.findElement(By.tagName(settingElements.get(0))).clear();
//		driver.findElement(By.tagName(settingElements.get(0))).sendKeys("" + rngarr.get(0));
//		System.out.println("Value: " + driver.findElement(By.tagName(settingElements.get(0))).getAttribute("value"));// use later to check																				// values
		WebElement myEle = null;
		System.out.println("in method");
		for(int i = 0; i<settingElements.size(); i++) {
			if(settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.trainersPerPage")) {
				myEle = settingElements.get(i);
			}
			
		}
		//myEle.click();
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(0));
		
		//to check if page has changed, call ng models again to get a new array
		//and check if old array matches new array.
		
	
	
	
	
	
	
	}

	// public void timelineTrainersPerPageEntryVP(WebDriver driver) {
	// driver.findElement(By.id("input_3")).clear();
	// driver.findElement(By.id("input_3")).sendKeys("" + rngarr.get(0));
	// System.out.println("Value: " +
	// driver.findElement(By.id("input_3")).getAttribute("value"));// use later to
	// check // values
	// } // values

	public void reportsOutgoingGradsEntryVP(WebDriver driver) {
		//driver.findElement(By.id("input_4")).clear();
		//driver.findElement(By.id("input_4")).sendKeys("" + rngarr.get(1));
		//System.out.println("Value: " + driver.findElement(By.id("input_4")).getAttribute("value"));// test
		WebElement myEle = null;
		System.out.println("in method");
		for(int i = 0; i<settingElements.size(); i++) {
			if(settingElements.get(i).getAttribute("ng-model").contains("sCtrl.settings.trainersPerPage")) {
				myEle = settingElements.get(i);
			}
			
		}
		//myEle.click();
		myEle.clear();
		myEle.sendKeys("" + rngarr.get(0));
	}

	public void reportsCandidateIncomingEntryVP(WebDriver driver) {
		driver.findElement(By.id("input_5")).clear();
		driver.findElement(By.id("input_5")).sendKeys("" + rngarr.get(2));
		System.out.println("Value: " + driver.findElement(By.id("input_5")).getAttribute("value"));// test
	}

	public void minimumBatchSizeEntryVP(WebDriver driver) {
		driver.findElement(By.id("input_10")).clear();
		driver.findElement(By.id("input_10")).sendKeys("" + rngarr.get(3));
		System.out.println("Value: " + driver.findElement(By.id("input_10")).getAttribute("value"));// test
	}

	public void maximumBatchSizeEntryVP(WebDriver driver) {
		driver.findElement(By.id("input_11")).clear();
		driver.findElement(By.id("input_11")).sendKeys("" + rngarr.get(4));
		System.out.println("Value: " + driver.findElement(By.id("input_11")).getAttribute("value"));// test
	}

	public void defaultBatchLengthEntryVP(WebDriver driver) {
		driver.findElement(By.id("input_12")).clear();
		driver.findElement(By.id("input_12")).sendKeys("" + rngarr.get(5));
		System.out.println("Value: " + driver.findElement(By.id("input_12")).getAttribute("value"));// test
	}

	public void minimumDayBetweenTrainerBatchesEntryVP(WebDriver driver) {
		driver.findElement(By.id("input_13")).clear();
		driver.findElement(By.id("input_13")).sendKeys("" + rngarr.get(6));
		System.out.println("Value: " + driver.findElement(By.id("input_13")).getAttribute("value"));// test
	}

	public void defaultBatchLocationEntryVP(WebDriver driver) {
		// driver.findElement(By.xpath("//*[@id=\"select_value_label_1\"]/span[1]/div")).click();;
		// driver.findElement(By.id("select_option_153")).click();
		// +rngarr.get(7)

		WebElement element = driver.findElement(By.xpath("//*[@id=\"select_value_label_1\"]/span[1]/div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		actions.moveToElement(driver.findElement(By.id("select_option_" + rngarr.get(7)))).click().perform();
		driver.findElement(By.id("select_option_" + rngarr.get(7))).click();
	}

	public void clickSave(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/section/button[1]/span"));
	}

	public void clickReset(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-list/section/button[2]/span"));
	}

	public void testClass(WebDriver driver) {
		System.out.println("Value: " + driver.findElement(By.id("input_3")).getAttribute("value"));// use later to check
		System.out.println("Value: " + driver.findElement(By.id("input_4")).getAttribute("value"));// use later to check
		System.out.println("Value: " + driver.findElement(By.id("input_5")).getAttribute("value"));// use later to check
		System.out.println("Value: " + driver.findElement(By.id("input_10")).getAttribute("value"));// use later to
																									// check
		System.out.println("Value: " + driver.findElement(By.id("input_11")).getAttribute("value"));// use later to
																									// check
		System.out.println("Value: " + driver.findElement(By.id("input_12")).getAttribute("value"));// use later to
																									// check
		System.out.println("Value: " + driver.findElement(By.id("input_13")).getAttribute("value"));// use later to
																									// check

	}

}
