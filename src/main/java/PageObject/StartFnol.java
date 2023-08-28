package PageObject;

import BaseClass.BasePage;
import BaseClass.PageDriver;
import Utility.RandomNames;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class StartFnol extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"hlc.json";

    String TestData = new ReadJSonData().Read_the_value_from_json(path,"Chat");
    String Email = new ReadJSonData().Read_the_value_from_json(path,"CsrUsername");
    String Phone = new ReadJSonData().Read_the_value_from_json(path,"Phone");
    WebDriver driver;
    public StartFnol(WebDriver driver) throws IOException, ParseException {
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    /*
        Start FNOL Web
     */
    By Start_FNOl_tab = By.xpath("//span[normalize-space()='Start FNOL Web']");
    By PlayButton = By.xpath("//div[@role='banner']/button");


    /*
        Drop Down
     */
    By DropDown = By.xpath("//div[starts-with(@id,'mat-select-value')]");
    By DropDownValue = By.xpath("//div[@role='listbox']/mat-option[2]/span");

    /*
        Input Text
     */

    By TextInput = By.xpath("//input[starts-with(@id,'mat-input')]");

    /*
        Next Button
     */
    By NextButton = By.xpath("//span[normalize-space()='Next']");

    /*
        Participant flow
     */

    By participant1 = By.xpath("//mat-icon[@class='mat-icon notranslate material-icons ng-trigger ng-trigger-fabToggler mat-icon-no-color']");
    By Participant2 = By.xpath("//mat-icon[normalize-space()='mail_outline']");

    By FirstName = By.xpath("//input[@formcontrolname='firstName']");
    By LastName = By.xpath("//input[@formcontrolname='lastName']");
    By EmailAddress = By.xpath("//input[@data-placeholder='Enter Email Address']");
    By SendNow = By.xpath("//span[normalize-space()='SEND NOW']");



    public void Start_FNOL(){
        click(Start_FNOl_tab);
        WaitForPresenceOfElement(PlayButton,10);
        click(PlayButton);
        WaitForPresenceOfElement(NextButton,10);
    }
    public void Go_to_Drop_Down(){
        click(DropDown);
        WaitForPresenceOfElement(DropDownValue,10);
        click(DropDownValue);
        click(NextButton);
    }

    public void Go_Input_Text(){
        WaitForPresenceOfElement(NextButton,10);
        type(TextInput,TestData);
        click(NextButton);
    }

    public void Go_Input_Email(){
        WaitForPresenceOfElement(NextButton,10);
        type(TextInput,Email);
        click(NextButton);
    }

    public void Go_Phone_Number(){
        WaitForPresenceOfElement(NextButton,10);
        type(TextInput,Phone);
        click(NextButton);
    }

    public void Go_to_Policy_Number(){
        WaitForPresenceOfElement(NextButton,10);
        type(TextInput,Phone);
        click(NextButton);
    }

    public void Go_to_Participant(){
        click(participant1);
        WaitForPresenceOfElement(Participant2,10);
        click(Participant2);
        WaitForPresenceOfElement(SendNow,10);
        type(FirstName,new RandomNames().GenerateFirstName());
        type(LastName,new RandomNames().GenerateLastName());

        click(DropDown);
        WaitForPresenceOfElement(DropDownValue,10);
        click(DropDownValue);
        type(EmailAddress,Email);
        click(SendNow);
    }





}
