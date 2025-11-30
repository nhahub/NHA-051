//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.swaglabs.tests;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {
    public WebDriver driver;

    @Test
    public void verifyItemAndCheckoutTest() {
     ProductsPage productsPage = new ProductsPage(driver);
     productsPage.clickAddToCartForFirstItem().clickShoppingCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
//        Assert.assertTrue(cartPage.isCartPageDisplayed(), "The user is not on the Cart page.");
//        Assert.assertEquals(cartPage.getCartItemCount(), 1, "The cart should contain exactly 1 item.");
//        Assert.assertTrue(cartPage.isBackpackItemPresent(), "The 'Sauce Labs Backpack' is not present in the cart.");
    }

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        new LoginPage(driver)
        .navigateToLoginPage()
                .enterusername("standard_user")
                .enterpassword("secret_sauce")
                .clickLoginButton();

//
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
