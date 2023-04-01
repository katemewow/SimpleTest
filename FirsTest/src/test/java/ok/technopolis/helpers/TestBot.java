package ok.technopolis.helpers;

public class TestBot {
    private final String userName;
    private final String login;
    private final String password;
    private final String id;
    private final String about;

    public TestBot() {
        userName = ConfProperties.getProperty("userName");
        login = ConfProperties.getProperty("login");
        password = ConfProperties.getProperty("password");
        id = ConfProperties.getProperty("id");
        about = ConfProperties.getProperty("note");
    }

    public String getUserName() {
        return userName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return about;
    }
}
