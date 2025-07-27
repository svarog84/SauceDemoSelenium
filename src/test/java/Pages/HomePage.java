package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(className = "error-button")
    WebElement errorMessage;

    public void inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isUserNameFieldDisplayed() {
        return usernameField.isDisplayed();
    }

}
