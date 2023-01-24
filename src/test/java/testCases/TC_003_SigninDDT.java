package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_SigninDDT extends BaseClass {

	@Test(dataProvider="SigninData",dataProviderClass=DataProviders.class)//v specify exact name given in dataprovider
	public void test_SigninDDT(String email,String password,String exp)//pass 3 paramtrs to get data frm xlsheet
	{
		log.info("*** Starting  TC_003_SignInDDT****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		log.info("Clicked on sigin link");
		
		SignInPage sp=new SignInPage(driver);
		log.info("Providing signin details");
		sp.setEmail(email);
		sp.setPassword(password);
		sp.clickSignIn();
		
		MyAccountPage ap=new MyAccountPage(driver);
		
		boolean trgtpage=ap.isMyAccountPageExists();		
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(trgtpage==true)
			{
				ap.clickDrpMyAcct();//again click dropdown from myacct page to view signout link
				ap.clickSignout();//if it is signin must signout
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				//Assert.fail();
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(trgtpage==false)
			{
				ap.clickDrpMyAcct();//again click dropdown from myacct page to view signout link
				ap.clickSignout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		log.info("**** Completed TC_003__SignInTest ****");
	}
}
