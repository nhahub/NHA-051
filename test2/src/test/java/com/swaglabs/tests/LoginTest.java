
package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.swaglabs.utils.BrowserActions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    //variables
    private WebDriver driver;


    //tests
    @Test
    public void succssfulLogin(){
        new LoginPage(driver).enterusername("standard_user")
                .enterpassword("secret_sauce")
                .clickLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), "https://www.saucedemo.com/inventory.html");


    }

    //configuration

    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
        new LoginPage(driver).navigateToLoginPage();

    }

    @AfterMethod
    public void tearDown() {
           driver.quit();
        }

    }

