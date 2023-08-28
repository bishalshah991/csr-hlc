package testCase.CSR;

import BaseClass.TestBase;
import PageObject.LoginPage;
import PageObject.StartFnol;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class StartFNOLTest extends TestBase {

    @Parameters({"username","password"})
    @Test
    public void StartIntakeTest(String username,String password) throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login_to_application(username +".com",password);
        StartFnol startFnol = new StartFnol(driver);
        startFnol.Start_FNOL();
        startFnol.Go_to_Drop_Down();
        startFnol.Go_Input_Text();
        startFnol.Go_Input_Email();
        startFnol.Go_Phone_Number();
        startFnol.Go_to_Policy_Number();
        startFnol.Go_to_Drop_Down();
        startFnol.Go_to_Participant();
    }

}
