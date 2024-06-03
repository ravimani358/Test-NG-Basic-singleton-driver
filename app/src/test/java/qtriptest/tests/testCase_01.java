package qtriptest.tests;

import qtriptest.DP;
import qtriptest.pages.Browser;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import com.beust.jcommander.Parameters;
import org.testng.annotations.Test;


public class testCase_01 extends Browser {

    @Test(dataProvider = "getdata", dataProviderClass= DP.class)
    public void TestCase01(String UserName, String Password) throws InterruptedException, MalformedURLException {
        HomePage Home_action = new HomePage();
        Home_action.Home_register_button();
        RegisterPage register = new RegisterPage();
        register.verify_register_page();
        register.register_new_user(UserName, Password, Password, true);
        register.register_button();
        LoginPage Login_action = new LoginPage();
        String oldUserName = register.lastGeneratedUserName;
        Login_action.enter_credentials(oldUserName,Password);
        HomePage home_page = new HomePage();
        home_page.successful_login();
        home_page.logout_button();
        home_page.successful_logout();
    }
}