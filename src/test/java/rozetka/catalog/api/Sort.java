package rozetka.catalog.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Sort {

    private String baseUrl = "";
    private String sortRequest = "v2/goods/get?sort=%s&category_id=2033137&page=1&lang=ru";


    @Parameters({"baseUrl"})
    @BeforeClass
    public void init(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @DataProvider
    public Object[][] sortingList() {
        return new Object[][]{
                {"cheap"},
                {"expensive"},
                {"popularity"},
                {"novelty"},
                {"action"},
                {"rank"},
        };
    }

    @Test(testName = "IVV-2515", description = "Проверка статус кода и данных в запросе getSort", dataProvider = "sortingList")
    public void checkSortingRequest(String sorting) {

        when()
                .get(baseUrl + (String.format(sortRequest, sorting)))
                .then()
                .statusCode(200)
                .body("data.ids_count", equalTo(60))
                .body("data.total_pages", equalTo(34))
                .body("data.show_next", equalTo(60))
                .body("data.goods_with_filter", equalTo(2000))
                .body("data.shown_page", equalTo(1));
    }
}
