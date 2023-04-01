package ok.technopolis.tests;

import ok.technopolis.App;
import ok.technopolis.helpers.TestBot;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class HasMessageTest {
    public static App app;
    public static TestBot testBot;

    @BeforeClass
    public static void setup() {
        app = new App();
        testBot = new TestBot();
        app.loginPage.login(testBot.getLogin(), testBot.getPassword());
    }

    @Test
    @DisplayName("The test checks for the presence of at least one message")
    public void hasMessages() {
        assertThat(app.homePage.toolbar.getCountMessage(), greaterThan(0));
    }

    @AfterClass
    public static void tearDown() {
        app.homePage.logout();
    }
}
