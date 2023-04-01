package ok.technopolis;

import ok.technopolis.helpers.PageBuilder;
import ok.technopolis.pages.HomePage;
import ok.technopolis.pages.LoginPage;
import ok.technopolis.pages.ProfilePage;

public class App {
    public LoginPage loginPage;
    public HomePage homePage;
    public ProfilePage profilePage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        homePage = PageBuilder.buildHomePage();
        profilePage = PageBuilder.buildProfilePage();
    }
}
