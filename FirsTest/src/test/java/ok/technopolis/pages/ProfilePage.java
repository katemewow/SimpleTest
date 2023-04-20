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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfilePage extends LoadableComponent<ProfilePage> {
    public WebDriver driver;
    public ToolbarWrapper toolbar;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        toolbar = new ToolbarWrapper(driver);
        isLoaded();
        check();
    }

    @FindBy(xpath = "//*[@hrefattrs=\"st.cmd=userStatuses&st._aid=NavMenu_User_StatusHistory\"]/span")
    private WebElement NOTE_COUNT;

    @FindBy(xpath = "//*[@class='pf-head_itx_a']")
    private WebElement NOTE_INPUT;

    @FindBy(xpath = "//*[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']")
    private WebElement POPUP_NOTE_INPUT;

    @FindBy(xpath = "//*[@class='posting_submit button-pro']")
    private WebElement SAVE_NOTE_BTN;

    public String getProfileId() {
        toolbar.redirectToProfile();
        String profileUrl = driver.getCurrentUrl();
        return profileUrl.substring(profileUrl.lastIndexOf("/") + 1);
    }

    public ProfilePage writeNote() {
        NOTE_INPUT.click();
        POPUP_NOTE_INPUT.sendKeys(ConfProperties.getProperty("note"));
        SAVE_NOTE_BTN.click();
        return this;
    }

    public int getNoteCount() {
        toolbar.redirectToProfile();
        return Integer.parseInt(NOTE_COUNT.getText());
    }

    private void check() {
        assertTrue(toolbar.isToolbarLoaded());
        assertTrue(NOTE_COUNT.isDisplayed());
        assertTrue(NOTE_INPUT.isDisplayed());
    }


    @Override
    protected void load() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(ConfProperties.getProperty("homePageUrl")));
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().contains(ConfProperties.getProperty("profilePageUrl")), "HomePage is not loaded");
    }
}
