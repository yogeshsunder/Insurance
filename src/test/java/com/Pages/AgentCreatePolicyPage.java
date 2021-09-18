package com.Pages;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AgentCreatePolicyPage {
	
	WebDriver driver;
	String username,password;
    JSONParser parser=new JSONParser();
	
	public AgentCreatePolicyPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of agency Representative Field on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.ID,using="AgencyRep")
	WebElement agencyRepresentativeField;
	
	//
	//Function of agency Representative Field on Pre-Quote Questionnaire page
	//
	public void enterAgencyRepresentativeField(String representative)
	{
		waitForVisibility(agencyRepresentativeField);
		agencyRepresentativeField.sendKeys(representative);
	}
	
	//
	//WebElement of Accept Answer button on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.CSS,using="#top > form > input.btnSubmit.right")
	WebElement driverFirstNameValidation;
	
	//
	//Function of Accept Answer button on Pre-Quote Questionnaire page
	//
	public void clickAcceptAnswer()
	{
		waitForVisibility(driverFirstNameValidation);
		driverFirstNameValidation.click();
	}
	
	//
	//WebElement of validation error message on questions on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.CLASS_NAME,using="field-validation-error")
	WebElement validationQuestion;
	
	//
	//Function of getting validation error message on questions on Pre-Quote Questionnaire page
	//
	public String getvalidationErrorMessageQuestion()
	{
		waitForVisibility(validationQuestion);
		return validationQuestion.getText();
	}
	
	//
	//WebElement of radio button of Unnacceptable Risk value true i.e. wrong answer for 1st question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasAutoInsuranceCancelled' and @value='True']")
	WebElement unnacceptableRisktrue;
	
	//
	//Function of radio button of Unnacceptable Risk value true i.e. wrong answer for 1st question on Pre-Quote Questionnaire page
	//
	public void clickUnnacceptableRisktrue()
	{
		waitForVisibility(unnacceptableRisktrue);
		unnacceptableRisktrue.click();
	}
	
	//
	//WebElement of radio button of Unnacceptable Risk value false i.e. correct answer for 1st question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasAutoInsuranceCancelled' and @value='False']")
	WebElement unnacceptableRiskFalse;
	
	//
	//Function of radio button of Unnacceptable Risk value false i.e. correct answer for 1st question on Pre-Quote Questionnaire page
	//
	public void clickUnnacceptableRiskFalse()
	{
		waitForVisibility(unnacceptableRiskFalse);
		unnacceptableRiskFalse.click();
	}
	
	//
	//WebElement of radio button of hasLicenseSuspended value true i.e. wrong answer for 2nd question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasLicenseSuspended' and @value='True']")
	WebElement hasLicenseSuspendedTrue;
	
	//
	//Function of radio button of hasLicenseSuspended Risk value true i.e. wrong answer for 2nd question on Pre-Quote Questionnaire page
	//
	public void clickHasLicenseSuspendedTrue()
	{
		waitForVisibility(hasLicenseSuspendedTrue);
		hasLicenseSuspendedTrue.click();
	}
	
	//
	//WebElement of radio button of hasLicenseSuspended value true i.e. correct answer for 2nd question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasLicenseSuspended' and @value='False']")
	WebElement hasLicenseSuspendedFalse;
	
	//
	//Function of radio button of hasLicenseSuspended value true i.e. correct answer for 2nd question on Pre-Quote Questionnaire page
	//
	public void clickhasLicenseSuspendedFalse()
	{
		waitForVisibility(hasLicenseSuspendedFalse);
		hasLicenseSuspendedFalse.click();
	}
	
	//
	//WebElement of radio button of hasDrivingImpairments value true i.e. wrong answer for 3rd question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasDrivingImpairments' and @value='True']")
	WebElement hasDrivingImpairmentsTrue;
	
	//
	//Function of radio button of hasLicenseSuspended Risk value true i.e. wrong answer for 3rd question on Pre-Quote Questionnaire page
	//
	public void clickHasDrivingImpairmentsTrue()
	{
		waitForVisibility(hasDrivingImpairmentsTrue);
		hasDrivingImpairmentsTrue.click();
	}
	
	//
	//WebElement of radio button of hasDrivingImpairments value true i.e. correct answer for 3rd question on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasDrivingImpairments' and @value='False']")
	WebElement hasDrivingImpairmentsFalse;
	
	//
	//Function of radio button of hasLicenseSuspended value true i.e. correct answer for 3rd question on Pre-Quote Questionnaire page
	//
	public void clickHasDrivingImpairmentsFalse()
	{
		waitForVisibility(hasDrivingImpairmentsFalse);
		hasDrivingImpairmentsFalse.click();
	}
	
	//
	//WebElement of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasMadePIPClaim' and @value='True']")
	WebElement hasMadePIPClaimTrue;
	
	//
	//Function of of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	public void clickHasMadePIPClaimTrue()
	{
		waitForVisibility(hasMadePIPClaimTrue);
		hasMadePIPClaimTrue.click();
	}

	//
	//WebElement of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	@FindBy(how=How.ID,using="twoPipClaims")
	WebElement hasMade2PIPClaimTrue;
	
	//
	//Function of of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	public void clickhasMade2PIPClaimTrue()
	{
		waitForVisibility(hasMade2PIPClaimTrue);
		hasMade2PIPClaimTrue.click();
	}
	
	//
	//WebElement of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	@FindBy(how=How.ID,using="onePipClaim")
	WebElement hasMade1PIPClaim;
	
	//
	//Function of of radio button of hasMadePIPClaim value true i.e. for question 4.
	//
	public void clickhasMade1PIPClaim()
	{
		waitForVisibility(hasMade1PIPClaim);
		hasMade1PIPClaim.click();
	}
	
	//
	//WebElement of radio button of clickhas2PlusAF value true i.e. for question 5.
	//
	@FindBy(how=How.ID,using="has2PlusAFs")
	WebElement has2PlusAF;
	
	//
	//Function of of radio button of clickhas2PlusAF value true i.e. for question 5.
	//
	public void clickhas2PlusAF()
	{
		waitForVisibility(has2PlusAF);
		has2PlusAF.click();
	}
	
	//
	//WebElement of radio button of clickhas2PlusAF value true i.e. for question 5.
	//
	@FindBy(how=How.XPATH,using="//input[@id='has2PlusAFs' and @value='False']")
	WebElement has2PlusAFFalse;
	
	//
	//Function of of radio button of clickhas2PlusAF value true i.e. for question 5.
	//
	public void clickhas2PlusAFFalse()
	{
		waitForVisibility(has2PlusAFFalse);
		has2PlusAFFalse.click();
	}
		
	//
	//WebElement of radio button of hasAnyDriverResideLessThanTenMonths value true i.e. for question 6.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasAnyDriverResideLessThanTenMonths' and @value='True']")
	WebElement hasAnyDriverResideLessThanTenMonths;
	
	//
	//Function of of radio button of hasAnyDriverResideLessThanTenMonths value true i.e. for question 6.
	//
	public void clickhasAnyDriverResideLessThanTenMonths()
	{
		waitForVisibility(hasAnyDriverResideLessThanTenMonths);
		hasAnyDriverResideLessThanTenMonths.click();
	}
	
	//
	//WebElement of radio button of hasAnyDriverResideLessThanTenMonths value false i.e. for question 6.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasAnyDriverResideLessThanTenMonths' and @value='False']")
	WebElement hasDriverResideLessThanTenMonths;
	
	//
	//Function of of radio button of hasAnyDriverResideLessThanTenMonths value false i.e. for question 6.
	//
	public void clickhasDriverResideLessThanTenMonths()
	{
		waitForVisibility(hasDriverResideLessThanTenMonths);
		hasDriverResideLessThanTenMonths.click();
	}
	
	//
	//WebElement of radio button of hasAnyDriverResideLessThanTenMonths value True i.e. for question 7.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasGrayMarketVehicle' and @value='True']")
	WebElement hasGrayMarketVehicle;
	
	//
	//Function of of radio button of hasAnyDriverResideLessThanTenMonths value True i.e. for question 7.
	//
	public void clickhasGrayMarketVehicle()
	{
		waitForVisibility(hasGrayMarketVehicle);
		hasGrayMarketVehicle.click();
	}
	
	//
	//WebElement of radio button of hasAnyDriverResideLessThanTenMonths value false i.e. for question 7.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasGrayMarketVehicle' and @value='False']")
	WebElement hasGrayMarketVehicleFalse;
	
	//
	//Function of of radio button of hasAnyDriverResideLessThanTenMonths value false i.e. for question 7.
	//
	public void clickhashasGrayMarketVehicleFalse()
	{
		waitForVisibility(hasGrayMarketVehicleFalse);
		hasGrayMarketVehicleFalse.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value false i.e. for question 8.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasVehicleForBusinessPurpose' and @value='True']")
	WebElement hasVehicleForBusinessPurposeTrue;
	
	//
	//Function of of radio button of hasVehicleForBusinessPurpose value false i.e. for question 8.
	//
	public void clickhasVehicleForBusinessPurposeTrue()
	{
		waitForVisibility(hasVehicleForBusinessPurposeTrue);
		hasVehicleForBusinessPurposeTrue.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value True i.e. for question 8.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasVehicleForBusinessPurpose' and @value='False']")
	WebElement hasVehicleForBusinessPurposeFalse;
	
	//
	//Function of of radio button of hasVehicleForBusinessPurpose value True i.e. for question 8.
	//
	public void clickhasVehicleForBusinessPurposeFalse()
	{
		waitForVisibility(hasVehicleForBusinessPurposeFalse);
		hasVehicleForBusinessPurposeFalse.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value True i.e. for question 9.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberNotDisclosed' and @value='True']")
	WebElement hasHouseholdMemberNotDisclosedTrue;
	
	//
	//Function of of radio button of hasVehicleForBusinessPurpose value false i.e. for question 9.
	//
	public void clickhasHouseholdMemberNotDisclosedTrue()
	{
		waitForVisibility(hasHouseholdMemberNotDisclosedTrue);
		hasHouseholdMemberNotDisclosedTrue.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value false i.e. for question 9.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberNotDisclosed' and @value='False']")
	WebElement hasHouseholdMemberNotDisclosedFalse;
	
	//
	//Function of of radio button of hasVehicleForBusinessPurpose value false i.e. for question 9.
	//
	public void clickhasHouseholdMemberNotDisclosedFalse()
	{
		waitForVisibility(hasHouseholdMemberNotDisclosedFalse);
		hasHouseholdMemberNotDisclosedFalse.click();
	}
	
	//
	//WebElement of radio button of hasOtherHouseholdMemberDriver value True i.e. for question 10.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasOtherHouseholdMemberDriver' and @value='True']")
	WebElement hasOtherHouseholdMemberDriverTrue;
	
	//
	//Function of of radio button of hasOtherHouseholdMemberDriver value True i.e. for question 10.
	//
	public void clickhasOtherHouseholdMemberDriverTrue()
	{
		waitForVisibility(hasOtherHouseholdMemberDriverTrue);
		hasOtherHouseholdMemberDriverTrue.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value False i.e. for question 10.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasOtherHouseholdMemberDriver' and @value='False']")
	WebElement hasOtherHouseholdMemberDriverFalse;
	
	//
	//Function of of radio button of hasOtherHouseholdMemberDriver value False i.e. for question 10.
	//
	public void clickhasOtherHouseholdMemberDriverFalse()
	{
		waitForVisibility(hasOtherHouseholdMemberDriverFalse);
		hasOtherHouseholdMemberDriverFalse.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value False i.e. for question 11.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasVehicleNotSolelyOwned' and @value='False']")
	WebElement hasVehicleNotSolelyOwnedFalse;
	
	//
	//Function of of radio button of hasOtherHouseholdMemberDriver value False i.e. for question 11.
	//
	public void clickhasVehicleNotSolelyOwnedFalse()
	{
		waitForVisibility(hasVehicleNotSolelyOwnedFalse);
		hasVehicleNotSolelyOwnedFalse.click();
	}
	
	//
	//WebElement of radio button of hasVehicleForBusinessPurpose value True i.e. for question 11.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasVehicleNotSolelyOwned' and @value='True']")
	WebElement hasVehicleNotSolelyOwnedTrue;
	
	//
	//Function of of radio button of hasOtherHouseholdMemberDriver value True i.e. for question 11.
	//
	public void clickhasVehicleNotSolelyOwnedTrue()
	{
		waitForVisibility(hasVehicleNotSolelyOwnedTrue);
		hasVehicleNotSolelyOwnedTrue.click();
	}
	
	//
	//WebElement of radio button of hasOtherResidentOrNonResidentDependent value True i.e. for question 12.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasOtherResidentOrNonResidentDependent' and @value='True']")
	WebElement hasOtherResidentOrNonResidentDependent;
	
	//
	//Function of of radio button of hasOtherResidentOrNonResidentDependent value True i.e. for question 12.
	//
	public void clickhasOtherResidentOrNonResidentDependentTrue()
	{
		waitForVisibility(hasOtherResidentOrNonResidentDependent);
		hasOtherResidentOrNonResidentDependent.click();
	}
	
	//
	//WebElement of radio button of hasOtherResidentOrNonResidentDependent False i.e. for question 12.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasOtherResidentOrNonResidentDependent' and @value='False']")
	WebElement hasOtherResidentOrNonResidentDependentFalse;
	
	//
	//Function of of radio button of hasOtherResidentOrNonResidentDependent value False i.e. for question 12.
	//
	public void clickhasOtherResidentOrNonResidentDependentFalse()
	{
		waitForVisibility(hasOtherResidentOrNonResidentDependentFalse);
		hasOtherResidentOrNonResidentDependentFalse.click();
	}
	
	//
	//WebElement of radio button of hasSalvagedVehicle True i.e. for question 13.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasSalvagedVehicle' and @value='True']")
	WebElement hasSalvagedVehicle;
	
	//
	//Function of of radio button of hasSalvagedVehicle value True i.e. for question 13.
	//
	public void clickhasSalvagedVehicle()
	{
		waitForVisibility(hasSalvagedVehicle);
		hasSalvagedVehicle.click();
	}

	//
	//WebElement of radio button of hasSalvagedVehicle False i.e. for question 13.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasSalvagedVehicle' and @value='False']")
	WebElement hasSalvagedVehicleFalse;
	
	//
	//Function of of radio button of hasSalvagedVehicle value False i.e. for question 13.
	//
	public void clickhasSalvagedVehicleFalse()
	{
		waitForVisibility(hasSalvagedVehicleFalse);
		hasSalvagedVehicleFalse.click();
	}
	
	//
	//WebElement of radio button of hasVehicleNotGaraged False i.e. for question 14.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasVehicleNotGaraged' and @value='False']")
	WebElement hasVehicleNotGaragedFalse;
	
	//
	//Function of of radio button of hasVehicleNotGaraged value False i.e. for question 14.
	//
	public void clickhasVehicleNotGaragedFalse()
	{
		waitForVisibility(hasVehicleNotGaragedFalse);
		hasVehicleNotGaragedFalse.click();
	}
	
	//
	//WebElement of radio button of hasResidence10monthAndGarageSame False i.e. for question 15.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasResidence10monthAndGarageSame' and @value='False']")
	WebElement hasResidence10monthAndGarageSame;
	
	//
	//Function of of radio button of hasResidence10monthAndGarageSame value False i.e. for question 15.
	//
	public void clickhasResidence10monthAndGarageSameFalse()
	{
		waitForVisibility(hasResidence10monthAndGarageSame);
		hasResidence10monthAndGarageSame.click();
	}
	
	//
	//WebElement of radio button of hasResidence10monthAndGarageSame True i.e. for question 15.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasResidence10monthAndGarageSame' and @value='True']")
	WebElement hasResidence10monthAndGarageSameTrue;
	
	//
	//Function of of radio button of hasResidence10monthAndGarageSame value True i.e. for question 15.
	//
	public void clickhasResidence10monthAndGarageSameTrue()
	{
		waitForVisibility(hasResidence10monthAndGarageSameTrue);
		hasResidence10monthAndGarageSameTrue.click();
	}
	
	//
	//WebElement of radio button of hasReportedBusinessUse False i.e. for question 16.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasReportedBusinessUse' and @value='False']")
	WebElement hasReportedBusinessUseFalse;
	
	//
	//Function of of radio button of hasReportedBusinessUse value False i.e. for question 16.
	//
	public void clickhasReportedBusinessUseFalse()
	{
		waitForVisibility(hasReportedBusinessUseFalse);
		hasReportedBusinessUseFalse.click();
	}
	
	//
	//WebElement of radio button of hasReportedBusinessUse True i.e. for question 16.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasReportedBusinessUse' and @value='True']")
	WebElement hasReportedBusinessUseTrue;
	
	//
	//Function of of radio button of hasReportedBusinessUse value True i.e. for question 16.
	//
	public void clickhasReportedBusinessUseTrue()
	{
		waitForVisibility(hasReportedBusinessUseTrue);
		hasReportedBusinessUseTrue.click();
	}
	
	//
	//WebElement of radio button of hasDisclosedRidesharing False i.e. for question 17.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasDisclosedRidesharing' and @value='False']")
	WebElement hasDisclosedRidesharingFalse;
	
	//
	//Function of of radio button of hasDisclosedRidesharing value False i.e. for question 17.
	//
	public void clickhasDisclosedRidesharingFalse()
	{
		waitForVisibility(hasDisclosedRidesharingFalse);
		hasDisclosedRidesharingFalse.click();
	}
	
	//
	//WebElement of radio button of hasDisclosedRidesharing True i.e. for question 17.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasDisclosedRidesharing' and @value='True']")
	WebElement hasDisclosedRidesharingTrue;
	
	//
	//Function of of radio button of hasDisclosedRidesharing value True i.e. for question 17.
	//
	public void clickhasDisclosedRidesharingTrue()
	{
		waitForVisibility(hasDisclosedRidesharingTrue);
		hasDisclosedRidesharingTrue.click();
	}
	
	//
	//WebElement of radio button of hasWorkOutsideFlorida True i.e. for question 18.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasWorkOutsideFlorida' and @value='True']")
	WebElement hasWorkOutsideFloridaTrue;
	
	//
	//Function of of radio button of hasWorkOutsideFlorida value True i.e. for question 18.
	//
	public void clickhasWorkOutsideFloridaTrue()
	{
		waitForVisibility(hasWorkOutsideFloridaTrue);
		hasWorkOutsideFloridaTrue.click();
	}
	
	//
	//WebElement of radio button of hasCriminalActivity True i.e. for question 19.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCriminalActivity' and @value='True']")
	WebElement hasCriminalActivityTrue;
	
	//
	//Function of of radio button of hasCriminalActivity value True i.e. for question 19.
	//
	public void clickhasCriminalActivityTrue()
	{
		waitForVisibility(hasCriminalActivityTrue);
		hasCriminalActivityTrue.click();
	}
	
	//
	//WebElement of radio button of hasCriminalActivity False i.e. for question 19.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCriminalActivity' and @value='False']")
	WebElement hasCriminalActivityFalse;
	
	//
	//Function of of radio button of hasCriminalActivity value False i.e. for question 19.
	//
	public void clickhasCriminalActivityFalse()
	{
		waitForVisibility(hasCriminalActivityFalse);
		hasCriminalActivityFalse.click();
	}
	
	//
	//WebElement of radio button of hasHouseholdMemberWithLawsuit True i.e. for question 20.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberWithLawsuit' and @value='True']")
	WebElement hasHouseholdMemberWithLawsuitTrue;
	
	//
	//Function of of radio button of hasHouseholdMemberWithLawsuit value True i.e. for question 20.
	//
	public void clickhasHouseholdMemberWithLawsuitTrue()
	{
		waitForVisibility(hasHouseholdMemberWithLawsuitTrue);
		hasHouseholdMemberWithLawsuitTrue.click();
	}	
	
	//
	//WebElement of radio button of hasHouseholdMemberWithLawsuit False i.e. for question 20.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberWithLawsuit' and @value='False']")
	WebElement hasHouseholdMemberWithLawsuitFalse;
	
	//
	//Function of of radio button of hasHouseholdMemberWithLawsuitFalse value True i.e. for question 20.
	//
	public void clickhasHouseholdMemberWithLawsuitFalse()
	{
		waitForVisibility(hasHouseholdMemberWithLawsuitFalse);
		hasHouseholdMemberWithLawsuitFalse.click();
	}
	
	//
	//WebElement of radio button of hasHouseholdMemberWithLoanDefaults True i.e. for question 21.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberWithLoanDefaults' and @value='True']")
	WebElement hasHouseholdMemberWithLoanDefaultsTrue;
	
	//
	//Function of of radio button of hasHouseholdMemberWithLoanDefaults value True i.e. for question 21.
	//
	public void clickhasHouseholdMemberWithLoanDefaultsTrue()
	{
		waitForVisibility(hasHouseholdMemberWithLoanDefaultsTrue);
		hasHouseholdMemberWithLoanDefaultsTrue.click();
	}
	
	//
	//WebElement of radio button of hasHouseholdMemberWithLoanDefaults False i.e. for question 21.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasHouseholdMemberWithLoanDefaults' and @value='False']")
	WebElement hasHouseholdMemberWithLoanDefaultsFalse;
	
	//
	//Function of of radio button of hasHouseholdMemberWithLoanDefaults value False i.e. for question 21.
	//
	public void clickhasHouseholdMemberWithLoanDefaultsFalse()
	{
		waitForVisibility(hasHouseholdMemberWithLoanDefaultsFalse);
		hasHouseholdMemberWithLoanDefaultsFalse.click();
	}
	
	//
	//WebElement of radio button of hasFailedToListAllVehicles True i.e. for question 22.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasFailedToListAllVehicles' and @value='True']")
	WebElement hasFailedToListAllVehiclesTrue;
	
	//
	//Function of of radio button of hasFailedToListAllVehicles value True i.e. for question 22.
	//
	public void clickhasFailedToListAllVehiclesTrue()
	{
		waitForVisibility(hasFailedToListAllVehiclesTrue);
		hasFailedToListAllVehiclesTrue.click();
	}
	
	//
	//WebElement of radio button of hasFailedToListAllVehicles False i.e. for question 22.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasFailedToListAllVehicles' and @value='False']")
	WebElement hasFailedToListAllVehiclesFalse;
	
	//
	//Function of of radio button of hasFailedToListAllVehicles value False i.e. for question 22.
	//
	public void clickhasFailedToListAllVehiclesFalse()
	{
		waitForVisibility(hasFailedToListAllVehiclesFalse);
		hasFailedToListAllVehiclesFalse.click();
	}
	
	//
	//WebElement of radio button of hasExistingDamage True i.e. for question 23.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasExistingDamage' and @value='True']")
	WebElement hasExistingDamageTrue;
	
	//
	//Function of of radio button of hasExistingDamage value True i.e. for question 23.
	//
	public void clickhasExistingDamageTrue()
	{
		waitForVisibility(hasExistingDamageTrue);
		hasExistingDamageTrue.click();
	}
	
	//
	//WebElement of radio button of hasExistingDamage False i.e. for question 23.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasExistingDamage' and @value='False']")
	WebElement hasExistingDamageFalse;
	
	//
	//Function of of radio button of hasExistingDamage value False i.e. for question 23.
	//
	public void clickhasExistingDamageFalse()
	{
		waitForVisibility(hasExistingDamageFalse);
		hasExistingDamageFalse.click();
	}
	
	//
	//WebElement of radio button of hasCustomizedEquipment True i.e. for question 24.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCustomizedEquipment' and @value='True']")
	WebElement hasCustomizedEquipmentTrue;
	
	//
	//Function of of radio button of hasCustomizedEquipment value True i.e. for question 24.
	//
	public void clickhasCustomizedEquipmentTrue()
	{
		waitForVisibility(hasCustomizedEquipmentTrue);
		hasCustomizedEquipmentTrue.click();
	}
	
	//
	//WebElement of radio button of hasCustomizedEquipment False i.e. for question 24.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCustomizedEquipment' and @value='False']")
	WebElement hasCustomizedEquipmentFalse;
	
	//
	//Function of of radio button of hasCustomizedEquipment value False i.e. for question 24.
	//
	public void clickhasCustomizedEquipmentFalse()
	{
		waitForVisibility(hasCustomizedEquipmentFalse);
		hasCustomizedEquipmentFalse.click();
	}
	
	//
	//WebElement of radio button of hasCoownerNonResident True i.e. for question 25.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCoownerNonResident' and @value='True']")
	WebElement hasCoownerNonResidentTrue;
	
	//
	//Function of of radio button of hasCoownerNonResident value True i.e. for question 25.
	//
	public void clickhasCoownerNonResidentTrue()
	{
		waitForVisibility(hasCoownerNonResidentTrue);
		hasCoownerNonResidentTrue.click();
	}
	
	//
	//WebElement of radio button of hasCoownerNonResident False i.e. for question 25.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCoownerNonResident' and @value='False']")
	WebElement hasCoownerNonResidentFalse;
	
	//
	//Function of of radio button of hasCoownerNonResident value False i.e. for question 25.
	//
	public void clickhasCoownerNonResidentFalse()
	{
		waitForVisibility(hasCoownerNonResidentFalse);
		hasCoownerNonResidentFalse.click();
	}
	
	//
	//WebElement of radio button of hasCoownerResident True i.e. for question 26.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCoownerResident' and @value='True']")
	WebElement hasCoownerResidentTrue;
	
	//
	//Function of of radio button of hasCoownerResident value True i.e. for question 26.
	//
	public void clickhasCoownerResidentTrue()
	{
		waitForVisibility(hasCoownerResidentTrue);
		hasCoownerResidentTrue.click();
	}
	
	//
	//WebElement of radio button of hasCoownerResident False i.e. for question 26.
	//
	@FindBy(how=How.XPATH,using="//input[@id='hasCoownerResident' and @value='False']")
	WebElement hasCoownerResidentFalse;
	
	//
	//Function of of radio button of hasCoownerResident value False i.e. for question 26.
	//
	public void clickhasCoownerResidentFalse()
	{
		waitForVisibility(hasCoownerResidentFalse);
		hasCoownerResidentFalse.click();
	}
	
	//---------------------------------Integration Screen-----------------------------------------------
	
	//
	//WebElement of orderPos button.
	//
	@FindBy(how=How.ID,using="orderButton")
	WebElement orderPos;
	
	//
	//Function of clicking orderPos button.
	//
	public void clickOrderPos()
	{
		waitForVisibility(orderPos);
		orderPos.click();
	}
	
	//
	//WebElement of ViewAll button.
	//
	@FindBy(how=How.ID,using="orderButton")
	WebElement viewAll;
	
	//
	//Function of clicking viewAll button.
	//
	public void clickviewAll() throws InterruptedException
	{
		waitForVisibility(viewAll);
		Thread.sleep(2000);
		viewAll.click();
	}
	
	//
	//WebElement of nextButton button.
	//
	@FindBy(how=How.ID,using="btnNext")
	WebElement nextButton;
	
	//
	//Function of clicking nextButton button.
	//
	public void clicknextButton() throws InterruptedException
	{
		waitForVisibility(nextButton);
		Thread.sleep(2000);
		nextButton.click();
	}

}
