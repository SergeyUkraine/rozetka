package pages.IVV;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ApiHelper.getCurrentMethodName;

public class PaginationArea extends BasePage {

    private SelenideElement showMoreLink = $("a.catalog-more__link");

    private SelenideElement paginatorBlock = $(byXpath("//app-paginator/div"));
    private ElementsCollection paginatorList = $$("ul.pagination__list li");

    private SelenideElement nextPageIcon = $("a.pagination__direction_type_forward");
    private SelenideElement prevPageIcon = $(byXpath("//a[@class='pagination__direction']"));

    public PaginationArea clickOnShowMoreLink() {
        showMoreLink.shouldBe(visible).click();
        return this;
    }

    private PaginationArea clickOnPreviousPageIcon() {
        prevPageIcon.shouldBe(visible).click();
        return this;
    }

    private PaginationArea clickOnNextPageIcon() {
        nextPageIcon.shouldBe(visible).click();
        return this;
    }

    public boolean isShowMoreDisplayed() {
        return showMoreLink.isDisplayed();
    }

    public boolean isPaginatorDisplayed() {
        return paginatorBlock.isDisplayed();
    }

    public boolean doShowMore() {
        showMoreLink.waitUntil(visible, 5000).click();
        $(byXpath("//app-goods/ul")).waitUntil(visible, 5000);
        $$(byXpath("//app-goods/ul/li")).shouldBe(CollectionCondition.sizeGreaterThan(59));
        log.debug("  |- OK " + getCurrentMethodName());
        return true;
    }

    public PaginationArea clickOnThePageNumber(int pageNumber) {
        paginatorList.get(pageNumber - 1).shouldBe(visible).click();
        waitUntilLoadComplete();
        sleep(2000);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public boolean isPrevPageIconDisabled() {
        return $(byXpath("//a[@class='pagination__direction pagination__direction_state_disabled']")).isDisplayed();
    }

    public CatalogPage gotoPreviousPage() {
        clickOnPreviousPageIcon();
        waitUntilLoadComplete();
        sleep(2000);
        log.debug("  |- OK " + getCurrentMethodName());
        return new CatalogPage();
    }

    public boolean isNextPageIconDisabled() {
        return $(byXpath("//a[@class='pagination__direction pagination__direction_type_forward pagination__direction_state_disabled']")).isDisplayed();
    }

    public CatalogPage gotoNextPage() {
        clickOnNextPageIcon();
        waitUntilLoadComplete();
        sleep(1000);
        log.debug("  |- OK " + getCurrentMethodName());
        return new CatalogPage();
    }

    public CatalogPage gotoLastPageViaPaginator() {
        int size = paginatorList.size();
        paginatorList.get(size - 1).click();
        sleep(1000);
        log.debug("  |- OK " + getCurrentMethodName());
        return new CatalogPage();
    }
}
