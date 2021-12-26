package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.CreateNewContactPage;
import pages.MainPage;
import utils.GenerateRandomData;

import static org.assertj.core.api.Assertions.assertThat;

public class EditContactTest extends BaseTestClass {

    public static CreateNewContactPage createNewAddressPage;
    public static MainPage mainPage;
    protected static String generatedLastName = GenerateRandomData.generateLastName();

    @Test(priority = 1)
    @Description("Test that user can enter edit contact page")
    public void testUserCanEnterEditContactPage() {
        createNewAddressPage = new CreateNewContactPage(driver);
        mainPage = new MainPage(driver);
        mainPage.clickFirstRowEditButton();
        assertThat(createNewAddressPage.getUpdateButton().isDisplayed()).isTrue();
    }

    @Test(priority = 2)
    @Description("Test that user can edit contact")
    public void testUserCanEditFirstContact() {
        createNewAddressPage = new CreateNewContactPage(driver);
        mainPage = new MainPage(driver);
        createNewAddressPage
                .clearLastNameField()
                .enterLastName(generatedLastName)
                .clickUpdateButton();
        mainPage.clickHomePageButton();
        assertThat(mainPage.checkIfLastNameExistsInTable(generatedLastName)).isTrue();
    }






}
