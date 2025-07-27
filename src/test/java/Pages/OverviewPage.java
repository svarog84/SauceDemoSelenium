package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseTest {
    public OverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(id = "finish")
    WebElement finishButton;

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean overviewPageTitleIsVisible() {
        return pageTitle.isDisplayed();
    }
}
