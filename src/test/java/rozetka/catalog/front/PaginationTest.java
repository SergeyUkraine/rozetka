package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IVV.CatalogPage;
import pages.IVV.PaginationArea;
import rozetka.SetupTest;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PaginationTest extends SetupTest {

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {
        open(manShoesCategoryURL);
    }

    @Test(testName = "IVV-1034", description = "Проверка количества товаров после нажатия на 'Показать еще ...'")
    public void showMoreGoods() {

        Assert.assertTrue(new PaginationArea().doShowMore());

    }

    @Test(testName = "IVV-1035", description = "Проверка параметров в URL, после перехода на вторую страницу, затем на третью и возврат на первую")
    public void paginationTest() {

        new PaginationArea().clickOnThePageNumber(2);
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=2"));

        new PaginationArea().clickOnThePageNumber(3);
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=3"));

        new PaginationArea().clickOnThePageNumber(1);
        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("page=1"));
    }

    @Test(testName = "IVV-1037", description = "Проверка работоспособности виджета 'Показать еще ...'")
    public void widgetScrollTest() {

        int middleOffset = new CatalogPage()
                .scrollToBottomOfPage()
                .clickOnShowMoreIcon()
                .getPageYOffset();

        int bottomOffset = new CatalogPage()
                .scrollToBottomOfPage()
                .getPageYOffset();

        Assert.assertNotEquals(middleOffset, bottomOffset);
        Assert.assertTrue(new CatalogPage().isMoreThanOnePageOpened(60, 120));
    }

    @Test(testName = "IVV-1038", description = "Проверка возврата в топ страницы после использования пагинатора")
    public void invalidURLPag() {

        new PaginationArea()
                .clickOnThePageNumber(2);

        Assert.assertTrue(getWebDriver()
                .getCurrentUrl()
                .contains("page=2"));

        Assert.assertTrue(new CatalogPage()
                .getPageYOffset() < 200);
    }

    @Test(testName = "IVV-1040", description = "Проверка параметров в URL, после переключения режимов отображения и переходе по страницам")
    public void changeViewPag() {

        new CatalogPage()
                .changeViewToBigTile()
                .changeViewToSmallView();

        Assert.assertEquals(new CatalogPage().getViewType(), "small");

        new PaginationArea()
                .clickOnThePageNumber(2);

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=2"));
    }

    @Test(testName = "IVV-1041", description = "Проверка количества товаров на странице после переключения в режим 'малая плитка' и использования виджета 'Показать еще ...'")
    public void changeViewWidget() {

        Assert.assertEquals(new CatalogPage()
                .changeViewToBigTile()
                .changeViewToSmallView()
                .clickOnShowMoreIcon()
                .getGoodsListSize(), 120);
    }

    @Test(testName = "IVV-1042", description = "Проверка параметров в URL и количества товаров после использования кнопки навигации 'следующая страница'")
    public void nextPagePag() {

        new PaginationArea().gotoNextPage();

        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=2"));
        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 60);
    }

    @Test(testName = "IVV-1043", description = "Проверка параметров в URL и количества товаров после использования кнопок навигации 'следующая страница' и 'предыдущая страница'")
    public void prevPagePag() {

        new PaginationArea().gotoNextPage();
        new PaginationArea().gotoPreviousPage();

        Assert.assertFalse(getWebDriver().getCurrentUrl().contains("page=2"));
        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 60);
    }

    @Test(testName = "IVV-1044", description = "Проверка количества товаров после переключения режимов отображения и нажатия на виджет 'Показать еще ...'")
    public void doubleChangeViewWidget() {

        new CatalogPage()
                .changeViewToBigTile()
                .changeViewToSmallView()
                .changeViewToBigTile()
                .changeViewToSmallView()
                .clickOnShowMoreIcon();

        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 120);
    }

    @Test(testName = "IVV-1045", description = "Подсчет количества товаров после перехода на страницу 5 и использование кнопок навинагации")
    public void pag5AndNavigation() {

        new PaginationArea().clickOnThePageNumber(5);
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=5"));
        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 60);

        new PaginationArea().gotoPreviousPage();
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=4"));
        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 60);

        new PaginationArea().gotoNextPage();
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=5"));
        Assert.assertEquals(new CatalogPage().getGoodsListSize(), 60);
    }

    @Test(testName = "IVV-1046", description = "Проверка наличия кнопок навигации на последней странице")
    public void lastPagePagCheck() {

        new PaginationArea().gotoLastPageViaPaginator();

        Assert.assertFalse(new PaginationArea().isShowMoreDisplayed());
        Assert.assertTrue(new PaginationArea().isNextPageIconDisabled());
    }

    @Test(testName = "IVV-1047", description = "Проверка наличия кнопок навигации на первой странице")
    public void firstPagePagCheck() {

        Assert.assertTrue(new PaginationArea().isPrevPageIconDisabled());
        Assert.assertFalse(new PaginationArea().isNextPageIconDisabled());
        Assert.assertTrue(new PaginationArea().isPaginatorDisplayed());
        Assert.assertTrue(new PaginationArea().isShowMoreDisplayed());
    }

    @Test(testName = "IVV-2232", description = "Проверка возврата на выбранную страницу после перехода на карточку товара и обратно")
    public void openedDesiredPageAfterOpenGoodsCardAndGoBack() {

        new PaginationArea()
                .clickOnThePageNumber(2);

        String goodstitle = new CatalogPage()
                .getFirstGoodsTitle();

        new CatalogPage().openGoodsCardPage(1);

        back();

        Assert.assertEquals(goodstitle, new CatalogPage().getFirstGoodsTitle());
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("page=2"));
    }
}
