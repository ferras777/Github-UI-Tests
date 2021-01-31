package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.net.URL;

import static config.ConfigHelper.*;

public class TestBase {

    protected final URL URL = getURL();
    protected final String login = getGithubLogin();
    protected final String password = getGithubPassword();
    protected final String repositoryName = getRepositoryName();
    protected final String issue = getIssueName();

    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @AfterEach
    void cleanUp() {
        Selenide.closeWebDriver();
    }
}
