package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.GithubSteps;

public class SelenideStepAnnotationTest extends TestBase {

    GithubSteps githubSteps = new GithubSteps();

    @Test
    @DisplayName("Sign in and create issue with steps")
    @Feature("Issues")
    @Story("User should can create issue")
    @Link(url = "https://github.com", name = "Github")
    @Owner("ilyaM")
    @Severity(SeverityLevel.CRITICAL)
    public void singInIntoGithubAccountAndOpenNewIssueTest() {
        githubSteps.openGithubMainPageAndSignInIntoAccount(login, password);
        githubSteps.openRepositoryPageAndOpenNewIssue(repositoryName, issue);
    }
}
