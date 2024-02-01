package commonMethods;

public interface MailmodoLocators {

	//Signup
	public static String email="Email >//input[@name='email']";
	public static String createPasswd="Create password>//input[@name='password']";
	public static String signupBtn="Sign Up Now Button>//*[text()='Sign up now']";
	public static String email_error="Enter email >//*[text()='Please enter email']";
	public static String email_error2="Enter valid email >//*[text()='Please enter valid email']";
	public static String pass_error="Enter password >//*[text()='Please enter password']";
	public static String pass_error2="Enter valid password >//*[text()='password should be at least 8 characters long']";
	public static String pass_error3="Enter valid password >//*[contains(text(),'Invalid Email or Password')]";

	public static String err="err>(//div[@class='error-message'])[1]";
	
	//Login
	public static String login_page="Login here>//span[text()='Login here']";
	public static String log_page="Login Page>//button[@type='button']";
	public static String password="Enter password>//input[@name='password']";
	public static String LoginBtn="Login Button>//*[text()='Login']";
	public static String forgot_passwd="Forgot password>//*[text()='Forgot Password ?']";
	public static String signup_page="Sign up here>//*[text()='Sign up free']";
	
	//forgot password
	public static String resetBtn="Reset password link>//*[text()='Email me a reset link']";
	public static String returnToLogin="Return to Login page>//*[text()='Return to Login']";
	public static String resentLink_msg="Resent link message>//*[text()='Reset Link Sent!']";
	
	//logout
	public static String profile_icon="profile icon>//*[contains(@class,'profile-icon')]";
	public static String my_profile="My profile>//*[text()='My Profile']";
	public static String help_doc="help documentation>//*[text()='Help Documentation']";
	public static String contactUs="contactus>//*[text()='Contact us']";
	public static String logout="Logout>//*[text()='Contact us']//following::span[contains(text(),'Logout')]";//span[text()=' Logout']
	
	// Userflow_02---> adding contacts
	public static String contacts_page="Contacts page>//span[text()='Contacts']";
	public static String add_manually="Add manually>//span[text()='Add manually']";
	public static String addContacts="Add Contacts>//div[text()='Add Contacts']";
	public static String upload_manual="Upload manually>//div[text()=' Upload manually']";
	public static String upload_CSV="upload csv file>//div[text()=' Upload using CSV']";
	public static String new_list="Enter New List>(//div[text()='New List']//following::input)[1]";
	public static String existing_list="Existing List>//*[@class='ant-select-selection-search-input']";//*[@class='ant-select-selection-item']
	public static String addContact_btn="Add contacts button>//span[text()='Add Contacts']";
	public static String import_popup="Import popup>//*[text()='Import complete']";
	public static String okay_btn="Okay button>//*[text()='Import complete']//following::button";
	public static String map_column="Map coloumn button>//*[text()='Map columns']";
	public static String review_import="Review import button>//*[text()='Review Import']";
	public static String import_contacts="Import contacts>//*[text()='Import contacts']";
	public static String close_icon="Close Icon>//*[contains(@class,'close-icon')]";
	public static String contact_loading="Contact loading symbol>//*[@data-icon='sync']";
	public static String select_newList="Select new List>//div[text()='New List']";
	public static String select_existingList="Select Exist list>//div[text()='Existing List']";
	
	public static String more_icon="More icon>//div[contains(@class,'ant-dropdown-trigger')]";
	public static String more_icon2="More icon 2>(//div[contains(@class,'ant-dropdown-trigger')])[2]";
	public static String archive="archive>//*[text()='Archive']";
	public static String archive2="Archive2>(//*[text()='Archive'])[4]";
	public static String archive_checkbox="archive checkbox>//*[text()='Also archive the contacts']";
	public static String archie_input="archiev input>//*[@id='archive-input']";
	public static String archie_text="archiew_text>//div[text()='You are about to archive ']//following::b";
	public static String confirm_archieve="Yes archive list>//*[text()='Yes, archive  list']";
	public static String archive_progress="Archive in progress>//*[text()='Archiving in progress...']";
	
	public static String exportToCSV="Export to CSV>(//span[text()='Export to CSV'])[1]";
	public static String rename="Rename>(//span[text()='Rename'])[1]";
	public static String rename_input="Rename input>//input[@placeholder='Enter contacts list name']";
	public static String rename_confirm_btn="Rename confirm button>//div//button//span[text()='Rename']";
	public static String send_compaign="Send compaign>(//span[text()='Send campaign'])[1]";
	
	// 
	public static String create_segment="Create segment>//*[text()='Create Segment']";
	public static String create_Template="Create Template>//*[text()='Create template']";
	public static String no_Template="No template>//*[text()='No templates created yet']";
	public static String template2="Template 2>(//*[@class='saved-template-container'])[2]";
	
	//bulk
	public static String Campaigns="Campaigns >//*[text()='Campaigns']";
	public static String noCampaign="No Campaign>//*[text()='No campaigns yet']";
	public static String createBulk="Create bulk campaigns>//*[text()='Create bulk campaign']";
	public static String template1="template >(//*[contains(text(),'Template -')])[1]";
	public static String template_1="template >//*[@class='overlay']";
	public static String next="Next>//*[text()='Next']";
	public static String SubjectLine="SubjectLine>//input[@name='subjectLine']";
	public static String pre_headerText="pre header text>//input[@id='input-preHeader']";
	public static String fromName="From Name >//input[@name='fromName']";
	public static String replyTo="ReplyTo>//input[@name='replyTo']";
	public static String checkbox="Checkbox>(//*[@class='ant-checkbox'])[2]";
	public static String Bulk="Bulk>//span[@label='Bulk']";
	public static String contacts="contacts>(//*[text()='View contacts'])[1]";
	public static String table_contact="table>//table[@class='table-wrapper']";
	public static String closeIcon="Close icon>//*[@class='ant-modal-close-x']";
	public static String selectTemp="Select template>(//*[text()='Select Template'])[1]";
	public static String closeIcon_1="Close icon>//*[@data-icon='close']";

	//bulk campaign new 
	public static String notemplate="No template>//*[text()='Create template']";
	public static String temp1="Template1>(//*[@class='saved-template-container'])[1]";
	public static String useTemp="Use this template>//*[text()='Use this template']";
	public static String noThanks_Btn="No thanks button>//*[text()='No, thanks']";
	public static String setUpBtn="SetUp Btn>(//button[@class='button '])[1]";
	public static String Url_input="URL input>(//*[@id='URL-id']//following::input)[1]";
	public static String saveTemp="Save template>//span[text()='Save']";
	public static String back_Btn="Back Button>//*[@class='back-btn']";
	
	public static String personalization="personalization>//*[text()='Personalization']";
    public static String columndrop="check>(//*[@class='ant-select-selection-search-input'])[2]";	
    public static String labelemail="Lable email>(//div[@class='ant-select-item-option-content'])[1]";
    public static String save_btn="Save button>//*[text()='Save']";
    public static String sendCampaign="sendCampaign>//*[text()='Send Campaign']";
    public static String sendNow="send now>//*[text()=' Send now']";
    public static String sendBtn="send now button>//*[text()='Yes, Send it now']";
    public static String refreshNow="Refresh Now>//*[text()='Refresh now']";
    public static String sentperc="Sent percentage>(//*[text()='Sent']//following::div[text()='100'])[1]";
    public static String overview="Overview>//*[text()='Overview']";
    public static String processed="processed>//*[text()='Processed']";
    public static String dashboard="dashboard>//*[text()='Dashboard']";
    public static String table="contacts table>//table[@class='table-wrapper']";
    public static String summary="Summary>//div[text()='Summary']";
    public static String receptienListSec="Receptient list Section>//div[text()='Recipient details']";
    public static String recepListName="Receptient List Name>(//td[@class='ant-table-cell'])[1]";
    
	//replyTo
	//trackdfect1234-ccdfafdfdf05.json
	//gmailautomation-405908-02059e1dbea3.json
	//Gmail locators
	public static String SignIn_gmail="SignIn link in gmail>//*[@data-action='sign in']";
	public static String emailInput_gmail="Email input >//input[@type='email']";
	public static String passwdInput_gmail="Password input field>//input[@type='password']";
	public static String nextBtn_gmail="Next button >//*[text()='Next']";
	
	
	//campaign verification
	public static String sentCount="Sent count>(//div[text()='Sent']//following::div)[1]";
	public static String sentPercent="Sent percentage>(//div[text()='Sent']//following::div)[2]";
	public static String deliverCount="Delivered count>(//div[text()='Delivered']//following::div)[1]";
	public static String deliverPercent="Delivered Percentage>(//div[text()='Delivered']//following::div)[2]";
	public static String openCount="openCount>(//div[text()='Opens']//following::div)[1]";
	public static String openpercent="Open percentage>(//div[text()='Opens']//following::div)[2]";
	public static String clickCount="Click Count>(//div[text()='Clicks']//following::div)[1]";
	public static String clickpercent="Click percentage>(//div[text()='Clicks']//following::div)[2]";
	public static String SubmissionCount="Submission Count>(//div[text()='Clicks']//following::div)[5]";
	public static String Submissionpercent="Submission Percentage>(//div[text()='Clicks']//following::div)[6]";
	public static String unsubscribeCount="Unsubscribe Count>(//div[text()='Unsubscribes']//following::div)[1]";
	public static String unsubscribePercent="Unsubscribe percent>(//div[text()='Unsubscribes']//following::div)[2]";
	public static String bouncedCount="Bounced Count>(//div[text()='Bounced']//following::div)[1]";
	public static String bouncedPercent="Bounced Percentage>(//div[text()='Bounced']//following::div)[2]";
	public static String blockedCount="Blocked Count>(//div[text()='Blocked']//following::div)[1]";
	public static String blockedPercent="Blocked Percentage>(//div[text()='Blocked']//following::div)[1]";
	
	public static String campaign="Recent Campaign>//div[@class='campaign-name']";
	public static String FromName="From Name>(//*[text()='From name']//following::div)[1]";
	//
	public static String contactsList="ContactsList>(//div[@class='action-icons'])[1]";
	public static String segments="Segments>//*[text()='Segments and lists']";
	
	public static String delivered="Delivered>//div[text()='Delivered']";
	//mailinator
	public static String publicinbox = "click on public inbox >//a[@class=\"inbox-link\"]";
	public static String txtboxmail = "write a text box >(//input[@class=\"primary-input\"])";
	public static String gobtn = "Tap on go button >(//button[@onclick=\"subInbox($('#inbox_field').val());\"])";
	
	public static String inboxMailModo="MailModo Inbox>//td[contains(text(),'[Test]')]";
	public static String bactToInbox="back to inbox>//*[contains(text(),'Back to Inbox')]";
	public static String setUpNowLink="Setup Now Link>//a[contains(text(),'Setup now')]";
	
	
	
	//JourneyFlow
	public static String Journey="Journey>//div[@label='Journey']";
	public static String createJourney="Create Journey>//*[text()='Create journey']";
	public static String createFirstJourney="Create first journey>//*[text()='Create your first journey']";
	public static String start_new="Start From Scratch>//*[@class='plus-button']";
	public static String birthday_Mildstone="Birthday / Mildstone>//*[text()='Birthday / Milestones']";
	public static String Use_journey="Use this journey button>//*[text()='Use this journey']";
	public static String preview_1="Preview Birthday journey>(//*[contains(text(),'Birthday')]//following::button)[1]";
	public static String selectSendCampaign="Select send Campaign>(//div[text()='Send campaign'])[1]";
	public static String webHook="Webhook>(//div[text()='Webhook'])[1]";
	public static String webHook2="WebHook2>(//div[text()='Webhook'])[2]";
	
	
	public static String from_Name="From name Value>//*[@label='From Name']";
	public static String replyToMail="Reply to mail>//*[@label='Reply To Email']";
	public static String senderEmail="SenderEmailSelect>//*[text()='Sender Email']//following::span[@class='ant-select-selection-item']";
	//public static String selectMail="Select sender mail>";//Win Back Flow
	public static String win_Back_Flow="Win Back Flow>//*[text()='Win Back Flow']";
	public static String winBack_preview="Win back flow preview>(//*[contains(text(),'Win Back')]//following::button)[1]";
    public static String publish_Btn="Publish Button>//*[text()='Publish']";
	public static String manual_Triger="Manual triger>//*[text()='Manual trigger']";
	public static String selectTriger="Select manual triger>//*[text()='Specific Contacts']";
	public static String Save_Btn="Save button>//*[text()='Save']";
	public static String tabSize="TabSize>(//*[@tabindex='0'])[5]";
    
	public static String dragPoint_1="Drag point 1>//div[@data-node-id='triggerNode']";
	public static String webhook_point1="WebHook Point 1>(//div[contains(@data-node-id,'-')])[1]";
	public static String webhook_point2="WebHook point 2>(//div[contains(@data-node-id,'-')])[2]";
	public static String exist_point="ExistPoint>(//div[contains(@data-node-id,'-')])[3]";
	public static String selectExit="Select Exit>(//*[text()='Exit journey'])[1]";
	public static String webHookURL_Input="Webhook Url Input>//input[@name='Webhook URL']";
	public static String publish_journey_Popup="Publish journey>//*[text()='Publish Journey']";
	public static String publishBtn_popup="Publish button in popup>//span[text()='Publish']";
	
	public static String enroll_Btn="Enroll button>//span[text()='Enroll']";
	public static String startJourney="Start journey>//*[text()='Start Journey']";
	public static String selectContactList="Select Contact List>(//*[@class='ant-checkbox-wrapper'])[2]";
	public static String startJourney_Btn="Start Journey Button>//span[text()='Start Journey']";
	public static String activity="Activity log>//*[text()='Activity logs']";
	public static String sentContactList="Sent contacts List>//td[contains(text(),'@mailinator.com')]";
	public static String sentContactList1="Sent contacts List>(//td[contains(text(),'@mailinator.com')])[1]";
	
	public static String webHook_Url_copy="WebHook Data>(//*[text()='Your unique URL']//following::code)[1]";
	public static String webhook_requestList="Request Lists>//*[@class='ng-binding ng-scope']";
	public static String requestDetails="Request details>//*[contains(text(),'Request Details')]";
	public static String rawContents="Raw contents>(//*[contains(text(),'Raw Content')]//following::pre)[1]";
	
	//contactsVerification
	public static String ListName="Contacts List Name>//*[@fill-rule='evenodd']//preceding::div[@class='segment-name-col' and position()=1]";
	public static String nextPageArrow="Next Page Arrow>//*[@title='Next Page' and @aria-disabled='false']";
	public static String listSegment="List/Segment>//*[text()='List/Segment']";
	public static String AddContactTrigger="Add contact in trigger>//*[text()='Contact added to a list']";
	public static String selectList="Select List>//*[@class='ant-select-selection-search']";
	public static String contactsInTrigger1="Contacts in trigger>//*[@class='rc-virtual-list-holder']/div";
	public static String contactsInTrigger="Contacts in trigger>//*[@class='ant-select-item-option-content']";
	public static String contactsInTrigger2="Contacts in trigger>(//*[@class='ant-select-item-option-content'])[2]";

	public static String deletedList="Deleted List name>//*[@fill-rule='evenodd']//preceding::div[@class='segment-name-col' and position()=1]";
	public static String deleteListMoreIcon="Delete List moreIcon>((//*[@fill-rule='evenodd']//preceding::div[@class='segment-name-col' and position()=1])//following::div[contains(@class,'ant-dropdown-trigger')])[1]";
	public static String contactMailInput="Mail Input>(//*[text()='Email Address']//following::input)[1]";
	
	public static String triggerCheckBox="Trigger check box>//*[text()='Trigger journey for existing contacts in the list']";
	
}
