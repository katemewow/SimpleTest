package ok.technopolis.tests;

import ok.technopolis.helpers.BaseTest;
import ok.technopolis.helpers.TestBot;
import ok.technopolis.pages.HomePage;
import ok.technopolis.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class HasMessageTest extends BaseTest {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static TestBot testBot;

    @Test
    @DisplayName("The test checks for the presence of at least one message")
    public void hasMessages() {
        loginPage = new LoginPage(driver);
        testBot = new TestBot();
        homePage = loginPage.login(testBot.getLogin(), testBot.getPassword());
        int messageCount = homePage
                .toolbar
                .getMessageCount();
        assertThat(messageCount, greaterThan(0));
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
    }
}
