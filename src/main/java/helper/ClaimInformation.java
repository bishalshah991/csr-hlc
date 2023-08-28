package helper;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ClaimInformation extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"hlc.json";
    WebDriver driver;
    public ClaimInformation(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By ClaimType = By.xpath("(//div[starts-with(@id,'mat-select-value')])[1]");
    By ClaimTypeList = By.xpath("//div[@role='listbox']/mat-option/span");
    By TextClaimType = By.xpath("(//span[contains(text(),'Phone')])[2]");
    By TextPhone = By.xpath("(//div[starts-with(@id,'mat-select-value')])[1]");
    By SpokeWith = By.xpath("//input[@id='spoke_with']");
    By Relationship = By.xpath("(//div[starts-with(@id,'mat-select-value')])[2]");
    By RelationshipList = By.xpath("//div[@role='listbox']/mat-option/span");
    By TextAttorney = By.xpath("//span[contains(text(),'Attorney ')]");
    By PhoneNumber = By.xpath("//input[@id='phone_number']");
    By Date_of_Birth = By.xpath("//input[@id='user_provided_insured_date_of_birth']");
    By CheckBox = By.xpath("//span[@class='mat-checkbox-inner-container']");
    By AcceptButton = By.xpath("//span[contains(text(),'ACCEPT')]");
    By StartClaimButton = By.xpath("//span[normalize-space()='SUBMIT CLAIM']");
    By Initiated = By.xpath("(//div[contains(text(),'Initiated')])[1]");
    By Inbox = By.xpath("//div[contains(text(),'INBOX')]");

    public void Wait_For_ClaimInformation(){
        WaitForPresenceOfElement(ClaimType,10);
        WaitForPresenceOfElement(SpokeWith,10);
        WaitForPresenceOfElement(Relationship,10);
    }

    public void Enter_Claim_type(){
        click(ClaimType);
        for (WebElement element : getEls(ClaimTypeList)){
            if (element.getAttribute("innerHTML").contains(GetText(TextClaimType))){
                element.click();
            }
        }
    }

    public void Enter_Spoke_with() throws IOException, ParseException {
        String textData = new ReadJSonData().Read_the_value_from_json(path,"SpokeWith");
        type(SpokeWith,textData);
    }

    public void Relationship(){
        click(Relationship);
        WaitForPresenceOfElement(TextAttorney,10);
        for (WebElement element : getEls(RelationshipList)){
            if (element.getAttribute("innerHTML").contains(GetText(TextAttorney))){
                element.click();
            }
        }
    }
    public void EnterPhoneNumber() throws IOException, ParseException {
        String TestData = new ReadJSonData().Read_the_value_from_json(path,"PhoneNumber");
        type(PhoneNumber,TestData);
        tab(PhoneNumber);
    }

    public void Insured_Date_of_Birth() throws IOException, ParseException {
        String TestData = new ReadJSonData().Read_the_value_from_json(path,"Date_of_Birth");
        type(Date_of_Birth,TestData);
    }

    public void Click_Accept_Button() throws InterruptedException {
        click(CheckBox);
        click(AcceptButton);
        WaitForPresenceOfElement(StartClaimButton,10);
        click(StartClaimButton);
        WaitForPresenceOfElement(Initiated,10);
        WaitForPresenceOfElement(Inbox,10);
        Thread.sleep(15000);
    }
}
