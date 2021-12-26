package pages;

import custom_elements.WebTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "home")
    private WebElement homePageButton;

    @FindBy(xpath = "//a[@onclick='document.logout.submit();']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id='top']//b")
    private WebElement currentUsername;

    @FindBy(xpath = "//a[text()='add new']")
    private WebElement addNewContactButton;

    @FindBy(xpath = "//table")
    private WebElement tableWithContacts;

    @FindBy(xpath = "//table[@id='maintable']/tbody/tr[2]/td[8]//img")
    private WebElement firstRowEditButton;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[@id='search_count']")
    private WebElement numberOfElementsInTable;

    public boolean checkIfLastNameExistsInTable(String lastName) {
        WebTable table = new WebTable(tableWithContacts);
        return table.checkIfLastNameExistsInTable(lastName);
    }
    
    public MainPage clickFirstCheckboxInTable() {
        WebTable table = new WebTable(tableWithContacts);
        table.clickFirstCheckbox();
        return new MainPage(driver);
    }

    public CreateNewContactPage clickFirstRowEditButton() {
        firstRowEditButton.click();
        return new CreateNewContactPage(driver);
    }

    public String getUserName() {
        String userName = currentUsername.getText();
        return userName.substring(1, userName.length() - 1);
    }

    public LoginPage userLogout() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public CreateNewContactPage clickAddNewContactButton() {
        addNewContactButton.click();
        return new CreateNewContactPage(driver);
    }

    public MainPage clickHomePageButton() {
        homePageButton.click();
        return this;
    }

    public MainPage clickDeleteButtonAndSubmit() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new MainPage(driver);
    }

    public String getNumberOfElementsInTable() {
        return numberOfElementsInTable.getText();
    }
}
