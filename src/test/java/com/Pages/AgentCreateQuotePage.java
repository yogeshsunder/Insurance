package com.Pages;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AgentCreateQuotePage {
	
	WebDriver driver;
	String username,password;
    JSONParser parser=new JSONParser();
	
	public AgentCreateQuotePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Request a Quote link on the logged in page
	//
	@FindBy(how=How.ID,using="RequestQuote")
	WebElement requestQuote;
	
	//
	//Function of click on Request a Quote link on the logged in page
	//
	public void clickRequestaQuote()
	{
		waitForVisibility(requestQuote);
		requestQuote.click();
	}
	
	//--------------------------------Entering Insured Information------------------------------------------------
	
	//
	//WebElement of first insured name input field on Create quote page
	//
	@FindBy(how=How.ID,using="FirstName1")
	WebElement firstinsuredName;
	
	//
	//Function of entering first insured name input field on Create quote page
	//
	public void enterFirstInsuredName(String firstname)
	{
		waitForVisibility(firstinsuredName);
		firstinsuredName.clear();
		firstinsuredName.sendKeys(firstname);
	}

	//
	//WebElement of last insured name input field on Create quote page
	//
	@FindBy(how=How.ID,using="LastName1")
	WebElement lastinsuredName;
	
	//
	//Function of entering last insured name input field on Create quote page
	//
	public void enterLastInsuredName(String lastname)
	{
		waitForVisibility(lastinsuredName);
		lastinsuredName.clear();
		lastinsuredName.sendKeys(lastname);
	}
	
	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="HomePhone")
	WebElement homePhone;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void enterHomePhone(String homephone)
	{
		waitForVisibility(homePhone);
		homePhone.clear();
		homePhone.sendKeys(homephone);
	}
	
	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="EmailAddress")
	WebElement emailAddress;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void enterEmailAddress(String emailaddress)
	{
		waitForVisibility(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys(emailaddress);
	}	
	
	//
	//WebElement of validation error of first insured name of insured information form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='FirstName1']")
	WebElement firstInsuredValidationEr;
	
	//
	//Function of getting validation error of first insured name of insured information form
	//
	public String getfirstInsuredValidationError()
	{
		waitForVisibility(firstInsuredValidationEr);
		return firstInsuredValidationEr.getText();
	}
	
	
	//
	//WebElement of validation error of last insured name of insured information form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='LastName1']")
	WebElement lastInsuredValidationEr;
	
	//
	//Function of getting validation error of first insured name of insured information form
	//
	public String getLastInsuredValidationError()
	{
		waitForVisibility(lastInsuredValidationEr);
		return lastInsuredValidationEr.getText();
	}
	
	//
	//WebElement of validation error of last insured name of insured information form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='HomePhone']")
	WebElement homePhoneValidationEr;
	
	//
	//Function of getting validation error of first insured name of insured information form
	//
	public String getHomePhoneValidationError()
	{
		waitForVisibility(homePhoneValidationEr);
		return homePhoneValidationEr.getText();
	}
	
	//
	//WebElement of validation error of last insured name of insured information form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='EmailAddress']")
	WebElement primaryEmailValidationEr;
	
	//
	//Function of getting validation error of first insured name of insured information form
	//
	public String getPrimaryEmailValidationError()
	{
		waitForVisibility(primaryEmailValidationEr);
		return primaryEmailValidationEr.getText();
	}
	
	//-------------------------------Insured Address----------------------------------------------------
	
	//
	//WebElement of Garage Street Address input field on Create quote page
	//
	@FindBy(how=How.ID,using="GarageStreetAddress")
	WebElement garageStreetAddress;
	
	//
	//Function of entering Garage Street Address input field on Create quote page
	//
	public void enterGarageStreetAddress(String garagestreetaddress) throws InterruptedException
	{
		waitForVisibility(garageStreetAddress);
		garageStreetAddress.clear();
		garageStreetAddress.sendKeys(garagestreetaddress);
		Thread.sleep(1000);
	}
	
	//
	//WebElement of Zip Code input field on Create quote page
	//
	@FindBy(how=How.ID,using="GarageZIPCode")
	WebElement garageZIPCode;
	
	//
	//Function of entering Zip Code input field on Create quote page
	//
	public void enterGarageZIPCode(String garageZIPcode)
	{
		waitForVisibility(garageZIPCode);
		garageZIPCode.clear();
		garageZIPCode.sendKeys(garageZIPcode);
	}
	
	//
	//WebElement of validation error of Street Address field of Address form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='GarageStreetAddress']")
	WebElement streetAddressValidationEr;
	
	//
	//Function of getting validation error of Street Address field of Address form
	//
	public String getfirstInsuredStreetAddressValidationError()
	{
		waitForVisibility(streetAddressValidationEr);
		return streetAddressValidationEr.getText();
	}
	
	//
	//WebElement of validation error of ZIP Code field of Address form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='GarageZIPCode']")
	WebElement zipCodeValidationEr;
	
	//
	//Function of getting validation error of ZIP Code field of Address form
	//
	public String getZipCodeValidationError()
	{
		waitForVisibility(zipCodeValidationEr);
		return zipCodeValidationEr.getText();
	}
	
	
	//-------------------------------Add Driver---------------------------------------------------------
	
	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="addDriver")
	WebElement adddriver;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void clickAddDriver() throws InterruptedException
	{
		waitForVisibility(adddriver);
		adddriver.click();
		Thread.sleep(1000);
	}
	
	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="FirstName")
	WebElement firstDriverName;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void enterFirstDriverName(String firstdrivername)
	{
		waitForVisibility(firstDriverName);
		firstDriverName.clear();
		firstDriverName.sendKeys(firstdrivername);
	}
	
	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="LastName")
	WebElement lastDriverName;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void enterLastDriverName(String lastdrivername)
	{
		waitForVisibility(lastDriverName);
		lastDriverName.clear();
		lastDriverName.sendKeys(lastdrivername);
	}

	//
	//WebElement of HomePhone input field on Create quote page
	//
	@FindBy(how=How.ID,using="DateOfBirth")
	WebElement dateOfBirth;
	
	//
	//Function of entering HomePhone input field on Create quote page
	//
	public void enterDateOfBirthDriver(String dateOfbirth)
	{
		waitForVisibility(dateOfBirth);
		dateOfBirth.sendKeys(dateOfbirth);
	}
	
	//
	//WebElement for Select Gender in Add Driver
	//
	@FindBy(how=How.ID,using="Gender")
	WebElement clickGender;
	
	//
	//Function to Select Gender for Driver in Add Driver
	//
	public void selectGenderforDriver()
	{
		Select fruits = new Select(driver.findElement(By.id("Gender")));
		fruits.selectByVisibleText("MALE");
	}
	
	//
	//WebElement for License Number input field in Add Driver
	//
	@FindBy(how=How.ID,using="DriversLicenseNumber")
	WebElement driversLicenseNumber;
	
	//
	//Function to enter License Number for Driver in Add Driver
	//
	public void enterLicenseNumberforDriver(String driverslicenseNumber)
	{
		waitForVisibility(driversLicenseNumber);
		driversLicenseNumber.sendKeys(driverslicenseNumber);
	}
	
	//
	//WebElement for Employer Name input field in Add Driver
	//
	@FindBy(how=How.ID,using="EmployerName")
	WebElement employerName;
	
	//
	//Function to enter Employer Name for Driver in Add Driver
	//
	public void enterEmployerNameforDriver(String employername)
	{
		waitForVisibility(employerName);
		employerName.sendKeys(employername);
	}
	
	//
	//WebElement for Employer Name input field in Add Driver
	//
	@FindBy(how=How.ID,using="Occupation")
	WebElement occupation;
	
	//
	//Function to enter Employer Name for Driver in Add Driver
	//
	public void enterOccupationforDriver(String employeoccupation)
	{
		waitForVisibility(occupation);
		occupation.sendKeys(employeoccupation);
	}
	
	//
	//WebElement for Add Driver button in Add Driver
	//
	@FindBy(how=How.ID,using="btnAddDriver")
	WebElement addDriver;
	
	//
	//Function to click on Add Driver button in Add Driver
	//
	public void clickSaveDriverButton()
	{
		waitForVisibility(addDriver);
		addDriver.click();
	}
	
	//
	//WebElement of validation error of first name in add driver form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='FirstName']")
	WebElement driverFirstNameValidation;
	
	//
	//Function of getting validation error of first name in add driver form
	//
	public String getDriverFirstNameValidationError()
	{
		waitForVisibility(driverFirstNameValidation);
		return driverFirstNameValidation.getText();
	}
	
	//
	//WebElement of validation error of last name in add driver form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='LastName']")
	WebElement driverLastNameValidation;
	
	//
	//Function of getting validation error of first name in add driver form
	//
	public String getDriverLastNameValidationError()
	{
		waitForVisibility(driverLastNameValidation);
		return driverLastNameValidation.getText();
	}
	
	//
	//WebElement of validation error of DOB in add driver form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='DateOfBirth']")
	WebElement driverDOBValidation;
	
	//
	//Function of getting validation error of first name in add driver form
	//
	public String getDriverDOBValidationError()
	{
		waitForVisibility(driverDOBValidation);
		return driverDOBValidation.getText();
	}
	
	//
	//WebElement of validation error of Gender missing on add driver on create quote page
	//
	@FindBy(how=How.CLASS_NAME,using="field-validation-error")
	WebElement quotePageValidation;
	
	//
	//Function of getting validation error of Gender missing on add driver on create quote page
	//
	public String getQuotePageValidationError()
	{
		waitForVisibility(quotePageValidation);
		return quotePageValidation.getText();
	}
	
	//
	//WebElement of validation error of License Number of create quote page
	//
	@FindBy(how=How.CSS,using="#top > div.validation-summary-errors.error")	
	WebElement quotePageLicenseNumberValidation;
	
	//
	//Function of getting validation error of License Number of create quote page
	//
	public String getQuotePageLicenseNumberValidationError()
	{
		waitForVisibility(quotePageLicenseNumberValidation);
		return quotePageLicenseNumberValidation.getText();
	}
	
	//
	//WebElement of Edit Driver on Create quote page
	//
	@FindBy(how=How.ID,using="editDriver")
	WebElement editDriver;
	
	//
	//Function of clicking Edit Driver on Create quote page
	//
	public void clickEditDriver() throws InterruptedException
	{
		waitForVisibility(editDriver);
		editDriver.click();
		Thread.sleep(5000);
	}
	
	
	//-------------------------------Add Vehicle---------------------------------------------------------
	//
	//WebElement for Add Vehicle button in create quote page
	//
	@FindBy(how=How.LINK_TEXT,using="Add Vehicle")
	WebElement addVehicle;
	
	//
	//Function to click on Add Vehicle button in create quote page
	//
	public void clickAddVehicleButton()
	{
		waitForVisibility(addVehicle);
		addVehicle.click();
	}
	
	//
	//WebElement for entering year of manufacturing of vehicle on add Vehicle page
	//
	@FindBy(how=How.ID,using="Year")
	WebElement year;
	
	//
	//Function to enter year of manufacturing of vehicle on add Vehicle page
	//
	public void enterVehicleYear(String enterYear)
	{
		waitForVisibility(year);
		year.sendKeys(enterYear);
	}
	
	//
	//WebElement for entering VIN of vehicle on add Vehicle page
	//
	@FindBy(how=How.ID,using="VIN")
	WebElement vIN;
	
	//
	//Function to enter VIN of vehicle on add Vehicle page
	//
	public void enterVehicleVIN(String enterVIN)
	{
		waitForVisibility(vIN);
		vIN.sendKeys(enterVIN);
	}
	
	//
	//WebElement for Save Vehicle button on add Vehicle page
	//
	@FindBy(how=How.ID,using="btnAddVehicle")
	WebElement btnAddvehicle;
	
	//
	//Function to enter VIN of vehicle on add Vehicle page
	//
	public void clickSaveVehicle()
	{
		waitForVisibility(btnAddvehicle);
		btnAddvehicle.click();
	}
	
	//
	//WebElement for Comp Deductible drop down on add Vehicle page
	//
	@FindBy(how=How.ID,using="ComprehensiveDeductible")
	WebElement compDed;
	
	//
	//Function to select Comp Deductible from drop down on add Vehicle pag
	//
	public void selectCompDed()
	{
		Select fruits = new Select(driver.findElement(By.id("ComprehensiveDeductible")));
		fruits.selectByVisibleText("500");
	}
	
	//
	//WebElement for Comp Deductible drop down on add Vehicle page
	//
	@FindBy(how=How.ID,using="btnContinueQuote")
	WebElement btncontinueQuote;
	
	//
	//Function to select Comp Deductible from drop down on add Vehicle pag
	//
	public void clickContinueQuoteButton()
	{
		waitForVisibility(btncontinueQuote);
		btncontinueQuote.click();
	}
	
	//
	//WebElement of validation error of VIN in add Vehicle form
	//
	@FindBy(how=How.XPATH,using="//span[@class='field-validation-error' and @data-valmsg-for='VIN']")
	WebElement vehicleVINValidation;
	
	//
	//Function of getting validation error of first name in add driver form
	//
	public String getVehicleVINValidationError()
	{
		waitForVisibility(vehicleVINValidation);
		return vehicleVINValidation.getText();
	}
	
	//
	//WebElement of validation error of Physical Damage coverage of Add Vehicle form
	//
	@FindBy(how=How.CSS,using="#top > form > div.validation-summary-errors.error")	
	WebElement physicalDamageCoverageValidation;
	
	//
	//Function of getting validation error of Physical Damage coverage of Add Vehicle form
	//
	public String getPhysicalDamageCoverageValidationError()
	{
		waitForVisibility(physicalDamageCoverageValidation);
		return physicalDamageCoverageValidation.getText();
	}
	
	//--------------------------------Pre-Quote Questionnaire----------------------------------------
	//
	//WebElement for question has Auto Insurance Cancelled on Pre-Quote Questionnaire page
	//
	@FindBy(how=How.ID,using="hasAutoInsuranceCancelled")
	WebElement hasautoInsuranceCancelled;
	
	//
	//Function to click question has Auto Insurance Cancelled on Pre-Quote Questionnaire page
	//
	public void clickHasAutoInsuranceCancelledQuestion()
	{
		waitForVisibility(hasautoInsuranceCancelled);
		hasautoInsuranceCancelled.click();
	}	
}