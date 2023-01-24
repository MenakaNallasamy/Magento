package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	String repname;
	
	public void onStart(ITestContext context) {

		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
		repname="Test-Report-"+ timestamp +".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);//specify location of the report(if v hard code name of report v cannot maintain history)
		
		sparkReporter.config().setDocumentTitle("Magento Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Magento Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","Magento");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("sub module","Customers");
		extent.setSystemInfo("os",System.getProperty("os.name"));//to get os from system
		extent.setSystemInfo("user name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");		
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, result.getThrowable().getMessage()); 
		
		try {
			String imgPath=new BaseClass().captureScreen(result.getName());//if we create object of base class there wil be a conflict for //
					//webdriver instance(it will create 2 driver instance) so make webdriver as static in BaseClass
			test.addScreenCaptureFromPath(imgPath);
		} catch(Exception e) {
		
		}
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	

	/*send the report through email
	 * -----------------
	 * try { URL url = new
	 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	 * 
	 * // Create the email message 
	 * ImageHtmlEmail email = new ImageHtmlEmail();
	 * 
	 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
	 * email.setHostName("smtp.googlemail.com"); 
	 * email.setSmtpPort(465);
	 * email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password")); 
	 * email.setSSLOnConnect(true);
	 * email.setFrom("pavanoltraining@gmail.com"); //Sender
	 * email.setSubject("Test Results");
	 * email.setMsg("Please find Attached Report....");
	 * email.addTo("pavankumar.busyqa@gmail.com"); //Receiver 
	 * email.attach(url, "extent report", "please check report..."); 
	 * email.send(); // send the email 
	 * }
	 * catch(Exception e) { e.printStackTrace(); }
	 */
}
	
}

