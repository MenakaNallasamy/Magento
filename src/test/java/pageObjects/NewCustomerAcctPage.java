package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerAcctPage extends BasePage {

	public NewCustomerAcctPage(WebDriver driver) {
		super(driver);
	}

	//Elements
	@FindBy(id="firstname")
	WebElement txtfirstname;

	@FindBy(id="lastname")
	WebElement txtlastname;
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpswd;
	
	@FindBy(name="password_confirmation")
	WebElement txtconfmpswd;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement btncreateacct;
	
	@FindBy(xpath="//div[@class='message-success success message']//div")
	WebElement msgconfirmation;

	//Action methods
	public void setFirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}

	public void setLastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}

	public void setPassword(String pswd)
	{
		txtpswd.sendKeys(pswd);
	}

	public void setConfirmPassword(String confmpswd)
	{
		txtconfmpswd.sendKeys(confmpswd);
	}

	public void clickCreateAcct() 
	{
		btncreateacct.click();
	}
	
	public String getConfirmationMsg() {
		try {
		return(msgconfirmation.getText());//if register is unsuccessful msg will not display it will throw an exception so use try catch
	     }
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}