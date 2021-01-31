package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected final String URL = "https://github.com/";
    protected final String login = "";
    protected final String password = "";
    protected final String repositoryName = "qaguru-test";
    protected final String newIssue = "New Issue";

    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Selenide.clearBrowserCookies();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @AfterEach
    void cleanUp() {
        Selenide.closeWebDriver();
    }
}
