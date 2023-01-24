package testBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class BaseClass {
           
	public static WebDriver driver;//in extentreptmangr v create object of (new Baseclass())(it will create 2 driver instance)
				//so to avoid conflict make it as static
	public Logger log;
	
	public ResourceBundle rb;//to get config data
	
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		//ChromeOptions option=new ChromeOptions();//for disabling txt while running browser
		//option.setExperimentalOption("excludeSwitches", new String[] {"enabled automation"});
		rb=ResourceBundle.getBundle("config");//resbun is a predefined class in java in tat
		//getbudl() is a static method to get data frm config
		
		log=LogManager.getLogger(this.getClass());
	
		if(br.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();//this will delete all prepopulated cookies in browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		
		//driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}

	public String randomAlphabet()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}
	
	public String randomNumber()
	{
		String generatedstring1=RandomStringUtils.randomNumeric(10);
		return(generatedstring1);
	}
	

	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(4);
		return(st+"@"+num);
	}
	
	//capture screenshot
		public String captureScreen(String tname) throws IOException 
		{
			/*SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");//predefined class in java
			Date dt=new Date();//predefined class in java
			String timestamp=df.format(dt);//format() is a method*/
			
			String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//df is a object reference variable mainly new SDF() is creating an object
			
			TakesScreenshot takesscreenshot=(TakesScreenshot) driver;
			File source=takesscreenshot.getScreenshotAs(OutputType.FILE);//refer sleneium project day31
			String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
			
			try {
			FileUtils.copyFile(source, new File(destination));
			}catch(Exception e) {
				e.getMessage();
			}
			return destination;
		}
}
