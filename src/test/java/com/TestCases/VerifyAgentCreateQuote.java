package com.TestCases;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

public class VerifyAgentCreateQuote {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11, child12, child13, child14, child15, child16, child17, child18;
	
	JSONParser parser=new JSONParser();
	
	String agentUsername,agentPassword,firstInsuredName,lastInsuredName,homePhoneNumber,emailAddress,garageStreetAddress;
	String garageZIPCode,dateOfBirthDriver,licenseNumberforDriver,employerNameforDriver,occupationforDriver,vehicleVIN;
	
	@Test
	public void VerifyCreateQuote() throws Exception
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Agent Request a Quote");
		
		//--------------------------------Agent Login--------------------------------------------------------------
		
		child1=report.startTest("Test Case 1: Check Agent login");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		AgentLoginPage agentlogin=PageFactory.initElements(driver, AgentLoginPage.class);
		
		AgentCreateQuotePage agentCreateQuote=PageFactory.initElements(driver, AgentCreateQuotePage.class);
		
		//agentlogin.clickOnAgentLogin();
		child1.log(LogStatus.INFO, "Click on Login option at the top of the Home page.");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/agentLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;		
		agentUsername = (String) jsonObject.get("Correct UserName");
		agentPassword = (String) jsonObject.get("Correct Password");
		
		agentlogin.agentLogin(agentUsername, agentPassword);
		
		child1.log(LogStatus.INFO, "Agent is able to login successfully.");
		
		agentCreateQuote.clickRequestaQuote();
		
		logger.appendChild(child1);
		
		//-----------------Check Insured Information form with keeping first name blank---------------
		
		child2=report.startTest("Test Case 2: Check Insured Information form with keeping first name blank");
				
		agentCreateQuote.enterFirstInsuredName("");
		child2.log(LogStatus.INFO, "Keep First Name blank in Insured Information form.");
		
		agentCreateQuote.clickContinueQuoteButton();
		child2.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping First Name blank in Insured Information form.");

		String firstInsured_err = agentCreateQuote.getfirstInsuredValidationError();		
		child2.log(LogStatus.INFO, "Get the validation error message on First Name input field in Insured Information form.");
		
		if (firstInsured_err.contains("required"))
			{
				child2.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping First Name blank in Insured Information form.");
			}
		else
			{
			child2.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping First Name blank in Insured Information form.");
			}
		
		child2.log(LogStatus.INFO, firstInsured_err);
				
		logger.appendChild(child2);
		
		//-----------------Check Insured Information form with keeping last name blank---------------
		
		child3=report.startTest("Test Case 3: Check Insured Information form with keeping last name blank");
		
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/agentCreateQuoteInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;		
		firstInsuredName = (String) jsonObject1.get("First Insured Name");
		
		agentCreateQuote.enterFirstInsuredName(firstInsuredName);
		child3.log(LogStatus.INFO, "Agent is able to enter First Name successfully.");
		
		agentCreateQuote.clickContinueQuoteButton();
		child3.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping Last Name blank in Insured Information form.");

		String secondInsured_err = agentCreateQuote.getLastInsuredValidationError();		
		child3.log(LogStatus.INFO, "Get the validation error message on Last Name input field in Insured Information form.");
		
		if (secondInsured_err.contains("required"))
			{
				child3.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping Last Name blank in Insured Information form.");
			}
		else
			{
				child3.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping Last Name blank in Insured Information form.");
			}
		
		
		child3.log(LogStatus.INFO, secondInsured_err);
				
		logger.appendChild(child3);	
		
		//------------------Check Insured Information form with keeping home phone numer field blank---------------------------
		
		child4=report.startTest("Test Case 4: Check Insured Information form with keeping home phone numer field blank");
						
		lastInsuredName = (String) jsonObject1.get("Last Insured Name");
				
		agentCreateQuote.enterLastInsuredName(lastInsuredName);
		child4.log(LogStatus.INFO, "Agent is able to enter Last Name successfully.");
				
		agentCreateQuote.clickContinueQuoteButton();
		child4.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping home phone numer blank in Insured Information form.");

		String homePhone_err = agentCreateQuote.getHomePhoneValidationError();		
		child4.log(LogStatus.INFO, "Get the validation error message on Home Phone input field in Insured Information form.");
		
		if (homePhone_err.contains("required"))
			{
				child4.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping Home Phone blank in Insured Information form.");
			}
		else
			{
				child4.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping Home Phone blank in Insured Information form.");
			}
						
		logger.appendChild(child4);
		
		//-------------------Check Insured Information form with keeping Primary Email Address	field blank---------------------
		
		child5=report.startTest("Test Case 5: Check Insured Information form with keeping Primary Email Address	field blank");
				
		homePhoneNumber = (String) jsonObject1.get("Home Phone Number");
		
		agentCreateQuote.enterHomePhone(homePhoneNumber);
		child5.log(LogStatus.INFO, "Agent is able to enter Home Phone Number successfully.");
		
		agentCreateQuote.clickContinueQuoteButton();
		child5.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping Primary Email Address blank in Insured Information form.");

		String primaryEmailAddress_err = agentCreateQuote.getPrimaryEmailValidationError();		
		child5.log(LogStatus.INFO, "Get the validation error message on Primary Email Address input field in Insured Information form.");
		
		if (primaryEmailAddress_err.contains("required"))
			{
				child5.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping Primary Email Address blank in Insured Information form.");
			}
		else
			{
				child5.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping Primary Email Address blank in Insured Information form.");
			}
				
		logger.appendChild(child5);	
		
		//------------------Check Insured Information form with entering correct data in all fields--------------------
		
		child6=report.startTest("Test Case 6: Check Insured Information form with entering correct data in all fields");
						
		emailAddress = (String) jsonObject1.get("Email Address");
				
		agentCreateQuote.enterEmailAddress(emailAddress);
		child6.log(LogStatus.INFO, "Agent is able to enter Email Address successfully.");
				
		agentCreateQuote.clickContinueQuoteButton();
		child6.log(LogStatus.INFO, "Agent clicks on Continue quote button with correct data in all fields in Insured Information form.");
		
		child6.log(LogStatus.PASS, "Agent is able to enter Insured Information correctly.");

						
		logger.appendChild(child6);
		
		//--------------Check Address form with keeping Street Address Blank-------------------
		
		child7=report.startTest("Test Case 7: Check Address form with keeping Street Address Blank");
								
		agentCreateQuote.enterGarageStreetAddress("");
		child7.log(LogStatus.INFO, "Agent is keeping Garage Street Address Blank.");
						
		agentCreateQuote.clickContinueQuoteButton();
		child7.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping Street Address Blank.");
		
		String streetValidationAddress_err = agentCreateQuote.getfirstInsuredStreetAddressValidationError();		
		child7.log(LogStatus.INFO, "Get the validation error message on Garage Street Address input field in Insured Information form.");
		
		if (streetValidationAddress_err.contains("required"))
			{
				child7.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping Garage Street Address blank in Address form.");
			}
		else
			{
				child7.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping Garage Street Address blank in Address form.");
			}
							
		logger.appendChild(child7);
		
		//-------------------Check Address form with keeping Zip Code Blank-----------------------
		
		child8=report.startTest("Test Case 8: Check Address form with keeping Zip Code Blank");
										
		garageStreetAddress = (String) jsonObject1.get("Garage Street Address");
								
		agentCreateQuote.enterGarageStreetAddress(garageStreetAddress);
		child8.log(LogStatus.INFO, "Agent is able to enter Street Address successfully.");
						
		agentCreateQuote.enterGarageZIPCode("");
		child8.log(LogStatus.INFO, "Agent is keeping Garage Zip Code Blank.");
								
		agentCreateQuote.clickContinueQuoteButton();
		child8.log(LogStatus.INFO, "Agent clicks on Continue quote button with keeping Zip Code Blank.");
				
		String zipCodeAddress_err = agentCreateQuote.getZipCodeValidationError();		
		child8.log(LogStatus.INFO, "Get the validation error message on Garage Street Address input field in Insured Information form.");
				
		if (zipCodeAddress_err.contains("required"))
			{
				child8.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Continue quote button with keeping Zip Code blank in Address form.");
			}
		else
			{
				child8.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Continue quote button with keeping Zip Code blank in Address form.");
			}
									
		logger.appendChild(child8);
				
		//--------------Check Address Form with all correct inputs--------------------------
		
		child9=report.startTest("Test Case 9: Check Address Form with all correct inputs");
						
		garageStreetAddress = (String) jsonObject1.get("Garage Street Address");
				
		agentCreateQuote.enterGarageStreetAddress(garageStreetAddress);
		child9.log(LogStatus.INFO, "Agent is able to enter Street Address successfully.");
		
		garageZIPCode = (String) jsonObject1.get("Garage ZIP Code");
				
		agentCreateQuote.enterGarageZIPCode(garageZIPCode);
		child9.log(LogStatus.INFO, "Agent is able to enter Zip Code successfully.");
		
		child9.log(LogStatus.PASS, "Agent is able to enter correct inputs in address form successfully.");
						
		logger.appendChild(child9);	
		
		//--------------------------------Add Driver--------------------------------------------------------------
		//----------------------Check Add Driver with keeping First Name blank------------------------------------
		
		child10=report.startTest("Test Case 10: Check Add Driver with keeping First Name blank");
												
		agentCreateQuote.clickAddDriver();
		child10.log(LogStatus.PASS, "Agent is able to click on Add Driver to open add driver screen successfully.");
								
		agentCreateQuote.enterFirstDriverName("");
		child10.log(LogStatus.INFO, "Keep First Name blank in Add Driver form.");
						
		agentCreateQuote.clickSaveDriverButton();
		child10.log(LogStatus.INFO, "Agent clicks on Save Driver button with keeping First Name blank in Add Driver form.");

		String driverFirstName_err = agentCreateQuote.getDriverFirstNameValidationError();		
		child10.log(LogStatus.INFO, "Get the validation error message on Garage Street Address input field in Insured Information form.");
								
		if (driverFirstName_err.contains("required"))
			{
				child10.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Driver button with keeping First Name blank in Add Driver form.");
			}
		else
			{
				child10.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with First Name blank in Add Driver form.");
			}
				
		logger.appendChild(child10);
		
		//----------------------Check Add Driver with keeping Last Name blank------------------------------------
		
		child11=report.startTest("Test Case 11: Check Add Driver with keeping Last Name blank");
		
		agentCreateQuote.enterFirstDriverName(firstInsuredName);
		child11.log(LogStatus.INFO, "Agent is able to enter first name in Add Driver form.");
		
		agentCreateQuote.enterLastDriverName("");
		child11.log(LogStatus.INFO, "Keep the last name blank in Add Driver form.");
								
		agentCreateQuote.clickSaveDriverButton();
		child11.log(LogStatus.INFO, "Agent clicks on Save Driver button with keeping Last Name blank in Add Driver form.");

		String driverLastName_err = agentCreateQuote.getDriverLastNameValidationError();		
		child11.log(LogStatus.INFO, "Get the validation error message on Garage Street Address input field in Insured Information form.");
										
		if (driverLastName_err.contains("required"))
			{
			child11.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Driver button with keeping Last Name blank in Add Driver form.");
			}
		else
			{
			child11.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with Last Name blank in Add Driver form.");
			}
						
		logger.appendChild(child11);
		
		//----------------------Check Add Driver with keeping Date of Birth	blank------------------------------------
		
		child12=report.startTest("Test Case 12: Check Add Driver with keeping Date of Birth blank");
																
		agentCreateQuote.enterLastDriverName(lastInsuredName);
		child12.log(LogStatus.INFO, "Agent is able to enter last name in Add Driver form.");
										
		agentCreateQuote.clickSaveDriverButton();
		child12.log(LogStatus.INFO, "Agent clicks on Save Driver button with keeping DOB blank in Add Driver form.");

		String driverDOB_err = agentCreateQuote.getDriverDOBValidationError();		
		child12.log(LogStatus.INFO, "Get the validation error message on Driver's Date of Birth input field in Add Driver form.");
												
		if (driverDOB_err.contains("required"))
			{
				child12.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Driver button with keeping DOB blank in Add Driver form.");
			}
		else
			{
				child12.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with keeping DOB blank in Add Driver form.");
			}
								
		logger.appendChild(child12);
		
		//----------------------Check Add Driver with keeping Date of Birth	blank------------------------------------
		
		child13=report.startTest("Test Case 13: Check Add Driver with keeping Gender blank");

		dateOfBirthDriver = (String) jsonObject1.get("Date Of Birth Driver");
		
		agentCreateQuote.enterDateOfBirthDriver(dateOfBirthDriver);
		child13.log(LogStatus.INFO, "Agent is able to enter Driver's Date of Birth successfully.");
												
		agentCreateQuote.clickSaveDriverButton();
		child13.log(LogStatus.INFO, "Agent clicks on Save Driver button with keeping Gender blank in Add Driver form.");
		
		agentCreateQuote.clickContinueQuoteButton();
		child13.log(LogStatus.INFO, "Agent is able to click on Continue quote button on create quote page successfully.");

		String quotePageValidationGender_err = agentCreateQuote.getQuotePageValidationError();		
		child13.log(LogStatus.INFO, "Get the validation error message on Driver's Date of Birth input field in Add Driver form.");
														
		if (quotePageValidationGender_err.contains("required"))
			{
				child13.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Driver button with keeping Gender blank in Add Driver form.");
			}
		else
			{
				child13.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with keeping Gender blank in Add Driver form.");
			}
										
		logger.appendChild(child13);
		
		//----------------------Check Add Driver with keeping License Number blank------------------------------------
		
		child14=report.startTest("Test Case 14: Check Add Driver with keeping License Number blank");
																				
		//agentUsername = (String) jsonObject.get("Agent Username");
		//agentPassword = (String) jsonObject.get("Agent Password");
		
		agentCreateQuote.clickEditDriver();
		child14.log(LogStatus.INFO, "Agent is able to click on Edit Driver on Create Quote page successfully.");
		
		agentCreateQuote.selectGenderforDriver();
		child14.log(LogStatus.INFO, "Agent is able to select Gender for Driver successfully.");
		
		agentCreateQuote.clickSaveDriverButton();
		child14.log(LogStatus.INFO, "Agent clicks on Save Driver button with keeping License Number blank in Add Driver form.");
				
		agentCreateQuote.clickContinueQuoteButton();
		child14.log(LogStatus.INFO, "Agent is able to click on Continue quote button on create quote page successfully.");

		String quotePageValidationLicenseNumber_err = agentCreateQuote.getQuotePageLicenseNumberValidationError();		
		child14.log(LogStatus.INFO, "Get the validation error message on Driver's License Number input field in Add Driver form.");
																
		if (quotePageValidationLicenseNumber_err.contains("required"))
			{
				child14.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Driver button with keeping License Number blank in Add Driver form.");
			}
		else
			{
				child14.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with keeping License Number blank in Add Driver form.");
			}
												
		logger.appendChild(child14);
		
		//----------------------Check Add Driver with entering all correct data------------------------------------
		
		child15=report.startTest("Test Case 15: Check Add Driver with entering all correct data");
				
		agentCreateQuote.clickEditDriver();
		child15.log(LogStatus.INFO, "Agent is able to click on Edit Driver on Create Quote page successfully.");
		
		licenseNumberforDriver = (String) jsonObject1.get("License Number for Driver");
		
		agentCreateQuote.enterLicenseNumberforDriver(licenseNumberforDriver);
		child15.log(LogStatus.INFO, "Agent is able to enter License Number for Driver successfully.");
		
		employerNameforDriver = (String) jsonObject1.get("Employer Name for Driver");
						
		agentCreateQuote.enterEmployerNameforDriver(employerNameforDriver);
		child15.log(LogStatus.INFO, "Agent is able to enter Employer Name for Driver successfully.");
		
		occupationforDriver = (String) jsonObject1.get("Occupation for Driver");
						
		agentCreateQuote.enterOccupationforDriver(occupationforDriver);
		child15.log(LogStatus.INFO, "Agent is able to enter License Occupation for Driver successfully.");
						
		agentCreateQuote.clickSaveDriverButton();
		child15.log(LogStatus.PASS, "Agent is able to Add Driver with all correct inputs successfully.");
														
		logger.appendChild(child15);
		
		//--------------------Check Add Vehicle with keeping Vehicle Information field blank----------------------------------
		
		child16=report.startTest("Test Case 16: Check Add Vehicle with keeping Vehicle Information field blank");
								
		agentCreateQuote.clickAddVehicleButton();
		child16.log(LogStatus.INFO, "Agent is able to click on Add Vehicle to open add Vehicle screen successfully.");
				
		agentCreateQuote.clickSaveVehicle();
		child16.log(LogStatus.INFO, "Click Save Vehicle button with keeping VIN field blank.");
				
		String addVehicleVIN_err = agentCreateQuote.getVehicleVINValidationError();		
		child16.log(LogStatus.INFO, "Get the validation error message on Driver's License Number input field in Add Driver form.");
																
		if (addVehicleVIN_err.contains("required"))
			{
				child16.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Vehicle button with keeping VIN blank in Add Vechile form.");
			}
		else
			{
				child16.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with keeping VIN blank in Add Vechile form.");
			}		
		
		logger.appendChild(child16);
		
		//--------------------Check Add Vehicle with keeping Physical Damage coverage blank----------------------------------
		
		child17=report.startTest("Test Case 17: Check Add Vehicle with keeping Physical Damage coverage blank");

		vehicleVIN = (String) jsonObject1.get("Vehicle VIN");
										
		agentCreateQuote.enterVehicleVIN(vehicleVIN);
		child17.log(LogStatus.INFO, "Agent is able to enter Vechicle's VIN successfully.");
		
		agentCreateQuote.enterVehicleYear("");
		Thread.sleep(5000);
						
		agentCreateQuote.clickSaveVehicle();
		child17.log(LogStatus.INFO, "Click Save Vehicle button with keeping Physical Damage coverage blank.");
						
		String addVehiclePhycialDamage_err = agentCreateQuote.getPhysicalDamageCoverageValidationError();		
		child17.log(LogStatus.INFO, "Get the validation error message on Physical Damage coverage in Add Driver form.");
																		
		if (addVehiclePhycialDamage_err.contains("error"))
			{
				child17.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks on Save Vehicle button with keeping Physical Damage coverag blank in Add Vechile form.");
			}
		else
			{
				child17.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks on Save Driver button with keeping Physical Damage coverag blank in Add Vechile form.");
			}
				
		logger.appendChild(child17);

		//------------------Check Add Vehicle with entering all correct data---------------------
		
		child18=report.startTest("Test Case 18: Check Add Vehicle with entering all correct data");
		
		agentCreateQuote.selectCompDed();
		child18.log(LogStatus.INFO, "Agent is able to select Comp Ded and Coll Ded successfully.");
		
		agentCreateQuote.clickSaveVehicle();
		child18.log(LogStatus.INFO, "Agent is able to click Save Vehicle button successfully.");
		
		Thread.sleep(5000);
		
		agentCreateQuote.clickContinueQuoteButton();
		child18.log(LogStatus.INFO, "Agent is able to click on Continue quote button on create quote page successfully.");
		child18.log(LogStatus.PASS, "Agent is able to create quote successfully.");
		
		logger.appendChild(child18);
		
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