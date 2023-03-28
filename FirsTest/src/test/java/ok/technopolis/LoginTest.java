package ok.technopolis;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("geckodriver"));
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));
        String userName = homePage.getUserName();
        // Проверяется имя пользователя в user menu
        Assert.assertEquals(ConfProperties.getProperty("userName"), userName);
    }

    @AfterClass
    public static void tearDown() {
        homePage.logout();
    }
}
