package org.SeleniumUtitlies;

import org.Setup.InitiateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebElementMethods extends InitiateDriver{

    private static WebElement findElement(By element){
        return driver.findElement(element);
    }
    private static List<WebElement> findElements(By element){
        return driver.findElements(element);
    }
    public static void clickTheElement(By element){
        findElement(element).click();
    }
    public static void enterTheValue(By element,String value){
        findElement(element).sendKeys(value);
    }
    public static String getPageTitle(){
        return driver.getTitle();
    }
    public static String getPageUrl(){
        return driver.getCurrentUrl();
    }
    public static void clearTheValue(By element){
         findElement(element).clear();
    }
    public static void selectTheValueFromDropdown(By element, String option){
        Select select=new Select(findElement(element));
        select.selectByValue(option);
    }
    public static Boolean elementIsVisible(By element){
        return findElement(element).isDisplayed();
    }
    public static Boolean elementIsEnabled(By element){
        return findElement(element).isEnabled();
    }
    public static Boolean elementIsSelected(By element){
        return findElement(element).isSelected();
    }

}
