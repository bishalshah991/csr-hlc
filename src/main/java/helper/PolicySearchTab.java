package helper;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PolicySearchTab extends BasePage {

    WebDriver driver;
    public PolicySearchTab(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By PolicySearchTab = By.xpath("//span[normalize-space()='Policy Search']");
    By PolicySearchTextBox = By.xpath("//input[@id='searchInput']");

    By TextActive = By.xpath("//div[contains(text(),'Active')]");
    By TextNeedsRequirement = By.xpath("//div[contains(text(),'Needs Requirement')]");
    By TextSettled = By.xpath("//div[contains(text(),'Settled')] ");
    By TextVoid = By.xpath("//div[contains(text(),'Voided')]");

    By ThreeDots = By.xpath("//mat-icon[normalize-space()='more_horiz']");

    By BeginClaim = By.xpath("//span[normalize-space()='Begin Claim']");

    By ViewDetail = By.xpath("//span[contains(text(),'View Details')]");

    public void Go_to_Policy_Search(String policyNumber){
        click(PolicySearchTab);
        WaitForPresenceOfElement(PolicySearchTextBox,10);
        type(PolicySearchTextBox,policyNumber);
        WaitForPresenceOfElement(TextActive,10);
    }

    public void Go_to_Action() throws InterruptedException {
        click(ThreeDots);
        WaitForPresenceOfElement(BeginClaim,10);
        click(BeginClaim);
        Thread.sleep(10000);
    }

    public void Go_to_NeedsRequirement(String policyNumber) throws InterruptedException {
        click(PolicySearchTab);
        WaitForPresenceOfElement(PolicySearchTextBox,10);
        type(PolicySearchTextBox,policyNumber);
        WaitForPresenceOfElement(TextNeedsRequirement,10);
        click(ThreeDots);
        click(ViewDetail);
        Thread.sleep(10000);
    }

    public void Go_to_Settled_PolicySearch(String policyNumber){
        click(PolicySearchTab);
        WaitForPresenceOfElement(PolicySearchTextBox,10);
        type(PolicySearchTextBox,policyNumber);
        WaitForPresenceOfElement(TextSettled,10);
    }

    public void Go_to_void_PolicySearch(String policyNumber){
        click(PolicySearchTab);
        WaitForPresenceOfElement(PolicySearchTextBox,10);
        type(PolicySearchTextBox,policyNumber);
        WaitForPresenceOfElement(TextVoid,10);
    }



}
