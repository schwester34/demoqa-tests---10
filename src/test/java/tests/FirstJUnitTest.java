package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class FirstJUnitTest {
    @BeforeEach
    void openBrowser(){
        System.out.println("");
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void closeBrowser(){
        Selenide.closeWebDriver();
    }
    @Test
    void simpleTest() {
        Assertions.assertTrue( 2<3);
    }
}
