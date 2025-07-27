package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class OverviewPageTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() throws IOException, InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        yourInformationPage = new YourInformationPage();
        overviewPage = new OverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();

        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");

        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickLoginButton();

        productPage.clickAllAddToCartButtons();
        productPage.clickShoppingCartIcon();
        cartPage.clickCheckoutButton();

        String firstName = "John";
        String lastName = "Smith";
        int postalCode = 1000;

        yourInformationPage.enterFirstName(firstName);
        yourInformationPage.enterLastName(lastName);
        yourInformationPage.enterPostalCode(String.valueOf(postalCode));
        yourInformationPage.clickContinueButton();
    }

    @Test
    public void confirmOrder() {
        overviewPage.clickFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertTrue(overviewPage.overviewPageTitleIsVisible());
        Assert.assertTrue(checkoutCompletePage.backToHomeButtonIsDisplayed());
        Assert.assertTrue(checkoutCompletePage.successfulCheckoutMessageIsDisplayed());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
