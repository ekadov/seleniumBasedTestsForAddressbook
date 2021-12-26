package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.ConfProperties;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTestClass {

    public static LoginPage loginPage;
    public static MainPage mainPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.get(ConfProperties.getProperty("base_url"));
    }

    @Test
    @Description("Verify page title")
    public void testLoginPageIsOpenedCorrectly() {
        assertThat(driver.getTitle()).isEqualTo("Address book");
    }

    @Test(priority = 1)
    @Description("Login negative test with invalid user and password")
    public void testUserCanNotLoginWithWrongCredentials() {
        loginPage
                .clearUsernameField()
                .clearPasswordField()
                .enterUsername(ConfProperties.getProperty("invalid_username"))
                .enterPassword(ConfProperties.getProperty("invalid_password"))
                .clickLoginButton();
        assertThat(loginPage.getLoginButton().isDisplayed()).isTrue();
    }

    @Test(priority = 2)
    @Description("Login positive test with valid user and password")
    public void testUserCanLoginWithValidCredentials() {
        loginPage
                .clearUsernameField()
                .clearPasswordField()
                .enterUsername(ConfProperties.getProperty("valid_username"))
                .enterPassword(ConfProperties.getProperty("valid_password"))
                .clickLoginButton();
        assertThat(mainPage.getUserName())
                .isEqualTo(ConfProperties.getProperty("valid_username"));
    }


}
