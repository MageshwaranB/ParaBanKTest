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
    static String browser=Browsers.CHROME.name();
    public static void setDriver() throws MalformedURLException {
        switch (browser){
            case "EDGE":
                var edgeOptions=new EdgeOptions();
                driver.set(new EdgeDriver(BrowserCapabilities.getEdgeCapabilities(edgeOptions)));
                break;
            case "REMOTE":
                    driver.set(new RemoteWebDriver(new URL("http://localhost:4444"),BrowserCapabilities.getRemoteCapabilities()));
                break;
            default:
                var chromeOptions=new ChromeOptions();
                driver.set(new ChromeDriver(BrowserCapabilities.getChromeCapabilities(chromeOptions)));
        }
    }
    public static WebDriver getDriver(){
        return driver.get();
    }

}
