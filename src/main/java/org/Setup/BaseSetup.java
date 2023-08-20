package org.Setup;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseSetup {
    static WebDriver driver;
    String url="https://parabank.parasoft.com/parabank/index.htm";


    @BeforeMethod
    public void setup(){
        driver= InitiateDriver.getDriver() ;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
