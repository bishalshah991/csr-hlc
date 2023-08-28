package helper;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Approve extends BasePage {
    WebDriver driver;
    public Approve(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By ApproveTab = By.xpath("//div[normalize-space()='APPROVE']");
    By ApproveConfirmButton = By.xpath("//span[normalize-space()='CONFIRM']");

    /*
        Payment
     */

    By PaymentTab = By.xpath("//div[normalize-space()='PAYMENT']");
    By TerminateAndPay = By.xpath("//div[normalize-space()='TERMINATE & PAY']");
    By MarkSettled = By.xpath("//div[contains(text(),'MARK SETTLED')]");

    By TerminateConfirmButton = By.xpath("//span[normalize-space()='CONFIRM']");

    /*
        Export Claim Packet
     */

    By ExportClaimPacket = By.xpath("//*[@id='caseload']/fuse-action-panel/div/div/div[2]/button[7]/span[1]/mat-icon");
    By Download = By.xpath("//*[@id='mat-dialog-5']/fuse-claim-packet-dialog/div/table/tbody/tr[1]/td[4]/button[2]/span[1]/mat-icon");

    /*
        Void The Policy
     */

    By VoidPolicy = By.xpath("//div[contains(text(),'VOID')]");
    By VoidConfirm = By.xpath("//span[contains(text(),'CONFIRM')]");
    By VoidReason = By.xpath("//textarea[@id='reason']");
    public void Go_to_Approve(){
        WaitForPresenceOfElement(ApproveTab,10);
        click(ApproveTab);
        WaitForPresenceOfElement(ApproveConfirmButton,10);
        click(ApproveConfirmButton);
        WaitForPresenceOfElement(new Inbox(driver).Inbox,10);
        WaitForPresenceOfElement(new Inbox(driver).AdditionalInfo,10);
        WaitForPresenceOfElement(new Inbox(driver).EventLog,10);
    }

    public void Go_to_Terminate_and_Pay() throws InterruptedException {
        WaitForPresenceOfElement(PaymentTab,10);
        click(PaymentTab);
        WaitForPresenceOfElement(TerminateAndPay,10);
        WaitForPresenceOfElement(new Inbox(driver).Inbox,10);
        click(TerminateAndPay);
        WaitForPresenceOfElement(TerminateConfirmButton,10);
        click(TerminateConfirmButton);
        Thread.sleep(25000);
        WaitForPresenceOfElement(new Inbox(driver).Inbox,10);
        WaitForPresenceOfElement(new Inbox(driver).AdditionalInfo,10);
        WaitForPresenceOfElement(new Inbox(driver).EventLog,10);
    }

    public void Go_to_Export_Claim_Packet() throws InterruptedException {
        WaitForPresenceOfElement(ExportClaimPacket,10);
        click(ExportClaimPacket);
        WaitForPresenceOfElement(Download,10);
        click(Download);
        Thread.sleep(15000);
        WaitForPresenceOfElement(new Inbox(driver).Inbox,10);
        WaitForPresenceOfElement(new Inbox(driver).AdditionalInfo,10);
        WaitForPresenceOfElement(new Inbox(driver).EventLog,10);
    }

    public void Void_the_Policy(){
        WaitForPresenceOfElement(VoidPolicy,10);
        click(VoidPolicy);
        WaitForPresenceOfElement(VoidConfirm,10);
        type(VoidReason,"This is a not a valid");
        click(VoidConfirm);
        WaitForPresenceOfElement(new Inbox(driver).EventLog,10);


    }
}
