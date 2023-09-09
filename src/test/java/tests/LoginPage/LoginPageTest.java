package tests.LoginPage;

import org.Elements.LoginUserComponents;
import org.Setup.BaseSetup;
import org.TestngUtilities.RetryFunctionality;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseSetup {
    @Test(retryAnalyzer = RetryFunctionality.class)
    public void loginPage_Test() {
        var loginUserComponents = new LoginUserComponents();
        loginUserComponents.getUserNameTxtBox().enterTheValue("standard_user");
        loginUserComponents.getPasswordTxtBox().enterTheValue("secret_sauce");
        loginUserComponents.getLoginButton().clickThElement();
    }


}
