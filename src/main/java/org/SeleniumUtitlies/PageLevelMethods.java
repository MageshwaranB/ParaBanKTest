package org.SeleniumUtitlies;

import org.Setup.InitiateDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalTime;

public class PageLevelMethods extends InitiateDriver {
    static JavascriptExecutor js = (JavascriptExecutor) getDriver();
    static String filePath;

    public static Boolean scrollingToTheElement(By element) {
        js.executeScript("arguments[0]. scrollIntoView(true);", element);
        return WebElementMethods.elementIsVisible(element);
    }
    public static String takeScreenshot(String testName){
        TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
        var source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        filePath=System.getProperty("user.dir")+"/Screenshots/"+testName+"_"+ System.currentTimeMillis()+".png";
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
