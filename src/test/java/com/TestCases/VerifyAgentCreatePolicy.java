package com.TestCases;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AgentCreatePolicyPage;
import com.Pages.AgentCreateQuotePage;
import com.Pages.AgentLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyAgentCreatePolicy {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11, child12, child13, child14, child15, child16, child17, child18, child19, child20;
	ExtentTest child21, child22, child23, child24, child25, child26, child27, child28, child29, child30;
	ExtentTest child31, child32, child33, child34, child35, child36, child37, child38, child39, child40;
	ExtentTest child41, child42, child43, child44, child45, child46, child47, child48, child49, child50;
	ExtentTest child51, child52, child53, child54, child55, child56, child57, child58, child59, child60;
	
	JSONParser parser=new JSONParser();
	
	String agentUsername,agentPassword,firstInsuredName;
	
	@Test
	public void VerifyCreatePolicy() throws Exception
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Agent Create Policy");
		
		//Object obj = parser.parse(new FileReader("src/test/java/JSONData/agentLoginInputData.json"));
		///JSONObject jsonObject = (JSONObject) obj;
		
		//--------------------------------Agent Login--------------------------------------------------------------
		
		child1=report.startTest("Test Case 1: Step1 - Agent login");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		AgentLoginPage agentlogin=PageFactory.initElements(driver, AgentLoginPage.class);
		
		AgentCreateQuotePage agentCreateQuote=PageFactory.initElements(driver, AgentCreateQuotePage.class);
		
		AgentCreatePolicyPage agentCreatePolicy=PageFactory.initElements(driver, AgentCreatePolicyPage.class);
		
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
		
		//--------------------------------Enter Insured Information--------------------------------------------------------------
		
		child2=report.startTest("Test Case 2: Step2 - Entering Insured Information");
				
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/agentCreatePolicyInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;		
		
		firstInsuredName = (String) jsonObject1.get("First Insured Name");
				
		agentCreateQuote.enterFirstInsuredName(firstInsuredName);
		child2.log(LogStatus.INFO, "Agent is able to enter First Name successfully.");
		
		String lastInsuredName = (String) jsonObject1.get("Last Insured Name");
		
		agentCreateQuote.enterLastInsuredName(lastInsuredName);
		child2.log(LogStatus.INFO, "Agent is able to enter Last Name successfully.");
		
		String homePhoneNumber = (String) jsonObject1.get("Home Phone Number");
		
		agentCreateQuote.enterHomePhone(homePhoneNumber);
		child2.log(LogStatus.INFO, "Agent is able to enter Home Phone Number successfully.");
		
		String emailAddress = (String) jsonObject1.get("Email Address");
		
		agentCreateQuote.enterEmailAddress(emailAddress);
		child2.log(LogStatus.INFO, "Agent is able to enter Email Address successfully.");
		
		String garageStreetAddress = (String) jsonObject1.get("Garage Street Address");
		
		agentCreateQuote.enterGarageStreetAddress(garageStreetAddress);
		child2.log(LogStatus.INFO, "Agent is able to enter Street Address successfully.");
		
		String garageZIPCode = (String) jsonObject1.get("Garage ZIP Code");
		
		agentCreateQuote.enterGarageZIPCode(garageZIPCode);
		child2.log(LogStatus.INFO, "Agent is able to enter Zip Code successfully.");
				
		logger.appendChild(child2);	
		
		//--------------------------------Add Driver--------------------------------------------------------------
		
		child3=report.startTest("Test Case 3: Step3 - Add Driver");
		
		agentCreateQuote.clickAddDriver();
		child3.log(LogStatus.INFO, "Agent is able to click on Add Driver to open add driver screen successfully.");
		
		String dateOfBirthDriver = (String) jsonObject1.get("Date Of Birth Driver");
		
		agentCreateQuote.enterDateOfBirthDriver(dateOfBirthDriver);
		child3.log(LogStatus.INFO, "Agent is able to enter Driver's Date of Birth successfully.");
		
		agentCreateQuote.selectGenderforDriver();
		child3.log(LogStatus.INFO, "Agent is able to select Gender for Driver successfully.");
		
		String licenseNumberforDriver = (String) jsonObject1.get("License Number for Driver");
		
		agentCreateQuote.enterLicenseNumberforDriver(licenseNumberforDriver);
		child3.log(LogStatus.INFO, "Agent is able to enter License Number for Driver successfully.");
		
		String employerNameforDriver = (String) jsonObject1.get("Employer Name for Driver");
		
		agentCreateQuote.enterEmployerNameforDriver(employerNameforDriver);
		child3.log(LogStatus.INFO, "Agent is able to enter Employer Name for Driver successfully.");
		
		String occupationforDriver = (String) jsonObject1.get("Occupation for Driver");
		
		agentCreateQuote.enterOccupationforDriver(occupationforDriver);
		child3.log(LogStatus.INFO, "Agent is able to enter License Occupation for Driver successfully.");
		
		agentCreateQuote.clickSaveDriverButton();
						
		logger.appendChild(child3);

		//--------------------------------Add Vehicle--------------------------------------------------------------
		
		child4=report.startTest("Test Case 4: Step4 - Add Vehicle");
						
		agentCreateQuote.clickAddVehicleButton();
		child4.log(LogStatus.INFO, "Agent is able to click on Add Vehicle to open add Vehicle screen successfully.");
		
		String vehicleVIN = (String) jsonObject1.get("Vehicle VIN");
		
		agentCreateQuote.enterVehicleVIN(vehicleVIN);
		child4.log(LogStatus.INFO, "Agent is able to enter Vechicle's VIN successfully.");
		
		agentCreateQuote.enterVehicleYear("");
		Thread.sleep(8000);
		
		agentCreateQuote.selectCompDed();
		
		agentCreateQuote.clickSaveVehicle();
		child4.log(LogStatus.INFO, "Agent is able to click Save Vehicle button successfully.");
		
		Thread.sleep(5000);
		
		agentCreateQuote.clickContinueQuoteButton();
		child4.log(LogStatus.INFO, "Agent is able to click on Continue quote button on create quote page successfully.");
		child4.log(LogStatus.INFO, "Agent is able to redirect to Questionnaire page successfully.");
		
		logger.appendChild(child4);
		
		//
		//--------------------------------Questionnaire--------------------------------------------------------------
		//--------------------Check Pre-Quote Questionnaire form with keeping Questions 1 blank--------------------
		//
		
		child5=report.startTest("Test Case 5: Step5 - Check Pre-Quote Questionnaire form with keeping Questions 1 blank");
		
		agentCreatePolicy.enterAgencyRepresentativeField("Test");
		child5.log(LogStatus.INFO, "Agent is able to enter Agency Representative Field successfully.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child5.log(LogStatus.INFO, "Agent is able to click Accept Answers with keeping all question Blank.");
		
		String autoInsuranceCancelled = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child5.log(LogStatus.INFO, "Get the validation error message on the first question");
		
		if (autoInsuranceCancelled.contains("answer"))
			{
				child5.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with keeping all question Blank.");
			}
		else
			{
				child5.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with keeping all question Blank.");
			}
		
		child5.log(LogStatus.INFO, autoInsuranceCancelled);
		
		logger.appendChild(child5);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 1 wrong------------
		
		child6=report.startTest("Test Case 6: Check Pre-Quote Questionnaire form with entering answer for Question 1 wrong");
		
		agentCreatePolicy.clickUnnacceptableRisktrue();
		child6.log(LogStatus.INFO, "Agent clicks Unnacceptable Risk value true for Question 1.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child6.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 1 wrong.");
		
		String unnacceptableRisktrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child6.log(LogStatus.INFO, "Get the validation error message on the first question");
		
		if (unnacceptableRisktrue.contains("cancelled"))
			{
				child6.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with keeping all question Blank.");
				child6.log(LogStatus.INFO, unnacceptableRisktrue);
			}
		else
			{
				child6.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with keeping all question Blank.");
			}
		
		logger.appendChild(child6);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 2 Blank-------------------
		
		child7=report.startTest("Test Case 7: Check Pre-Quote Questionnaire form with entering answer for Question 2 Blank");
		
		agentCreatePolicy.clickUnnacceptableRiskFalse();
		child7.log(LogStatus.INFO, "Agent clicks Unnacceptable Risk value false for Question 1.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child7.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 1 correct.");
		
		String unnacceptableRiskFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child7.log(LogStatus.INFO, "Get the validation error message on the second question");
		
		if (unnacceptableRiskFalse.contains("answer"))
			{
				child7.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 2 Blank.");
				child7.log(LogStatus.INFO, unnacceptableRisktrue);
			}
		else
			{
				child7.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 2 Blank.");
			}
							
		logger.appendChild(child7);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 2 wrong-------------------
		
		child8=report.startTest("Test Case 8: Check Pre-Quote Questionnaire form with entering answer for Question 2 wrong");
		
		agentCreatePolicy.clickHasLicenseSuspendedTrue();
		child8.log(LogStatus.INFO, "Agent clicks HasLicenseSuspended Risk value true for Question 2.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child8.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 2 wrong.");
		
		String hasLicenseSuspended = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child8.log(LogStatus.INFO, "Get the validation error message on the second question");
		
		if (hasLicenseSuspended.contains("cancelled"))
			{
				child8.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 2 wrong.");
				child8.log(LogStatus.INFO, hasLicenseSuspended);
			}
		else
			{
				child8.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 2 wrong.");
			}
		
		logger.appendChild(child8);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 3 blank-------------------
		
		child9=report.startTest("Test Case 9: Check Pre-Quote Questionnaire form with entering answer for Question 3 Blank");
		
		agentCreatePolicy.clickhasLicenseSuspendedFalse();
		child9.log(LogStatus.INFO, "Agent clicks HasLicenseSuspended Risk value false for Question 2.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child9.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 2 correct.");
		
		String hasDrivingImpairments = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child9.log(LogStatus.INFO, "Get the validation error message on the third question");
		
		if (hasDrivingImpairments.contains("answer"))
			{
				child9.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 3 Blank.");
				child9.log(LogStatus.INFO, hasDrivingImpairments);
			}
		else
			{
				child9.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 3 Blank.");
			}
		
		logger.appendChild(child9);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 3 wrong-------------------
		
		child10=report.startTest("Test Case 10: Check Pre-Quote Questionnaire form with entering answer for Question 3 wrong");
		
		agentCreatePolicy.clickHasDrivingImpairmentsTrue();
		child10.log(LogStatus.INFO, "Agent clicks HasDrivingImpairments value true for Question 3.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child10.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 3 wrong.");
		
		String hasDrivingImpairmentsTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child10.log(LogStatus.INFO, "Get the validation error message on the third question");
		
		if (hasDrivingImpairmentsTrue.contains("Unnacceptable Risk"))
			{
				child10.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 3 wrong.");
				child10.log(LogStatus.INFO, hasDrivingImpairmentsTrue);
			}
		else
			{
				child10.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 3 wrong.");
			}
		
		logger.appendChild(child10);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 4 blank-------------------
		
		child11=report.startTest("Test Case 11: Check Pre-Quote Questionnaire form with entering answer for Question 4 Blank");
				
		agentCreatePolicy.clickHasDrivingImpairmentsFalse();
		child11.log(LogStatus.INFO, "Agent clicks HasDrivingImpairments value false for Question 3.");
				
		agentCreatePolicy.clickAcceptAnswer();
		child11.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 4 Blank.");
		
		String hasDrivingImpairmentsFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child11.log(LogStatus.INFO, "Get the validation error message on the third question");
		
		if (hasDrivingImpairmentsFalse.contains("answer"))
			{
				child11.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 4 Blank.");
				child11.log(LogStatus.INFO, hasDrivingImpairmentsFalse);
			}
		else
			{
				child11.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 4 Blank.");
			}
		
		logger.appendChild(child11);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 4 wrong-------------------
		
		child12=report.startTest("Test Case 12: Check Pre-Quote Questionnaire form with entering answer for Question 4 wrong");
						
		agentCreatePolicy.clickHasDrivingImpairmentsFalse();
		child12.log(LogStatus.INFO, "Agent clicks HasDrivingImpairments value false for Question 3.");
						
		agentCreatePolicy.clickHasMadePIPClaimTrue();
		child12.log(LogStatus.INFO, "Agent is able to click Accept Answers with entering answer for Question 4 Blank.");
		
		agentCreatePolicy.clickhasMade2PIPClaimTrue();
		child12.log(LogStatus.INFO, "Agent clicks hasMade2PlusPIPClaims value false for Question 4.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child12.log(LogStatus.INFO, "Click on Accept Answers");
				
		String hasMade2PlusPIPClaims = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child12.log(LogStatus.INFO, "Get the validation error message on the forth question");
				
		if (hasMade2PlusPIPClaims.contains("Unnacceptable Risk"))
			{
				child12.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 4 wrong.");
				child12.log(LogStatus.INFO, hasMade2PlusPIPClaims);
			}
		else
			{
				child12.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 4 wrong.");
			}
			
		logger.appendChild(child12);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 5 Blank-------------------
		
		child13=report.startTest("Test Case 13: Check Pre-Quote Questionnaire form with entering answer for Question 5 Blank");
								
		agentCreatePolicy.clickhasMade1PIPClaim();
		child13.log(LogStatus.INFO, "Agent clicks Made a claim for Personal Injury value acceptable.");
				
		agentCreatePolicy.clickAcceptAnswer();
		child13.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 5 Blank");
						
		String has2PlusAFsWrong = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child13.log(LogStatus.INFO, "Get the validation error message on the fifth question");
						
		if (has2PlusAFsWrong.contains("answer"))
				{
					child13.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 5 Blank.");
					child13.log(LogStatus.INFO, has2PlusAFsWrong);
				}
		else
				{
					child13.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 5 Blank.");
				}
				
		logger.appendChild(child13);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 5 Wrong-------------------
		
		child14=report.startTest("Test Case 14: Check Pre-Quote Questionnaire form with entering answer for Question 5 Wrong");
										
		agentCreatePolicy.clickhas2PlusAF();
		child14.log(LogStatus.INFO, "Agent clicks Made a claim for Personal Injury value acceptable.");
						
		agentCreatePolicy.clickAcceptAnswer();
		child14.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 5 Wrong");
								
		String has2PlusAFsBlank = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child14.log(LogStatus.INFO, "Get the validation error message on the fifth question");
								
		if (has2PlusAFsBlank.contains("Unnacceptable Risk"))
			{
				child14.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 5 wrong.");
				child14.log(LogStatus.INFO, has2PlusAFsBlank);
			}
		else
			{
				child14.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 5 wrong.");
			}
						
		logger.appendChild(child14);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 6 Blank-------------------
		
		child15=report.startTest("Test Case 15: Check Pre-Quote Questionnaire form with entering answer for Question 6 Blank");
												
		agentCreatePolicy.clickhas2PlusAFFalse();
		child15.log(LogStatus.INFO, "Agent entering answer for Question 5 correct.");
								
		agentCreatePolicy.clickAcceptAnswer();
		child15.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 6 Blank");
		
		String hasAnyDriverResideLessThanTenMonths = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child15.log(LogStatus.INFO, "Get the validation error message on the sixth question");
								
		if (hasAnyDriverResideLessThanTenMonths.contains("answer"))
			{
				child15.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 6 Blank.");
				child15.log(LogStatus.INFO, hasAnyDriverResideLessThanTenMonths);
			}
		else
			{
				child15.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 6 Blank.");
			}
		
		logger.appendChild(child15);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 7 Blank-------------------
		
		child16=report.startTest("Test Case 16: Check Pre-Quote Questionnaire form with entering answer for Question 7 Blank");
		
		agentCreatePolicy.clickhasDriverResideLessThanTenMonths();
		child16.log(LogStatus.INFO, "Agent entering answer for Question 6 correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child16.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 6 correct");
		
		String Err_hasDriverResideLessThanTenMonths = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child16.log(LogStatus.INFO, "Get the validation error message on the sixth question");
		
		if (Err_hasDriverResideLessThanTenMonths.contains("answer"))
			{
				child16.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 7 Blank.");
				child16.log(LogStatus.INFO, Err_hasDriverResideLessThanTenMonths);
			}
		else
			{
				child16.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 7 Blank.");
			}
		
		logger.appendChild(child16);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 7 Wrong-------------------
		
		child17=report.startTest("Test Case 17: Check Pre-Quote Questionnaire form with entering answer for Question 7 Wrong");
		
		agentCreatePolicy.clickhasGrayMarketVehicle();
		child17.log(LogStatus.INFO, "Agent entering answer for Question 7 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child17.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 7 Wrong");
		
		String Err_hasGrayMarketVehicle = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child17.log(LogStatus.INFO, "Get the validation error message on the seventh question");
		
		if (Err_hasGrayMarketVehicle.contains("Unnacceptable Risk"))
			{
				child17.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 7 Wrong.");
				child17.log(LogStatus.INFO, Err_hasGrayMarketVehicle);
			}
		else
			{
				child17.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 7 Wrong.");
			}
		
		logger.appendChild(child17);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 8 Blank-------------------
		
		child18=report.startTest("Test Case 18: Check Pre-Quote Questionnaire form with entering answer for Question 8 Blank");
				
		agentCreatePolicy.clickhashasGrayMarketVehicleFalse();
		child18.log(LogStatus.INFO, "Agent entering answer for Question 8 Blank.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child18.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 8 Blank");
		
		String Err_hasGrayMarketVehicleFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child18.log(LogStatus.INFO, "Get the validation error message on the eight question");
		
		if (Err_hasDriverResideLessThanTenMonths.contains("answer"))
			{
				child18.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 8 Blank.");
				child18.log(LogStatus.INFO, Err_hasGrayMarketVehicleFalse);
			}
		else
			{
				child18.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 8 Blank.");
			}
				
		logger.appendChild(child18);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 8 Wrong-------------------
		
		child19=report.startTest("Test Case 19: Check Pre-Quote Questionnaire form with entering answer for Question 8 Wrong");
		
		agentCreatePolicy.clickhasVehicleForBusinessPurposeTrue();
		child19.log(LogStatus.INFO, "Agent entering answer for Question 8 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child19.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 8 Wrong");
		
		String Err_hasVehicleForBusinessPurposeTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child19.log(LogStatus.INFO, "Get the validation error message on the eight Wrong");
		
		if (Err_hasVehicleForBusinessPurposeTrue.contains("Unnacceptable Risk"))
			{
				child19.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 8 Wrong.");
				child19.log(LogStatus.INFO, Err_hasVehicleForBusinessPurposeTrue);
			}
		else
			{
				child19.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 8 Wrong.");
			}
		
		logger.appendChild(child19);
				
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 9 Blank-------------------
		
		child20=report.startTest("Test Case 20: Check Pre-Quote Questionnaire form with entering answer for Question 9 Blank");
		
		agentCreatePolicy.clickhasVehicleForBusinessPurposeFalse();
		child20.log(LogStatus.INFO, "Agent entering answer for Question 9 Blank.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child20.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 9 Blank");
		
		String Err_hasVehicleForBusinessPurposeFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child20.log(LogStatus.INFO, "Get the validation error message on the 9th question");
		
		if (Err_hasVehicleForBusinessPurposeFalse.contains("answer"))
			{
			child20.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 9 Blank.");
			child20.log(LogStatus.INFO, Err_hasVehicleForBusinessPurposeFalse);
			}
		else
			{
			child20.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 9 Blank.");
			}
		
		logger.appendChild(child20);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 9 Wrong-------------------
		
		child21=report.startTest("Test Case 21: Check Pre-Quote Questionnaire form with entering answer for Question 9 Wrong");
		
		agentCreatePolicy.clickhasHouseholdMemberNotDisclosedTrue();
		child21.log(LogStatus.INFO, "Agent entering answer for Question 9 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child21.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 9 Wrong");
		
		String Err_hasHouseholdMemberNotDisclosedTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child21.log(LogStatus.INFO, "Get the validation error message on the 9th question");
		
		if (Err_hasHouseholdMemberNotDisclosedTrue.contains("Unnacceptable Risk"))
			{
				child21.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 9 Wrong.");
				child21.log(LogStatus.INFO, Err_hasHouseholdMemberNotDisclosedTrue);
			}
		else
			{
				child21.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 9 Wrong.");
			}
				
		logger.appendChild(child21);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 10 Blank-------------------
		
		child22=report.startTest("Test Case 22: Check Pre-Quote Questionnaire form with entering answer for Question 10 Blank");
		
		agentCreatePolicy.clickhasHouseholdMemberNotDisclosedFalse();
		child22.log(LogStatus.INFO, "Agent entering answer for Question 10 Blank.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child22.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 10 Blank");
		
		String Err_hasHouseholdMemberNotDisclosedFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child22.log(LogStatus.INFO, "Get the validation error message on the 10th question");
		
		if (Err_hasHouseholdMemberNotDisclosedFalse.contains("answer"))
			{
				child22.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 10 Blank.");
				child22.log(LogStatus.INFO, Err_hasHouseholdMemberNotDisclosedFalse);
			}
		else
			{
				child22.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 10 Blank.");
			}
		
		logger.appendChild(child22);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 10 Wrong-------------------
		
		child23=report.startTest("Test Case 23: Check Pre-Quote Questionnaire form with entering answer for Question 10 Wrong");
		
		agentCreatePolicy.clickhasOtherHouseholdMemberDriverTrue();
		child23.log(LogStatus.INFO, "Agent entering answer for Question 10 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child23.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 10 Wrong");
		
		String Err_hasOtherHouseholdMemberDriverTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child23.log(LogStatus.INFO, "Get the validation error message on the 10th question");
		
		if (Err_hasOtherHouseholdMemberDriverTrue.contains("Unnacceptable Risk"))
			{
				child23.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 10 Wrong.");
				child23.log(LogStatus.INFO, Err_hasOtherHouseholdMemberDriverTrue);
			}
		else
			{
				child23.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 10 Wrong.");
			}
		
		logger.appendChild(child23);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 11 Blank-------------------
		
		child24=report.startTest("Test Case 24: Check Pre-Quote Questionnaire form with entering answer for Question 11 Blank");
		
		agentCreatePolicy.clickhasOtherHouseholdMemberDriverFalse();
		child24.log(LogStatus.INFO, "Agent entering answer for Question 11 Blank.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child24.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 11 Blank");
		
		String Err_hasOtherHouseholdMemberDriverFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child24.log(LogStatus.INFO, "Get the validation error message on the 11th question");
		
		if (Err_hasOtherHouseholdMemberDriverFalse.contains("answer"))
			{
				child24.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 11 Blank.");
				child24.log(LogStatus.INFO, Err_hasOtherHouseholdMemberDriverFalse);
			}
		else
			{
				child24.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 11 Blank.");
			}
			
		logger.appendChild(child24);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 11 Wrong-------------------
		
		child25=report.startTest("Test Case 25: Check Pre-Quote Questionnaire form with entering answer for Question 11 Wrong");
		
		agentCreatePolicy.clickhasVehicleNotSolelyOwnedFalse();
		child25.log(LogStatus.INFO, "Agent entering answer for Question 11 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child25.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 11 Wrong");
		
		String Err_hasVehicleNotSolelyOwnedFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child25.log(LogStatus.INFO, "Get the validation error message on the 11th question");
		
		if (Err_hasVehicleNotSolelyOwnedFalse.contains("Unnacceptable Risk"))
			{
				child25.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 11 Wrong.");
				child25.log(LogStatus.INFO, Err_hasVehicleNotSolelyOwnedFalse);
			}
		else
			{
				child25.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 11 Wrong.");
			}
		
		logger.appendChild(child25);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 12 Blank-------------------
		
		child26=report.startTest("Test Case 26: Check Pre-Quote Questionnaire form with entering answer for Question 12 Blank");
		
		agentCreatePolicy.clickhasVehicleNotSolelyOwnedTrue();
		child26.log(LogStatus.INFO, "Agent entering answer for Question 12 Blank.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child26.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 12 Blank");
		
		String Err_hasVehicleNotSolelyOwnedTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child26.log(LogStatus.INFO, "Get the validation error message on the 12th question");
		
		if (Err_hasVehicleNotSolelyOwnedTrue.contains("answer"))
			{
				child26.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 12 Blank.");
				child26.log(LogStatus.INFO, Err_hasVehicleNotSolelyOwnedTrue);
			}
		else
			{
				child26.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 12 Blank.");
			}
				
		logger.appendChild(child26);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 12 Wrong-------------------
		
		child27=report.startTest("Test Case 27: Check Pre-Quote Questionnaire form with entering answer for Question 12 Wrong");
		
		agentCreatePolicy.clickhasOtherResidentOrNonResidentDependentTrue();
		child27.log(LogStatus.INFO, "Agent entering answer for Question 12 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child27.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 12 Wrong");
		
		String Err_hasOtherResidentOrNonResidentDependentTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child27.log(LogStatus.INFO, "Get the validation error message on the 12th question");
		
		if (Err_hasOtherResidentOrNonResidentDependentTrue.contains("Unnacceptable Risk"))
			{
				child27.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 12 Wrong.");
				child27.log(LogStatus.INFO, Err_hasOtherResidentOrNonResidentDependentTrue);
			}
		else
			{
				child27.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 12 Wrong.");
			}
		
		logger.appendChild(child27);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 13 Blank-------------------
		
		child28=report.startTest("Test Case 28: Check Pre-Quote Questionnaire form with entering answer for Question 13 Blank");
		
		agentCreatePolicy.clickhasOtherResidentOrNonResidentDependentFalse();
		child28.log(LogStatus.INFO, "Agent entering answer for Question 12 correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child28.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 12 Blank");
		
		String Err_hasOtherResidentOrNonResidentDependentFlase = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child28.log(LogStatus.INFO, "Get the validation error message on the 13th question");
		
		if (Err_hasVehicleNotSolelyOwnedTrue.contains("answer"))
			{
				child28.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 13 Blank.");
				child28.log(LogStatus.INFO, Err_hasOtherResidentOrNonResidentDependentFlase);
			}
		else
			{
				child28.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 13 Blank.");
			}
		
		logger.appendChild(child28);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 13 Wrong-------------------
		
		child29=report.startTest("Test Case 29: Check Pre-Quote Questionnaire form with entering answer for Question 13 Wrong");
		
		agentCreatePolicy.clickhasSalvagedVehicle();
		child29.log(LogStatus.INFO, "Agent entering answer for Question 13 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child29.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 13 Wrong");
		
		String Err_hasSalvagedVehicle = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child29.log(LogStatus.INFO, "Get the validation error message on the 13th question");
		
		if (Err_hasSalvagedVehicle.contains("Unnacceptable Risk"))
			{
				child29.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 13 Wrong.");
				child29.log(LogStatus.INFO, Err_hasSalvagedVehicle);
			}
		else
			{
				child29.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 13 Wrong.");
			}
				
		logger.appendChild(child29);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 14 Blank-------------------
		
		child30=report.startTest("Test Case 30: Check Pre-Quote Questionnaire form with entering answer for Question 14 Blank");
		
		agentCreatePolicy.clickhasSalvagedVehicleFalse();
		child30.log(LogStatus.INFO, "Agent entering answer for Question 13 correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child30.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 14 Blank");
		
		String Err_hasSalvagedVehicleFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child30.log(LogStatus.INFO, "Get the validation error message on the 14th question");
		
		if (Err_hasSalvagedVehicleFalse.contains("answer"))
			{
				child30.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 14 Blank.");
				child30.log(LogStatus.INFO, Err_hasSalvagedVehicleFalse);
			}
		else
			{
				child30.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 14 Blank.");
			}
		
		logger.appendChild(child30);
		
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 15 Blank-------------------
		
		child31=report.startTest("Test Case 31: Check Pre-Quote Questionnaire form with entering answer for Question 15 Blank");
		
		agentCreatePolicy.clickhasVehicleNotGaragedFalse();
		child31.log(LogStatus.INFO, "Agent entering answer for Question 14 correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child31.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 15 Blank");
		
		String Err_hasVehicleNotGaragedFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child31.log(LogStatus.INFO, "Get the validation error message on the 15th question");
		
		if (Err_hasSalvagedVehicleFalse.contains("answer"))
			{
			child31.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 15 Blank.");
			child31.log(LogStatus.INFO, Err_hasVehicleNotGaragedFalse);
			}
		else
			{
			child31.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 15 Blank.");
			}
		
		logger.appendChild(child31);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 15 Wrong-------------------
		
		child32=report.startTest("Test Case 32: Check Pre-Quote Questionnaire form with entering answer for Question 15 Wrong");
		
		agentCreatePolicy.clickhasResidence10monthAndGarageSameFalse();
		child32.log(LogStatus.INFO, "Agent entering answer for Question 15 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child32.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 15 Wrong");
		
		String Err_hasResidence10monthAndGarageSameFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child32.log(LogStatus.INFO, "Get the validation error message on the 15th question");
		
		if (Err_hasResidence10monthAndGarageSameFalse.contains("garaging address"))
			{
				child32.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 15 Wrong.");
				child32.log(LogStatus.INFO, Err_hasResidence10monthAndGarageSameFalse);
			}
		else
			{
				child32.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 15 Wrong.");
			}
		
		logger.appendChild(child32);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 16 Blank-------------------
		
		child33=report.startTest("Test Case 33: Check Pre-Quote Questionnaire form with entering answer for Question 16 Blank");
		
		agentCreatePolicy.clickhasResidence10monthAndGarageSameTrue();
		child33.log(LogStatus.INFO, "Agent entering answer for Question 15 Correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child33.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 16 Blank");
		
		String Err_hasResidence10monthAndGarageSameTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child33.log(LogStatus.INFO, "Get the validation error message on the 16th question");
		
		if (Err_hasResidence10monthAndGarageSameTrue.contains("answer"))
			{
				child33.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 16 Blank.");
				child33.log(LogStatus.INFO, Err_hasResidence10monthAndGarageSameTrue);
			}
		else
			{
				child33.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 16 Blank.");
			}
		
		logger.appendChild(child33);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 16 Wrong-------------------
		
		child34=report.startTest("Test Case 34: Check Pre-Quote Questionnaire form with entering answer for Question 16 Wrong");
		
		agentCreatePolicy.clickhasReportedBusinessUseFalse();
		child34.log(LogStatus.INFO, "Agent entering answer for Question 16 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child34.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 16 Wrong");
		
		String Err_hasReportedBusinessUseFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child34.log(LogStatus.INFO, "Get the validation error message on the 16th question");
		
		if (Err_hasReportedBusinessUseFalse.contains("must be reported"))
			{
				child34.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 16 Wrong.");
				child34.log(LogStatus.INFO, Err_hasReportedBusinessUseFalse);
			}
		else
			{
				child34.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 16 Wrong.");
			}
				
		logger.appendChild(child34);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 17 Blank-------------------
		
		child35=report.startTest("Test Case 35: Check Pre-Quote Questionnaire form with entering answer for Question 17 Blank");
		
		agentCreatePolicy.clickhasReportedBusinessUseTrue();
		child35.log(LogStatus.INFO, "Agent entering answer for Question 16 Correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child35.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 17 Blank");
		
		String Err_hasReportedBusinessUseTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child35.log(LogStatus.INFO, "Get the validation error message on the 17th question");
		
		if (Err_hasReportedBusinessUseTrue.contains("answer"))
			{
				child35.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 17 Blank.");
				child35.log(LogStatus.INFO, Err_hasReportedBusinessUseTrue);
			}
		else
			{
				child35.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 17 Blank.");
			}
		
		logger.appendChild(child35);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 17 Wrong-------------------
		
		child36=report.startTest("Test Case 36: Check Pre-Quote Questionnaire form with entering answer for Question 17 Wrong");
		
		agentCreatePolicy.clickhasDisclosedRidesharingFalse();
		child36.log(LogStatus.INFO, "Agent entering answer for Question 17 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child36.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 17 Wrong");
		
		String Err_hasDisclosedRidesharingFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child36.log(LogStatus.INFO, "Get the validation error message on the 17th question");
		
		if (Err_hasDisclosedRidesharingFalse.contains("must be disclosed"))
			{
				child36.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 17 Wrong.");
				child36.log(LogStatus.INFO, Err_hasDisclosedRidesharingFalse);
			}
		else
			{
				child36.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 17 Wrong.");
			}
		
		logger.appendChild(child36);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 18 Blank-------------------
		
		child37=report.startTest("Test Case 37: Check Pre-Quote Questionnaire form with entering answer for Question 18 Blank");
		
		agentCreatePolicy.clickhasDisclosedRidesharingTrue();
		child37.log(LogStatus.INFO, "Agent entering answer for Question 17 Correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child37.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 18 Blank");
		
		String Err_hasDisclosedRidesharingTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child37.log(LogStatus.INFO, "Get the validation error message on the 18th question");
		
		if (Err_hasDisclosedRidesharingTrue.contains("answer"))
			{
				child37.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 18 Blank.");
				child37.log(LogStatus.INFO, Err_hasDisclosedRidesharingTrue);
			}
		else
			{
				child37.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 18 Blank.");
			}
		
		logger.appendChild(child37);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 19 Blank-------------------
		
		child38=report.startTest("Test Case 38: Check Pre-Quote Questionnaire form with entering answer for Question 19 Blank");
		
		agentCreatePolicy.clickhasWorkOutsideFloridaTrue();
		child38.log(LogStatus.INFO, "Agent entering answer for Question 18 Correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child38.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 19 Blank");
		
		String Err_hasWorkOutsideFloridaTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child38.log(LogStatus.INFO, "Get the validation error message on the 19th question");
		
		if (Err_hasWorkOutsideFloridaTrue.contains("answer"))
			{
				child38.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 19 Blank.");
				child38.log(LogStatus.INFO, Err_hasWorkOutsideFloridaTrue);
			}
		else
			{
				child38.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 19 Blank.");
			}
		
		logger.appendChild(child38);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 19 Wrong-------------------
		
		child39=report.startTest("Test Case 39: Check Pre-Quote Questionnaire form with entering answer for Question 19 Wrong");
		
		agentCreatePolicy.clickhasCriminalActivityTrue();
		child39.log(LogStatus.INFO, "Agent entering answer for Question 19 Wrong.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child39.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 19 Wrong");
		
		String Err_hasCriminalActivityTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child39.log(LogStatus.INFO, "Get the validation error message on the 19th question");
		
		if (Err_hasCriminalActivityTrue.contains("REMARK required"))
			{
				child39.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 19 Wrong.");
				child39.log(LogStatus.INFO, Err_hasCriminalActivityTrue);
			}
		else
			{
				child39.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 19 Wrong.");
			}
		
		logger.appendChild(child39);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 20 Blank-------------------
		
		child40=report.startTest("Test Case 40: Check Pre-Quote Questionnaire form with entering answer for Question 20 Blank");
		
		agentCreatePolicy.clickhasCriminalActivityFalse();
		child40.log(LogStatus.INFO, "Agent entering answer for Question 19 Correct.");
		
		agentCreatePolicy.clickAcceptAnswer();
		child40.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 20 Blank");
		
		String Err_hasCriminalActivityFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child40.log(LogStatus.INFO, "Get the validation error message on the 20th question");
		
		if (Err_hasCriminalActivityFalse.contains("answer"))
			{
				child40.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 20 Blank.");
				child40.log(LogStatus.INFO, Err_hasCriminalActivityFalse);
			}
		else
			{
				child40.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 20 Blank.");
			}
		
		logger.appendChild(child40);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 20 Wrong-------------------
		
		child41=report.startTest("Test Case 41: Check Pre-Quote Questionnaire form with entering answer for Question 20 Wrong");
		
		agentCreatePolicy.clickhasHouseholdMemberWithLawsuitTrue();
		child41.log(LogStatus.INFO, "Agent entering answer for Question 20 Wrong");
		
		agentCreatePolicy.clickAcceptAnswer();
		child41.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 20 Wrong");
		
		String Err_hasHouseholdMemberWithLawsuitTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child41.log(LogStatus.INFO, "Get the validation error message on the 20th question");
		
		if (Err_hasHouseholdMemberWithLawsuitTrue.contains("REMARK required"))
			{
				child41.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 20 Wrong.");
				child41.log(LogStatus.INFO, Err_hasHouseholdMemberWithLawsuitTrue);
			}
		else
			{
				child41.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 20 Wrong.");
			}
		
		logger.appendChild(child41);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 21 Blank-------------------
		
		child42=report.startTest("Test Case 42: Check Pre-Quote Questionnaire form with entering answer for Question 21 Blank");
		
		agentCreatePolicy.clickhasHouseholdMemberWithLawsuitFalse();
		child42.log(LogStatus.INFO, "Agent entering answer for Question 20 Correct");
		
		agentCreatePolicy.clickAcceptAnswer();
		child42.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 21 Blank");
		
		String Err_hasHouseholdMemberWithLawsuitFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child42.log(LogStatus.INFO, "Get the validation error message on the 21th question");
		
		if (Err_hasHouseholdMemberWithLawsuitFalse.contains("answer"))
			{
				child42.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 21 Blank.");
				child42.log(LogStatus.INFO, Err_hasHouseholdMemberWithLawsuitFalse);
			}
		else
			{
				child42.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 21 Blank.");
			}
		
		logger.appendChild(child42);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 21 Wrong-------------------
		
		child43=report.startTest("Test Case 43: Check Pre-Quote Questionnaire form with entering answer for Question 21 Wrong");
		
		agentCreatePolicy.clickhasHouseholdMemberWithLoanDefaultsTrue();
		child43.log(LogStatus.INFO, "Agent entering answer for Question 21 Wrong");
		
		agentCreatePolicy.clickAcceptAnswer();
		child43.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 21 Wrong");
		
		String Err_hasHouseholdMemberWithLoanDefaultsTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child43.log(LogStatus.INFO, "Get the validation error message on the 21th question");
		
		if (Err_hasHouseholdMemberWithLoanDefaultsTrue.contains("REMARK required"))
			{
				child43.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 21 Wrong.");
				child43.log(LogStatus.INFO, Err_hasHouseholdMemberWithLoanDefaultsTrue);
			}
		else
			{
				child43.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 21 Wrong.");
			}
		
		logger.appendChild(child43);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 22 Blank-------------------
		
		child44=report.startTest("Test Case 44: Check Pre-Quote Questionnaire form with entering answer for Question 22 Blank");
		
		agentCreatePolicy.clickhasHouseholdMemberWithLoanDefaultsFalse();
		child44.log(LogStatus.INFO, "Agent entering answer for Question 21 Correct");
		
		agentCreatePolicy.clickAcceptAnswer();
		child44.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 22 Blank");
		
		String Err_hasHouseholdMemberWithLoanDefaultsFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child44.log(LogStatus.INFO, "Get the validation error message on the 22th question");
		
		if (Err_hasHouseholdMemberWithLoanDefaultsFalse.contains("answer"))
			{
				child44.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 22 Blank.");
				child44.log(LogStatus.INFO, Err_hasHouseholdMemberWithLoanDefaultsFalse);
			}
		else
			{
				child44.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 22 Blank.");
			}
		
		logger.appendChild(child44);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 22 Wrong-------------------
		
		child45=report.startTest("Test Case 45: Check Pre-Quote Questionnaire form with entering answer for Question 22 Wrong");
		
		agentCreatePolicy.clickhasFailedToListAllVehiclesTrue();
		child45.log(LogStatus.INFO, "Agent entering answer for Question 22 Wrong");
		
		agentCreatePolicy.clickAcceptAnswer();
		child45.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 22 Wrong");
		
		String Err_clickhasFailedToListAllVehiclesTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child45.log(LogStatus.INFO, "Get the validation error message on the 22th question");
		
		if (Err_clickhasFailedToListAllVehiclesTrue.contains("REMARK"))
			{
				child45.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 22 Wrong.");
				child45.log(LogStatus.INFO, Err_clickhasFailedToListAllVehiclesTrue);
			}
		else
			{
				child45.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 22 Wrong.");
			}
		
		logger.appendChild(child45);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 23 Blank-------------------
		
		child46=report.startTest("Test Case 46: Check Pre-Quote Questionnaire form with entering answer for Question 23 Blank");
				
		agentCreatePolicy.clickhasFailedToListAllVehiclesFalse();
		child46.log(LogStatus.INFO, "Agent entering answer for Question 23 Blank");
				
		agentCreatePolicy.clickAcceptAnswer();
		child46.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 23 Blank");
				
		String Err_hasFailedToListAllVehiclesFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child46.log(LogStatus.INFO, "Get the validation error message on the 23th question");
				
		if (Err_hasFailedToListAllVehiclesFalse.contains("answer"))
			{
				child46.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 23 Blank.");
				child46.log(LogStatus.INFO, Err_hasFailedToListAllVehiclesFalse);
			}
		else
			{
				child46.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 23 Blank.");
			}
				
		logger.appendChild(child46);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 23 Wrong-------------------
		
		child47=report.startTest("Test Case 47: Check Pre-Quote Questionnaire form with entering answer for Question 23 Wrong");
		
		agentCreatePolicy.clickhasExistingDamageTrue();
		child47.log(LogStatus.INFO, "Agent entering answer for Question 23 Wrong");
				
		agentCreatePolicy.clickAcceptAnswer();
		child47.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 23 Wrong");
		
		String Err_hasExistingDamageTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child47.log(LogStatus.INFO, "Get the validation error message on the 23th question");
		
		if (Err_hasExistingDamageTrue.contains("REMARK"))
			{
				child47.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 23 Wrong.");
				child47.log(LogStatus.INFO, Err_hasExistingDamageTrue);
			}
		else
			{
				child47.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 23 Wrong.");
			}
		
		logger.appendChild(child47);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 24 Blank-------------------
		
		child48=report.startTest("Test Case 48: Check Pre-Quote Questionnaire form with entering answer for Question 24 Blank");
		
		agentCreatePolicy.clickhasExistingDamageFalse();
		child48.log(LogStatus.INFO, "Agent entering answer for Question 23 Correct");
				
		agentCreatePolicy.clickAcceptAnswer();
		child48.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 24 Blank");
		
		String Err_hasExistingDamageFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child48.log(LogStatus.INFO, "Get the validation error message on the 24th question");
		
		if (Err_hasExistingDamageFalse.contains("answer"))
			{
				child48.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 24 Blank.");
				child48.log(LogStatus.INFO, Err_hasExistingDamageFalse);
			}
		else
			{
				child48.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 24 Blank.");
			}
		
		logger.appendChild(child48);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 24 Wrong-------------------
		
		child49=report.startTest("Test Case 48: Check Pre-Quote Questionnaire form with entering answer for Question 24 Wrong");
				
		agentCreatePolicy.clickhasCustomizedEquipmentTrue();
		child49.log(LogStatus.INFO, "Agent entering answer for Question 24 Wrong");
						
		agentCreatePolicy.clickAcceptAnswer();
		child49.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 24 Wrong");
		
		String Err_hasCustomizedEquipmentTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child49.log(LogStatus.INFO, "Get the validation error message on the 24th question");
		
		if (Err_hasCustomizedEquipmentTrue.contains("REMARK"))
			{
				child49.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 24 Wrong.");
				child49.log(LogStatus.INFO, Err_hasCustomizedEquipmentTrue);
			}
		else
			{
				child49.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 24 Wrong.");
			}
		
		logger.appendChild(child49);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 25 Blank-------------------
		
		child50=report.startTest("Test Case 48: Check Pre-Quote Questionnaire form with entering answer for Question 25 Blank");
		
		agentCreatePolicy.clickhasCustomizedEquipmentFalse();
		child50.log(LogStatus.INFO, "Agent entering answer for Question 24 Correct");
						
		agentCreatePolicy.clickAcceptAnswer();
		child50.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 25 Blank");
		
		String Err_hasCustomizedEquipmentFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child50.log(LogStatus.INFO, "Get the validation error message on the 25th question");
		
		if (Err_hasCustomizedEquipmentFalse.contains("answer"))
			{
				child50.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 25 Blank.");
				child50.log(LogStatus.INFO, Err_hasCustomizedEquipmentFalse);
			}
		else
			{
				child50.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 25 Blank.");
			}
		
		
		logger.appendChild(child50);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 25 Wrong-------------------
		
		child51=report.startTest("Test Case 51: Check Pre-Quote Questionnaire form with entering answer for Question 25 Wrong");
		
		agentCreatePolicy.clickhasCoownerNonResidentTrue();
		child51.log(LogStatus.INFO, "Agent entering answer for Question 25 Wrong");
						
		agentCreatePolicy.clickAcceptAnswer();
		child51.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 25 Wrong");		
		
		String Err_hasCoownerNonResidentTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child51.log(LogStatus.INFO, "Get the validation error message on the 25th question");
		
		if (Err_hasCoownerNonResidentTrue.contains("REMARK"))
			{
				child51.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 25 Wrong.");
				child51.log(LogStatus.INFO, Err_hasCoownerNonResidentTrue);
			}
		else
			{
				child51.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 25 Wrong.");
			}
		
		logger.appendChild(child51);
		
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 26 Blank-------------------
		
		child52=report.startTest("Test Case 52: Check Pre-Quote Questionnaire form with entering answer for Question 26 Blank");
		
		agentCreatePolicy.clickhasCoownerNonResidentFalse();
		child52.log(LogStatus.INFO, "Agent entering answer for Question 25 Correct");
						
		agentCreatePolicy.clickAcceptAnswer();
		child52.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 26 Blank");
		
		String Err_hasCoownerNonResidentFalse = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child52.log(LogStatus.INFO, "Get the validation error message on the 26th question");
		
		if (Err_hasCoownerNonResidentFalse.contains("answer"))
			{
				child52.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 26 Blank.");
				child52.log(LogStatus.INFO, Err_hasCoownerNonResidentFalse);
			}
		else
			{
				child52.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 26 Blank.");
			}		
		
		logger.appendChild(child52);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 26 Wrong-------------------
		
		child53=report.startTest("Test Case 53: Check Pre-Quote Questionnaire form with entering answer for Question 26 Wrong");
		
		agentCreatePolicy.clickhasCoownerResidentTrue();
		child53.log(LogStatus.INFO, "Agent entering answer for Question 26 Wrong");
						
		agentCreatePolicy.clickAcceptAnswer();
		child53.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 26 Wrong");
		
		String Err_hasCoownerResidentTrue = agentCreatePolicy.getvalidationErrorMessageQuestion();
		child53.log(LogStatus.INFO, "Get the validation error message on the 26th question");
		
		if (Err_hasCoownerResidentTrue.contains("REMARK"))
			{
				child53.log(LogStatus.PASS, "Agent is getting correct validation error message when clicks Accept Answers with entering answer for Question 26 Wrong.");
				child53.log(LogStatus.INFO, Err_hasCoownerResidentTrue);
			}
		else
			{
				child53.log(LogStatus.FAIL, "Agent is not getting correct validation error message when clicks Accept Answers with entering answer for Question 26 Wrong.");
			}
		
		logger.appendChild(child53);
		
		//--------Check Pre-Quote Questionnaire form with entering answer for Question 26 Correct-------------------
		
		child54=report.startTest("Test Case 54: Check Pre-Quote Questionnaire form with entering answer for Question 26 Correct");
		
		agentCreatePolicy.clickhasCoownerResidentFalse();
		child54.log(LogStatus.INFO, "Agent entering answer for Question 26 Correct");
						
		agentCreatePolicy.clickAcceptAnswer();
		child54.log(LogStatus.INFO, "Click on Accept Answers with keeping Question 26 Correct");
		
		child54.log(LogStatus.PASS, "Agent answers all the questions of Pre-Quote Questionnaire form correctly.");
		
		logger.appendChild(child54);
		
		//------------------------------------------Integration Screen----------------------------------------------------------
		//--------Check Integration Screen with all correct inputs-------------------
		
		child55=report.startTest("Test Case 55: Check Integration Screen with all correct inputs");
		
		agentCreatePolicy.clickOrderPos();
		child55.log(LogStatus.INFO, "Agent clicks on OrderPos button successfully.");
		
		agentCreatePolicy.clickviewAll();
		child55.log(LogStatus.INFO, "Agent clicks on viewAll button successfully.");
		
		agentCreatePolicy.clicknextButton();
		child55.log(LogStatus.INFO, "Agent clicks on Next button successfully.");
		
		child55.log(LogStatus.PASS, "Agent gets all the output on integration screen correctly.");
		
		logger.appendChild(child55);
		
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
		//driver.close();
	}
}