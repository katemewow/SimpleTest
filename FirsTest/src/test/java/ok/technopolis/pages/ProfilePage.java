package ok.technopolis.pages;

import ok.technopolis.helpers.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProfilePage {
    public WebDriver driver;
    public ToolbarWrapper toolbar;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        toolbar = new ToolbarWrapper(driver);
    }

    @FindBy(xpath = "//*[@hrefattrs=\"st.cmd=userStatuses&st._aid=NavMenu_User_StatusHistory\"]/span")
    private WebElement countNote;

    @FindBy(xpath = "//*[@class='pf-head_itx_a']")
    private WebElement noteInput;

    @FindBy(xpath = "//*[@class='posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler']")
    private WebElement popUpNoteInput;

    @FindBy(xpath = "//*[@class='posting_submit button-pro']")
    private WebElement saveNoteBtn;

    public String getProfileId() {
        toolbar.redirectToProfile();
        String profileUrl = driver.getCurrentUrl();
        return profileUrl.substring(profileUrl.lastIndexOf("/") + 1);
    }

    public void writeNote() {
        noteInput.click();
        popUpNoteInput.sendKeys(ConfProperties.getProperty("note"));
        saveNoteBtn.click();
    }

    public int getCountNote() {
        toolbar.redirectToProfile();
        return Integer.parseInt(countNote.getText());
    }

}
