package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CartPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() throws IOException, InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();

        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");

        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickLoginButton();

        productPage.clickAllAddToCartButtons();
    }

    @Test
    public void isCartPageLoaded() {
        productPage.clickShoppingCartIcon();
        Assert.assertTrue(cartPage.isCheckoutButtonPresent());
        Assert.assertTrue(cartPage.isCheckoutButtonPresent());
    }

    @Test
    public void isContinueShoppingButtonWorking() {
        productPage.clickShoppingCartIcon();
        cartPage.clickOnContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productPage.isShoppingCartButtonPresent());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
