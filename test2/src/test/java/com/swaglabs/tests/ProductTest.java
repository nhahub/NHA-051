//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest {
    public WebDriver driver;

    @Test
    public void addItemToCartTest() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickAddToCartForFirstItem();
        productsPage.clickShoppingCart();
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "The user is not on the Products page after login.");
        Assert.assertTrue(productsPage.isShoppingCartBadgeCountCorrect("1"), "Shopping cart badge count is incorrect after adding an item.");

    }

    @BeforeMethod
    public void setUp() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);// هنا بنعمل initialize للـ driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // أفضل استخدام الثواني بدل الملي ثانية
        driver.get("https://saucedemo.com");
        new LoginPage(driver)
                .enterusername("standard_user")
                .enterpassword("secret_sauce")
                .clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
