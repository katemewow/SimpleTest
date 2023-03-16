package ok.technopolis;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"field_email\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"field_password\"]")
    private WebElement passwdInput;

    public void login(String login, String passwd) {
        loginInput.sendKeys(login);
        passwdInput.sendKeys(passwd);
        passwdInput.sendKeys(Keys.ENTER);
    }

}
