package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.CreateNewContactPage;
import pages.LoginPage;
import pages.MainPage;
import utils.JdbcConnector;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.SqlQueries.SELECT_LAST_NAMES;

public class CreateNewContactTest extends BaseTestClass {

    public static CreateNewContactPage createNewAddressPage;
    public static MainPage mainPage;
    public static LoginPage loginPage;

    @Test(priority = 1)
    @Description("Enter contact creation page")
    public void testUserCanEnterNewContactPage() {
        createNewAddressPage = new CreateNewContactPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.clickAddNewContactButton();
        assertThat(createNewAddressPage.getFirstNameField().isDisplayed()).isTrue();
    }

    @Test(priority = 2)
    @Description("Add new contact and save")
    public void testUserCanAddNewContact() {
        createNewAddressPage
                .enterFirstName(generatedFirstName)
                .enterLastName(generatedLastName)
                .enterNickName(generatedNickName)
                .clickSaveButton();
        mainPage.clickHomePageButton();
        assertThat(mainPage.checkIfLastNameExistsInTable(generatedLastName)).isTrue();
    }

    @Test(priority = 3)
    @Description("Test that new contact added to DB")
    public void testNewContactAddedToDatabase() {
        List<String> firstNames = JdbcConnector.getJdbcTemplate()
                .queryForList(SELECT_LAST_NAMES.getSqlQuery(), String.class);
        assertThat(firstNames.contains(generatedFirstName)).isTrue();
    }



}
