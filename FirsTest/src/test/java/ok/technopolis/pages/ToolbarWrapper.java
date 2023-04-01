package ok.technopolis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolbarWrapper {
    public WebDriver driver;

    public ToolbarWrapper(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='topPanelLeftCorner']")
    private WebElement logo;

    @FindBy(xpath = "//*[@class='toolbar_accounts-user_name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class='tico ellip']")
    private WebElement profileBtn;

    @FindBy(xpath = "//*[@class='lp']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id='counter_ToolbarMessages']")
    private WebElement countMessage;

    public String getUserName() {
        userMenu.click();
        return userName.getText();
    }

    public void logout() {
        userMenu.click();
        logoutBtn.click();
    }

    public void redirectToHome() {
        logo.click();
    }

    public void redirectToProfile() {
        redirectToHome();
        profileBtn.click();
    }

    public int getCountMessage() {
        return Integer.parseInt(countMessage.getText());
    }

}
