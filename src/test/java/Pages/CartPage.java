package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class CartPage extends BaseTest {
    public CartPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Your Cart")
    WebElement yourCartText;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id="continue-shopping")
    WebElement continueShoppingButton;

    public boolean isYourCartTextDisplayed() {
        return yourCartText.isDisplayed();
    }

    public String yourCartText() {
        return yourCartText.getText();
    }

    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isDisplayed();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }


}
