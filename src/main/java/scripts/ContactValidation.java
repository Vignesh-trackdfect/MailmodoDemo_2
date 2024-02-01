package scripts;

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

public class ContactValidation extends Keywords{

	public void contactValidation(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("journeyFlow");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		
		driver.manage().window().maximize();
		navigateUrl(driver,Url);
		
		waitForElement1(driver,login_page);
		click(driver,login_page);
		
		waitForElement1(driver,email);
		sendKeys(driver,email,email_id);
		
		wait(driver,"2");
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		click(driver,LoginBtn);
		
		waitForElement(driver,contacts_page);
		click(driver,contacts_page);
		
		waitForElement1(driver,addContacts);
		
		List<WebElement> ListNames_elements=getWebElements(driver,ListName);
		List<String> ListNames_Expected=new ArrayList<String>();
		int l=1;
		for(WebElement listElement:ListNames_elements) {
			String listText=listElement.getText();
		    add(driver,"","Contact List "+l+" : "+listText, true, "");
			//System.out.println(listText);
			ListNames_Expected.add(listText);
			l++;
		}
		
	
		newTab2(driver);
	
		navigateUrl(driver,Url);
		
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
		
		waitForElement1(driver,AddContactTrigger);
		click(driver,AddContactTrigger);
		
		waitForElement1(driver,selectList);
		doubleClick(driver,selectList);
		
		
		List<WebElement> TriggerContactsList=getWebElements(driver,contactsInTrigger);
		
		List<String> ListNames_Actual=new ArrayList<String>();
		

	    l=1;
		for(WebElement listElement:TriggerContactsList) {
			String listText=listElement.getText();
			//System.out.println(listText);
		    add(driver,"","Trigger Contact List "+l+" : "+listText, true, "");
			ListNames_Actual.add(listText);
			l++;
		}
	
		
		
		System.out.println("Expected Count : "+ListNames_Expected.size());
		System.out.println("Actual Count : "+ListNames_Actual.size());
		
		System.out.println();
		System.out.println("       <------------->       ");
		System.out.println();
		
		for(int i=0;i<ListNames_Expected.size();i++) {
			
			  String Expected=ListNames_Expected.get(i);
			
			for(int j=0;j<ListNames_Actual.size();j++) {
				
				String Actual= ListNames_Actual.get(j);
				if(Actual.contains(Expected)) {
					System.out.println("Contacts List verified passed for the list : "+Expected);
    				    add(driver,"Contacts List verified passed for the list : "+Expected,"", true, "");

					break;
				}
				
				if(j==ListNames_Actual.size()-1) {
					System.out.println("Contacts List verified failed for the list  : "+Expected);
 		           add1(driver,"Contacts List verified failed for the list  : "+Expected, LogAs.FAILED,true,"");

				}
				
			}
		}
		
		System.out.println();
		System.out.println("       <------------->       ");
		System.out.println();
		WebElement markElement;
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));	
		
        waitForElement(driver,deleteListMoreIcon);
        String deletedText=getText(driver,deletedList);
        
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        markElement=getWebElement(driver,deletedList);
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",markElement);
		
        click(driver,deleteListMoreIcon);
        
        waitForElement(driver,archive);
        click(driver,archive);
        
        waitForElement1(driver,confirm_archieve);
		click(driver,confirm_archieve);
		
		driver.switchTo().window(tabs.get(1));
		wait(driver,"1");
		
		refreshPage1(driver);
        
		waitForElement1(driver,AddContactTrigger);
		click(driver,AddContactTrigger);
		
		waitForElement1(driver,selectList);
		doubleClick(driver,selectList);
		
        TriggerContactsList=null;
        TriggerContactsList=getWebElements(driver,contactsInTrigger);
        
		ListNames_Actual=null;
		
		int z=0;
		for(WebElement listElement:TriggerContactsList) {
			String listText=listElement.getText();
			if(listText.contains(deletedText)) {
				System.out.println("Deleted List showing in the contact List && Result failed");
		           add1(driver,"Deleted List showing in the contact List && Result failed", LogAs.FAILED,true,"");
                 break;
			}
		
			if(z==TriggerContactsList.size()-1) {
				if(!listText.contains(deletedText)) {
					System.out.println("Deleted List Not showing in the contact List && Result Passed");
					System.out.println("Deleted List : "+deletedText);
				    add(driver,"Deleted List Not showing in the contact List && Result Passed","Deleted List : "+deletedText, true, "");
	                 break;
				}
			}
			z++;
		}
		
		System.out.println();
		System.out.println("       <------------->       ");
		System.out.println();
		
		driver.switchTo().window(tabs.get(0));

		String newlistName=randomString(5);
		
		waitForElement1(driver,addContacts);
		click(driver,addContacts);
		
		waitForElement(driver,upload_manual);
		click(driver,upload_manual);
		
        waitForElement1(driver,new_list);
		
		sendKeys(driver,new_list,newlistName);
		enter(driver);
		
		typeContacts(driver,3);
		click(driver,addContact_btn);
		wait(driver,"1");
		boolean import_pop=isDisplayed(driver,import_popup);
		if(import_pop) {
			click(driver,okay_btn);
		}
		
		elementnotvisible(driver,contact_loading);
	
		driver.switchTo().window(tabs.get(1));
		refreshPage1(driver);
		
		waitForElement1(driver,AddContactTrigger);
		click(driver,AddContactTrigger);
		
		waitForElement1(driver,selectList);
		doubleClick(driver,selectList);
		
        TriggerContactsList=null;
        TriggerContactsList=getWebElements(driver,contactsInTrigger);
        
		ListNames_Actual=null;
		
	    z=0;
		for(WebElement listElement:TriggerContactsList) {
			String listText=listElement.getText();
			if(listText.contains(newlistName)) {
				System.out.println("Newly added List showing in the trigger contact List && Result Passed ");
				System.out.println("Newly added List : "+newlistName);
				executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",listElement);

			    add(driver,"Newly added List showing in the trigger contact List && Result Passed ","Newly added List : "+newlistName, true, "");
                 break;
			}
		
			if(z==TriggerContactsList.size()-1) {
				if(!listText.contains(newlistName)) {
					System.out.println("Newly added List not showing in the trigger contact List && Result Failed ");
					add1(driver,"Newly added List not showing in the trigger contact List && Result Failed ", LogAs.FAILED,true,"");
	                 break;
				}
			}
			z++;
		}
		System.out.println();
		System.out.println("       <------------->       ");
		System.out.println();

		driver.switchTo().window(tabs.get(0));

		 waitForElement(driver,deleteListMoreIcon);
	     String beforeRenameText=getText(driver,deletedList);
	     
	     markElement=getWebElement(driver,deletedList);
		 executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",markElement);

	     click(driver,deleteListMoreIcon);
	     
	     waitForElement(driver,rename);
	     click(driver,rename);
			
	     waitForElement(driver,rename_input);
		 doubleClick(driver,rename_input);
		 String afterRenameText=randomString(4);
         sendKeys(driver,rename_input,afterRenameText);
		 click(driver,rename_confirm_btn);
	       
		 driver.switchTo().window(tabs.get(1));
		 refreshPage1(driver);
			
			waitForElement1(driver,AddContactTrigger);
			click(driver,AddContactTrigger);
			
			waitForElement1(driver,selectList);
			doubleClick(driver,selectList);
			
	        TriggerContactsList=null;
	        TriggerContactsList=getWebElements(driver,contactsInTrigger);
	        
			ListNames_Actual=null;
			
		    z=0;
			for(WebElement listElement:TriggerContactsList) {
				String listText=listElement.getText();
				if(listText.contains(afterRenameText)) {
					System.out.println(" Renamed List name showing in the trigger contact List && Result Passed ");
					System.out.println();
					System.out.print("ListName Before Rename : "+beforeRenameText+"       ");
					System.out.print("ListName After Rename : "+afterRenameText);
					executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",listElement);
				    add(driver,"Renamed List name showing in the trigger contact List && Result Passed ","ListName After Rename : "+afterRenameText, true, "");
	                 break;
				}
			
				if(z==TriggerContactsList.size()-1) {
					if(!listText.contains(afterRenameText)) {
						System.out.println("Newly added List not showing in the trigger contact List && Result Failed ");
						add1(driver,"Newly added List not showing in the trigger contact List && Result Failed ", LogAs.FAILED,true,"");
		                 break;
					}
				}
				z++;
			}
			System.out.println();
			System.out.println("       <------------->       ");
			System.out.println();

	}
}
