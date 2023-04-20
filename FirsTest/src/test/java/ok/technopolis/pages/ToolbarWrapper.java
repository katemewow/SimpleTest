package ok.technopolis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class ToolbarWrapper {
    public WebDriver driver;

    public ToolbarWrapper(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='topPanelLeftCorner']")
    private WebElement LOGO;

    @FindBy(xpath = "//*[@class='toolbar_accounts-user_name']")
    private WebElement USER_NAME;

    @FindBy(xpath = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    private WebElement USER_MENU;

    @FindBy(xpath = "//*[@class='tico ellip']")
    private WebElement PROFILE_BTN;

    @FindBy(xpath = "//*[@class='lp']")
    private WebElement LOGOUT_BTN;

    @FindBy(xpath = "//*[@id='counter_ToolbarMessages']")
    private WebElement MESSAGE_COUNT;

    public String getUserName() {
        USER_MENU.click();
        return USER_NAME.getText();
    }

    public void logout() {
        USER_MENU.click();
        LOGOUT_BTN.click();
    }

    public ProfilePage redirectToProfile() {
        PROFILE_BTN.click();
        return new ProfilePage(driver);
    }

    public int getMessageCount() {
        return Integer.parseInt(MESSAGE_COUNT.getText());
    }

    public boolean isToolbarLoaded() {
        try {
            return LOGO.isDisplayed() && USER_MENU.isDisplayed() && MESSAGE_COUNT.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
