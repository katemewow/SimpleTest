package ok.technopolis.pages;

import ok.technopolis.helpers.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginPage extends LoadableComponent<LoginPage> {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.isLoaded();
        this.check();
    }

    @FindBy(xpath = "//*[@id=\"field_email\"]")
    private WebElement LOGIN_FIELD;

    @FindBy(xpath = "//*[@id=\"field_password\"]")
    private WebElement PASSWD_FIELD;

    @FindBy(xpath = "//*[@class='button-pro __wide']")
    private WebElement LOGIN_BTN;

    public HomePage login(String login, String passwd) {
        LOGIN_FIELD.sendKeys(login);
        PASSWD_FIELD.sendKeys(passwd);
        LOGIN_BTN.click();
        return new HomePage(driver);
    }

    private void check() {
        assertThat("Toolbar is not present", LOGIN_FIELD.isDisplayed());
        assertThat("Confirm logout button is not present", PASSWD_FIELD.isDisplayed());
        assertThat("Confirm logout button is not present", LOGIN_BTN.isDisplayed());
    }

    @Override
    protected void load() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(ConfProperties.getProperty("loginPageUrl")));
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat("LoginPage is not loaded", driver.getCurrentUrl(), containsString(ConfProperties.getProperty("loginPageUrl")));
    }
}
