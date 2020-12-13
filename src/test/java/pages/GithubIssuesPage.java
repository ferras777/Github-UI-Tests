package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GithubIssuesPage {

    @Step(value = "Нажать кнопку New Issue")
    public void clickNewIssueButton() {
        $x("//*[text()='New issue']/..").click();
    }

    @Step(value = "Назначить Issue на себя")
    public void assignIssueOnYourself() {
        $(byText("assign yourself")).click();
    }

    private void clickLabelsButton() {
        $x("//*[@id='labels-select-menu']/summary/*").click();
    }
    @Step(value = "Выбрать метку 'Баг'")
    public void pickBugLabel() {
        clickLabelsButton();
        $(byText("bug")).click();
        $("body").click();
    }
    @Step(value = "Вставить заголовок '{issueTitle}'")
    public void fillIssueTitle(String issueTitle) {
        $("#issue_title").val(issueTitle);
    }
    @Step(value = "Нажать кнопку создать")
    public void clickSubmitButton() {
        $(byText("Submit new issue")).click();
    }

    @Step(value = "Проверить создание Issue")
    public void isIssueOpen() {
        $("body").shouldHave(Condition.text("Open"));
    }
}
