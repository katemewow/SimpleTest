package ok.technopolis.helpers;

import ok.technopolis.pages.HomePage;
import ok.technopolis.pages.LoginPage;
import ok.technopolis.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageBuilder {

    public static WebDriver driver = new FirefoxDriver();

    public static LoginPage buildLoginPage() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("geckodriver"));
        driver.get(ConfProperties.getProperty("loginPageUrl"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LoginPage(driver);
    }

    public static HomePage buildHomePage() {
        return new HomePage(driver);
    }

    public static ProfilePage buildProfilePage() {
        return new ProfilePage(driver);
    }

}
