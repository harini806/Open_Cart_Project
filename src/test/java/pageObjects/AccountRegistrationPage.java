package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

//constructor
	
	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

//locators
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkboxbtn;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@id='content']//h1") WebElement msgConfirmation;

//action methods
 public void setfirstname(String firstname)
 {
	 txtFirstname.sendKeys(firstname);
 }
 public void setlastname(String lastname)
 {
	 txtLastname.sendKeys(lastname);
 }
 public void setemailid(String email)
 {
	 txtEmail.sendKeys(email);
 }
 public void settelnumber(String telno)
 {
	 txtTelephone.sendKeys(telno);
 }
 public void setpassword(String pwd)
 {
	 txtPassword.sendKeys(pwd);
 }
 public void setconfirmpassword(String pwd)
 {
	 txtConPassword.sendKeys(pwd); 
 }
 public void clickchekbox()
 {
	chkboxbtn.click();
 }
 public void clickcontinue()
 {
	 btnContinue.click();
 }
 
 //This is not a validation poin
 //and as we know we dont write any validation code in 
 //page object class
 public String getConfirmationMsg()
 {
	 try
	 {
		 return(msgConfirmation.getText());
	 }
	 catch(Exception e)
	 {
		 return(e.getMessage());
	 }
 }
 
}
