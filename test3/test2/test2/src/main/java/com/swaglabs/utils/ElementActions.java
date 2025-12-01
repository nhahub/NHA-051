package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;

public class ElementActions {
    private ElementActions(){

    }
    //send keys
    public static void sendData(WebDriver driver, By locator, String data){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver, locator).sendKeys(data);

    }
    //click
    public static void clickElement(WebDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver, locator).click();
    }

    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        Scrolling.scrolltoElement(driver, locator);
        return findElement(driver, locator).getText();

    }
    //find element
    public static WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }
}
