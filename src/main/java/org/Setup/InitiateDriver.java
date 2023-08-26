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
   public static WebDriver driver;
    static String browser=Browsers.REMOTE.name();
    public static WebDriver getDriver() throws MalformedURLException {
        switch (browser){
            case "EDGE":
                var edgeOptions=new EdgeOptions();
                driver=new EdgeDriver(BrowserCapabilities.getEdgeCapabilities(edgeOptions));
                break;
            case "REMOTE":
                    driver=new RemoteWebDriver(new URL("http://localhost:4444"),BrowserCapabilities.getRemoteCapabilities());
                break;
            default:
                var chromeOptions=new ChromeOptions();
                driver=new ChromeDriver(BrowserCapabilities.getChromeCapabilities(chromeOptions));
        }
        return driver;
    }

}
