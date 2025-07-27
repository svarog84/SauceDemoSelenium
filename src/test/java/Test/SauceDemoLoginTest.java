package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SauceDemoLoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        productPage = new ProductPage();
        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");
    }


    @Test
    public void userLogInTestValidCredentials() {
        homePage.inputUsername(excelReader.getStringData("Sheet1", 1, 0));
        homePage.inputPassword(excelReader.getStringData("Sheet1", 1, 1));
        homePage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productPage.isShoppingCartButtonPresent());
    }

    @Test
    public void userLoginTestInvalidUsername() {
        homePage.inputUsername(excelReader.getStringData("Sheet1", 2, 0));
        homePage.inputPassword(excelReader.getStringData("Sheet1", 2, 2));
        homePage.clickLoginButton();

        Assert.assertTrue(homePage.isErrorMessageDisplayed());
        Assert.assertTrue(homePage.isLoginButtonDisplayed());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
