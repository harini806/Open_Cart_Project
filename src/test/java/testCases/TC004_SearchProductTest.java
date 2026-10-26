package testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test(groups="master")
   public void productFouond() throws IOException
 
	{
		
	    logger.info("***** starting TC_004_SearchProductTest *****");
	    
	    try {
	    HomePage hp = new HomePage(driver);
	    hp.search(p.getProperty("searchProductName"));
	    hp.clicksearch();
	    
	    SearchPage sp= new SearchPage(driver);
	    String r=sp.getprodcompare();
	    if(r.equalsIgnoreCase(p.getProperty("searchProductName")))
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Product found!");
	    	sp.backhome();
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    	captureScreen("SearchProduct failed");
	    }
	    }  
	    catch(Exception e)
		{
			Assert.fail();
		}
		
   }
	
	    
	    
   }
