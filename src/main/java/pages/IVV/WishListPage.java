package pages.IVV;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static helpers.ApiHelper.getCurrentMethodName;

public class WishListPage extends BasePage {

    private String goodsTitle = "//li[contains(@class, 'catalog-grid__cell')][%s]//span[@class='goods-tile__title']";

    private SelenideElement wishListTitle = $(byXpath("h3.wish-details__heading"));
    private SelenideElement clearListLink = $(byXpath("//span[text()='Удалить список']"));

    public String getWishListTitle() {
        return wishListTitle.getText();
    }

    private void clickOnClearListLink() {
        clearListLink.shouldBe(visible).click();
    }

    private void clickOnConfirmYesButton() {
        $(byXpath("//span[text()='Да, удалить']")).shouldBe(visible).click();
    }

    public List<String> getSeveralGoodsTitle(int goodsQuantity) {
        List<String> goodsTitle = new ArrayList<>();

        if ($(byXpath("//div[@class='social-bind social-bind-tiny']")).isDisplayed()) {
            $(byXpath("//div[@class='social-bind social-bind-tiny']/a")).click();
        }
        //Если появляется попап "оплаты частями" то нужно добавить этот медот, для его закрытия
        //checkPayForPartPopupAndCloseIt();
        for (int i = goodsQuantity; i >= 1; i--) {
            goodsTitle.add($(byXpath(String.format(this.goodsTitle, String.valueOf(i)))).getText());
        }
        log.debug("  |- OK " + getCurrentMethodName());

        return goodsTitle;
    }

    public WishListPage clearWishList() {
        if (clearListLink.is(not(visible))) {
            log.debug("list is empty");
        } else {
            clickOnClearListLink();
            //Если появляется попап "оплаты частями" то нужно добавить этот медот, для его закрытия
            //checkPayForPartPopupAndCloseIt();
            clickOnConfirmYesButton();
            waitUntilLoadComplete();
            $(byId("firstlist_button")).waitUntil(visible, 10000);
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public void backToPreviousPage() {
        back();
        log.debug("  |- OK " + getCurrentMethodName());
    }
}

