package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GithubRepositoryPage {

    @Step(value = "Нажать ссылку Issues")
    public void clickIssuesLink() {
        $("[data-tab-item='i1issues-tab']").click();
    }
}
