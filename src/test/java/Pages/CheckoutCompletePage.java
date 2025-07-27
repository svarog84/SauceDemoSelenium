package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {
    public CheckoutCompletePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "complete-header")
    WebElement successfulCheckoutMessage;

    @FindBy (id = "back-to-products")
    WebElement backToHomeButton;

    public boolean successfulCheckoutMessageIsDisplayed() {
        return successfulCheckoutMessage.isDisplayed();
    }

    public boolean backToHomeButtonIsDisplayed() {
        return backToHomeButton.isDisplayed();
    }
}
