package pages.IVV;

import com.codeborne.selenide.ElementsCollection;
import pages.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.ApiHelper.getCurrentMethodName;

public class GoodsCard extends BasePage {

    private ElementsCollection goodsList = $$(byXpath("//app-goods/ul/li"));
    private String addToWishListIcon = "//li[%s]//button[@class='wish-button js-wish-button']";
    private String goodsPicture = "//li[%s]//a[@class='goods-tile__picture']/img";
    private String goodsBrand = "//li[%s]//span[@class='goods-tile__title']/strong";
    private String goodsTitle = "//li[%s]//a[@class='goods-tile__heading']";
    private String goodsPrice = "//li[%s]//span[@class='goods-tile__price-value']";
    private String goodsBonus = "//li[%s]//p[@class='goods-tile__bonuses']";
    private String goodsCompare = "//li[%s]//button[@class='compare-button']";

    private boolean checkData(String data) {
        waitUntilLoadComplete();
        for (int i = 1; i <= goodsList.size(); i++) {
            if (!$(byXpath(String.format(data, String.valueOf(i)))).is(exist)) {
                log.debug("  |- WARNING element isn't present in " + i + " goods card");
                return false;
            }
            log.debug("  |- OK element is present in " + i + " goods card");
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    boolean isDataPresentOnGoodsCard(String data) {
        switch (data) {
            case "picture":
                return checkData(goodsPicture);
            case "brand":
                return checkData(goodsBrand);
            case "title":
                return checkData(goodsTitle);
            case "price":
                return checkData(goodsPrice);
            case "bonus":
                return checkData(goodsBonus);
            case "wishListIcon":
                return checkData(addToWishListIcon);
            case "compare":
                return checkData(goodsCompare);
        }
        return false;
    }
}
