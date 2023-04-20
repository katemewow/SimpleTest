package ok.technopolis.tests;

import ok.technopolis.helpers.BaseTest;
import ok.technopolis.helpers.TestBot;
import ok.technopolis.pages.HomePage;
import ok.technopolis.pages.LoginPage;
import ok.technopolis.pages.ProfilePage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class HasNoteTest extends BaseTest {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static ProfilePage profilePage;
    public static TestBot testBot;

    @Test
    @DisplayName("User writes a note")
    public void containsNote() {
        loginPage = new LoginPage(driver);
        testBot = new TestBot();
        homePage = loginPage.login(testBot.getLogin(), testBot.getPassword());
        profilePage = homePage.toolbar.redirectToProfile();
        int noteCount = profilePage
                .writeNote()
                .getNoteCount();
        assertThat(noteCount, greaterThan(0));
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
    }
}
