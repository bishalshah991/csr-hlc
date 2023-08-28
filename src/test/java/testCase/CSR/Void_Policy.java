package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import helper.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class Void_Policy extends TestBase {

    @Parameters({"username","password"})
    @Test(priority = 1)
    public void Login_to_application(String username,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login_to_application(username +".com",password);
    }
    @Parameters({"policySearch1"})
    @Test(priority = 2)
    public void SearchPolicy(String policySearch1) throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        PolicySearchTab policy = new PolicySearchTab(driver);
        policy.Go_to_Policy_Search(policySearch1);
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
        policy.Go_to_NeedsRequirement(policySearch1);
        ViewCheckList viewCheckList = new ViewCheckList(driver);
        viewCheckList.go_to_View_checklist();
        viewCheckList.go_inbox();
        Inbox inbox = new Inbox(driver);
        inbox.Inbox();
        AddBeneficiary addBeneficiary = new AddBeneficiary(driver);
        addBeneficiary.go_Beneficiary_tab();
        addBeneficiary.Create_Note();
        addBeneficiary.CloseIcon();
        inbox.Go_Additional_Info();
        inbox.Go_to_Event_Log();
        inbox.Go_Customer_Support();
        viewCheckList.go_to_View_checklist();
        FileUpload fileUpload = new FileUpload();
        fileUpload.Upload_file();
        fileUpload.Get_match_this();
        fileUpload.Go_View_Button();
        AssignToMeTab assignToMeTab = new AssignToMeTab(driver);
        assignToMeTab.Go_to_Assign_to_me();
        assignToMeTab.Go_to_ClaimTag();
        Approve approve = new Approve(driver);
        approve.Go_to_Approve();
        approve.Void_the_Policy();
        policy.Go_to_void_PolicySearch(policySearch1);
        new LoginPage(driver).Log_out_from_application();
        WaitForPresenceOfElement(new LoginPage(driver).LoginButton,10);
    }
}
