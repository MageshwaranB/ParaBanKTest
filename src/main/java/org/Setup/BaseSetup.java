package org.Setup;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.Setup.InitiateDriver.getDriver;

public class BaseSetup {
    static String environment=Environment.REMOTE.name();
    static String browser=Browsers.EDGE.name();
    String url="https://www.saucedemo.com/";


    @BeforeMethod
    public void setup() throws MalformedURLException {
        InitiateDriver.setDriver(browser,environment);
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        getDriver().manage().deleteAllCookies();
        getDriver().quit();
    }

}
