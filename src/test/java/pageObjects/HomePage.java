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
	@FindBy(xpath="//input[@class='form-control input-lg']")
	WebElement searchbox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchbutton;
	
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
	public void search(String product)
	{
		searchbox.sendKeys(product);
	}
	public void clicksearch()
	{
		searchbutton.click();
	}
	
}
