package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void setUp() {
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
