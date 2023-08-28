package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import PageObject.MyProfile;
import org.testng.annotations.Test;

public class My_Profile_Test extends TestBase {

    @Test
    public void Update_My_Profile(){
        MyProfile profile = new MyProfile(driver);
        profile.Go_to_Profile();
        profile.Enter_Detail_Profile();
        new LoginPage(driver).Log_out_from_application();
        WaitForPresenceOfElement(new LoginPage(driver).LoginButton,10);
    }
}
