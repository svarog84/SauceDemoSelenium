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

public class EnterYourInformationPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws IOException, InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");

        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickLoginButton();

        productPage.clickAllAddToCartButtons();
        productPage.clickShoppingCartIcon();
        cartPage.clickCheckoutButton();
    }

    @Test
    public void enterYourInformationData() {
        String firstName = "John";
        String lastName = "Smith";
        int postalCode = 1000;


        yourInformationPage.enterFirstName(firstName);
        yourInformationPage.enterLastName(lastName);
        yourInformationPage.enterPostalCode(String.valueOf(postalCode));
        yourInformationPage.clickContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertTrue(overviewPage.overviewPageTitleIsVisible());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
