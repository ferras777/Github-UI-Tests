package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GithubMainAccPage {

    @Step(value = "Нажать ссылку на репозиторий {repositoryName}")
    public void clickRepositoryByName(String repositoryName) {
        $("[title='" + repositoryName + "']").click();
    }
}
