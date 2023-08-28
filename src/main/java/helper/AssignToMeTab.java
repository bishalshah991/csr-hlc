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

public class AssignToMeTab extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"hlc.json";
    WebDriver driver;
    public AssignToMeTab(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By Assign_to_me = By.xpath("//div[normalize-space()='ASSIGN TO ME']");
    By Confirm_Button = By.xpath("//span[normalize-space()='CONFIRM']");
    By NeedsRequirement = By.xpath("//div[normalize-space()='NEW REQUIREMENT DOC']");
    /*
        Claim Tag
     */
    By ClaimTag = By.xpath("//div[normalize-space()='CLAIM TAG']");
    By UserTag = By.xpath("//input[@role='combobox']");
    By TextNote = By.xpath("//span[normalize-space()='Notes']");

    By TagReason = By.xpath("//textarea[@id='ClaimTagReason']");
    By ClaimConfirmButton = By.xpath("//div[starts-with(@class,'mat-dialog-actions')]/button[1]/span[1]");
    /*
        Approve
     */
    By ApproveTab = By.xpath("//div[normalize-space()='APPROVE']");

    public void Go_to_Assign_to_me(){
        WaitForPresenceOfElement(Assign_to_me,10);
        click(Assign_to_me);
        WaitForPresenceOfElement(Confirm_Button,10);
        click(Confirm_Button);
        WaitForPresenceOfElement(Confirm_Button,10);
    }

    public void Go_to_ClaimTag() throws IOException, ParseException, InterruptedException {
        WaitForPresenceOfElement(ClaimTag,10);
        click(ClaimTag);
        WaitForPresenceOfElement(ClaimConfirmButton,10);
        click(UserTag);
        WaitForPresenceOfElement(TextNote,10);
        click(TextNote);

        String TestData = new ReadJSonData().Read_the_value_from_json(path,"Chat");
        type(TagReason,TestData);
        click(ClaimConfirmButton);
        Thread.sleep(10000);
    }
}
