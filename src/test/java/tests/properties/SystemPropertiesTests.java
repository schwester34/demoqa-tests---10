package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTests {

    @Test
    void someTest3() {
        String browser = System.getProperty("browser", "chrome");
        System.out.println(browser);
    }

    @Test
    void someTest4() {
        CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
        String selenoidLogin = credentialsConfig.login();
        String selenoidPassword = credentialsConfig.password();

        System.out.println(selenoidLogin);
        System.out.println(selenoidPassword);
    }

}
