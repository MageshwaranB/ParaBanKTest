package org.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class InitiateDriver
{
   public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static void setDriver(String browser,String environment) throws MalformedURLException {
        switch (environment) {
           case "LOCAL"->{
                    decideBrowser(browser,false);
           }
            case "REMOTE"->{
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), BrowserCapabilities.getRemoteCapabilities(decideBrowser(browser,true))));
            }
        }
    }
    private static String decideBrowser(String browser, boolean headless)  {
        switch (browser){
            case "EDGE" -> {
                driver.set(new EdgeDriver(BrowserCapabilities.getEdgeCapabilities(headless)));
            }
            default -> {
                driver.set(new ChromeDriver(BrowserCapabilities.getChromeCapabilities(headless)));
            }
        }
        return browser;
    }
    public static WebDriver getDriver(){
        return driver.get();
    }

}
