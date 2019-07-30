package helpers;

import helpers.js2p.categoryConfig.GetId;
import helpers.js2p.goodsCard.GetDetailsRequest;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.when;

public class ApiHelper {

    private static Logger log = LoggerFactory.getLogger(ApiHelper.class);

    private String dataFile = "robotsFiltersData.txt";
    private String category = PropertiesHelper.getDataFromTxt(dataFile, "category");
    private static GetDetailsRequest getDetailsRequest;
    private static GetId getId;

    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static int getStatusCodeOfRequest(String url){
        return RestAssured
                .when()
                .get(url)
                .then()
                .extract()
                .statusCode();
    }

    private static String getRequest(String url, String param) {
        String responseData = when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .path(param, "")
                .toString();

        log.debug("  |- OK " + getCurrentMethodName());
        return responseData;
    }

    private String setURL(String url, String value) {
        String result = url + value + category;
        log.info("URL - " + result);
        return result;
    }

    private String setURL(String url, String value1, String value2) {
        String result = url + value1 + value2 + category;
        log.info("URL - " + result);
        return result;
    }

    public String getFiltersRequest(String url, String value, String param) {
        return getRequest(setURL(url, PropertiesHelper.getDataFromTxt(dataFile, value)), param);
    }

    public String getFiltersRequest(String url, String value1, String value2, String param) {
        return getRequest(setURL(url, PropertiesHelper.getDataFromTxt(dataFile, value1), PropertiesHelper.getDataFromTxt(dataFile, value2)), param);
    }

}
