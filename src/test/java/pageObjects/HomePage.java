package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	 public HomePage(WebDriver driver) 
	 {
		super(driver);//super-keyword can invoke parent class of homepage
	 }
	 
	 //Elements
	 @FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	 WebElement lnkcreateacct;
	
	 @FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	 WebElement lnksignin;
	 
	 
	 //Action methods
	 public void clickCreateAcct()
	 {
		 lnkcreateacct.click();
	 }
	 
	 public void clickSignIn()
	 {
		 lnksignin.click();
	 }
}
