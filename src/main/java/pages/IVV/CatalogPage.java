package pages.IVV;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import database.Goods;
import database.Producer;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ApiHelper.getCurrentMethodName;

public class CatalogPage extends BasePage {

    private ElementsCollection goodsList = $$(byXpath("//ul[@class='catalog-grid']/li")),
            goodsIdList = $$("div.goods-tile__inner");

    private String addToWishListIcon = "//ul[@class='catalog-grid']/li[%s]//button";
    private String addToCompareIcon = "//li[%s]//button[@class='compare-button']/..";
    private String goodsTitle = "//app-goods/ul/li[%s]//a[@class='goods-tile__heading']";

    public SelenideElement goodsWithBonusCheckbox = $(byXpath("//label[@for='С бонусами']"));


    private SelenideElement wishListTitleInputField = $("#wishlist_title"),
            authEmailInputField = $("#auth_email"),
            authPassInputField = $("#auth_pass"),
            saveToWishListButton = $(byXpath("//button[contains(@class, 'wishlist-modal')]")),
            enterWishListButton = $(byXpath("//span[text()='Войти']")),
            closeModalIcon = $(byXpath("//button[contains(@class, 'modal__close')]"));

    private SelenideElement sortingField = $("rz-catalog-sort select");

    private SelenideElement smallViewIcon = $(byXpath("//a[@title='Малая плитка']")),
            bigTileViewIcon = $(byXpath("//a[@title='Крупная плитка']"));

    public SelenideElement smallGoodsBlock = $("ul.catalog-grid li.goods-tile.goods-tile_type_slim");
    private ElementsCollection bigGoodsBlock = $$("ul.catalog-grid li.catalog-grid__cell");

    private void setWishListTitle(String value) {
        wishListTitleInputField.shouldBe(visible).clear();
        wishListTitleInputField.setValue(value);
    }

    private void setEmail(String email) {
        authEmailInputField.shouldBe(visible).clear();
        authEmailInputField.setValue(email);
    }

    private void setPassword(String password) {
        authPassInputField.shouldBe(visible).setValue(password);
    }

    private void clickOnSaveButton() {
        saveToWishListButton.shouldBe(visible).click();
    }

    private void clickOnEnterButton() {
        enterWishListButton.waitUntil(visible, 10000).click();
    }

    private void clickOnCloseWishListPopupIcon() {
        closeModalIcon.shouldBe(visible).click();
    }

    public CatalogPage clickOnShowMoreIcon() {
        new PaginationArea().clickOnShowMoreLink();
        sleep(2000);
        return this;
    }

    public String getFirstGoodsTitle() {
        return $(byXpath(String.format(this.goodsTitle, String.valueOf(1)))).waitUntil(visible, 5000).attr("title");
    }

    public ArrayList<Integer> getGoodsIdFromCatalog() {
        ArrayList<Integer> list = new ArrayList();
        for (SelenideElement selenideElement : goodsIdList) {
            list.add(Integer.valueOf(selenideElement.attr("data-goods-id")));
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return list;
    }

    public ArrayList getListOfGoodsTitleFromDb(ArrayList<Integer> idList) {
        ArrayList brands = new ArrayList();

        for (Integer id : idList) {
            Goods goods = Goods.findFirst("id = ?", id);
            Producer producer = Producer.findFirst("id = ?", goods.getInteger("producer_id"));
            brands.add(producer.getString("name"));
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return brands;
    }

    public AuthorizationArea openLoginPopup() {
        new HeaderArea().clickOnEnterToPersonalCabinetButton();
        return new AuthorizationArea();
    }

    public RozetkaGoodsPage openGoodsCardPage(int goodsNumber) {
        $(byXpath(String.format(goodsTitle, goodsNumber))).should(visible).click();
        return new RozetkaGoodsPage();
    }

    public CatalogPage addGoodsToWishList(int goodsQuantity) {
        for (int i = 1; i <= goodsQuantity; i++) {
            $(byXpath(String.format(addToWishListIcon, String.valueOf(i)))).waitUntil(visible, 5000).click();

            //"Костыль" для того, чтоб счетчик успевал обновляться
            sleep(2000);
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public List<String> getSeveralGoodsTitle(int goodsQuantity) {
        //moveCursorForDetectChanges();
        sleep(1000);
        List<String> goodsTitle = new ArrayList<>();
        for (int i = 1; i <= goodsQuantity; i++) {
            goodsTitle.add($(byXpath(String.format(this.goodsTitle, String.valueOf(i)))).attr("title"));
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return goodsTitle;
    }

    public int getBigGoodsBlockSize() {
        return bigGoodsBlock.size();
    }

    public CatalogPage setEmailAndClickOnSaveButton(String email) {
        setEmail(email);
        clickOnSaveButton();
        waitUntilLoadComplete();
        return this;
    }

    public CatalogPage setPasswordAndClickOnEnterButton(String password) {
        enterWishListButton.waitUntil(visible, 10000);
        setPassword(password);
        clickOnEnterButton();
        waitUntilLoadComplete();
        return this;
    }

    public CatalogPage setEmailAndPasswordAndClickOnEnterButton(String email, String password) {
        enterWishListButton.shouldBe(visible);
        setEmail(email);
        setPassword(password);
        clickOnEnterButton();
        waitUntilLoadComplete();
        return this;
    }

    public CatalogPage changeWishListTitle(String wishListTitle) {
        setWishListTitle(wishListTitle);
        return this;
    }

    public CatalogPage closeAddToWishListPopup() {
        clickOnCloseWishListPopupIcon();
        return this;
    }

    public boolean checkDataOnGoodsCard(String verifiedData) {
        waitUntilLoadComplete();
        return new GoodsCard().isDataPresentOnGoodsCard(verifiedData);
    }

    public CatalogPage scrollToBottomOfPage() {
        Selenide.executeJavaScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight)-200);");
        sleep(1000);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public int getPageYOffset() {
        return (int) (long) Selenide.executeJavaScript("return window.pageYOffset");
    }

    public boolean isMoreThanOnePageOpened(int minValue, int maxValue) {
        waitUntilLoadComplete();
        if (goodsList.size() >= minValue && goodsList.size() <= maxValue) {
            return true;
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return false;
    }

    public CatalogPage changeViewToBigTile() {
        bigTileViewIcon.shouldBe(visible).click();
        sleep(500);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public CatalogPage changeViewToSmallView() {
        smallViewIcon.shouldBe(visible).click();
        sleep(500);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public String getViewType() {
        if ($("li.catalog-grid__cell_type_slim").isDisplayed()) {
            return "small";
        } else if (!$("li.catalog-grid__cell_type_slim").isDisplayed()) {
            return "big";
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return "";
    }

    public int getGoodsListSize() {
        sleep(1000);
        return goodsList.size();
    }

    public CatalogPage sortGoodsBy(String sortValue) {
        sortingField.selectOption(sortValue);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public CatalogPage selectFilterByTitle(String filterBlock, String filterItem) {
        new FiltersArea().selectFilterByTitle(filterBlock, filterItem);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public CatalogPage addGoodsToCompare(int goodsNumber) {
        $(byXpath(String.format(addToCompareIcon, goodsNumber))).shouldBe(visible).click();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }
}

