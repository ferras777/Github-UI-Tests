package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GithubLoginPage {

    @Step(value = "Ввести логин")
    public void fillLoginField(String login) {
        $("#login_field").val(login);
    }

    @Step(value = "Ввести пароль")
    public void fillPasswordField(String password) {
        $("#password").val(password);
    }

    @Step(value = "Нажать кнопку войти")
    public void clickSignInButton() {
        $("input[type='submit']").click();
    }
}
