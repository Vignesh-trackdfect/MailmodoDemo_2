package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;


public class ContactsPage extends Keywords {

	public void contactsAdd(WebDriver driver) {
		
		String Url=TestNgXml.getdatafromExecution().get("ContactsPage");
		String email_id=Utils.getDataFromTestData("Mailmodo", "Mail");
		String passwd_1=Utils.getDataFromTestData("Mailmodo", "Password");
		String csvfile=System.getProperty("user.dir")+"\\contacts.csv";
		
		//driver.manage().window().maximize();
		navigateUrl(driver,Url);
		
		waitForElement(driver,login_page);
		click(driver,login_page);
		
		waitForElement(driver,email);
		sendKeys(driver,email,email_id);
		
		waitForElement(driver,password);
		sendKeys(driver,password,passwd_1);
		
		click(driver,LoginBtn);
		
		waitForElement(driver,contacts_page);
		click(driver,contacts_page);
		
		String listName=randomString(4);
		
		boolean add_manual_present=isDisplayed(driver,add_manually);
		
		if(add_manual_present) {
			
			click(driver,add_manually);
			
			waitForElement1(driver,new_list);
			
			sendKeys(driver,new_list,listName);
			enter(driver);
			
			typeContacts(driver,3);
			
			click(driver,addContact_btn);
			
			boolean import_pop=isDisplayed(driver,import_popup);
			if(import_pop) {
				click(driver,okay_btn);
			}
			
			System.out.println("Contacts added by manually in the list : "+listName);
		    addfps(driver, "Contacts added by manually in the list : ", listName, true, "");

//			waitForElement1(driver,addContacts);
//			click(driver,addContacts);
//			
//			waitForElement(driver,upload_manual);
//			click(driver,upload_manual);
//			
//			waitForElement1(driver,select_existingList);
//			click(driver,select_existingList);
//			mouseOverAndClick(driver,existing_list);
//		
//			searchExistList(driver,listName);
//			
//			
//			typeContacts(driver,3);
//			wait(driver,"2");
//			click(driver,addContact_btn);
//			
//			boolean import_pop1=isDisplayed(driver,import_popup);
//			
//			if(import_pop1) {
//				click(driver,okay_btn);
//			}
			
			refreshPage(driver);
			
		}else {
			
			waitForElement1(driver,addContacts);
			click(driver,addContacts);
			
			waitForElement(driver,upload_manual);
			click(driver,upload_manual);
			
            waitForElement1(driver,new_list);
			
			sendKeys(driver,new_list,listName);
			enter(driver);
			
			typeContacts(driver,3);
			click(driver,addContact_btn);
			wait(driver,"2");
			boolean import_pop=isDisplayed(driver,import_popup);
			if(import_pop) {
				click(driver,okay_btn);
			}
			
			elementnotvisible(driver,contact_loading);
			
			System.out.println("Contacts added by manually in the list : "+listName);
		    addfps(driver, "Contacts added by manually in the list : ", listName, true, "");

			wait(driver,"2");
			waitForElement1(driver,addContacts);
			wait(driver,"1");
			click(driver,addContacts);
			wait(driver,"2");

			waitForElement(driver,upload_manual);
			click(driver,upload_manual);
			wait(driver,"2");

			waitForElement1(driver,select_existingList);
			click(driver,select_existingList);
			mouseOverAndClick(driver,existing_list);
		
			searchExistList(driver,listName);
			
			typeContacts(driver,2);
			wait(driver,"2");
			click(driver,addContact_btn);
			wait(driver,"2");
			boolean import_pop1=isDisplayed(driver,import_popup);
			
			if(import_pop1) {
				click(driver,okay_btn);
			}
			
			wait(driver,"1");
			
		}
		
		elementnotvisible(driver,contact_loading);
		wait(driver,"2");
		
		waitForElement(driver,addContacts);
		click(driver,addContacts);
		wait(driver,"2");
		waitForElement(driver,upload_CSV);
		click(driver,upload_CSV);
		
		 String listName1=randomString(4);
		 
		waitForElement(driver,new_list);
		sendKeys(driver,new_list,listName1);
		
		uploadfile(driver,csvfile);
		wait(driver,"3");
		
		click(driver,map_column);
		
		waitForElement1(driver,review_import);
		click(driver,review_import);
		
		waitForElement1(driver,import_contacts);
		click(driver,import_contacts);
		wait(driver,"2");

		waitForElement(driver,close_icon);
		wait(driver,"1");
		click(driver,close_icon);
		if(isDisplayed(driver,close_icon)) {
			click(driver,close_icon);
		}
		elementnotvisible(driver,contact_loading);
		
		System.out.println("Contacts added by uploading CSV file in the list : "+listName1);
	    addfps(driver, "Contacts added by uploading CSV in the list : ", listName1, true, "");

		wait(driver,"2");
		
        refreshPage(driver);
        
        waitForElement1(driver,addContacts);
        
    if(isDisplayed(driver,more_icon)) {
    	
    	wait(driver,"2");
		click(driver,more_icon);
		wait(driver,"2");
		
		waitForElement1(driver,archive);
		click(driver,archive);
		wait(driver,"1");
		waitForElement1(driver,confirm_archieve);
		click(driver,confirm_archieve);
		
		System.out.println("Contacts archieved successfully");
	    addfps(driver, "Contacts archieved successfully", "", true, "");

		
		wait(driver,"2");
		click(driver,more_icon);
		waitForElement1(driver,exportToCSV);
		click(driver,exportToCSV);
		wait(driver,"2");
		
		click(driver,more_icon);
		
		waitForElement(driver,rename);
		click(driver,rename);
		
		waitForElement(driver,rename_input);
		doubleClick(driver,rename_input);
			
		String rename=randomString(4);
		sendKeys(driver,rename_input,rename);
		click(driver,rename_confirm_btn);
		
		System.out.println("Contact List Renamed successfully");
	    addfps(driver, "Contact List Renamed successfully", "", true, "");

		
		wait(driver,"2");
      }
    

	}
}
