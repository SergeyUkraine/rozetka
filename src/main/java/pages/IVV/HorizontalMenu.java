package pages.IVV;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.restassured.RestAssured;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.ApiHelper.getCurrentMethodName;

public class HorizontalMenu extends BasePage {

    private SelenideElement fashionMenuLink = $("h3.fashion-menu__genders-title a"),
            womenLink = $(byXpath("//ul[@class='fashion-menu__genders']/li[2]/button")),
            menLink = $(byXpath("//ul[@class='fashion-menu__genders']/li[3]/button")),
            girlsLink = $(byXpath("//ul[@class='fashion-menu__genders']/li[4]/button")),
            boysLink = $(byXpath("//ul[@class='fashion-menu__genders']/li[5]/button")),
            childrenLink = $(byXpath("//ul[@class='fashion-menu__genders']/li[6]/button"));

    private ElementsCollection linksList = $$(byXpath("//div[@class='fashion-menu__body js-fashion-menu-body']//a"));

    public String getMainFashionTitle() {
        return fashionMenuLink.getText().trim();
    }

    public String getMainFashionLink() {
        return fashionMenuLink.attr("href").split(".ua/")[1];
    }

    public String getMenLinkTitle() {
        return menLink.getText().trim();
    }

    public String getWomenLinkTitle() {
        return womenLink.getText().trim();
    }

    public String getChildrenLinkTitle() {
        return childrenLink.getText().trim();
    }

    public String getBoysLinkTitle() {
        return boysLink.getText().trim();
    }

    public String getGirlsLinkTitle() {
        return girlsLink.getText().trim();
    }

    private ArrayList getLinksTitle() {
        ArrayList<String> list = new ArrayList();
        for (SelenideElement aLinksLink : linksList) {
            list.add(aLinksLink.getText().trim());
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return list;
    }

    public ArrayList getPartOfLinks() {
        ArrayList<String> list = new ArrayList();
        for (SelenideElement aLinksLink : linksList) {
            log.debug(aLinksLink.attr("href").split(".ua/")[1]);
            list.add(aLinksLink.attr("href").split(".ua/")[1]);
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return list;
    }

    public int getStatusCodeOfResponse(String url) {
        int statusCode = RestAssured.when()
                .get(url)
                .then()
                .extract()
                .statusCode();
        log.debug("  |- OK " + getCurrentMethodName());
        return statusCode;
    }

    public SuperPortalPage clickOnFashionMainLink() {
        fashionMenuLink.shouldBe(visible).click();
        return new SuperPortalPage();
    }

    public HorizontalMenu clickOnMenLink() {
        menLink.shouldBe(visible).click();
        return this;
    }

    public HorizontalMenu clickOnWomenLink() {
        womenLink.shouldBe(visible).click();
        return this;
    }

    public HorizontalMenu clickOnChildrenLink() {
        childrenLink.shouldBe(visible).click();
        return this;
    }

    public HorizontalMenu clickOnBoysLink() {
        boysLink.shouldBe(visible).click();
        return this;
    }

    public HorizontalMenu clickOnGirlsLink() {
        girlsLink.shouldBe(visible).click();
        return this;
    }

    public boolean isLinksTitleEqualTo(List<String> title) {
        ArrayList list = getLinksTitle();
        List<String> titles = title;

        for (int i = 0; i < list.size(); i++) {
            log.debug("  |- Title from menu - " + list.get(i));
            log.debug("  |- Title from data file - " + titles.get(i));
            if (!list.get(i).equals(titles.get(i))) {
                return false;
            }
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    public boolean isLinksHrefEqualTo(List<String> hrefList) {
        ArrayList list = getPartOfLinks();
        List<String> href = hrefList;

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(href.get(i))) {
                log.error(" - Link from menu - " + list.get(i));
                log.debug(" - Link from data file - " + href.get(i));
                return false;
            }
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    public boolean isLinksHaveStatusCode200(String baseUrl) {
        ArrayList<String> list = getPartOfLinks();
        for (String s : list) {
            log.debug("  |- request link - " + baseUrl + s);
            if (getStatusCodeOfResponse(baseUrl + s) != 200) {
                return false;
            }
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    public boolean isHorizontalMenuOpened() {
        return $("button.fashion-menu__genders-button.fashion-menu__genders-button_state_active").exists();
    }
}
