package pages.IVV;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static helpers.ApiHelper.getCurrentMethodName;

public class HeaderArea extends BasePage {

    private SelenideElement enterToPersonalCabinetButton = $("a.header-topline__user-link.link-dashed");
    private SelenideElement logoutLink = $(byXpath("//a[contains(@href, 'signout')]"));
    private SelenideElement userNameField = $("a.header-topline__user-link.link-dashed");
    private SelenideElement loginModal = $("single-modal-window user-identification");

    private SelenideElement goodsCatalogButton = $(byXpath("//fat-menu/../button"));

    public SelenideElement bonusIcon = $(byXpath("//li[contains(@class, 'type_bonus')]//a"));
    private SelenideElement compareCounter = $("li.js-app-comparison span.header-actions__button-counter");
    private SelenideElement activeWishListIcon = $(byXpath("//li[contains(@class, 'type_wish')]//a[contains(@class, 'state_active')]"));
    private SelenideElement wishListCounter = $("li.js-app-wishlist span.header-actions__button-counter");
    private SelenideElement activeBasketIcon = $("a.header-actions__button_type_basket");

    public FatMenuArea openCatalogFatMenu() {
        goodsCatalogButton.waitUntil(visible, 5000).click();
        new FatMenuArea().firstLevelLinksBlock.waitUntil(visible, 10000);
        return new FatMenuArea();
    }

    public void clickOnEnterToPersonalCabinetButton() {
        enterToPersonalCabinetButton.shouldBe(visible).click();
    }

    public WishListPage openWishListPage() {
        activeWishListIcon.waitUntil(visible, 10000).click();
        waitUntilLoadComplete();
        log.debug("  |- OK " + getCurrentMethodName());
        return new WishListPage();
    }

    public AuthorizationArea openLoginPopup() {
        clickOnEnterToPersonalCabinetButton();
        loginModal.waitUntil(visible, 5000).shouldBe(visible);
        log.debug("  |- OK " + getCurrentMethodName());
        return new AuthorizationArea();
    }

    public HeaderArea logout() {
        sleep(1000);
        userNameField.shouldNotHave(text("войдите в личный кабинет"));
        userNameField.shouldBe(visible).hover();
        logoutLink.waitUntil(visible, 5000).click();
        $(byText("войдите в личный кабинет")).waitUntil(visible, 10000);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public void checkStatusAndLogout() {
        if ($(byText("войдите в личный кабинет")).is(not(visible))) {
            userNameField.hover();
            logoutLink.waitUntil(visible, 5000).click();
            $(byText("войдите в личный кабинет")).waitUntil(visible, 10000);
            log.debug("  |- OK " + getCurrentMethodName());
        }
    }

    public boolean isCompareCounterPresent() {
        return compareCounter.waitUntil(visible, 5000).is(exist);
    }

    public boolean isCompareCounterEquals(int quantity) {
        return Integer.valueOf(compareCounter.getText()).equals(quantity);
    }

    public boolean isWishListCounterAbsent() {
        return wishListCounter.waitWhile(visible, 5000).is(not(exist));
    }

    public boolean isWishListCounterEquals(int goodsQuantity) {
        return Integer.valueOf(wishListCounter.getText()).equals(goodsQuantity);
    }
}
