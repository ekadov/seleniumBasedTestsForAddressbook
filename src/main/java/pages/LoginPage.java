package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='user']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    @Getter
    private WebElement loginButton;

    public LoginPage clearUsernameField() {
        loginField.clear();
        return this;
    }

    public LoginPage enterUsername(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clearPasswordField() {
        passwordField.clear();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }


}
