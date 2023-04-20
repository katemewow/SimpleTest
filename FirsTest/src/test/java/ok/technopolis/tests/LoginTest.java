package ok.technopolis.tests;

import ok.technopolis.helpers.BaseTest;
import ok.technopolis.helpers.TestBot;
import ok.technopolis.pages.HomePage;
import ok.technopolis.pages.LoginPage;
import ok.technopolis.pages.ProfilePage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginTest extends BaseTest {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static ProfilePage profilePage;
    public static TestBot testBot;

    @Test
    @DisplayName("The login test verifies the user's name and ID")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        testBot = new TestBot();
        homePage = loginPage.login(testBot.getLogin(), testBot.getPassword());
        profilePage = homePage.toolbar.redirectToProfile();

        assertAll("Login failed",
                () -> assertEquals(testBot.getUserName(), homePage.getToolbarUserName()),
                () -> assertEquals(testBot.getId(), profilePage.getProfileId())
        );
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
    }
}
