package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class UserCanLogout extends BaseTest {
    @BeforeMethod
    public void pageSetUp() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        productPage = new ProductPage();
        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");

        homePage.inputUsername("standard_user");
        homePage.inputPassword("secret_sauce");
        homePage.clickLoginButton();
    }
    @Test
    public void userCanLogout() {
        productPage.clickHamburgerMenu();
        productPage.clickSidebarLogoutButton();

        Assert.assertTrue(homePage.isLoginButtonDisplayed());
        Assert.assertTrue(homePage.isUserNameFieldDisplayed());
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
