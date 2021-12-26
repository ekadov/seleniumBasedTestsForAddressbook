package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

    protected WebDriver driver;

    public CreateNewContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    @Getter
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='nickname']")
    private WebElement nickNameField;

    @FindBy(xpath = "//input[@value='Enter']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@value='Update']")
    @Getter
    private WebElement updateButton;

    public CreateNewContactPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CreateNewContactPage clearLastNameField() {
        lastNameField.clear();
        return this;
    }

    public CreateNewContactPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CreateNewContactPage enterNickName(String nickName) {
        nickNameField.sendKeys(nickName);
        return this;
    }

    public CreateNewContactPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public MainPage clickUpdateButton() {
        updateButton.click();
        return new MainPage(driver);
    }

}
