package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Page_test extends TestBase {

    @Parameters({"username","password"})
    @Test
    public void Login_to_application_test(String username,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login_to_application(username +".com",password);
        loginPage.Log_out_from_application();
    }
}
