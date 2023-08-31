package tests.LoginPage;

import org.Elements.LoginUserComponents;
import org.SeleniumUtitlies.PageLevelMethods;
import org.SeleniumUtitlies.WebElementMethods;
import org.Setup.BaseSetup;
import org.TestngUtilities.RetryFunctionality;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseSetup {
    @Test(retryAnalyzer = RetryFunctionality.class)
    public void loginPage_Test() {
        var loginUserComponents = new LoginUserComponents();
        WebElementMethods.enterTheValue(loginUserComponents.getUserNameTxtBox(), "standard_user");
        WebElementMethods.enterTheValue(loginUserComponents.getPasswordTxtBox(), "secret_sauce");
        WebElementMethods.clickTheElement(loginUserComponents.getLoginButton());
        Assert.assertTrue(PageLevelMethods.getPageUrl().contains("inventory1"));
    }


}
