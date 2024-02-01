package scripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TriggerFunctionValidation extends Keywords {

	public void triggerFunction(WebDriver driver) {

		String Url = TestNgXml.getdatafromExecution().get("journeyFlow");
		String email_id = Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1 = Utils.getDataFromTestData("Mailmodo", "Password");
		String webhook_Url = Utils.getDataFromTestData("Mailmodo", "Webhook Site");

		driver.manage().window().maximize();
		navigateUrl(driver, Url);

		waitForElement1(driver, login_page);
		click(driver, login_page);

		waitForElement1(driver, email);
		sendKeys(driver, email, email_id);

		wait(driver, "2");
		waitForElement(driver, password);
		sendKeys(driver, password, passwd_1);

		click(driver, LoginBtn);

		waitForElement1(driver, Journey);
		click(driver, Journey);

		boolean firstJourney = isDisplayed(driver, createFirstJourney);
		if (firstJourney) {
			click(driver, createFirstJourney);
		} else {
			click(driver, createJourney);
		}

		waitForElement1(driver, start_new);
		click(driver, start_new);

		waitForElement1(driver, AddContactTrigger);
		click(driver, AddContactTrigger);

		waitForElement1(driver, selectList);
		doubleClick(driver, selectList);

		waitForElement1(driver, contactsInTrigger2);
		String Listvalue=getText(driver,contactsInTrigger2);
		click(driver, contactsInTrigger2);
		
		//
		waitForElement(driver, Save_Btn);
		click(driver, Save_Btn);

		///
		waitForElement(driver, webHook);

		WebElement webhook = getWebElement(driver, webHook);
		WebElement exitJourney = getWebElement(driver, selectExit);
		WebElement DragPoint_1 = getWebElement(driver, dragPoint_1);

		Actions action2 = new Actions(driver);

		action2.dragAndDropBy(webhook, 280, 150).build().perform();

		action2.dragAndDropBy(exitJourney, 281, 153).build().perform();

		WebElement Webhook_point1 = getWebElement(driver, webhook_point1);
		WebElement Webhook_point2 = getWebElement(driver, webhook_point2);
		WebElement Exist_point = getWebElement(driver, exist_point);

		action2.clickAndHold(DragPoint_1).moveToElement(Webhook_point1).click().perform();

		action2.clickAndHold(Webhook_point2).moveToElement(Exist_point).click().perform();

		doubleClick(driver, webHook2);

		newTab2(driver);
		driver.get(webhook_Url);
		waitForElement1(driver, webHook_Url_copy);
		String uniqueUrl = getText(driver, webHook_Url_copy);

		driver.close();
		ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(0));

		waitForElement1(driver, webHookURL_Input);
		click(driver, webHookURL_Input);
		sendKeys(driver, webHookURL_Input, uniqueUrl);

		waitForElement(driver, Save_Btn);
		click(driver, Save_Btn);

		waitForElement(driver, publish_Btn);
		click(driver, publish_Btn);

		// waitForElement(driver,publish_journey_Popup);
		boolean popup1 = isDisplayed(driver, publish_journey_Popup);
		if (popup1) {
			waitForElement(driver, publishBtn_popup);
			click(driver, publishBtn_popup);

		}

		waitForElement1(driver, enroll_Btn);

//		waitForElement1(driver,activity);
//		click(driver,activity);
		
		newTab2(driver);
		
		navigateUrl(driver, Url);
		
		waitForElement(driver,contacts_page);
		click(driver,contacts_page);
		
		waitForElement1(driver,addContacts);
		click(driver,addContacts);

		waitForElement(driver,upload_manual);
		click(driver,upload_manual);

		waitForElement1(driver,select_existingList);
		click(driver,select_existingList);
		wait(driver,"1");
		mouseOverAndClick(driver,existing_list);

		searchExistList(driver,Listvalue);
		
		String newMail=randomString(4)+"@mailinator.com";
		sendKeys(driver,contactMailInput,newMail);
		
		click(driver,addContact_btn);
		wait(driver,"1");

		boolean import_pop1=isDisplayed(driver,okay_btn);
		
		if(import_pop1) {
			click(driver,okay_btn);
		}
		wait(driver,"1");
		elementnotvisible(driver,contact_loading);
		
		wait(driver,"1");
		List<String> contactLists=getContactsList1(driver,Listvalue.trim());
		
		driver.close();
		tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(0));
		
		refreshPage1(driver);
		waitForElement1(driver,activity);
		click(driver,activity);
		
		if(!isDisplayed(driver,sentContactList1)) {
			refreshPage1(driver);
			waitForElement1(driver,activity);
			click(driver,activity);
		}
		
		scrollBottom(driver);
		List<WebElement> contacts=getWebElements(driver,sentContactList);
		List<String> contactMails=new ArrayList<String>();
		for(WebElement ele:contacts) {
			String mailID=ele.getText();
			contactMails.add(mailID);
		}

		if(contactMails.size()<contactLists.size()) {
			System.out.println("Trigger function Passed..");
			System.out.println();

			List<String> displayed_Email=new ArrayList<String>();
			for(int i=0;i<contactLists.size();i++) {
				String email_I=contactLists.get(i);
				for(int j=0;j<contactMails.size();j++) {
					String email_J=contactMails.get(j);
					
					if(email_J.contains(email_I)) {
						displayed_Email.add(email_I);
						break;
					}
				}
			}
			
			for(String displayMail:displayed_Email) {
				System.out.println("Email Id displayed in activity Page Without trigger : "+displayMail);
				
			}
		}else {
			System.out.println("Trigger function failed");
			
		}
		
		System.out.println();

		//2nd with trigger....
		
		waitForElement1(driver, Journey);
		click(driver, Journey);
		
		waitForElement1(driver, createJourney);
		click(driver, createJourney);
		waitForElement1(driver, start_new);
		click(driver, start_new);

		waitForElement1(driver, AddContactTrigger);
		click(driver, AddContactTrigger);

		waitForElement1(driver, selectList);
		doubleClick(driver, selectList);

		waitForElement1(driver, contactsInTrigger2);
		 Listvalue=getText(driver,contactsInTrigger2);
		click(driver, contactsInTrigger2);
		
		waitForElement(driver,triggerCheckBox);
		click(driver,triggerCheckBox);
		//
		waitForElement(driver, Save_Btn);
		click(driver, Save_Btn);

		///
		waitForElement(driver, webHook);

		 webhook = getWebElement(driver, webHook);
		 exitJourney = getWebElement(driver, selectExit);
		 DragPoint_1 = getWebElement(driver, dragPoint_1);

		 action2 = new Actions(driver);

		action2.dragAndDropBy(webhook, 280, 150).build().perform();

		action2.dragAndDropBy(exitJourney, 281, 153).build().perform();

		 Webhook_point1 = getWebElement(driver, webhook_point1);
		 Webhook_point2 = getWebElement(driver, webhook_point2);
		 Exist_point = getWebElement(driver, exist_point);

		action2.clickAndHold(DragPoint_1).moveToElement(Webhook_point1).click().perform();

		action2.clickAndHold(Webhook_point2).moveToElement(Exist_point).click().perform();

		doubleClick(driver, webHook2);

//		newTab2(driver);
//		driver.get(webhook_Url);
//		waitForElement1(driver, webHook_Url_copy);
//		uniqueUrl = getText(driver, webHook_Url_copy);

		waitForElement1(driver, webHookURL_Input);
		click(driver, webHookURL_Input);
		sendKeys(driver, webHookURL_Input, uniqueUrl);

		waitForElement(driver, Save_Btn);
		click(driver, Save_Btn);

		waitForElement(driver, publish_Btn);
		click(driver, publish_Btn);

		// waitForElement(driver,publish_journey_Popup);
		 popup1 = isDisplayed(driver, publish_journey_Popup);
		if (popup1) {
			waitForElement(driver, publishBtn_popup);
			click(driver, publishBtn_popup);

		}

		waitForElement1(driver, enroll_Btn);

//		waitForElement1(driver,activity);
//		click(driver,activity);
		
		newTab2(driver);
		
		navigateUrl(driver, Url);
		
		waitForElement(driver,contacts_page);
		click(driver,contacts_page);
		
		waitForElement1(driver,addContacts);
		click(driver,addContacts);

		waitForElement(driver,upload_manual);
		click(driver,upload_manual);

		waitForElement1(driver,select_existingList);
		click(driver,select_existingList);
		wait(driver,"1");
		mouseOverAndClick(driver,existing_list);

		searchExistList(driver,Listvalue);
		
		 newMail=randomString(4)+"@mailinator.com";
		sendKeys(driver,contactMailInput,newMail);
		
		click(driver,addContact_btn);
		wait(driver,"1");
	
		waitForElement(driver,okay_btn);
		click(driver,okay_btn);
		
		wait(driver,"1");
		elementnotvisible(driver,contact_loading);
		
		wait(driver,"1");
		contactLists=null;
		contactLists=getContactsList1(driver,Listvalue.trim());
		
		driver.close();
		tab1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(0));
		
		refreshPage1(driver);

		waitForElement1(driver,activity);
		click(driver,activity);
		
		if(!isDisplayed(driver,sentContactList1)) {
			refreshPage1(driver);
			waitForElement1(driver,activity);
			click(driver,activity);
		}
		
		scrollBottom(driver);
		contacts=null;
		 contacts=getWebElements(driver,sentContactList);
		 contactMails=null;
		 contactMails=new ArrayList<String>();
		for(WebElement ele:contacts) {
			String mailID=ele.getText();
			contactMails.add(mailID);
		}

		if(contactMails.size()==contactLists.size()) {
			System.out.println("Trigger function Passed..");
			System.out.println();

			List<String> displayed_Email=new ArrayList<String>();
			for(int i=0;i<contactLists.size();i++) {
				String email_I=contactLists.get(i);
				for(int j=0;j<contactMails.size();j++) {
					String email_J=contactMails.get(j);
					
					if(email_J.contains(email_I)) {
						displayed_Email.add(email_I);
						break;
					}
				}
			}
			
			for(String displayMail:displayed_Email) {
				System.out.println("Email Id displayed in activity Page With Trigger : "+displayMail);
				
			}
		}else {
			System.out.println("Trigger function failed");
			
		}

		
		
	}
}
