package rozetka.catalog.api;

import helpers.js2p.SuperPortal;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static helpers.PropertiesHelper.getDataFromTxt;
import static io.restassured.RestAssured.when;

public class CeoAPITest {

    private String baseUrl = "";
    private String getSuperPortalRequest = "v2/categories/getSuperPortal?category_id=%s&lang=ru";
    private String getFiltersRequest = "v2/goods/getFilters?category_id=%s&lang=ru";
    private String superPortalDataFile = "ceo/ceoSuperPortal.txt";
    private String filtersDataFile = "ceo/ceoFilters.txt";

    @Parameters({"baseUrl"})
    @BeforeClass
    public void init(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Test(testName = "IVV-2488", description = "Проверка СЕО данных в запросе getSuperPortal. Главный суперпортал")
    public void getSuperPortalMain() {
        String mainSuperPortal = "1162030";

        SuperPortal superPortal = when()
                .get(baseUrl + (String.format(getSuperPortalRequest, mainSuperPortal)))
                .then()
                .extract()
                .body()
                .as(SuperPortal.class);

        Assert.assertEquals(superPortal.getData().getSeo().getDescription(), getDataFromTxt(superPortalDataFile, "mainDescription"));
        Assert.assertEquals(superPortal.getData().getSeo().getFooter(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getH1(), getDataFromTxt(superPortalDataFile, "mainH1"));
        Assert.assertTrue(superPortal.getData().getSeo().getIsFirstPageOnly());
        Assert.assertEquals(superPortal.getData().getSeo().getKeywords(), getDataFromTxt(superPortalDataFile, "mainKeywords"));
        Assert.assertFalse(superPortal.getData().getSeo().getLinkNext());
        Assert.assertFalse(superPortal.getData().getSeo().getLinkPrev());
        Assert.assertEquals(superPortal.getData().getSeo().getPaginatorSuffix(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getRobots(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getTitle(), getDataFromTxt(superPortalDataFile, "mainTitle"));
    }

    @Test(testName = "IVV-2477", description = "Проверка СЕО данных в запросе getSuperPortal. Женский суперпортал")
    public void getSuperPortalForWoman() {
        String womanSuperPortal = "2337947";

        SuperPortal superPortal = when()
                .get(baseUrl + (String.format(getSuperPortalRequest, womanSuperPortal)))
                .then()
                .extract()
                .body()
                .as(SuperPortal.class);

        Assert.assertEquals(superPortal.getData().getSeo().getDescription(), getDataFromTxt(superPortalDataFile, "womanDescription"));
        Assert.assertEquals(superPortal.getData().getSeo().getFooter(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getH1(), getDataFromTxt(superPortalDataFile, "womanH1"));
        Assert.assertTrue(superPortal.getData().getSeo().getIsFirstPageOnly());
        Assert.assertEquals(superPortal.getData().getSeo().getKeywords(), getDataFromTxt(superPortalDataFile, "womanKeywords"));
        Assert.assertFalse(superPortal.getData().getSeo().getLinkNext());
        Assert.assertFalse(superPortal.getData().getSeo().getLinkPrev());
        Assert.assertEquals(superPortal.getData().getSeo().getPaginatorSuffix(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getRobots(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getTitle(), getDataFromTxt(superPortalDataFile, "womanTitle"));
    }

    @Test(testName = "IVV-2478", description = "Проверка СЕО данных в запросе getSuperPortal. Мужской суперпортал")
    public void getSuperPortalForMan() {
        String manSuperPortal = "2337942";

        SuperPortal superPortal = when()
                .get(baseUrl + (String.format(getSuperPortalRequest, manSuperPortal)))
                .then()
                .extract()
                .body()
                .as(SuperPortal.class);

        Assert.assertEquals(superPortal.getData().getSeo().getDescription(), getDataFromTxt(superPortalDataFile, "manDescription"));
        Assert.assertEquals(superPortal.getData().getSeo().getFooter(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getH1(), getDataFromTxt(superPortalDataFile, "manH1"));
        Assert.assertTrue(superPortal.getData().getSeo().getIsFirstPageOnly());
        Assert.assertEquals(superPortal.getData().getSeo().getKeywords(), getDataFromTxt(superPortalDataFile, "manKeywords"));
        Assert.assertFalse(superPortal.getData().getSeo().getLinkNext());
        Assert.assertFalse(superPortal.getData().getSeo().getLinkPrev());
        Assert.assertEquals(superPortal.getData().getSeo().getPaginatorSuffix(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getRobots(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getTitle(), getDataFromTxt(superPortalDataFile, "manTitle"));
    }

    @Test(testName = "IVV-2479", description = "Проверка СЕО данных в запросе getSuperPortal. Детский суперпортал")
    public void getSuperPortalForChildren() {
        String childrenSuperPortal = "2028477";

        SuperPortal superPortal = when()
                .get(baseUrl + (String.format(getSuperPortalRequest, childrenSuperPortal)))
                .then()
                .extract()
                .body()
                .as(SuperPortal.class);

        Assert.assertEquals(superPortal.getData().getSeo().getDescription(), getDataFromTxt(superPortalDataFile, "childrenDescription"));
        Assert.assertEquals(superPortal.getData().getSeo().getFooter(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getH1(), getDataFromTxt(superPortalDataFile, "childrenH1"));
        Assert.assertTrue(superPortal.getData().getSeo().getIsFirstPageOnly());
        Assert.assertEquals(superPortal.getData().getSeo().getKeywords(), getDataFromTxt(superPortalDataFile, "childrenKeywords"));
        Assert.assertFalse(superPortal.getData().getSeo().getLinkNext());
        Assert.assertFalse(superPortal.getData().getSeo().getLinkPrev());
        Assert.assertEquals(superPortal.getData().getSeo().getPaginatorSuffix(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getRobots(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getTitle(), getDataFromTxt(superPortalDataFile, "newChildrenTitle"));
    }

    @DataProvider
    public Object[][] categoriesList() {
        return new Object[][]{
                {"458425"},
                {"721654"},
                {"721659"},
                {"2033137"},
                {"1162060"},
                {"1162070"},
                {"1285573"},
                {"4630220"},
                {"723119"},
        };
    }

    @Test(testName = "IVV-2481", description = "Проверка СЕО данных в запросе getFilters, в различных категориях", dataProvider = "categoriesList")
    public void getFiltersCEO(String category) {

        SuperPortal superPortal = when()
                .get(baseUrl + (String.format(getFiltersRequest, category)))
                .then()
                .extract()
                .body()
                .as(SuperPortal.class);

        Assert.assertEquals(superPortal.getData().getSeo().getDescription(), getDataFromTxt(filtersDataFile, category + "Description"));
        Assert.assertEquals(superPortal.getData().getSeo().getH1(), getDataFromTxt(filtersDataFile, category + "H1"));
        Assert.assertTrue(superPortal.getData().getSeo().getIsFirstPageOnly());
        Assert.assertEquals(superPortal.getData().getSeo().getKeywords(), getDataFromTxt(filtersDataFile, category + "Keywords"));
        Assert.assertFalse(superPortal.getData().getSeo().getLinkNext());
        Assert.assertFalse(superPortal.getData().getSeo().getLinkPrev());
        Assert.assertEquals(superPortal.getData().getSeo().getRobots(), "");
        Assert.assertEquals(superPortal.getData().getSeo().getTitle(), getDataFromTxt(filtersDataFile, category + "Title"));
    }

}
