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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends LoadableComponent<HomePage> {

    public WebDriver driver;
    public ToolbarWrapper toolbar;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        toolbar = new ToolbarWrapper(driver);
        isLoaded();
        check();
    }

    @FindBy(xpath = "//*[@class='button-pro form-actions_yes']")
    private WebElement confLogoutBtn;

    public String getToolbarUserName() {
        return toolbar.getUserName();
    }

    public void logout() {
        toolbar.logout();
        confLogoutBtn.click();
    }

    private void check() {
        assertTrue(toolbar.isToolbarLoaded());
    }

    @Override
    protected void load() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("homePageUrl")));
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat("HomePage is not loaded", driver.getCurrentUrl(), containsString(ConfProperties.getProperty("homePageUrl")));
    }
}
