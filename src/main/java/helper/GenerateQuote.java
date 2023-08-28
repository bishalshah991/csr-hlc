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

public class GenerateQuote extends BasePage {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"hlc.json";


    WebDriver driver;
    public GenerateQuote(WebDriver driver){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By GenerateQuoteTab = By.xpath("//div[@class='action-button-title']");
    By GenerateQuoteButton = By.xpath("//span[contains(text(),'GENERATE QUOTE')]");

    /*
    Cause of Death
     */
    By None_Selected = By.xpath("//div[starts-with(@id,'mat-select-value')]");
    By Cause_of_Death = By.xpath("//div[@role='listbox']/mat-option");

    By TextNatural = By.xpath("//span[contains(text(),'NATURAL')]");

    /*
        Funeral Amount
     */

    By FuneralAmount = By.xpath("//input[@id='funeralAmount']");

    /*
        Date of Death
     */
    By Date_of_Death = By.xpath("//input[@id='v_datDeath']");

    /*
        Start Claim
     */

    By StartClaimButton = By.xpath("//span[normalize-space()='START CLAIM']");
    /*
        Radio Button
     */

    By RadioButton = By.xpath("//div[starts-with(@class,'ng-untouched ng-pristine ng-invalid ng-star-inserted')]/mat-radio-group/mat-radio-button[1]/label/span[2]");


    public void Wait_for_Generate_Quote(){
        WaitForPresenceOfElement(GenerateQuoteTab,10);
        click(GenerateQuoteTab);
        WaitForPresenceOfElement(GenerateQuoteButton,10);
        WaitForPresenceOfElement(Date_of_Death,10);
    }

    public void Enter_Cause_Death(){
        click(None_Selected);
        WaitForPresenceOfElement(TextNatural,10);
        for (int i=0; i<=getEls(Cause_of_Death).size();i++)
        {
            if (getEls(Cause_of_Death).get(i).getText().contains(GetText(TextNatural))){
                getEls(Cause_of_Death).get(i).click();
                break;
            }
        }
    }

    public void PickRadioButton(){
        ClickElementIsDisplayed(RadioButton);
    }

    public void Enter_Funeral_Amount() throws IOException, ParseException {
        String TestData = new ReadJSonData().Read_the_value_from_json(path,"FuneralAmount");
        String TestData1 = new ReadJSonData().Read_the_value_from_json(path,"Date_of_Birth");
        verifyElementPresent(FuneralAmount,TestData,Date_of_Death,TestData1);
    }

    public void Enter_Date_Death() throws IOException, ParseException {
        String TestData = new ReadJSonData().Read_the_value_from_json(path,"FuneralAmount");
        CheckElementIsDisplayed(FuneralAmount,TestData);
    }

    public void Click_Generate_Quote_Button(){
        click(GenerateQuoteButton);
        WaitForPresenceOfElement(StartClaimButton,10);
        click(StartClaimButton);
    }

}
