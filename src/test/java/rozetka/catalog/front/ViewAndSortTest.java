package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IVV.CatalogPage;
import pages.IVV.FiltersArea;
import pages.IVV.PaginationArea;
import rozetka.SetupTest;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ViewAndSortTest extends SetupTest {

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {
        open(manShoesCategoryURL);
    }

    @Test(testName = "IVV-1017", description = "Проверка переключения в режим 'малая плитка'")
    public void changeViewToSmall() {
        new CatalogPage()
                .changeViewToBigTile()
                .changeViewToSmallView();

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("tile=big"));
    }

    @Test(testName = "IVV-1018", description = "Проверка переключения в режим 'большая плитка'")
    public void changeViewToBig() {

        new CatalogPage()
                .changeViewToBigTile();

        Assert.assertTrue(new CatalogPage().smallGoodsBlock.is(not(exist)));
        Assert.assertEquals(new CatalogPage().getBigGoodsBlockSize(), 60);
    }

    @Test(testName = "IVV-1019", description = "Проверка сортировки 'От дешевых к дорогим'")
    public void testCheapSort() {
        new CatalogPage()
                .sortGoodsBy("От дешевых к дорогим");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=cheap"));
    }

    @Test(testName = "IVV-1020", description = "Проверка сортировки 'От дорогих к дешевым'")
    public void testExpensiveSort() {
        new CatalogPage()
                .sortGoodsBy("От дорогих к дешевым");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=expensive"));
    }

    @Test(testName = "IVV-1021", description = "Проверка сортировки 'Популярные'")
    public void testPopularSort() {
        new CatalogPage()
                .sortGoodsBy("Популярные");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=popularity"));
    }

    @Test(testName = "IVV-1022", description = "Проверка сортировки 'Акционные'")
    public void testActionSort() {
        new CatalogPage()
                .sortGoodsBy("Акционные");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=action"));
    }

    @Test(testName = "IVV-1023", description = "Проверка сортировки 'Новинки'")
    public void testNoveltySort() {
        new CatalogPage()
                .sortGoodsBy("Новинки");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=novelty"));
    }

    @Test(testName = "IVV-1024", description = "Проверка сортировки 'По рейтингу'")
    public void testRankSort() {
        new CatalogPage()
                .sortGoodsBy("Акционные")
                .sortGoodsBy("По рейтингу");

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("sort=rank"));
    }

    @Test(testName = "IVV-1025", description = "Проверка удаления параметра пагинации с URL после изменения сортировки")
    public void checkClearPageAfterSort() {

        new PaginationArea()
                .clickOnThePageNumber(5);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=5"));

        new CatalogPage()
                .sortGoodsBy("От дешевых к дорогим");

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("page="));
    }

    @Test(testName = "IVV-2230", description = "Проверка режима отображения товаров 'Крупная плитка' после использовании фильтров/сортировки")
    public void checkBigTileAfterUsingFiltersAndSort() {

        new CatalogPage()
                .changeViewToBigTile();

        Assert.assertTrue(new CatalogPage().smallGoodsBlock.is(not(exist)));
        Assert.assertEquals(new CatalogPage().getBigGoodsBlockSize(), 60);

        new CatalogPage()
                .sortGoodsBy("От дорогих к дешевым");

        Assert.assertTrue(new CatalogPage().smallGoodsBlock.is(not(exist)));
        Assert.assertEquals(new CatalogPage().getBigGoodsBlockSize(), 60);

        new FiltersArea()
                .selectFilterByNumber("Бренд", 1);

        Assert.assertTrue(new CatalogPage().smallGoodsBlock.is(not(exist)));
    }
}
