package tests;

import base.TestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaSelenideTest extends TestBase {

    @Test
    @DisplayName("Sign in and create issue lambda steps")
    @Feature("Issues")
    @Story("User should can create issue")
    @Link(url = "https://github.com", name = "Github")
    @Owner("ilyaM")
    @Severity(SeverityLevel.CRITICAL)
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
        step("Создаем новый Issue c названием " + issue, () -> {
            $("[data-tab-item='i1issues-tab']").click();
            $x("//*[text()='New issue']/..").click();
            $(byText("assign yourself")).click();
            $x("//*[@id='labels-select-menu']/summary/*").click();
            $(byText("bug")).click();
            $("body").click();
            $("#issue_title").val(issue);
            $(byText("Submit new issue")).click();
            $("body").shouldHave(Condition.text("Open"));
        });
    }
}
