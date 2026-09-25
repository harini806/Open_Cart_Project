package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//constructor
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegisterBtn;
	@FindBy(xpath="//a[text()='Login']") //Login link added insteps
	WebElement linkLogin;
	
	//action methods
	public void clickMyAccount()
	{
		lnkMyAccount.click();
		
	}
	public void clickRegisterButton()
	{
		lnkRegisterBtn.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
}
