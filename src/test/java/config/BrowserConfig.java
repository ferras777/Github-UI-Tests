package config;

import org.aeonbits.owner.Config;

import java.net.URL;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface BrowserConfig extends Config {

    @DefaultValue("https://github.com/")
    @Key("browser.url")
    URL URL();

    @Key("github.login")
    String githubLogin();

    @Key("github.password")
    String githubPassword();

    @Key("github.repository.name")
    @DefaultValue("test-repo")
    String repositoryName();

    @Key("github.issue.name")
    @DefaultValue("test-issue")
    String issueName();
}
