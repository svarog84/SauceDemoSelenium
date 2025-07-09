package Base;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public HomePage homePage;
    public ProductPage productPage;
    public ExcelReader excelReader;
    public CartPage cartPage;

    @BeforeClass
    public void SetUp() {
        WebDriverManager.firefoxdriver().setup();
    }
}
