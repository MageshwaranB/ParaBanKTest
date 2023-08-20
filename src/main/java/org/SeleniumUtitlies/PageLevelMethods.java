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
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static Boolean scrollingToTheElement(By element) {
        js.executeScript("arguments[0]. scrollIntoView(true);", element);
        return WebElementMethods.elementIsVisible(element);
    }
    public static void takeScreenshot(){
        try{
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            var source=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile=new File("./Screenshots/FailedTest_"+ LocalTime.now()+".png");
            FileUtils.copyFile(source,destFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
