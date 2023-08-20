package org.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class InitiateDriver
{
   public static WebDriver driver;
    static String browser=Browsers.CHROME.name();
    public static WebDriver getDriver(){
        switch (browser){
            case "EDGE":
                var edgeOptions=new EdgeOptions();
                driver=new EdgeDriver(BrowserCapabilities.getEdgeCapabilities(edgeOptions));
                break;
            default:
                var chromeOptions=new ChromeOptions();
                driver=new ChromeDriver(BrowserCapabilities.getChromeCapabilities(chromeOptions));
        }
        return driver;
    }

}
