package tests;

import base.TestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ClearSelenideTest extends TestBase {

    @Test
    @DisplayName("Sign in and create issue")
    @Feature("Issues")
    @Story("User should can create issue")
    @Link(url = "https://github.com", name = "Github")
    @Owner("ilyaM")
    @Severity(SeverityLevel.CRITICAL)
    public void singInIntoGithubAccountAndOpenNewIssueTest() {
        open(URL);
        $(byText("Sign in")).click();
        $("#login_field").val(login);
        $("#password").val(password);
        $("input[type='submit']").click();
        $("[title='" + repositoryName + "']").click();
        $("[data-tab-item='i1issues-tab']").click();
        $x("//*[text()='New issue']/..").click();
        $(byText("assign yourself")).click();
        $x("//*[@id='labels-select-menu']/summary/*").click();
        $(byText("bug")).click();
        $("body").click();
        $("#issue_title").val(issue);
        $(byText("Submit new issue")).click();
        $("body").shouldHave(Condition.text("Open"));
    }
}
