package rozetka.catalog.api;

import helpers.ApiHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RobotsAPITest {

    private final String robotsPath = "data.seo.robots";
    private final String robotsValue = "noindex,nofollow";
    private String URL;

    @Parameters({"url"})
    @BeforeClass
    public void initURL(String url) {
        URL = url;
    }

    @Test(testName = "IVV-1845",
            description = "Отсутствие параметра robots при дефолтной сортировке")
    public void absentRobotsWithDefaultSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "", robotsPath), "[]");
    }

    @Test(testName = "IVV-1846",
            description = "Наличие параметра robots при сортировке по цене ('От дешевых к дорогим')",
            priority = 1)
    public void isRobotsWithCheapSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "cheapSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1847",
            description = "Наличие параметра robots при сортировке по цене ('От дорогих к дешевым')",
            priority = 2)
    public void isRobotsWithExpensiveSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "expensiveSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1848",
            description = "Наличие параметра robots при сортировке по популярности",
            priority = 3)
    public void isRobotsWithPopularSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "popularSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1849",
            description = "Наличие параметра robots при сортировке по новизне",
            priority = 4)
    public void isRobotsWithNewestSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "newestSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1850",
            description = "Наличие параметра robots при сортировке по акциям",
            priority = 5)
    public void isRobotsWithActionSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "actionSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1851",
            description = "Отсутствие параметра robots при сортировке по рейтингу",
            priority = 6)
    public void absentRobotsWithRankSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "rankSort", robotsPath), "");
    }

    @Test(testName = "IVV-1852",
            description = "Наличие параметра robots при сортировке по рейтингу и отображении в режиме 'крупной плитке'",
            priority = 7)
    public void isRobotsWithRankSortAndBigTileView() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "bigTileView", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1853",
            description = "Наличие параметра robots при фильтрации по цене",
            priority = 9)
    public void isRobotsWithOnlyPrice() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "price", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1854",
            description = "Наличие параметра robots при фильтрации и сортировке по цене",
            priority = 10)
    public void isRobotsWithPriceAndCheapSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "price", "cheapSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1855",
            description = "Наличие параметра robots при фильтрации по цене и сортировке по рейтингу",
            priority = 11)
    public void isRobotsWithPriceAndRankSort() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "price", "rankSort", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1856",
            description = "Наличие параметра robots при фильтрации по цене и отображении в режиме 'большой плитки'",
            priority = 12)
    public void isRobotsWithPriceAndBigTileView() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "price", "bigTileView", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1857",
            description = "Наличие параметра robots при фильтрации по цене и бренду",
            priority = 13)
    public void isRobotsWithPriceAndBrand() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "price", "brand", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1858",
            description = "Наличие параметра robots при фильтрации по продавцу",
            priority = 14)
    public void isRobotsWithOnlySeller() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "seller", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1859",
            description = "Наличие параметра robots при фильтрации по продавцу и цене",
            priority = 15)
    public void isRobotsWithSellerAndPrice() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "seller", "price", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1860",
            description = "Наличие параметра robots при фильтрации по продавцу и росту",
            priority = 16)
    public void isRobotsWithSellerAndHeight() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "seller", "height", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1861",
            description = "Наличие параметра robots при фильтрации по продавцу и сезону",
            priority = 17)
    public void isRobotsWithSellerAndSeason() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "seller", "season", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1862",
            description = "Наличие параметра robots при фильтрации по продавцам (два продавца)",
            priority = 18)
    public void isRobotsWithTwoSellers() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "twoSellers", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1863",
            description = "Наличие параметра robots при фильтрации по брендам (два бренда)",
            priority = 19)
    public void isRobotsWithTwoBrands() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "twoBrands", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1864",
            description = "Отсутствие параметра robots при фильтрации по трем различным фильтрам",
            priority = 20)
    public void absentRobotsWithThreeDifferentFilters() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "sizeColorStyle", robotsPath), "");
    }

    @Test(testName = "IVV-1865",
            description = "Наличие параметра robots при фильтрации по четырем различным фильтрам (два бренда)",
            priority = 21)
    public void isRobotsWithFourDifferentFilters() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "sizeColorStyleCountry", robotsPath), robotsValue);
    }

    @Test(testName = "IVV-1866",
            description = "Наличие параметра robots при фильтрации по бонусам",
            priority = 22)
    public void isRobotsWithBonusFilters() {
        Assert.assertEquals(
                new ApiHelper().getFiltersRequest(URL, "bonus", robotsPath), robotsValue);
    }
}
