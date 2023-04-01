package ok.technopolis.tests;

import ok.technopolis.App;
import ok.technopolis.helpers.TestBot;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginTest {
    public static App app;
    public static TestBot testBot;

    @BeforeClass
    public static void setup() {
        app = new App();
        testBot = new TestBot();
        app.loginPage.login(testBot.getLogin(), testBot.getPassword());
    }

    @Test
    @DisplayName("The login test verifies the user's name and ID")
    public void loginTest() {
        assertAll("Login failed",
                () -> assertEquals(testBot.getUserName(), app.homePage.getToolbarUserName()),
                () -> assertEquals(testBot.getId(), app.profilePage.getProfileId())
        );
    }

    @AfterClass
    public static void tearDown() {
        app.homePage.logout();
    }
}
