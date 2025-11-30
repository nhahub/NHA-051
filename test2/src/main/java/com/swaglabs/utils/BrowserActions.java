

package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BrowserActions {

    public static WebDriver openURL(String url) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        return driver;
    }
    //get current URL
    public static String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    //get page title
    public static void refreshable(WebDriver driver){
        driver.navigate().refresh();
    }

}