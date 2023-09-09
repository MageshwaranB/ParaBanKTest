package tests.productpage;

import org.Elements.InventoryPageComponents;
import org.Elements.LoginUserComponents;
import org.SeleniumUtitlies.FilterOperations;
import org.SeleniumUtitlies.SeleniumMethods;
import org.Setup.BaseSetup;
import org.TestngUtilities.RetryFunctionality;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_TShirt_15DollarOrMore_Test extends BaseSetup {
    @Test(retryAnalyzer = RetryFunctionality.class)
    public void addingTshirts_Test(){
        var loginUserComponents = new LoginUserComponents();
        var inventoryComponents=new InventoryPageComponents();
        loginUserComponents.getUserNameTxtBox().enterTheValue("standard_user");
        loginUserComponents.getPasswordTxtBox().enterTheValue("secret_sauce");
        loginUserComponents.getLoginButton().clickThElement();
        Assert.assertTrue(SeleniumMethods.getPageUrl().contains("inventory"));
        SeleniumMethods.filterByPriceWithAction(inventoryComponents.getPrices(), FilterOperations.ADDTOCART.getValue(),15);
        Assert.assertEquals(
                (long) SeleniumMethods.filterByPriceWithAction(inventoryComponents.getPrices(),
                        FilterOperations.TOTALCOUNT.getValue(), 15).size(),4);
        }
}
