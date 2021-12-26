package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.CreateNewContactPage;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteContactTest extends BaseTestClass {

    public static CreateNewContactPage createNewAddressPage;
    public static MainPage mainPage;

    @Test(priority = 1)
    @Description("Test that user can delete first contact")
    public void testUserCanDeleteFirstContact() {
        createNewAddressPage = new CreateNewContactPage(driver);
        mainPage = new MainPage(driver);
        String numberOfElementsBefore = mainPage.getNumberOfElementsInTable();
        mainPage
                .clickFirstCheckboxInTable()
                .clickDeleteButtonAndSubmit()
                .clickHomePageButton();
        assertThat(mainPage.getNumberOfElementsInTable()).isNotEqualTo(numberOfElementsBefore);
    }


    @AfterClass
    public void teardown() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
