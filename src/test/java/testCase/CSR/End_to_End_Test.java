package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import helper.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class End_to_End_Test extends TestBase {

    @Parameters({"policySearch"})
    @Test
    public void SearchPolicy(String policySearch) throws InterruptedException, IOException, ParseException {
        PolicySearchTab policy = new PolicySearchTab(driver);
        policy.Go_to_NeedsRequirement(policySearch);
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
        approve.Go_to_Terminate_and_Pay();
        policy.Go_to_Settled_PolicySearch(policySearch);
    }
}
