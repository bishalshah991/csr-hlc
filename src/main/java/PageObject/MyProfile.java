package PageObject;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import Utility.RandomNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyProfile extends BasePage {
    WebDriver driver;

    public MyProfile(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By MyProfile = By.xpath("//span[normalize-space()='My Profile']");
    By My_Profile_info = By.xpath("//div[contains(text(),'My Profile Info')]");

    By FirstName = By.xpath("//input[@data-placeholder='First Name']");
    By MiddleName = By.xpath("//input[@data-placeholder='Middle Name']");
    By LastName = By.xpath("//input[@data-placeholder='Last Name']");
    By Title = By.xpath("//input[@data-placeholder='Title']");
    By SaveButton = By.xpath("//mat-icon[normalize-space()='check_circle']");

    By Alert = By.xpath("//p[normalize-space()='Your profile has been updated successfully.']");
    By CloseButton = By.xpath("//button[@type='button']");

    public void Go_to_Profile(){
        click(new LoginPage(driver).LogOut);
        WaitForPresenceOfElement(MyProfile,10);
        click(MyProfile);
        WaitForPresenceOfElement(My_Profile_info,10);
    }

    public void Enter_Detail_Profile(){
        clearTextBox(FirstName);
        type(FirstName,new RandomNames().GenerateFirstName());
        clearTextBox(LastName);
        type(FirstName,new RandomNames().GenerateLastName());
        click(SaveButton);
        WaitForPresenceOfElement(Alert,10);
        WaitForPresenceOfElement(CloseButton,10);
        click(CloseButton);
    }


}
