package org.SeleniumUtitlies;

import org.Setup.InitiateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementMethods extends InitiateDriver{

    public static void clickTheElement(By element){
        driver.findElement(element).click();
    }
    public static void enterTheValue(By element,String value){
        driver.findElement(element).sendKeys(value);
    }
    public static String getPageTitle(){
        return driver.getTitle();
    }
    public static String getPageUrl(){
        return driver.getCurrentUrl();
    }

}
