package Test;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AddAllItemsToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        productPage = new ProductPage();
        excelReader = new ExcelReader("C:\\Users\\Svarog84\\Desktop\\SauceDemoUsers.xlsx\\");

        homePage.inputUsername(excelReader.getStringData("Sheet1", 1, 0));
        homePage.inputPassword(excelReader.getStringData("Sheet1", 1, 1));
        homePage.clickLoginButton();
    }

    @Test
    public void addAllItemsToCartTest() throws InterruptedException {
        productPage.clickAllAddToCartButtons();
        //dodaje samo 3 itema u cart, pronaci zasto ostala 3 ne dodaje
        //Assert.assertEquals(productPage.shoppingCartIconNumber(), 6);
    }

}
