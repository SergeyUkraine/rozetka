package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IVV.HeaderArea;
import pages.IVV.CatalogPage;
import rozetka.SetupTest;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static helpers.PropertiesHelper.getDataProviderFromTxt;

public class CompareTest extends SetupTest {

    @DataProvider
    public Object[][] presentCompareIcon() throws IOException {
        return getDataProviderFromTxt("pagesForCompareTests/presentCompareIcon.txt");
    }

    @Test(testName = "IVV-2447",
            description = "Проверка наличия иконки сравнения товара, на плитке",
            dataProvider = "presentCompareIcon")
    public void compareIconIsPresent(String url) {
        open(url);

        Assert.assertTrue(new CatalogPage().checkDataOnGoodsCard("compare"));
    }

    @DataProvider
    public Object[][] absentCompareIcon() throws IOException {
        return getDataProviderFromTxt("pagesForCompareTests/absentCompareIcon.txt");
    }

    @Test(testName = "IVV-2448",
            description = "Проверка отсутствия иконки сравнения товара, на плитке, в каталоге Fashion",
            dataProvider = "absentCompareIcon")
    public void compareIconIsAbsentOnFashionPages(String url) {

        open(url);

        Assert.assertFalse(new CatalogPage().checkDataOnGoodsCard("compare"));
    }

    @Test(testName = "IVV-2449", description = "Проверка добавления товара в сравнение (обновление счетчика в хедере и изменение иконки добавления)")
    public void addGoodsToCompareList() {

        open("notebooks/c80004/");

        new CatalogPage().addGoodsToCompare(2);

        Assert.assertTrue(new HeaderArea().isCompareCounterPresent());

        new CatalogPage().addGoodsToCompare(3);

        Assert.assertTrue(new HeaderArea().isCompareCounterEquals(2));
    }
}
