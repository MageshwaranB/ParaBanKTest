package org.SeleniumUtitlies;

import org.Setup.InitiateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebElementMethods extends InitiateDriver{

    private static WebElement findElement(By element){
        return getDriver().findElement(element);
    }
    private static List<WebElement> findElements(By element){
        return getDriver().findElements(element);
    }
    public static void clickTheElement(By element){
        findElement(element).click();
    }
    private static void clickTheElement(WebElement element){
        element.click();
    }
    public static void enterTheValue(By element,String value){
        findElement(element).sendKeys(value);
    }

    public static String getValue(By element){
        return findElement(element).getText();
    }
    private static String getValue(WebElement webElement){
        return webElement.getText();
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

    private static List<WebElement> getListOfValues(By element){
        return findElements(element);
    }

    public static List<Object> filterByPriceWithAction(By element, String operation, Integer value){
        var elementList=getListOfValues(element);
        List<Object> list=new ArrayList<>();
        int sum=0;
        for (WebElement currentElement:elementList) {
            sum++;
            if (Double.parseDouble(removeDollarSign(currentElement.getText()))>=value){
                switch (operation){
                    case "add_to_cart":
                        var elementVar=currentElement.toString().split("xpath: ")[1];
                        var newString=elementVar.substring(0,elementVar.length()-1);
                        clickTheElement(currentElement.findElement(By.xpath("("+newString+"/following-sibling::button)["+sum+"]")));
                        list.add(true);
                        break;
                    case "count":
                        list.add(sum++);
                        break;
                    case "values":
                        list.add(getValue(currentElement));
                }

            }
        }
        return list;
    }

    private static String removeDollarSign(String value){
        return value.split("\\$")[1];
    }
    public static void hoverOnTheElement(By element){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(findElement(element)).build().perform();
    }
    public static void dragAndDropObjects(By sourceElement,By targetElement){
        Actions actions=new Actions(getDriver());
        actions.dragAndDrop(findElement(sourceElement), findElement(targetElement)).build().perform();
    }
    public static void rightClickOnElement(By element){
        Actions actions=new Actions(getDriver());
        actions.contextClick(findElement(element)).build().perform();
    }
    

}
