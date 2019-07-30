package pages.IVV;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ApiHelper.getCurrentMethodName;

public class FiltersArea extends BasePage {

    private ElementsCollection brandTitleList = $$(byXpath("//div[@class='sidebar-block js-sidebar-block'][1]//li//input"));

    private SelenideElement minPriceField = $(byXpath("//input[@formcontrolname='min']")),
            maxPriceField = $(byXpath("//input[@formcontrolname='max']")),
            minPriceSlider = $("button.rz-slider__range-button_type_left"),
            maxPriceSlider = $("button.rz-slider__range-button_type_right"),
            priceSlider = $("div.rz-slider-wrapper"),
            priceButton = $("button.slider-filter__button"),

    goodsCounter = $("p.catalog-selection__label"),
            clearAllFiltersIcon = $(byXpath("//button[contains(text(),'Сбросить')]"));

    private String selectedFilters = "//div[@class='catalog-settings']//div[1]//li[%s]";
    private String filterItemWithTitle = "//button[contains(text(), '%s')]/following-sibling::div//label[contains(@for, '%s')]";
    private String filterBlockTitle = "//button[contains(text(), '%s')]";
    private String filterLabelList = "/following-sibling::div//label";
    private String closedFilterChecking = "/parent::div[contains(@class, 'sidebar-block_state_collapsed')]";
    private String filterSearchInputField = "/following-sibling::div//input[@type='search']";

    public FiltersArea selectFilterByTitle(String filterBlock, String filterItem) {
        if ($(byXpath(String.format(filterBlockTitle, filterBlock) + closedFilterChecking)).is(exist)) {
            $(byXpath(String.format(filterBlockTitle, filterBlock))).click();
        }
        waitUntilLoadComplete();
        $(byXpath(String.format(filterItemWithTitle, filterBlock, filterItem))).waitUntil(visible, 10000).click();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea selectFilterByNumber(String filterBlock, int filterNumber) {
        if ($(byXpath(String.format(filterBlockTitle, filterBlock) + closedFilterChecking)).is(exist)) {
            $(byXpath(String.format(filterBlockTitle, filterBlock))).click();
        }
        waitUntilLoadComplete();
        $$(byXpath(String.format(filterBlockTitle, filterBlock) + filterLabelList)).get(filterNumber - 1).click();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea clickOnPriceButton() {
        priceButton.shouldBe(visible).click();
        waitUntilLoadComplete();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea clickOnClearAllFilters() {
        clearAllFiltersIcon.waitUntil(visible, 5000).click();
        sleep(1000);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea clickOnClearFilter(int number) {
        $(byXpath(String.format(selectedFilters, number + 1))).waitUntil(visible, 5000).click();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public String getBrandTitle(int number) {
        String brand = brandTitleList.get(number - 1).attr("id").toLowerCase().replaceAll("'", "").replaceAll("&", "");
        log.debug("  |- Brand - " + brand);
        return brand;
    }

    public int getMinPrice() {
        return Integer.valueOf(executeJavaScript("return document.getElementsByClassName('slider-filter__input')[0].value"));
    }

    public int getMaxPrice() {
        return Integer.valueOf(executeJavaScript("return document.getElementsByClassName('slider-filter__input')[1].value"));
    }

    public int getMinSliderPosition() {
        return minPriceSlider.getLocation().getX();
    }

    public int getMaxSliderPosition() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return maxPriceSlider.getLocation().getX();
    }

    public int getSelectedGoodsQuantity() {
        String counter = goodsCounter.waitUntil(visible, 5000).getText();
        String counterParts[] = counter.split(" ");
        int value = Integer.valueOf(counterParts[1]);
        log.debug("  |- OK " + getCurrentMethodName());
        return value;
    }

    private void setDataIntoSearchInputField(String title, String item) {
        $(byXpath(String.format(filterBlockTitle, title) + filterSearchInputField)).waitUntil(visible, 5000).setValue(item);
        waitUntilLoadComplete();
        log.debug("  |- OK " + getCurrentMethodName());
    }

    public FiltersArea setMinPriceField(int value) {
        minPriceField.shouldBe(visible).setValue(String.valueOf(value));
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea setMaxPriceField(int value) {
        maxPriceField.shouldBe(visible).setValue(String.valueOf(value));
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    private int getStepsOfSlider() {
        return priceSlider.shouldBe(visible).getSize().width / 5;
    }

    public FiltersArea moveMinSliderToPosition(int position) {
        if (position < 1 || position > 5) {
            throw new AssertionError(
                    "Slider position value should be in the range of 1 to 5");
        }
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        int xOffset = (position - 1) * getStepsOfSlider();
        actions.dragAndDropBy(minPriceSlider, xOffset, 0).perform();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public FiltersArea moveMaxSliderToPosition(int position) {
        if (position < 1 || position > 5) {
            throw new AssertionError(
                    "Slider position value should be in the range of 1 to 5");
        }
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        int xOffset = -position * getStepsOfSlider() + priceSlider.getSize().width;
        actions.dragAndDropBy(maxPriceSlider, -xOffset, 0).perform();
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }

    public boolean isFiltersAreaPresent() {
        log.debug("  |- OK " + getCurrentMethodName());
        return $("aside.sidebar").is(exist);
    }

    public FiltersArea searchFilterItemAndSelectIt(String title, String item) {
        setDataIntoSearchInputField(title, item);
        selectFilterByNumber(title, 1);
        log.debug("  |- OK " + getCurrentMethodName());
        return this;
    }
}
