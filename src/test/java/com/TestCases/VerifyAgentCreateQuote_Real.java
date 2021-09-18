package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AgentCreateQuotePage;
import com.Pages.AgentLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyAgentCreateQuote_Real {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4;
	
	//JSONParser parser=new JSONParser();
	
	String agentUsername,agentPassword;
	
	@Test
	public void VerifyCreateQuote() throws Exception
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Agent Request a Quote");
		
		//Object obj = parser.parse(new FileReader("src/test/java/JSONData/agentLoginInputData.json"));
		///JSONObject jsonObject = (JSONObject) obj;
		
		//--------------------------------Agent Login--------------------------------------------------------------
		
		child1=report.startTest("Test Case 1: Check Agent login");
		
		//agentUsername = (String) jsonObject.get("Agent Username");
		//agentPassword = (String) jsonObject.get("Agent Password");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		AgentLoginPage agentlogin=PageFactory.initElements(driver, AgentLoginPage.class);
		
		AgentCreateQuotePage agentCreateQuote=PageFactory.initElements(driver, AgentCreateQuotePage.class);
		
		//agentlogin.clickOnAgentLogin();
		child1.log(LogStatus.INFO, "Click on Login option at the top of the Home page.");
		
		agentlogin.agentLogin("ykumar", "ykumar2020!");
		
		child1.log(LogStatus.INFO, "Agent is able to login successfully.");
		
		agentCreateQuote.clickRequestaQuote();
		
		logger.appendChild(child1);
		
		//--------------------------------Enter Insured Information--------------------------------------------------------------
		
		child2=report.startTest("Test Case 2: Enter Insured Information");
				
		//agentUsername = (String) jsonObject.get("Agent Username");
		//agentPassword = (String) jsonObject.get("Agent Password");
				
		agentCreateQuote.enterFirstInsuredName("Cate");
		child2.log(LogStatus.INFO, "Agent is able to enter First Name successfully.");
		
		agentCreateQuote.enterLastInsuredName("Flemingo");
		child2.log(LogStatus.INFO, "Agent is able to enter Last Name successfully.");
		
		agentCreateQuote.enterHomePhone("1234567898");
		child2.log(LogStatus.INFO, "Agent is able to enter Home Phone Number successfully.");
		
		agentCreateQuote.enterEmailAddress("test@test.com");
		child2.log(LogStatus.INFO, "Agent is able to enter Email Address successfully.");
		
		agentCreateQuote.enterGarageStreetAddress("test");
		child2.log(LogStatus.INFO, "Agent is able to enter Street Address successfully.");
		
		agentCreateQuote.enterGarageZIPCode("32086");
		child2.log(LogStatus.INFO, "Agent is able to enter Zip Code successfully.");
				
		logger.appendChild(child2);	
		
		//--------------------------------Add Driver--------------------------------------------------------------
		
		child3=report.startTest("Test Case 3: Add Driver");
						
		//agentUsername = (String) jsonObject.get("Agent Username");
		//agentPassword = (String) jsonObject.get("Agent Password");
						
		agentCreateQuote.clickAddDriver();
		child3.log(LogStatus.INFO, "Agent is able to click on Add Driver to open add driver screen successfully.");
		
		agentCreateQuote.enterDateOfBirthDriver("2/2/1995");
		child3.log(LogStatus.INFO, "Agent is able to enter Driver's Date of Birth successfully.");
		
		agentCreateQuote.selectGenderforDriver();
		child3.log(LogStatus.INFO, "Agent is able to select Gender for Driver successfully.");
		
		agentCreateQuote.enterLicenseNumberforDriver("B162954957718");
		child3.log(LogStatus.INFO, "Agent is able to enter License Number for Driver successfully.");
		
		agentCreateQuote.enterEmployerNameforDriver("Insurance Company");
		child3.log(LogStatus.INFO, "Agent is able to enter Employer Name for Driver successfully.");
		
		agentCreateQuote.enterOccupationforDriver("Engineer");
		child3.log(LogStatus.INFO, "Agent is able to enter License Occupation for Driver successfully.");
		
		agentCreateQuote.clickSaveDriverButton();
						
		logger.appendChild(child3);
		

		//--------------------------------Add Vehicle--------------------------------------------------------------
		
		child4=report.startTest("Test Case 4: Add Vehicle");
		
		//agentUsername = (String) jsonObject.get("Agent Username");
		//agentPassword = (String) jsonObject.get("Agent Password");
						
		agentCreateQuote.clickAddVehicleButton();
		child4.log(LogStatus.INFO, "Agent is able to click on Add Vehicle to open add Vehicle screen successfully.");
		
		agentCreateQuote.enterVehicleVIN("3FA6P0G75HR416829");
		child4.log(LogStatus.INFO, "Agent is able to enter Vechicle's VIN successfully.");
		
		agentCreateQuote.enterVehicleYear("");
		Thread.sleep(5000);
		
		agentCreateQuote.selectCompDed();
		
		agentCreateQuote.clickSaveVehicle();
		child4.log(LogStatus.INFO, "Agent is able to click Save Vehicle button successfully.");
		
		Thread.sleep(5000);
		
		agentCreateQuote.clickContinueQuoteButton();
		child4.log(LogStatus.INFO, "Agent is able to click on Continue quote button on create quote page successfully.");
		
		logger.appendChild(child4);
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		//
		//If test is getting failed then take the screen shot and put it in Automation Report.
		//
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path=Utility.captureScreenshot(driver, result.getName());
			String image=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "User is Not able to Login as Agent.");
			logger.log(LogStatus.FAIL, "Agent_Login_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);;
		report.flush();;
		driver.close();
	}
}