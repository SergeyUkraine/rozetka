package rozetka;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;

public class SetupTest {
    protected Logger log = LoggerFactory.getLogger(SetupTest.class);

    public enum Browsers {CHROME, FIREFOX, IE, EDGE}

    @Parameters({"browser", "baseUrl", "hubUrl"})
    @BeforeClass
    public void init(Browsers browser, String baseUrl, String hubUrl) {

        //вывод только ошибок Selenium and Selenide
        java.util.logging.Logger.getLogger("com.codeborne.selenide.").setLevel(Level.SEVERE);
        java.util.logging.Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.SEVERE);

        Configuration.browser = browser.toString().toLowerCase();
        Configuration.remote = hubUrl;
        Configuration.startMaximized = true;
        Configuration.baseUrl = baseUrl;
        open(baseUrl);
    }

    @AfterClass
    public void down() {
        Selenide.close();
    }
}
