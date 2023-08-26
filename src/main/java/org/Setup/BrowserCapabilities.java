package org.Setup;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserCapabilities {
    static ChromeOptions getChromeCapabilities(ChromeOptions options){
        options.addArguments("--incognito");
        options.addArguments("--version");
        options.addExtensions(new File("Extensions/adblocker.crx"));
        Map<String,String> prefs=new HashMap<>();
        prefs.put("download.default_directory","DownloadedFiles");
        options.setExperimentalOption("prefs",prefs);
        var desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setAcceptInsecureCerts(true);
        options.merge(desiredCapabilities);
        return options;
    }
    static EdgeOptions getEdgeCapabilities(EdgeOptions options){
        options.addArguments("--incognito");
        options.addArguments("--version");
        options.addExtensions(new File("Extensions/adblocker.crx"));
        Map<String,String> prefs=new HashMap<>();
        prefs.put("download.default_directory","DownloadedFiles");
        options.setExperimentalOption("prefs",prefs);
        var desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setAcceptInsecureCerts(true);
        options.merge(desiredCapabilities);
        return options;
    }

    static DesiredCapabilities getRemoteCapabilities(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        return desiredCapabilities;
    }

}
