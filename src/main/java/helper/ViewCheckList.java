package helper;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewCheckList extends BasePage {
    WebDriver driver;
    public ViewCheckList(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By viewChecklist = By.xpath("//div[normalize-space()='VIEW CHECKLIST']");

    public void go_to_View_checklist() throws InterruptedException {
        WaitForPresenceOfElement(viewChecklist,10);
        click(viewChecklist);
        WaitForPresenceOfElement(new Inbox(driver).Inbox,10);
        Thread.sleep(3000);
        WaitForPresenceOfElement(new AddBeneficiary(driver).BeneficiaryTab,10);
    }
    public void go_inbox(){
        click(new Inbox(driver).Inbox);
    }
}
