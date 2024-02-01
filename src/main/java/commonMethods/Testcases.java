package commonMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.exceptions.ATUReporterException;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import scripts.BulkCampaign;
import scripts.ContactValidation;
import scripts.ContactsPage;
import scripts.Journey;
import scripts.Login;
import scripts.TriggerFunctionValidation;
;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class Testcases extends Config {
	{
		System.setProperty("atu.reporter.config", System.getProperty("user.dir") + "/atu.properties");
	}
	public String appURL;
	public String appURL1;
	public String appURL2;
	public String prurl;
	public String mailinatorurl;
	public String proxy;
	public String usernameValue;
	public String passwordValue;
	public String project_Name;
	public String version_Name;
	public String environment;
	public String browser;
	public WebDriver driver;
	public String search;

	public ChromeOptions options = null;
	String Userflowurl = null;
	File f = new File(report_folder_create + "\\reports");
	
	public String Execution = "null";
	public String buildname = "null";
	
	boolean log = false;
	
	
	ContactsPage contacts = new ContactsPage();
	Login login = new Login();
	BulkCampaign bulk=new BulkCampaign();
	Journey journey=new Journey();
	ContactValidation cv=new ContactValidation();
	TriggerFunctionValidation tf=new TriggerFunctionValidation();
	
	@BeforeClass
	public void getDataFromConfig() throws ATUReporterException, IOException, InterruptedException {

		System.out.println("******************Script Execution Started******************");
		appURL = Utils.getDataFromTestConfig("URL1");
		browser = Utils.getDataFromTestConfig("AppBrowser");
		project_Name = Utils.getDataFromTestConfig("Project_Name");
		version_Name = Utils.getDataFromTestConfig("Version_Name");
		buildname = project_Name + "_" + java.time.LocalDate.now().toString() + "_" + java.time.LocalTime.now();
		Execution = Utils.getDataFromTestConfig("Execution env");
	    //driver = getWebDriver(browser);
//		options = getWebDriver(browser);

	}

	@Test
	public void Login()  {
		
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		login.login1(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
	@Test
	public void ContactsPage(){
		
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		contacts.contactsAdd(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
	@Test
	public void BulkCampaign(){
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		bulk.bulkCampaignSend(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
	@Test
	public void MailValidation(){
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		bulk.mailValidation(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}

	@Test
	public void journeyFlow(){
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		journey.journeyFlow(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
	@Test
	public void ContactValidation(){
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		cv.contactValidation(driver);
		driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
	@Test
	public void TriggerFunction(){
		driver=null;
		try {
			driver=getWebDriver(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		tf.triggerFunction(driver);
		//driver.quit();
		System.out.println("******************Script Execution Completed******************");

	}
	
}
