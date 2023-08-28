package helper;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileUpload extends TestBase {
    WebDriver driver;
    public FileUpload(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By Document = By.xpath("//input[@type='file']");
    By MatchThis = By.xpath("//span[contains(text(),'Match This')]");
    By SaveButton = By.xpath("//span[contains(text(),'Save')]");
    By TextCompleted = By.xpath("//div[contains(text(),'Completed')]");
    By TextUploaded = By.xpath("//div[contains(text(),'Uploaded')]");
    By TextInbox = By.xpath("//div[normalize-space()='INBOX']");

    /*
        View Tab
     */

    By ViewButton = By.xpath("(//span[contains(text(),'VIEW')])[1]");
    By ViewClose = By.xpath("//button[@aria-label='Close dialog']/span[1]");
    By CrossIcon = By.xpath("//*[@id='doctracks']/div/div[3]/button[2]/span[1]/mat-icon");

    By SaveButton1 = By.xpath("//div[@class='nav']/div/button/span[1]/mat-icon");


    public void Upload_file(){
        DocumentUpload(Document);
        WaitForPresenceOfElement(MatchThis,10);
        WaitForPresenceOfElement(SaveButton,10);
    }

    public void Get_match_this() throws InterruptedException {
        Thread.sleep(10000);
        int count = getEls(MatchThis).size();
        System.out.println("Total Count :- "+count);
        for (int i = 1;i<=count;i++){
            driver.findElement(By.xpath("//div[@fxlayoutalign='center']/div["+i+"]/div/div[3]/button"))
                    .click();
            Thread.sleep(2000);
        }
        Thread.sleep(10000);
        click(SaveButton);
        Thread.sleep(10000);
        WaitForPresenceOfElement(ViewButton,10);
        WaitForPresenceOfElement(TextCompleted,10);
        WaitForPresenceOfElement(TextUploaded,10);
        WaitForPresenceOfElement(TextInbox,10);
    }

    public void Go_View_Button() throws InterruptedException {
        click(ViewButton);
        Thread.sleep(20000);
        WaitForPresenceOfElement(ViewClose,10);
        Thread.sleep(5000);
        ClickElementIsDisplayed(CrossIcon);
        Thread.sleep(5000);
        ClickElementIsDisplayed(SaveButton1);
        //click(SaveButton1);
        Thread.sleep(10000);
    }
}
