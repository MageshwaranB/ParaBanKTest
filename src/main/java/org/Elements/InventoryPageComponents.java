package org.Elements;

import org.openqa.selenium.By;

public class InventoryPageComponents {
    public By getPrices(){
        return By.xpath("//div[@class='pricebar']");
    }
    public By getProductName(){
        return By.xpath("//div[@class='inventory_item_name']");
    }
}
