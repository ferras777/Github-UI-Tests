package config;

import org.aeonbits.owner.ConfigFactory;

import java.net.URL;

public class ConfigHelper {

    public static URL getURL() {
        return getConfig().URL();
    }

    public static String getGithubLogin() {
        return getConfig().githubLogin();
    }

    public static String getGithubPassword() {
        return getConfig().githubPassword();
    }

    public static String getRepositoryName() {
        return getConfig().repositoryName();
    }

    public static String getIssueName() {
        return getConfig().issueName();
    }

    private static BrowserConfig getConfig() {
        return ConfigFactory.newInstance().create(BrowserConfig.class, System.getProperties());
    }
}
