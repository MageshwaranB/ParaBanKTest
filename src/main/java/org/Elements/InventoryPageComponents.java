package org.Elements;

import org.openqa.selenium.By;

public class InventoryPageComponents {
    public static String itemDescription="(//div[@class='inventory_item_description'])";
    public static String priceBar="//div[@class='itemDescription']";

    public By getItemDescription(){
        return By.xpath(itemDescription);
    }
    public By getPrices(){
        return By.xpath(itemDescription+"//div[@class='pricebar']/div[@class='inventory_item_price']");
    }
    public By getProductName(){
        return By.xpath(itemDescription+"//div[@class='inventory_item_name']");
    }
}
