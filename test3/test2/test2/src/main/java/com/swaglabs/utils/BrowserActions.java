

package com.swaglabs.utils;

import com.swaglabs.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BrowserActions {
    private static WebDriver driver;

    public static void openURL(String url) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
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