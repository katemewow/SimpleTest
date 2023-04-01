package ok.technopolis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public WebDriver driver;
    public ToolbarWrapper toolbar;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        toolbar = new ToolbarWrapper(driver);
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

}
