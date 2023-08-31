package tests.productpage;

import org.Elements.InventoryPageComponents;
import org.Elements.LoginUserComponents;
import org.SeleniumUtitlies.FilterOperations;
import org.SeleniumUtitlies.PageLevelMethods;
import org.SeleniumUtitlies.WebElementMethods;
import org.Setup.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_TShirt_15DollarOrMore_Test extends BaseSetup {
    @Test
    public void addingTshirts_Test(){
        var loginUserComponents = new LoginUserComponents();
        var inventoryComponents=new InventoryPageComponents();
        WebElementMethods.enterTheValue(loginUserComponents.getUserNameTxtBox(), "standard_user");
        WebElementMethods.enterTheValue(loginUserComponents.getPasswordTxtBox(), "secret_sauce");
        WebElementMethods.clickTheElement(loginUserComponents.getLoginButton());
        Assert.assertTrue(PageLevelMethods.getPageUrl().contains("inventory"));
        WebElementMethods.filterByPriceWithAction(inventoryComponents.getPrices(), FilterOperations.ADDTOCART.getValue(),15);
        Assert.assertEquals(
                (long) WebElementMethods.filterByPriceWithAction(inventoryComponents.getPrices(),
                        FilterOperations.TOTALCOUNT.getValue(), 15).size(),4);
        }
}
