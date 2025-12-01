package tests;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
    public WebDriver driver;
    private final By cartHeader = By.className("title");


    @Test
    public void verifyItemAndCheckoutTest() {
        new LoginPage(driver)
                .enterusername("standard_user")
                .enterpassword("secret_sauce")
                //Claas = productPage
                .clickLoginButton()
                .clickAddToCartForFirstItem()
            //Claas = CartPage
                .clickShoppingCart()
                .clickCheckout();
//        Assert.assertTrue(cartPage.isCartPageDisplayed(cartHeader), "The user is not on the Cart page.");
//        Assert.assertEquals(cartPage.getCartItemCount(), 1, "The cart should contain exactly 1 item.");
//        Assert.assertTrue(cartPage.isBackpackItemPresent(), "The 'Sauce Labs Backpack' is not present in the cart.");
    }

    @BeforeMethod
    public void setUp() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);// هنا بنعمل initialize للـ driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // أفضل استخدام الثواني بدل الملي ثانية
        driver.get("https://saucedemo.com");

    }


    @AfterMethod
    public void tearDown() {
            driver.quit();
        }

    }

