package scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import atu.testng.reports.logging.LogAs;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class BulkCampaign extends Keywords{

	public void bulkCampaignSend(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("BulkCampaign");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		String subLine=randomString(5);
		String preHead=randomString(5);
		String fromname=randomString(4);
		List<String> contactsList;
		
		driver.manage().window().maximize();
		navigateUrl(driver,Url);
		
		waitForElement(driver,login_page);
		click(driver,login_page);
		
		waitForElement(driver,email);
		sendKeys(driver,email,email_id);
		
		wait(driver,"2");
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		click(driver,LoginBtn);
		
		waitForElement1(driver,Campaigns);
		click(driver,Campaigns);
		
		waitForElement1(driver,Bulk);
		click(driver,Bulk);
		
		if(isDisplayed(driver,noCampaign)) {
			
			waitForElement1(driver,createBulk);
			mouseOverAndClick(driver,createBulk);
			
			if(isDisplayed(driver,notemplate)) {
				
				waitForElement1(driver,notemplate);
				click(driver,notemplate);

				waitForElement1(driver,temp1);
				mouseOver(driver,temp1);
				
				waitForElement(driver,useTemp);
				mouseOverAndClick(driver,useTemp);
				
				  if(isDisplayed(driver,noThanks_Btn)) {
				     	click(driver,noThanks_Btn);
				 	
				    }
				  
				waitForElement1(driver,setUpBtn);
				click(driver,setUpBtn);
				
				waitForElement1(driver,Url_input);
				sendKeys(driver,Url_input,Url);
				
				waitForElement1(driver,saveTemp);
				click(driver,saveTemp);
				
				waitForElement1(driver,back_Btn);
				click(driver,back_Btn);
				
				waitForElement1(driver,Campaigns);
				click(driver,Campaigns);
				
				waitForElement1(driver,createBulk);
				mouseOverAndClick(driver,createBulk);
			}
			
			
			
			waitForElement1(driver,template1);
			mouseOverAndClick(driver,template1);
			
			waitForElement(driver,next);
			click(driver,next);
			
			
			waitForElement1(driver,SubjectLine);
			sendKeys(driver,SubjectLine,subLine);
			System.out.println("Subject Line value  : "+subLine );

			waitForElement1(driver,pre_headerText);
			sendKeys(driver,pre_headerText,preHead);
			System.out.println("PreHeader text value  : "+preHead );

			waitForElement1(driver,fromName);
			sendKeys(driver,fromName,fromname);
			System.out.println("From Name value  : "+fromname );

			waitForElement1(driver,replyTo);
			sendKeys(driver,replyTo,email_id);
			System.out.println("Reply to mail  : "+email_id );


			waitForElement(driver,next);
			click(driver,next);
			System.out.println("next clicked");

			
			waitForElement1(driver,checkbox);
			mouseOverAndClick(driver,checkbox);
				
			waitForElement(driver,next);
			click(driver,next);
			
			
			if(isDisplayed(driver,personalization)) {
				
				waitForElement(driver,personalization);
				waitForElement(driver,columndrop);
				doubleClick(driver,columndrop);

				waitForElement(driver,labelemail);
				click(driver,labelemail);
				
				waitForElement(driver,save_btn);
				click(driver,save_btn);
			}
			
			
			waitForElement1(driver,sendCampaign);
			click(driver,sendCampaign);
			
			waitForElement(driver,sendNow);
			click(driver,sendNow);
			
			waitForElement(driver,sendBtn);
			click(driver,sendBtn);
			System.out.println("Send Button clicked");

			waitForElement1(driver,overview);
			
			for(int i=0;i<15;i++) {
			if(isDisplayed(driver,refreshNow)) {
				click(driver,refreshNow);
			}else {
				break;
			}
			}
			waitForElement1(driver,dashboard);
			
			refreshPage(driver);
			
			if(isDisplayed(driver,sentperc)) {
				System.out.println("Campain Sent Successfully.!");
				System.out.println();
				int afterSentCount=Integer.parseInt(getTextWithoutFail(driver,sentCount));
				System.out.println(" Sent Count : "+afterSentCount);
				addfps(driver, " Sent Count : ", getTextWithoutFail(driver,sentCount), true, "");

				int afterSentPrecent=Integer.parseInt(getTextWithoutFail(driver,sentPercent).replace("%",""));
				System.out.println(" Sent percentage : "+afterSentPrecent+"%");
				addfps(driver, " Sent percentage : ", getTextWithoutFail(driver,sentPercent), true, "");

				int afterDeliverCount=Integer.parseInt(getTextWithoutFail(driver,deliverCount));
				System.out.println(" Delivered Count : "+afterDeliverCount);
				addfps(driver, " Delivered Count : ", getTextWithoutFail(driver,deliverCount), true, "");

				int afterDeliverPrecent=Integer.parseInt(getTextWithoutFail(driver,deliverPercent).replace("%",""));
				System.out.println(" Delivered percentage : "+afterDeliverPrecent+"%");
				addfps(driver, " Delivered percentage : ", getTextWithoutFail(driver,deliverPercent), true, "");

			}else {
				System.out.println("Campain Not Sent..!");

			}
			
			
	// **************** first campaign created *************** //
			
		}else {
			
		  // ********create another campaign*********** //
			
			System.out.println(" start...");
			
		 int beforeSentCount=Integer.parseInt(getTextJavascript(driver,sentCount));
		System.out.println("Before Sent Count :"+beforeSentCount);
		addfps(driver, "Before Sent Count :", getTextJavascript(driver,sentCount), true, "");
		
		System.out.println(" success 1...");

		int beforeSentPercent=Integer.parseInt(getTextJavascript(driver,sentPercent).replace("%",""));
		System.out.println("Before Sent Percentage :"+beforeSentPercent+"%");
		addfps(driver, "Before Sent Percentage :", getTextJavascript(driver,sentPercent), true, "");

		System.out.println(" success 2...");

	    int beforeDeliverCount=Integer.parseInt(getTextJavascript(driver,deliverCount));
		System.out.println("Before Delivered Count :"+beforeDeliverCount);
		addfps(driver, "Before Delivered Count :", getTextJavascript(driver,deliverCount), true, "");

		int beforeDeliverPercent=Integer.parseInt(getTextJavascript(driver,deliverPercent).replace("%",""));
		System.out.println("Before Delivered Percentage :"+beforeDeliverPercent+"%");
		addfps(driver, "Before Delivered Percentage :", getTextJavascript(driver,deliverPercent), true, "");

		System.out.println(" End...");

		waitForElement1(driver,createBulk);
		click(driver,createBulk);
		
		System.out.println("Checking..");

//		if(isDisplayed(driver,closeIcon_1)) {
//			System.out.println("Close icon displayed..");
//			click(driver,closeIcon_1);
//			System.out.println("Close icon closed..");
//		}else {
//			System.out.println("Close icon not displayed..");
//		}

		waitForElement1(driver,selectTemp);
		System.out.println("Moving to template");
		waitForElement1(driver,template_1);
    	click(driver,template_1);
		System.out.println("Template selected...");
		waitForElement(driver,next);
		click(driver,next);
		
		waitForElement(driver,SubjectLine);
		sendKeys(driver,SubjectLine,subLine);
    	System.out.println("Subject Line value : "+subLine );


		waitForElement(driver,pre_headerText);
		sendKeys(driver,pre_headerText,preHead);
		System.out.println("PreHeader text value : "+preHead );

		waitForElement(driver,fromName);
		sendKeys(driver,fromName,fromname);
		System.out.println("From Name value : "+fromname );		

		waitForElement(driver,next);
		click(driver,next);
		
		System.out.println("next clicked");

		waitForElement1(driver,checkbox);
		mouseOver(driver,checkbox);
		click(driver,checkbox);
		
		System.out.println("Contact checkbox clicked");
	
		waitForElement(driver,next);
		click(driver,next);
		
		System.out.println("next clicked");

		
		if(isDisplayed(driver,personalization)) {
			
			waitForElement(driver,personalization);
			waitForElement(driver,columndrop);
			doubleClick(driver,columndrop);

			waitForElement(driver,labelemail);
			click(driver,labelemail);
			
			waitForElement(driver,save_btn);
			click(driver,save_btn);
		}
		
				
		waitForElement1(driver,sendCampaign);
		click(driver,sendCampaign);
		
		waitForElement(driver,sendNow);
		click(driver,sendNow);
		
		waitForElement(driver,sendBtn);
		click(driver,sendBtn);
		System.out.println("Sent button clicked..");

		waitForElement1(driver,overview);
		
		for(int i=0;i<15;i++) {
		if(isDisplayed(driver,refreshNow)) {
			click(driver,refreshNow);
			wait(driver,"2");
		}else {
			break;
		}
		}
		
		waitForElement1(driver,Campaigns);
		click(driver,Campaigns);
		wait(driver,"2");
		
		if(isDisplayed(driver,sentperc)) {
			System.out.println("Campain Sent Successfully.!");
		}
		
		int afterSentCount=Integer.parseInt(getTextWithoutFail(driver,sentCount));
		System.out.println("After Sent Count : "+afterSentCount);
		addfps(driver, "After Sent Count : ", getTextWithoutFail(driver,sentCount), true, "");

		int afterSentPrecent=Integer.parseInt(getTextWithoutFail(driver,sentPercent).replace("%",""));
		System.out.println("After Sent percentage : "+afterSentPrecent+"%");
		addfps(driver, "After Sent percentage : ", getTextWithoutFail(driver,sentPercent), true, "");

		int afterDeliverCount=Integer.parseInt(getTextWithoutFail(driver,deliverCount));
		System.out.println("After Delivered Count : "+afterDeliverCount);
		addfps(driver, "After Delivered Count : ", getTextWithoutFail(driver,deliverCount), true, "");

		int afterDeliverPrecent=Integer.parseInt(getTextWithoutFail(driver,deliverPercent).replace("%",""));
		System.out.println("After Delivered percentage : "+afterDeliverPrecent+"%");
		addfps(driver, "After Delivered percentage : ", getTextWithoutFail(driver,deliverPercent), true, "");

		
		if(afterSentCount>beforeSentCount) {
			System.out.println("Sent Count Increased and verified succesfully...!");
			addfps(driver, "Sent Count Increased and verified succesfully...!", "", true, "");

		}else {
			System.out.println("Sent Count not increased ...!");
			add1(driver, "Sent Count not increased ...!", LogAs.FAILED, true,"");

		}
		
		if(afterDeliverCount>beforeDeliverCount) {
			System.out.println("Delivered Count Increased and verified succesfully...!");
			addfps(driver, "Delivered Count Increased and verified succesfully...!", "", true, "");

		}else {
			System.out.println("Delivered Count not increased ...!");
			add1(driver, "Delivered Count not increased ...!", LogAs.FAILED, true,"");

		}
		
		}
	}

	
	
	public void mailValidation(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("MailValidation");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		List<String> contactsList;
		
		driver.manage().window().maximize();
		navigateUrl(driver,Url);
		
		waitForElement(driver,login_page);
		click(driver,login_page);
		
		waitForElement(driver,email);
		sendKeys(driver,email,email_id);
		
		wait(driver,"2");
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		click(driver,LoginBtn);
		
		waitForElement1(driver,Campaigns);
		click(driver,Campaigns);
		
		waitForElement1(driver,Bulk);
		click(driver,Bulk);
		
		waitForElement1(driver,openCount);
		int beforeOpenCount=Integer.parseInt(getTextWithoutFail(driver,openCount));
		System.out.println("Before Open Count : "+beforeOpenCount);
		addfps(driver, "Before Open Count : ", getTextWithoutFail(driver,openCount), true, "");

		
		int beforeOpenPrecent=Integer.parseInt(getTextWithoutFail(driver,openpercent).replace("%",""));
		System.out.println("Before Open Percentage : "+beforeOpenPrecent+"%");
		addfps(driver, "Before Open Percentage : ", getTextWithoutFail(driver,openpercent)+"%", true, "");

		
		int beforeClickCount=Integer.parseInt(getTextWithoutFail(driver,clickCount));
		System.out.println("Before Click Count : "+beforeClickCount);
		addfps(driver, "Before Click Count : ", getTextWithoutFail(driver,clickCount), true, "");

		int beforeClickPrecent=Integer.parseInt(getTextWithoutFail(driver,clickpercent).replace("%",""));
		System.out.println("Before Click Percentage : "+beforeClickPrecent+"%");
		addfps(driver, "Before Click Percentage : ", getTextWithoutFail(driver,clickpercent)+"%", true, "");


		waitForElement1(driver,campaign);
		click(driver,campaign);
		
		waitForElement1(driver,dashboard);
		
		waitForElement(driver,summary);
		click(driver,summary);
		
		waitForElement1(driver,receptienListSec);
		click(driver,receptienListSec);
		
		String receptListName=getTextWithoutFail(driver,recepListName).trim();
		
		waitForElement(driver,contacts_page);
		click(driver,contacts_page);
		
		waitForElement1(driver,segments);
		
		//getting contacts List
		contactsList=getContactsList1(driver,receptListName);
		
		wait(driver,"1");
		newTab2(driver);
		wait(driver,"1");
        driver.get("https://www.mailinator.com/");
		wait(driver,"2");
		waitForElement1(driver,publicinbox);
		click(driver, publicinbox);
		
		for(int i=1;i<contactsList.size();i++) {
			
			String mail=contactsList.get(i);
			waitForElement(driver,txtboxmail);
			clearAndType(driver, txtboxmail, mail);
			waitForElement(driver,gobtn);
			click(driver, gobtn);
			
			if(isDisplayed(driver,inboxMailModo)) {
			
			waitForElement(driver,inboxMailModo);
			click(driver, inboxMailModo);
			
			wait(driver,"2");
			waitForElement(driver,bactToInbox);
			click(driver, bactToInbox);
			}
			
		}
		
		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_W);
//			r.keyRelease(KeyEvent.VK_CONTROL);
//			wait(driver, "1");
			driver.close();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			wait(driver, "1");
			System.out.println(tabs.size());
			driver.switchTo().window(tabs.get(0));
			wait(driver, "1");
		} catch (Exception e) {
			
		}
		
		
		wait(driver,"1");
		if(isDisplayed(driver,closeIcon)) {
			click(driver,closeIcon);
		}
		
		wait(driver,"2");
		
		waitForElement(driver,Campaigns);
		click(driver,Campaigns);
		
//		waitForElement(driver,Bulk);
//		click(driver,Bulk);
		
		wait(driver,"2");
		
		refreshPage(driver);
		wait(driver,"5");
		
		waitForElement1(driver,Bulk);
		click(driver,Bulk);
		
		int afterOpenCount=Integer.parseInt(getTextWithoutFail(driver,openCount));
		System.out.println("After Open Count : "+afterOpenCount);
		addfps(driver, "After Open Count : ", getTextWithoutFail(driver,openCount), true, "");

		int afterOpenPrecent=Integer.parseInt(getTextWithoutFail(driver,openpercent).replace("%",""));
		System.out.println("After Open Percentage : "+afterOpenPrecent+"%");
		addfps(driver, "After Open Percentage : ", getTextWithoutFail(driver,openpercent)+"%", true, "");

		if(afterOpenCount>beforeOpenCount) {
			
			System.out.println("Open count increased....!");
			addfps(driver, "Open count increased....!", "", true, "");

			
		}else {

			System.out.println("Open count  not changed....!");
			add1(driver, "Open count  not changed....!", LogAs.FAILED, true,"");


		}
		
		wait(driver,"2");
		newTab2(driver);
		wait(driver,"2");
        driver.get("https://www.mailinator.com/");
		wait(driver,"2");
		waitForElement1(driver,publicinbox);
		click(driver, publicinbox);
		
		for(int i=1;i<contactsList.size();i++) {
			
			String mail=contactsList.get(i);
			waitForElement(driver,txtboxmail);
			clearAndType(driver, txtboxmail, mail);
			waitForElement(driver,gobtn);
			click(driver, gobtn);
			
			if(isDisplayed(driver,inboxMailModo)) {
			
			waitForElement(driver,inboxMailModo);
			click(driver, inboxMailModo);
			
			wait(driver,"2");
			scrollBottom(driver);
			driver.switchTo().frame("html_msg_body");
			
			waitForElement(driver,setUpNowLink);
			click(driver,setUpNowLink);
			
			driver.switchTo().defaultContent();
			
			waitForElement(driver,bactToInbox);
			click(driver, bactToInbox);
			}
			
		}
		
		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_W);
//			r.keyRelease(KeyEvent.VK_CONTROL);
//			wait(driver, "1");
			driver.close();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			wait(driver, "1");
			driver.switchTo().window(tabs.get(0));
			wait(driver, "1");
		} catch (Exception e) {
			
		}
		
		refreshPage(driver);
		waitForElement1(driver,delivered);
		
		
		int afterOpenCount2=Integer.parseInt(getTextWithoutFail(driver,openCount));
		System.out.println("After Open Count  : "+afterOpenCount2);
		addfps(driver, "After Open Count : ", getTextWithoutFail(driver,openCount), true, "");

//		int afterOpenPrecent2=Integer.parseInt(getTextWithoutFail(driver,openpercent).replace("%",""));
//		System.out.println("After Open Percentage : "+afterOpenPrecent2+"%");
//		addfps(driver, "After Open Percentage : ", getTextWithoutFail(driver,openpercent)+"%", true, "");

		if(afterOpenCount2>beforeOpenCount) {
			
			System.out.println("Open count increased....!");
			addfps(driver, "Open count increased....!", "", true, "");

			
		}else {

			System.out.println("Open count  not changed....!");
			add1(driver, "Open count  not changed....!", LogAs.FAILED, true,"");


		}
		
		
		
		int afterClickCount=Integer.parseInt(getTextWithoutFail(driver,clickCount));
		System.out.println("After Click Count : "+afterClickCount);
		addfps(driver, "After Click Count : ", getTextWithoutFail(driver,clickCount), true, "");

		int afterClickPrecent=Integer.parseInt(getTextWithoutFail(driver,clickpercent).replace("%",""));
		System.out.println("After Click Percentage : "+afterClickPrecent+"%");
		addfps(driver, "After Open Percentage : ", getTextWithoutFail(driver,clickpercent)+"%", true, "");

		
        if(afterClickCount>beforeClickCount) {
			
			System.out.println("Click count increased....!");
			addfps(driver, "Click count increased....!", "", true, "");

			
		}else {
			
			System.out.println("Click count not changed....!");
			add1(driver, "Click count not changed....!", LogAs.FAILED, true,"");


		}
	}

	
}
