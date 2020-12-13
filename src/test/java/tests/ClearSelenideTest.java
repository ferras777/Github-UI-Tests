package tests;

import base.TestBase;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ClearSelenideTest extends TestBase {

    private final String URL = "https://github.com/";
    private final String login = "";
    private final String password = "";
    private final String repositoryName = "qaguru-test";
    private final String newIssue = "New Issue";

    @Test
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
        $("#issue_title").val(newIssue);
        $(byText("Submit new issue")).click();
        $("body").shouldHave(Condition.text("Open"));
    }
}
