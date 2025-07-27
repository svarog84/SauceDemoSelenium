package Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddBackpackToCartTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        productPage = new ProductPage();
        homePage = new HomePage();

        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickLoginButton();

    }

    @Test
    public void addBackpackToCartTest() {
        productPage.addBackpackToCart();
        driver.navigate().refresh();
        Assert.assertTrue(productPage.isRemoveBackpackButtonPresent());
        Assert.assertTrue(productPage.isShoppingCartButtonPresent());
        Assert.assertEquals(productPage.shoppingCartIconNumber(), "1");
        System.out.println("Broj predmeta u korpi: " + productPage.shoppingCartIconNumber());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
