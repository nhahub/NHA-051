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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.id("checkout");
    private final By cartItem = By.className("cart_item");
    private final By backpackItemTitle = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        ElementActions.clickElement(this.driver, this.checkoutButton);
    }

    public boolean isCartPageDisplayed(By locator) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return this.driver.findElement(locator).getText().equals("Your Cart");
    }

    public boolean isBackpackItemPresent() {
        try {
            return this.driver.findElement(this.backpackItemTitle).isDisplayed();
        } catch (NoSuchElementException var2) {
            return false;
        }
    }

    public int getCartItemCount() {
        return this.driver.findElements(this.cartItem).size();
    }
}
