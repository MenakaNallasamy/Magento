package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC_002_SignInTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void Test_Signin()
	{
		log.info("*** Starting  TC_002_SignIn ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		log.info("Clicked on sigin link");
		
		SignInPage sp=new SignInPage(driver);
		log.info("Providing sign in details");
		sp.setEmail(rb.getString("email"));
		sp.setPassword(rb.getString("password"));
		sp.clickSignIn();
		
		MyAccountPage ap=new MyAccountPage(driver);
		log.info("Validating MyAccount");
		Assert.assertEquals(ap.isMyAccountPageExists(),true);		
		}
		catch(Exception e) {
			Assert.fail();
		}
		log.info("*** Completed TC_002_SignInTest ****");
	}
}
