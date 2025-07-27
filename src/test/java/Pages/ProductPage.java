package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BaseTest {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackFromCArtButton;

    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartIcon;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory ")
    List <WebElement> addToCartButtons;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement sidebarLogoutButton;


    public void addBackpackToCart() {
        addBackpackToCartButton.click();
    }

    public boolean isRemoveBackpackButtonPresent() {
        return removeBackpackFromCArtButton.isDisplayed();
    }

    public boolean isShoppingCartButtonPresent() {
        return shoppingCartIcon.isDisplayed();
    }

    public String shoppingCartIconNumber() {
        return shoppingCartIcon.getText();

    }

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    public void clickAllAddToCartButtons() throws InterruptedException {
        for (WebElement addToCartButton : addToCartButtons) {
            addToCartButton.click();
        }
    }

    public void clickHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickSidebarLogoutButton() {
        sidebarLogoutButton.click();
    }
}
