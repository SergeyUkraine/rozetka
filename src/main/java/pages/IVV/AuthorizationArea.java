package pages.IVV;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.SkipException;
import pages.BasePage;
import pages.IVV.CatalogPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ApiHelper.getCurrentMethodName;

public class AuthorizationArea extends BasePage {

    private SelenideElement emailField = $(By.id("auth_email"));
    private SelenideElement passwordField = $(By.id("auth_pass"));

    private void clickOnLoginButton() {
        long t = Configuration.timeout;
        Configuration.timeout = 500;
        $(".auth-modal__submit").shouldBe(visible).click();
        if ($(byId("social_popup")).isDisplayed()) {
            $(byId("social_popup")).$(byXpath(".//a[@name='close']")).click();
            $(byXpath("//div[@class='social-bind social-bind-tiny']")).waitUntil(disappear, 5000);
        }
        Configuration.timeout = t;
    }

    private void setEmailData(String email) {
        emailField.shouldBe(visible).setValue(email);
    }

    private void setPasswordData(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }


    public CatalogPage loginAs(String email, String password) {
        if ($("re-captcha").is(exist)) {
            log.info("    reCaptcha is present and test is skipped");
            throw new SkipException("Test skipped");
        } else {
            setEmailData(email);
            setPasswordData(password);
            clickOnLoginButton();
            waitUntilLoadComplete();
            log.debug("  |- OK " + getCurrentMethodName());
        }
        return new CatalogPage();
    }
}
