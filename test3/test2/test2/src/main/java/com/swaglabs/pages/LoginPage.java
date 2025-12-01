package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

import static com.swaglabs.utils.BrowserActions.openURL;

public class LoginPage {

    //locators
    private  WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginbutton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }
    // navigate to login page

    public LoginPage navigateToLoginPage( ) {

        BrowserActions.openURL("https://saucedemo.com");
        return this;
    }

    //Actions
    public LoginPage enterusername(String userN) {
        ElementActions.sendData(driver ,username, userN);
        return this;
    }

    public LoginPage enterpassword(String pass) {
        ElementActions.sendData(driver, password, pass);
        return this;
    }

    public ProductsPage clickLoginButton() {
        ElementActions.clickElement(driver, loginbutton);
        return new ProductsPage(driver);
    }
    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }





}
