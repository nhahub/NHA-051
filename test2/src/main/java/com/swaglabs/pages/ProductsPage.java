//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    WebDriver driver;
    private final By productsHeader = By.className("title");
    private final By firstItemAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage clickAddToCartForFirstItem() {
        ElementActions.clickElement(driver, firstItemAddToCartButton);
        return this;
    }

    public CartPage clickShoppingCart() {
        ElementActions.clickElement(driver, shoppingCartLink);
        return new CartPage(driver);
    }

    public boolean isProductsPageDisplayed() {
        try {
            Waits.waitforElementVisible(driver,productsHeader);
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }

    public boolean isShoppingCartBadgeCountCorrect(String expectedCount) {
        try {
            WebElement badge = this.driver.findElement(this.shoppingCartBadge);
            return badge.isDisplayed() && badge.getText().equals(expectedCount);
        } catch (NoSuchElementException var3) {
            return false;
        }
    }
}
