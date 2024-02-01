package scripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class Journey extends Keywords{

	public void journeyFlow(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("journeyFlow");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		String webhook_Url=Utils.getDataFromTestData("Mailmodo", "Webhook Site");
		//String webhook_data=Utils.getDataFromTestData("Mailmodo", "Webhook Data");
		//driver.manage().window().maximize();
		navigateUrl(driver,Url);
				
		waitForElement1(driver,login_page);
		click(driver,login_page);
		
		waitForElement1(driver,email);
		sendKeys(driver,email,email_id);
		
		wait(driver,"2");
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		click(driver,LoginBtn);
		
		waitForElement1(driver,Journey);
		click(driver,Journey);
		
		boolean firstJourney=isDisplayed(driver,createFirstJourney);
		if(firstJourney) {
			click(driver,createFirstJourney);
		}else {
			click(driver,createJourney);
		}
		
		waitForElement1(driver,start_new);
		click(driver,start_new);
		
		waitForElement(driver,manual_Triger);
		click(driver,selectTriger);
		
		waitForElement(driver,Save_Btn);
		click(driver,Save_Btn);
		
		waitForElement(driver,webHook);
		
		WebElement webhook=getWebElement(driver,webHook);
		WebElement exitJourney=getWebElement(driver,selectExit);
		WebElement DragPoint_1=getWebElement(driver,dragPoint_1);
		
	
		Actions action2=new Actions(driver);
		
		action2.dragAndDropBy(webhook,280, 150).build().perform();
		
		action2.dragAndDropBy(exitJourney,281, 154).build().perform();
		
		WebElement Webhook_point1=getWebElement(driver,webhook_point1);
		WebElement Webhook_point2=getWebElement(driver,webhook_point2);
		WebElement Exist_point=getWebElement(driver,exist_point);
		
		action2.clickAndHold(DragPoint_1).moveToElement(Webhook_point1).click().perform();
		
		action2.clickAndHold(Webhook_point2).moveToElement(Exist_point).click().perform();
		
		doubleClick(driver,webHook2);
		
		newTab2(driver);
		driver.get(webhook_Url);
		waitForElement1(driver,webHook_Url_copy);
		String uniqueUrl=getText(driver,webHook_Url_copy);
		
		ArrayList<String> tab1= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab1.get(0));
        
		waitForElement1(driver,webHookURL_Input);
		click(driver,webHookURL_Input);
		sendKeys(driver,webHookURL_Input,uniqueUrl);
		
		waitForElement(driver,Save_Btn);
		click(driver,Save_Btn);
		
		waitForElement(driver,publish_Btn);
		click(driver,publish_Btn);
		
		//waitForElement(driver,publish_journey_Popup);
		boolean popup1=isDisplayed(driver,publish_journey_Popup);
		if(popup1) {
			waitForElement(driver,publishBtn_popup);
			click(driver,publishBtn_popup);
			
		}
		
		waitForElement1(driver,enroll_Btn);
		click(driver,enroll_Btn);
		
		waitForElement(driver,startJourney);
		mouseOverAndClick(driver,selectContactList);
		
		waitForElement(driver,next);
		click(driver,next);
		
		waitForElement(driver,startJourney_Btn);
		click(driver,startJourney_Btn);
		waitForElement(driver,activity);
		refreshPage(driver);
		waitForElement1(driver,activity);
		click(driver,activity);
		
		if(!isDisplayed(driver,sentContactList1)) {
			refreshPage(driver);
			waitForElement1(driver,activity);
			click(driver,activity);
		}
		
		List<WebElement> contacts=getWebElements(driver,sentContactList);
		List<String> contactMails=new ArrayList<String>();
		for(WebElement ele:contacts) {
			String mailID=ele.getText();
			contactMails.add(mailID);
		}
		
		driver.switchTo().window(tab1.get(1));
		
		refreshPage(driver);
		
		waitForElement1(driver,requestDetails);
		
		List<WebElement> requests=getWebElements(driver,webhook_requestList);
		
		for(WebElement request:requests) {
			request.click();
			String content=getText(driver,rawContents);
			for(int i=0;i<contactMails.size();i++) {
				String mail=contactMails.get(i);
				if(content.contains(mail)) {
					System.out.println("Requests verification is Passed for this contact : "+mail);
					break;
				}
				if(i==contactMails.size()-1) {
					if(!content.contains(mail)) {
						System.out.println("Requests verification is failed for this contact : "+mail);
						break;
					}
				}
			}
		}
//		mouseOver(driver,win_Back_Flow);
		
//		click(driver,winBack_preview);
//		
//		waitForElement1(driver,Use_journey);
//		click(driver,Use_journey);	
//		waitForElement1(driver,publish_Btn);
//		click(driver,publish_Btn);
		
	}
}
