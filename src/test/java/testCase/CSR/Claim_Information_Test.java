package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import helper.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Claim_Information_Test extends TestBase {

    @Parameters({"username","password"})
    @Test(priority = 1)
    public void Login_to_application(String username,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login_to_application(username +".com",password);
    }
    @Parameters({"policySearch"})
    @Test(priority = 2)
    public void SearchPolicy(String policySearch) throws InterruptedException, IOException, ParseException {
        PolicySearchTab policy = new PolicySearchTab(driver);
        policy.Go_to_Policy_Search(policySearch);
        policy.Go_to_Action();
        GenerateQuote generateQuote = new GenerateQuote(driver);
        generateQuote.Wait_for_Generate_Quote();
        generateQuote.Enter_Cause_Death();
        generateQuote.PickRadioButton();
        generateQuote.Enter_Funeral_Amount();
        generateQuote.Enter_Date_Death();
        generateQuote.Click_Generate_Quote_Button();
        ClaimInformation claimInformation = new ClaimInformation(driver);
        claimInformation.Wait_For_ClaimInformation();
        claimInformation.Enter_Claim_type();
        claimInformation.Enter_Spoke_with();
        claimInformation.Relationship();
        claimInformation.EnterPhoneNumber();
        claimInformation.Insured_Date_of_Birth();
        claimInformation.Click_Accept_Button();
    }
}
