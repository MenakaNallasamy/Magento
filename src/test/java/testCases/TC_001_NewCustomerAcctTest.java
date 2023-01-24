package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.NewCustomerAcctPage;
import testBase.BaseClass;

public class TC_001_NewCustomerAcctTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void Test_NewCustomer_Acct()
	{
		log.info("*** Starting  TC_001_NewCustomerAcctTest ****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickCreateAcct();
		log.info("Clicked on Create an Account link");
		
		NewCustomerAcctPage cacct=new NewCustomerAcctPage(driver);
		log.info("Providing Customer Details");
		cacct.setFirstname(randomAlphabet());
		
		cacct.setLastname(randomAlphabet());
		
		cacct.setEmail(randomAlphabet()+"@gmail.com");
	
		String password=randomAlphaNumeric();//if v cal  this method directly it will generate different pswd in both fields
		cacct.setPassword(password);
		cacct.setConfirmPassword(password);
		
		cacct.clickCreateAcct();
		log.info("Clicked on create an Account Button");
		
		log.info("Successfully Account created");
		String confmmsg=cacct.getConfirmationMsg();
		
		log.info("Validating expected message");
		Assert.assertEquals(confmmsg,"Thank you for registering with Fake Online Clothing Store.","Test Failed");
		
		} catch(Exception e) {
			
			log.error("Test Failed");
			Assert.fail();
		}
		log.info("**** Completed  TC_001_NewCustomerAcctTest **** ");
	}
	

}
