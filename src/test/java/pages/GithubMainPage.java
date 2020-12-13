package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubMainPage {
    private final String URL = "https://github.com/";

    @Step(value = "Открыть главную страницу Github")
    public void openMainPage() {
        open(URL);
    }
    @Step(value = "Нажать кнопку войти")
    public void clickSignInButton() {
        $(byText("Sign in")).click();
    }
}
