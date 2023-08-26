package org.LoginPage;

import org.Elements.LoginUserComponents;
import org.SeleniumUtitlies.WebElementMethods;
import org.Setup.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseSetup {
    @Test
    public void demoRun(){
       var loginUserComponents =new LoginUserComponents();
        WebElementMethods.enterTheValue(loginUserComponents.getUserNameTxtBox(),"Doyce Forest");
        WebElementMethods.enterTheValue(loginUserComponents.getPasswordTxtBox(),"ParaBank");
        WebElementMethods.clickTheElement(loginUserComponents.getLoginButton());
        Assert.assertEquals(WebElementMethods.getPageTitle(),"ParaBank | Accounts Overview");
    }


}
