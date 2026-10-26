package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	
	//Constructor
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//a[normalize-space()='iPhone']") WebElement iphone;
	@FindBy(xpath="//ul[@class='breadcrumb']//li[1]") WebElement backhome;
	
	//Action methods

	public String getprodcompare()
	 {
		 try
		 {
			 return(iphone.getText());
		 }
		 catch(Exception e)
		 {
			 return(e.getMessage());
		 }
	 }
	public void backhome()
	{
		backhome.click();
	}
}
