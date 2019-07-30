package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class BasePage {

    static protected Logger log = LoggerFactory.getLogger(BasePage.class);

    private SelenideElement preLoader = $(byXpath("//div[@class='preLoader']"));


    protected static void openAndSwitchNewTab(String url) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get(url);
        log.debug("  |- OK " + format("OpenAndSwitchNewTab: %s", url));
    }

    protected static void switchToTub(int tab) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
        log.debug("  |- OK " + format("SwitchToTub %s ", tab));
    }

    public static boolean waitUntilAjaxComplete() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        log.debug("  |- OK waitUntilAjaxComplete");
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

//    protected  void waitPreloader() {
//        $( preLoader ).waitUntil( hidden, 60000 );
//    }

    protected static void checkPopupAndClose() {
        if ($(byXpath("//div[text()='Оплата частями!']")).is(Condition.appear)) {
            $("span.exponea-close-cross").click();
        }

        String social_popup = "#social_popup a[name='close']";
        if ($(social_popup).isDisplayed()) {
            $(social_popup).click();
            $(social_popup).waitUntil(not(exist), 1000);
        }
    }

    public static void waitUntilLoadComplete() {
        $(".preloader").waitUntil(hidden, 60000);
    }

    //Костыль для иммитации движения мышкой
    public void moveCursorForDetectChanges() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        robot.mouseMove(random.nextInt(500), random.nextInt(500));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.mouseMove(random.nextInt(500), random.nextInt(500));
    }

    /**
     * При работе тестов с многоми браузерами  нухжно каждый раз явно создавать Actions для текущего драйвера
     */
    protected static void mooveToElement(SelenideElement element) {
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.moveToElement(element).build().perform();
    }

    public void scrollToEndPageWithHistory(){
        WebDriver driver = WebDriverRunner.getWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i = 0; i <=12; i++){
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            waitUntilAjaxComplete();
        }
    }

}


