package tests;

import base.TestBase;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaSelenideTests extends TestBase {

    private final String URL = "https://github.com/";
    private final String login = "";
    private final String password = "";
    private final String repositoryName = "qaguru-test";
    private final String issueName = "Bug #1";

    @Test
    public void singInIntoGithubAccountAndOpenNewIssueTest() {
        step("Открываем страницу " + URL, () -> open(URL));
        step("Входим в аккаунт", () -> {
            $(byText("Sign in")).click();
            $("#login_field").val(login);
            $("#password").val(password);
            $("input[type='submit']").click();
        });
        step("Открываем репозиторий " + repositoryName, () -> {
            $("[title='" + repositoryName + "']").click();
        });
        step("Создаем новый Issue c названием " + issueName, () -> {
            $("[data-tab-item='i1issues-tab']").click();
            $x("//*[text()='New issue']/..").click();
            $(byText("assign yourself")).click();
            $x("//*[@id='labels-select-menu']/summary/*").click();
            $(byText("bug")).click();
            $("body").click();
            $("#issue_title").val(issueName);
            $(byText("Submit new issue")).click();
            $("body").shouldHave(Condition.text("Open"));
        });
    }
}
