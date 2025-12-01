package tests;

import com.swaglabs.pages.LoginPage;

import java.time.Duration;

import com.swaglabs.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

