package rozetka.catalog.front;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.javalite.activejdbc.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.IVV.CatalogPage;
import pages.IVV.FiltersArea;
import pages.IVV.PaginationArea;
import rozetka.SetupTest;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.PropertiesHelper.getProperty;
import static org.openqa.selenium.Keys.ENTER;

public class FiltersTest extends SetupTest {

    @BeforeClass
    public void openDbConnection() {
        Base.open(getProperty("dbDriver"), getProperty("dbUrl"), getProperty("dbLogin"), getProperty("dbPassword"));
    }

    @AfterClass
    public void closeDbConnection() {
        Base.close();
    }

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {
        Configuration.startMaximized = true;
        open(manShoesCategoryURL);
    }


    @Test(testName = "IVV-1086", description = "Выбор бренда и проверка добавления в URL")
    public void isBrandPresentInUrl() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 3);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(3)));
    }

    @Test(testName = "IVV-1087", description = "Выбор бренда и очистка активных фильтров с помощью кнопки 'Сбросить'")
    public void clearAllFilters() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 2)
                .clickOnClearAllFilters();

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(2)));
    }

    @Test(testName = "IVV-1088", description = "Выбор бренда и удаление с помощью иконки в списке выбранных фильтров")
    public void applyFilterAndClear() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 2)
                .clickOnClearFilter(1);

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(2)));
    }

    @Test(testName = "IVV-1089", description = "Проверка добавления параметров в URL, после выбора бренда и цены")
    public void applyTwoFilters() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 3)
                .clickOnPriceButton();

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(3)));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price="));
    }

    @Test(testName = "IVV-1090", description = "Проверка добавления параметров в URL, после выбора фильтров и перехода по страницам")
    public void pag2Filters() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 1)
                .clickOnPriceButton();

        new PaginationArea()
                .clickOnThePageNumber(2);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(1)));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price="));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=2"));
    }

    @Test(testName = "IVV-1091", description = "Проверка добавления параметров в URL, после выбора фильтров и нажатия на виджет 'Показать еще ...'")
    public void showMoreGoods2Filters() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 1)
                .clickOnPriceButton();

        new PaginationArea()
                .clickOnShowMoreLink();

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(1)));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price="));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=1-2"));
    }

    @Test(testName = "IVV-1092", description = "Проверка добавления параметров в URL, после выбора фильтров, нажатия на виджет 'Показать еще ...' и перехода на страницу 3")
    public void applyFiltersAndCheck() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 9)
                .clickOnPriceButton();

        new PaginationArea()
                .clickOnShowMoreLink()
                .clickOnThePageNumber(3);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(9)));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price="));
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=3"));
    }

    @Test(testName = "IVV-1093", description = "Проверка добавления параметров в URL, после выбора бренда, удаления и повторного выбора")
    public void applyClearRepeat() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 1)
                .clickOnClearAllFilters()
                .selectFilterByNumber("Бренд", 1);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=" + new FiltersArea().getBrandTitle(1)));
    }

    @Test(testName = "IVV-1094", description = "Выбор диапазона цены от 500 до 1000. Проверка URL и счетчика товаров")
    public void assertPriceAndCounter() {

        new FiltersArea()
                .setMinPriceField(500)
                .setMaxPriceField(1000)
                .clickOnPriceButton();

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price=500-1000"));
        Assert.assertTrue(new FiltersArea().getSelectedGoodsQuantity() < 60000);
    }

    @Test(testName = "IVV-1095", description = "Проверка добавления параметров в URL, после выбора опции")
    public void assertOptions() {

        new FiltersArea()
                .selectFilterByTitle("Сезон", "Летняя");

        System.out.println("Url - " + getWebDriver().getCurrentUrl());
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("39560=63320"));
    }

    @Test(testName = "IVV-1096", description = "Изменение положения слайдера минимальной цены в позиции n (1-5)")
    public void dragMinSlider() {
        int beforeChangePosition = new FiltersArea()
                .getMinSliderPosition();

        int afterChangePosition = new FiltersArea()
                .moveMinSliderToPosition(2)
                .getMinSliderPosition();

        Assert.assertTrue(afterChangePosition > beforeChangePosition);
    }

    @Test(testName = "IVV-1097", description = "Изменение положения слайдера максимальной цены в позиции n (1-5)")
    public void dragMaxSlider() {
        int beforeChangePosition = new FiltersArea()
                .getMaxSliderPosition();

        int afterChangePosition = new FiltersArea()
                .moveMaxSliderToPosition(4)
                .getMaxSliderPosition();

        Assert.assertTrue(afterChangePosition < beforeChangePosition);
    }

    @Test(testName = "IVV-1098", description = "Установка слайдеров цены в одно положение и проврека цены")
    public void dragSlidersToMiddle() {

        new FiltersArea()
                .moveMinSliderToPosition(3)
                .moveMaxSliderToPosition(3);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1099", description = "Установка слайдера минимальной цены в максимальное значение")
    public void dragLeftSliderToMax() {

        new FiltersArea()
                .moveMinSliderToPosition(5);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1100", description = "Установка слайдера максимальной цены в минимальное значение")
    public void dragRightSliderToMin() {

        new FiltersArea()
                .moveMaxSliderToPosition(1);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1101", description = "Многократное изменение положения слайдера максимальной цены")
    public void multipleDragRightSlider() {

        new FiltersArea()
                .moveMaxSliderToPosition(2)
                .moveMaxSliderToPosition(4)
                .moveMaxSliderToPosition(1);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1102", description = "Установка слайдера максимальной цены в среднее положение и попытка установить минимальное значение справа")
    public void dragLeftSliderBehindRight() {

        new FiltersArea()
                .moveMaxSliderToPosition(3)
                .moveMinSliderToPosition(4);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1103", description = "Установка слайдера минимальное цены в среднее положение и попытка установить максимальное значение слева")
    public void dragRightSliderBehindLeft() {

        new FiltersArea()
                .moveMinSliderToPosition(3)
                .moveMaxSliderToPosition(2);

        Assert.assertEquals(new FiltersArea().getMinPrice(), new FiltersArea().getMaxPrice());
    }

    @Test(testName = "IVV-1104", description = "Установка слайдера максимальной цены в среднее положение и установка цены")
    public void inputPriceAndDragSlider() {

        int maxSliderPosition = new FiltersArea().getMaxSliderPosition();
        int maxPrice = new FiltersArea().getMaxPrice();

        new FiltersArea()
                .moveMaxSliderToPosition(3);

        Assert.assertNotEquals(new FiltersArea().getMaxPrice(), maxPrice);

        new FiltersArea()
                .setMaxPriceField(maxPrice)
                .clickOnPriceButton();

        Assert.assertEquals(new FiltersArea().getMaxSliderPosition(), maxSliderPosition);
    }

    @Test(testName = "IVV-1105", description = "Проверка сброса параметров пагинации после выбора бренда, перехода на другую страницу и удаления выбранного бренда")
    public void checkClearPageAfterFilter() {

        new FiltersArea()
                .selectFilterByNumber("Бренд", 1);

        new PaginationArea()
                .clickOnThePageNumber(3);

        new FiltersArea()
                .clickOnClearFilter(1);

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("page="));
    }

    @Test(testName = "tests.IVV-1107", description = "Выбор бренда в фильтрах и сравнение тайтла товаров с БД")
    public void checkClick10BrandAndGoodsFromDB() {

        String brandTitle = new FiltersArea()
                .getBrandTitle(3);

        new FiltersArea()
                .selectFilterByNumber("Бренд", 3);

        ArrayList goodsTitle = new CatalogPage()
                .getListOfGoodsTitleFromDb(new CatalogPage().getGoodsIdFromCatalog());

        Assert.assertTrue(goodsTitle.contains(brandTitle));
    }

    @Test(testName = "IVV-2233", description = "Проверка влияния фильтров на изменение диапазона в фильтре 'Цена'")
    public void priceDataDoesNotChangeAfterBrandSelected() {

        new FiltersArea()
                .setMinPriceField(500)
                .setMaxPriceField(1000)
                .clickOnPriceButton()
                .selectFilterByNumber("Бренд", 2);

        Assert.assertEquals(new FiltersArea().getMinPrice(), 500);
        Assert.assertEquals(new FiltersArea().getMaxPrice(), 1000);
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("price=500-1000"));
    }

    @Test(testName = "IVV-2243", description = "Проверка отображения блока фильтров после ввода цен и нажатия на клавишу Enter")
    public void filtersAreaDoNotDisappearAfterClickOnEnter() {

        new FiltersArea()
                .setMinPriceField(100)
                .setMaxPriceField(200)
                .clickOnPriceButton()
                .clickOnClearAllFilters()
                .setMinPriceField(100)
                .setMaxPriceField(200);

        Selenide.actions().sendKeys(ENTER).perform();

        Assert.assertTrue(new FiltersArea().isFiltersAreaPresent());
    }

    @Test(testName = "IVV-2442", description = "Поиск производителя через поле ввода")
    public void searchProducerViaInputField() {

        new FiltersArea()
                .searchFilterItemAndSelectIt("Бренд", "Nike");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("producer=nike"));
    }
}
