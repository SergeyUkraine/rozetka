package pages.IVV;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ApiHelper.getCurrentMethodName;

public class SuperPortalPage extends BasePage {

    private SelenideElement womenLink = $(byXpath("//a[text()=' Женщинам ']")),
                            mainWomenImage = $(byXpath("//img[contains(@src, 'assets/img/superportal/women_top_spring.jpg')]")),
                            firstWomenImage = $(byXpath("//section[@class='portal-row']//img[contains(@src, 'assets/img/superportal/women_wide_1.jpg')]")),
                            secondWomenImage = $(byXpath("//ul[@class='portal-row']/li[1]//img[contains(@src, 'assets/img/superportal/woman_sandals.jpg')]")),
                            thirdWomenImage = $(byXpath("//ul[@class='portal-row']/li[2]//img[contains(@src, 'assets/img/superportal/women_square_2.jpg')]")),
                            fourthWomenImage = $(byXpath("//ul[@class='portal-row']/li[3]//img[contains(@src, 'assets/img/superportal/woman_swimwear.jpg')]")),
                            fifthWomenImage = $(byXpath("//section[@class='portal-row portal-row_type_reverse']/a//img[contains(@src, 'assets/img/superportal/woman_dresses_wide.jpg')]")),

                            menLink = $(byXpath("//a[text()=' Мужчинам ']")),
                            mainMenImage = $(byXpath("//img[contains(@src, 'assets/img/superportal/men_top_spring.jpg')]")),
                            firstMenImage = $(byXpath("//section[@class='portal-row']//img[contains(@src, 'assets/img/superportal/men_wide_1.jpg')]")),
                            secondMenImage = $(byXpath("//ul[@class='portal-row']/li[1]//img[contains(@src, 'assets/img/superportal/men_shoes_wide.jpg')]")),
                            thirdMenImage = $(byXpath("//ul[@class='portal-row']/li[2]//img[contains(@src, 'assets/img/superportal/men_square_2.jpg')]")),
                            fourthMenImage = $(byXpath("//ul[@class='portal-row']/li[3]//img[contains(@src, 'assets/img/superportal/men_square_3.jpg')]")),
                            fifthMenImage = $(byXpath("//section[@class='portal-row portal-row_type_reverse']/a//img[contains(@src, 'assets/img/superportal/men_shirts_wide.jpg')]")),

                            childrenLink = $(byXpath("//a[text()=' Детям ']")),
                            mainChildrenImage = $(byXpath("//img[contains(@src, 'assets/img/superportal/kids_top_spring.jpg')]")),
                            firstChildrenImage = $(byXpath("//section[@class='portal-row']//img[contains(@src, 'assets/img/superportal/kids_wide_3.jpg')]")),
                            secondChildrenImage = $(byXpath("//section[@class='portal-row portal-row_type_reverse']//img[contains(@src, 'assets/img/superportal/kids_wide_1.jpg')]")),
                            thirdChildrenImage = $(byXpath("//section[@class='portal-row']//img[contains(@src, 'assets/img/superportal/kids_wide_2.jpg')]"));

    private ElementsCollection brands = $$(byXpath("//li[@class='portal-popular__item']/a"));
    private SelenideElement mainAdvertiseBlock = $(byXpath("//section[@class='portal-row']")),
                            firstAdvertiseBlock = $(byXpath("//app-portal-content//section[@class='portal-row'][1]//div[@class='portal-column']")),
                            secondAdvertiseBlock = $(byXpath("//app-portal-content//section[@class='portal-row portal-row_type_reverse']//div[@class='portal-column']")),
                            thirdAdvertiseBlock = $(byXpath("//app-portal-content//section[@class='portal-row'][2]//div[@class='portal-column']")),
                            actualSalesBlock = $("section.portal-sales");

    public SuperPortalPage clickOnWomenLink() {
        womenLink.shouldBe(visible).click();
        womenLink.waitUntil(have(cssClass("portal-cats__link_state_active")),5000);
        return this;
    }

    public SuperPortalPage clickOnMenLink() {
        menLink.shouldBe(visible).click();
        menLink.waitUntil(have(cssClass("portal-cats__link_state_active")),5000);
        return this;
    }

    public SuperPortalPage clickOnChildrenLink() {
        childrenLink.shouldBe(visible).click();
        childrenLink.waitUntil(have(cssClass("portal-cats__link_state_active")), 5000);
        return this;
    }

    private ArrayList getBrandsLinks() {
        ArrayList<String> list = new ArrayList<String>();
        for (SelenideElement brand : brands) {
            list.add(brand.attr("href").split("com.ua/")[1]);
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return list;
    }

    private ArrayList getBrandsTitles() {
        ArrayList<String> list = new ArrayList<String>();
        for (SelenideElement brand : brands) {
            list.add(brand.attr("title").trim());
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return list;
    }

    public String getActiveGenderTitle(){
        log.debug("  |- OK " + getCurrentMethodName());
        return $("a.portal-cats__link_state_active").getText();
    }

    public boolean isBrandOnSuperPortalIsEqualToCatalog(String baseUrl) {
        SelenideElement brandTitle = $(byXpath("//a[@class='catalog-selection__link']"));
        ArrayList<String> links = getBrandsLinks();
        ArrayList<String> titles = getBrandsTitles();
        for (int i = 0; i < links.size(); i++) {
            open(baseUrl + links.get(i));
            if (!brandTitle.shouldBe(visible).getText().replaceAll("’", "'").trim().equals(titles.get(i).replaceAll("’", "'"))){
                return false;
            }
        }
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    public boolean isMainGenderImagesPresent() {
        waitUntilLoadComplete();
        return mainWomenImage.isDisplayed() &&
                mainMenImage.isDisplayed() &&
                mainChildrenImage.isDisplayed();
    }

    public boolean isMainWomenImagePresent() {
        waitUntilLoadComplete();
        return firstWomenImage.isDisplayed() &&
                secondWomenImage.isDisplayed() &&
                thirdWomenImage.isDisplayed() &&
                fourthWomenImage.isDisplayed() &&
                fifthWomenImage.isDisplayed();
    }

    public boolean isMainMenImagesPresent() {
        waitUntilLoadComplete();
        return firstMenImage.isDisplayed() &&
                secondMenImage.isDisplayed() &&
                thirdMenImage.isDisplayed() &&
                fourthMenImage.isDisplayed() &&
                fifthMenImage.isDisplayed();
    }

    public boolean isMainChildrenImagesPresent() {
        waitUntilLoadComplete();
        return firstChildrenImage.isDisplayed() &&
                secondChildrenImage.isDisplayed() &&
                thirdChildrenImage.isDisplayed();
    }

    public boolean isMainAdvertiseBlockPresent(){
        waitUntilLoadComplete();
        return mainAdvertiseBlock.isDisplayed();
    }

    public boolean isActualSalesBlockPresent() {
        waitUntilLoadComplete();
        return actualSalesBlock.isDisplayed();
    }

    public boolean isAdvertiseBlocksPresent() {
        waitUntilLoadComplete();
        return firstAdvertiseBlock.isDisplayed() &&
                secondAdvertiseBlock.isDisplayed();
    }

    public boolean isChildrenAdvertiseBlocksPresent(){
        waitUntilLoadComplete();
        return firstAdvertiseBlock.isDisplayed() &&
                secondAdvertiseBlock.isDisplayed() &&
                thirdAdvertiseBlock.isDisplayed();
    }
}
