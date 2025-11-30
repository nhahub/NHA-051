package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class LoginPage {

    //locators
    private WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginbutton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }
    // navigate to login page

    public LoginPage navigateToLoginPage(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions); // هنا هنستخدم الـ driver اللي فوق مباشرة
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://saucedemo.com");
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

    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginbutton);
        return this;
    }
    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }





}
