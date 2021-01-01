package steps;

import io.qameta.allure.Step;
import pages.*;

public class GithubSteps {

    GithubMainPage githubMainPage = new GithubMainPage();
    GithubLoginPage githubLoginPage = new GithubLoginPage();
    GithubMainAccPage githubMainAccPage = new GithubMainAccPage();
    GithubIssuesPage githubIssuesPage = new GithubIssuesPage();
    GithubRepositoryPage githubRepositoryPage = new GithubRepositoryPage();


    @Step(value = "Открыть главную страницу Github и войти в аккаунт")
    public void openGithubMainPageAndSignInIntoAccount(String login, String password) {
        githubMainPage.openMainPage();
        githubMainPage.clickSignInButton();
        githubLoginPage.fillLoginField(login);
        githubLoginPage.fillPasswordField(password);
        githubLoginPage.clickSignInButton();
    }

    @Step(value = "Открыть новый Issue с именем {title}")
    public void openRepositoryPageAndOpenNewIssue(String repositoryName, String title) {
        githubMainAccPage.clickRepositoryByName(repositoryName);
        githubRepositoryPage.clickIssuesLink();
        githubIssuesPage.clickNewIssueButton();
        githubIssuesPage.assignIssueOnYourself();
        githubIssuesPage.fillIssueTitle(title);
        githubIssuesPage.pickBugLabel();
        githubIssuesPage.clickSubmitButton();
        githubIssuesPage.isIssueOpen();
    }
}
