package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(id="email")
	WebElement txtemail;
	
	@FindBy(id="pass")
	WebElement txtpswd;
	
	@FindBy(name="send")
	WebElement btnsignin;
	
	//Action Methods
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String pswd)
	{
		txtpswd.sendKeys(pswd);
	}
	
	public void clickSignIn()
	{
		btnsignin.click();
	}
}
