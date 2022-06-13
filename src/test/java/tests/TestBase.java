package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    @BeforeAll
    static void setUp (){
        CredentialsConfig credentialConfig = ConfigFactory.create(CredentialsConfig.class);
        String selenoidLogin = credentialConfig.login();
        String selenoidPassword = credentialConfig.password();

        String selenoidURL = System.getProperty("selenoidURL");
        System.out.println(selenoidURL);
        String selenoidConnectionString = String.format("https://%s:%s@%s/wd/hub;",
                selenoidLogin,
                selenoidPassword,
                selenoidURL);
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.remote = selenoidConnectionString;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    void addAttachments (){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }
}
