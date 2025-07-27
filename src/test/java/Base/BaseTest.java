package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public HomePage homePage;
    public ProductPage productPage;
    public ExcelReader excelReader;
    public CartPage cartPage;
    public YourInformationPage yourInformationPage;
    public OverviewPage overviewPage;
    public CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void SetUp() {
        WebDriverManager.firefoxdriver().setup();
    }
}
