package com.Pages;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AgentLoginPage {
	
	WebDriver driver;
	String username,password;
    JSONParser parser=new JSONParser();
	
	public AgentLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of agent login option of the top of Homepage
	//
	@FindBy(how=How.ID,using="menu-item-1291")
	WebElement clickagentlogin;
	
	//
	//Function of click on login option of the top of Homepage
	//
	public void clickOnAgentLogin()
	{
		waitForVisibility(clickagentlogin);
		clickagentlogin.click();
	}
	
	//
	//WebElement of user name option of the login page
	//
	@FindBy(how=How.ID,using="UserName")
	WebElement uname;
	
	//
	//Function of entering username on login page
	//
	public void enterUsername(String username)
	{
		waitForVisibility(uname);
		uname.clear();
		uname.sendKeys(username);
	}
	
	//
	//WebElement of user name option of the login page
	//
	@FindBy(how=How.ID,using="Password")
	WebElement pwd;
	
	//
	//Function of entering username on login page
	//
	public void enterPassword(String password)
	{
		waitForVisibility(pwd);
		pwd.clear();
		pwd.sendKeys(password);
	}
	
	//
	//WebElement of Log On button of the login page
	//
	@FindBy(how=How.CLASS_NAME,using="btnSubmit")
	WebElement logOn;
	
	//
	//Function of clicking on Log On button on login page
	//
	public void clickLogOn()
	{
		waitForVisibility(logOn);
		logOn.click();
	}
	
	//
	//Function of Agent Login
	//
	public void agentLogin(String username, String password)
	{
		waitForVisibility(uname);
		uname.sendKeys(username);
		pwd.sendKeys(password);
		logOn.click();
		
	}
	
	//
	//WebElement is for validation error message on login form
	//
	@FindBy(how=How.CLASS_NAME,using="field-validation-error")
	WebElement validationLogin;
	
	//
	//Function for getting validation error message on login form
	//
	public String getValidationUsername()
	{
		return validationLogin.getText();
	}
	
	//
	//WebElement is for main validation error message on login form
	//
	@FindBy(how=How.CLASS_NAME,using="validation-summary-errors")
	WebElement validationMain;
	
	//
	//Function for getting validation error message on login form
	//
	public String getMainValidation()
	{
		return validationMain.getText();
	}
	
	//
	//WebElement to get title of the page
	//
	@FindBy(how=How.TAG_NAME,using="title")
	WebElement titlePage;
	
	//
	//Function to get title of the page
	//
	public String getTitle()
	{
		return titlePage.getText();
	}
	
	
}
