package ok.technopolis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='toolbar_accounts-user_name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class='lp']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@class='button-pro form-actions_yes']")
    private WebElement confLogoutBtn;

    public String getUserName() {
        userMenu.click();
        return userName.getText();
    }

    public void logout() {
        userMenu.click();
        logoutBtn.click();
        confLogoutBtn.click();
    }
}
