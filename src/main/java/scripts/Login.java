package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import atu.testng.reports.logging.LogAs;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class Login extends Keywords{

	
	public void login1(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("Login");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		
		
		driver.manage().window().maximize();
		navigateUrl(driver,Url);
	//	navigateUrl(driver,"https://manage.mailmodo.com/auth/login");
		
		waitForElement1(driver,login_page);
		wait(driver,"2");
		click(driver,login_page);
		
		waitForElement1(driver,email);
		sendKeys(driver,email,email_id);
		
		wait(driver,"2");
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		wait(driver,"2");
		
		click(driver,LoginBtn);
		
		System.out.println("Clicked Login button");
		
//		if(isDisplayed(driver,err)) {
//			
//			System.out.println("Passed..");
//		}
//		
		waitForElement1(driver,profile_icon);
		click(driver,profile_icon);
		
		wait(driver,"2");
		waitForElement(driver,logout);
		click(driver,logout);
		
		
		///      negative case   start  /// 
		
		//case : 1
		waitForElement1(driver,email);
		click2(driver,LoginBtn);
		
		if(isDisplayed(driver,email_error)) {
			System.out.println();
			System.out.println("Verification passed case 1..");
			System.out.println("Error while click login without enter the email : "+getText(driver,email_error));
			System.out.println();
			addfps(driver, "Error while click login without enter the email : ", getText(driver,email_error), true, "");

		}else {
			System.out.println();
			System.out.println("while click login without enter the email error not shown");
			add1(driver, "while click login without enter the email error not shown", LogAs.FAILED, true,"");

		}
		
		//case : 2
		
		waitForElement1(driver,email);
		sendKeys(driver,email,"dfaasf");
		
		click2(driver,LoginBtn);

		if(isDisplayed(driver,email_error2)) {
			System.out.println();
			System.out.println("Verification passed case 2..");
			System.out.println("Error while click login after enter the invalid email : "+getText(driver,email_error2));
			System.out.println();
			addfps(driver, "Error while click login after enter the invalid email : ", getText(driver,email_error2), true, "");

		}else {
			System.out.println();
			System.out.println("While click login after enter the invalid email, error not shown");
			add1(driver, "While click login after enter the invalid email, error not shown", LogAs.FAILED, true,"");

		}
		
		//case : 3
		
		waitForElement1(driver,email);
		doubleClick(driver,email);
		sendKeys(driver,email,email_id);
		
		click2(driver,LoginBtn);
		
		if(isDisplayed(driver,pass_error)&&!isDisplayed(driver,email_error2)) {
			System.out.println();
			System.out.println("Verification passed case 3..");
			System.out.println("Error while click login without enter the password : "+getText(driver,pass_error));
			System.out.println();
			addfps(driver, "Error while click login without enter the password : ", getText(driver,pass_error), true, "");

		}else {
			System.out.println();
			System.out.println("While click login without enter the password, error not shown..");
			add1(driver, "While click login without enter the password, error not shown", LogAs.FAILED, true,"");

		}
		
		
		//case : 4
		
		waitForElement1(driver,password);
		sendKeys(driver,password,"123");
		
		click2(driver,LoginBtn);
		
		if(isDisplayed(driver,pass_error2)) {
			System.out.println();
			System.out.println("Verification passed case 4..");
			System.out.println("Error while click login after enter the password with less size : "+getText(driver,pass_error2));
			System.out.println();
			addfps(driver, "Error while click login after enter the password with less size : ", getText(driver,pass_error2), true, "");

		}else {
			System.out.println();
			System.out.println("While click login after enter the password with less size, error not shown");
			add1(driver, "While click login after enter the password with less size, error not shown", LogAs.FAILED, true,"");

		}
		
		//case : 5
		
		//waitForElement1(driver,password);
		doubleClick(driver,password);
		sendKeys(driver,password,"123456789");
		
		click2(driver,LoginBtn);
		
		if(isDisplayed(driver,pass_error3)) {
			System.out.println();
			System.out.println("Verification passed case 5..");
			System.out.println("Error while click login after enter the Invalid password : "+getText(driver,pass_error3));
			System.out.println();
		    addfps(driver, "Error while click login after enter the Invalid password : ", getText(driver,pass_error3), true, "");

		}else {
			System.out.println();
			System.out.println("While click login after enter the Invalid password, error not shown");
			add1(driver, "While click login after enter the Invalid password, error not shown", LogAs.FAILED, true,"");

		}
		
		//// Negative test case end  ////
		
		waitForElement1(driver,forgot_passwd);
		click(driver,forgot_passwd);
		
		waitForElement1(driver,resetBtn);
		
		waitForElement(driver,email);
		sendKeys(driver,email,email_id);
		
		waitForElement(driver,resetBtn);
		click(driver,resetBtn);
		
		
		boolean elementPresent=isDisplayed(driver,resentLink_msg);
		
		if(elementPresent) {
			System.out.println("Reset password link sent successfully...!!");
			addfps(driver, "Reset password link sent successfully...!!", "", true, "");

		}else {
			System.out.println("Failed to sent sent reset password link ..!");
			add1(driver, "Failed to sent  reset password link ..!", LogAs.FAILED, true,"");

			Assert.fail();
		}
		
	}
}
