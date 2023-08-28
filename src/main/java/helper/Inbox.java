package helper;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Inbox extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"hlc.json";
    WebDriver driver;
    public Inbox(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    public By Inbox = By.xpath("//div[normalize-space()='INBOX']");
    By TextMessageRead = By.xpath("//span[contains(text(),'Select a message to read')]");
    By OutBox = By.xpath("//div[contains(text(),'Outbox')]");
    By TextOutbox = By.xpath("//span[contains(text(),'Select a message to read')]");

    /*
        Additional Info
     */

    public By AdditionalInfo = By.xpath("//div[normalize-space()='ADDITIONAL INFO']");
    By TextAdditionalField = By.xpath("//th[normalize-space()='ADDITIONAL FIELDS']");

    /*
        Back Button
     */

    By BackButton = By.xpath("//div[normalize-space()='BACK']");

    /*
        Event Log
     */

    public By EventLog = By.xpath("//div[normalize-space()='EVENT LOGS']");
    By TextCreated = By.xpath("//th[normalize-space()='Created On']");
    By TextCaseLoad = By.xpath("//th[normalize-space()='Caseload Status']");

    /*
        Customer Support
     */
    By CustomerSupport = By.xpath("//div[normalize-space()='CUSTOMER SUPPORT']");
    By TypeYourMessage = By.xpath("//textarea[@placeholder='Type your message']");
    By SendButton = By.xpath("//mat-icon[normalize-space()='send']");
    By TextMessage = By.xpath("//div[@id='chat-content']/div[1]/div/div/div[1]");


    public void Inbox() throws InterruptedException {
        click(Inbox);
        Thread.sleep(5000);
        click(OutBox);
        Thread.sleep(5000);
    }

    public void Go_Additional_Info() throws InterruptedException {
        click(AdditionalInfo);
        WaitForPresenceOfElement(TextAdditionalField,10);
        Thread.sleep(5000);
        click(BackButton);
        WaitForPresenceOfElement(TextMessageRead,10);
        Thread.sleep(5000);
    }

    public void Go_to_Event_Log() throws InterruptedException {
        click(EventLog);
        Thread.sleep(10000);
        click(BackButton);
        WaitForPresenceOfElement(AdditionalInfo,10);
        WaitForPresenceOfElement(OutBox,10);
    }

    public void Go_Customer_Support() throws IOException, ParseException {
        click(CustomerSupport);
        WaitForPresenceOfElement(TypeYourMessage,10);
        String TestData = new ReadJSonData().Read_the_value_from_json(path,"Chat");
        type(TypeYourMessage,TestData);
        click(SendButton);
        WaitForPresenceOfElement(TextMessage,10);
        click(BackButton);
        WaitForPresenceOfElement(TextMessageRead,10);
        click(BackButton);
        WaitForPresenceOfElement(AdditionalInfo,10);
        WaitForPresenceOfElement(EventLog,10);
    }

    public void ClickBackButton(){
        click(BackButton);
        WaitForPresenceOfElement(Inbox,10);
        WaitForPresenceOfElement(EventLog,10);
    }

}
