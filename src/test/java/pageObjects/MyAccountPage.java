package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//h1[@class='page-title']")
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	WebElement drpmyacct;
	
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement lnksignout;
	
	//Action methods
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed()); //if it not avalable throw an exception
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickDrpMyAcct()
	{
		drpmyacct.click();
	}
	
	public void clickSignout()
	{
		lnksignout.click();
	}
}
