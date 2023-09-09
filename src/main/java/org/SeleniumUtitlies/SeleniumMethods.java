package org.SeleniumUtitlies;

import org.Setup.InitiateDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SeleniumMethods extends InitiateDriver{
    protected WebElement webElement;
    private By element;
    static JavascriptExecutor js = (JavascriptExecutor) getDriver();
    static String filePath;
    public SeleniumMethods(By element){
        this.element =element;
        this.webElement=findElement(element);
    }

    private boolean isElementVisible(){
       return webElement.isDisplayed();
    }
    public boolean clickThElement(){
        if (isElementVisible()){
            webElement.click();
            return true;
        }
        return false;
    }

    private static WebElement findElement(By element){
        return getDriver().findElement(element);
    }
    private static List<WebElement> findElements(By element){
        return getDriver().findElements(element);
    }
    public String clickTheElement(){
        if (isElementVisible()){
            webElement.click();
            return getPageTitle();
        }
        return "";
    }
    private static void clickTheElement(WebElement element){
        element.click();
    }
    public Boolean enterTheValue(String value){
        if (isElementVisible()){
          webElement.sendKeys(value);
          return true;
        }
        return false;
    }

    public String getValue(){
        if (isElementVisible()){
            return webElement.getText();
        }
        return "";
    }
    private static String getValue(WebElement webElement){
        return webElement.getText();
    }

    public Boolean clearTheValue(By element){
         if(isElementVisible()){
             webElement.clear();
             return true;
         }
         return false;
    }
    public Boolean selectTheValueFromDropdown( String option){
        if (isElementVisible()){
            Select select=new Select(webElement);
            select.selectByValue(option);
            return true;
        }
        return false;
    }
    public Boolean elementIsVisible(){
        return webElement.isDisplayed();
    }
    public  Boolean elementIsEnabled(){
        return webElement.isEnabled();
    }
    public Boolean elementIsSelected(){
        return webElement.isSelected();
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
    public Boolean hoverOnTheElement(){
        Actions actions=new Actions(getDriver());
        if (isElementVisible()){
            actions.moveToElement(findElement(element)).build().perform();
            return true;
        }
        return false;

    }
    private void dragAndDropObjects(By sourceElement,By targetElement){
        Actions actions=new Actions(getDriver());
        actions.dragAndDrop(findElement(sourceElement), findElement(targetElement)).build().perform();
    }
    public Boolean rightClickOnElement(){
        Actions actions=new Actions(getDriver());
        if (isElementVisible()){
            actions.contextClick(findElement(element)).build().perform();
            return true;
        }
        return false;
    }

    //Page methods
    public Boolean scrollingToTheElement() {
        js.executeScript("arguments[0]. scrollIntoView(true);", element);
        return elementIsVisible();
    }
    public static String takeScreenshot(String testName){
        TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
        var source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        var separator=File.separator;
        filePath=System.getProperty("user.dir")+separator+"Screenshots"+separator+testName+"_"+ System.currentTimeMillis()+".png";
        File destFile=new File(filePath);
        try{
            FileUtils.copyFile(source, destFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return filePath;
    }
    public static String getPageTitle(){
        return getDriver().getTitle();
    }
    public static String getPageUrl(){
        return getDriver().getCurrentUrl();
    }


}
