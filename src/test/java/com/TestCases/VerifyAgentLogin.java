package com.TestCases;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AgentLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyAgentLogin {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5;
	
	String agentUsername,agentPassword,wUserName,cpassword,cUsername;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifyLogin() throws Exception
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Agent Login");
		
		
		//--------------------------------Check Agent Login with User name blank--------------------------------------------------------------
		
		child1=report.startTest("Test Case 1: Check Agent Login with User name blank");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		AgentLoginPage agentlogin=PageFactory.initElements(driver, AgentLoginPage.class);
		
		//agentlogin.clickOnAgentLogin();
		child1.log(LogStatus.INFO, "Click on Logon option at the top of the Home page.");
		
		agentlogin.clickLogOn();
		child1.log(LogStatus.INFO, "Click on Log On button of login form with keeping user name blank.");
		
		String userNameValidation = agentlogin.getValidationUsername();
		child1.log(LogStatus.INFO, "Getting validation error message .");
		
		if(userNameValidation.contains("The User name field is required."))
			{
				child1.log(LogStatus.PASS, "Agent is able to get the correct validation error message when click on Logon with keeping user name blank.");
			}
		else
			{
				child1.log(LogStatus.FAIL, "Agent is not getting correct validation error message when click on Logon with keeping user name blank.");
			}
		
		logger.appendChild(child1);
		
		//--------------------------------Check Agent Login with password field blank--------------------------------------------------------------
			
		child2=report.startTest("Test Case 2: Check Agent Login with password blank");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/agentLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		wUserName = (String) jsonObject.get("Wrong UserName");
		
		agentlogin.enterUsername(wUserName);
		child2.log(LogStatus.INFO, "Enter username in the user field of login form.");
		
		agentlogin.clickLogOn();
		child2.log(LogStatus.INFO, "Click on Log On button of login form with keeping password blank.");
		
		String passwordValidation = agentlogin.getValidationUsername();
		child2.log(LogStatus.INFO, "Getting validation error message .");
		
		if(passwordValidation.contains("The Password field is required."))
			{
				child2.log(LogStatus.PASS, "Agent is able to get the correct validation error message when click on Logon with keeping password blank.");
			}
		else
			{
				child2.log(LogStatus.FAIL, "Agent is not getting correct validation error message when click on Logon with keeping password blank.");
			}
		
		logger.appendChild(child2);
		
		//--------------------------------Check Agent Login with wrong User name--------------------------------------------------------------
		
		child3=report.startTest("Test Case 3: Check Agent Login with wrong User name");
		
		child3.log(LogStatus.INFO, "Enter wrong username in the user field of login form.");
		
		cpassword = (String) jsonObject.get("Correct Password");
		
		agentlogin.enterPassword(cpassword);
		child3.log(LogStatus.INFO, "Enter correct password in the password field of login form.");		
		
		agentlogin.clickLogOn();
		child3.log(LogStatus.INFO, "Click on Log On button of login form with wrong User name.");
		
		String wrongUsernameValidation = agentlogin.getMainValidation();
		child3.log(LogStatus.INFO, "Getting validation error message.");
		
		if(wrongUsernameValidation.contains("unsuccessful"))
			{
				child3.log(LogStatus.PASS, "Agent is able to get the correct validation error message when click on Logon with entering wrong username.");
			}
		else
			{
				child3.log(LogStatus.FAIL, "Agent is not getting correct validation error message when click on Logon with entering wrong username.");
			}
		
		logger.appendChild(child3);
		
		//--------------------------------Check Agent Login with wrong password--------------------------------------------------------------
		
		child4=report.startTest("Test Case 4: Check Agent Login with wrong password");
		
		cUsername = (String) jsonObject.get("Correct UserName");
		
		agentlogin.enterUsername(cUsername);
		child4.log(LogStatus.INFO, "Enter correct username in the user field of login form.");
		
		agentlogin.enterPassword("ykumar2020");
		child4.log(LogStatus.INFO, "Enter wrong password in the password field of login form.");		
		
		agentlogin.clickLogOn();
		child4.log(LogStatus.INFO, "Click on Log On button of login form with wrong password.");
		
		String wrongPasswordValidation = agentlogin.getMainValidation();
		child4.log(LogStatus.INFO, "Getting validation error message.");
		
		if(wrongPasswordValidation.contains("unsuccessful"))
			{
				child4.log(LogStatus.PASS, "Agent is able to get the correct validation error message when click on Logon with entering wrong password.");
			}
		else
			{
				child4.log(LogStatus.FAIL, "Agent is not getting correct validation error message when click on Logon with entering wrong password.");
			}
		
		logger.appendChild(child4);
		
		//--------------------------------Check Agent Login with correct username and password--------------------------------------------------------------
		
		child5=report.startTest("Test Case 5: Check Agent Login with correct username and password");
		
		String login_title = agentlogin.getTitle();
		child5.log(LogStatus.INFO, login_title +"Get the title of the login form page.");
		
		agentlogin.enterUsername(cUsername);
		child5.log(LogStatus.INFO, "Enter correct username in the user field of login form.");
		
		agentlogin.enterPassword("ykumar2020!");
		child5.log(LogStatus.INFO, "Enter correct password in the user field of login form.");
		
		agentlogin.clickLogOn();
		child5.log(LogStatus.INFO, "Click on Log On button of login form.");
		
		Thread.sleep(5000);
		
		String loggedIn_title = agentlogin.getTitle();
		
		if(loggedIn_title.contains("Loginn"))
			{
				child5.log(LogStatus.FAIL, "Agent is not able to login.");
			}
		else
			{
				child5.log(LogStatus.PASS, "Agent is able to login successfully.");
			}
		
		logger.appendChild(child5);
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