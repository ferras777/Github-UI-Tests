package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.GithubSteps;

public class SelenideStepAnnotationTest extends TestBase {

    private final String newIssue = "New Issue";

    GithubSteps githubSteps = new GithubSteps();

    @Test
    @DisplayName(value = "Войти в аккаунт и создать новую Issue в репозитории")
    public void singInIntoGithubAccountAndOpenNewIssueTest() {
        githubSteps.openGithubMainPageAndSignInIntoAccount();
        githubSteps.openNewIssue(newIssue);
    }
}
