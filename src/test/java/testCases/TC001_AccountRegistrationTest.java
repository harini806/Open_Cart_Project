package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


@Test(groups={"Regression","Master"})
void Verify_Account_Registration()
{ 
	//On homepage ,it clicks on myaccount
	//and click on Register
	
	logger.info("*********** Starting TC001_AccountRegistrationTest *****");
	
	try {
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	
	logger.info("***** Clicked on MyAccount Link *****");

	hp.clickRegisterButton();
	
	logger.info("***** Clicked on Register Link *****");


	AccountRegistrationPage arp= new AccountRegistrationPage(driver);
	
	logger.info("***** Providing customer details *****"); //Log4j2 code

	arp.setfirstname(randomString().toUpperCase());
	arp.setlastname(randomString().toUpperCase());
	arp.setemailid(randomString()+"@gmail.com");
	arp.settelnumber(randomNumber());
	
	String password=randompassword();
	
	arp.setpassword(password);
	arp.setconfirmpassword(password);
	
	arp.clickchekbox();
	arp.clickcontinue();
	
	logger.info("***** Validating expected message *****");
	
	
	//String confmsg=arp.getConfirmationMsg();

//	SoftAssert sa = new SoftAssert();
	//sa.assertEquals(confmsg,"Your Account Has Been Created!");
//	logger.error("Test failed..");
	//logger.debug("Debug logs..");
	//Assert.assertTrue(false);
//	sa.assertAll();
String confmsg=arp.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
	else
	{
		logger.error("Test failed..");
		logger.debug("Debug logs..");
		Assert.assertTrue(false);
	}
	
}
	
	catch(Exception e)
	{
		
		Assert.fail();
	}
	
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	

}



}
