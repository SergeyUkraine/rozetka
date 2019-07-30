package rozetka.catalog.api;

import database.*;
import io.restassured.RestAssured;
import org.javalite.activejdbc.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static helpers.PropertiesHelper.getProperty;
import static org.hamcrest.Matchers.equalTo;

public class CategoriesAPITest {

    private String getCategoriesUrl;
    private String getDetailsUrl;

    @Parameters({"getCategoriesUrl", "getDetailsUrl"})
    @BeforeClass
    public void connectToDBAndInitUrl(String getCategoriesUrl, String getDetailsUrl) {
        this.getCategoriesUrl = getCategoriesUrl;
        this.getDetailsUrl = getDetailsUrl;
        Base.open(getProperty("dbDriver"), getProperty("dbUrl"), getProperty("dbLogin"), getProperty("dbPassword"));
    }

    @AfterClass
    public void closeDbConnection() {
        Base.close();
    }

    @Test(testName = "IVV-966",
            description = "Валидность полей запроса /categories/getChildren?category_id=4636239&lang=ru")
    public void getChildrenRequestValidation() {

        int categoryId = 2033137;
        int childrenId = 1162060;
        Category category = Category.findById(categoryId);
        Category children = Category.findById(childrenId);

        RestAssured.when()
                .get(getCategoriesUrl + categoryId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.current.id", equalTo(category.getInteger("id")))
                .body("data.current.title", equalTo(category.getString("title")))
                .body("data.current.name", equalTo(category.getString("name")))
                .body("data.current.parent_id", equalTo(category.getInteger("parent_id")))
                .body("data.current.left_key", equalTo(category.getInteger("left_key")))
                .body("data.current.right_key", equalTo(category.getInteger("right_key")))
                .body("data.current.level", equalTo(category.getInteger("level")))
                .body("data.current.href", equalTo(category.getString("href")))
                .body("data.current.allow_index_three_parameters", equalTo(category.getBoolean("allow_index_three_parameters")))
                .body("data.childrenSuperPortal[0].id", equalTo(children.getInteger("id")))
                .body("data.childrenSuperPortal[0].title", equalTo(children.getString("title")))
                .body("data.childrenSuperPortal[0].name", equalTo(children.getString("name")))
                .body("data.childrenSuperPortal[0].parent_id", equalTo(children.getInteger("parent_id")))
                .body("data.childrenSuperPortal[0].left_key", equalTo(children.getInteger("left_key")))
                .body("data.childrenSuperPortal[0].right_key", equalTo(children.getInteger("right_key")))
                .body("data.childrenSuperPortal[0].level", equalTo(children.getInteger("level")))
                .body("data.childrenSuperPortal[0].href", equalTo(children.getString("href")))
                .body("data.childrenSuperPortal[0].allow_index_three_parameters", equalTo(children.getBoolean("allow_index_three_parameters")));
    }

    @Test(testName = "IVV-986",
            description = "getDetails Соответствие полей")
    public void getDetailsRequestValidation() {
        int categoryId = 1162070;

        Goods goods = Goods.findFirst("category_id = ? AND status = ?", categoryId, "active");
        Producer producer = goods.parent(Producer.class);
        Category category = goods.parent(Category.class);
        GoodsAttachment goodsAttachment = GoodsAttachment.findFirst("goods_id = ?", goods.get("id"));
        GoodsAttachmentVariant goodsAttachmentVariant =
                GoodsAttachmentVariant.findFirst("parent_id = ? AND variant = ?", goodsAttachment.get("id"), "big_tile");

        RestAssured.when()
                .get(getDetailsUrl + String.valueOf(goods.get("id")) + "&lang=ru")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data[0].id", equalTo(goods.getInteger("id")))
                .body("data[0].title", equalTo(goods.getString("title")))
                .body("data[0].price", equalTo(goods.getString("price").split(".\\w+$")[0]))
                .body("data[0].old_price", equalTo(goods.getString("old_price").split(".\\w+$")[0]))
                .body("data[0].price_pcs", equalTo(goods.getString("price_pcs")))
                .body("data[0].href", equalTo(goods.getString("href")))
                .body("data[0].comments_amount", equalTo(goods.getInteger("comments_amount")))
                .body("data[0].sell_status", equalTo(goods.getString("sell_status")))
                .body("data[0].comments_mark", equalTo(goods.getString("comments_mark").split(".\\w+$")[0]))
                .body("data[0].category_id", equalTo(goods.getInteger("category_id")))
                .body("data[0].seller_id", equalTo(goods.getInteger("seller_id")))
                .body("data[0].merchant_id", equalTo(goods.getInteger("merchant_id")))
                .body("data[0].brand", equalTo(String.valueOf(producer.getString("title"))))
                .body("data[0].brand_id", equalTo(goods.getInteger("producer_id")))
                .body("data[0].group_id", equalTo(goods.getInteger("group_id")))
                .body("data[0].pl_bonus_charge_pcs", equalTo(goods.getInteger("pl_bonus_charge_pcs")))
                .body("data[0].pl_use_instant_bonus", equalTo(goods.getInteger("pl_use_instant_bonus")))
                .body("data[0].state", equalTo(goods.getString("state")))
                .body("data[0].image_main", equalTo(goodsAttachmentVariant.getString("url")))
                .body("data[0].parent_category_id", equalTo(Integer.valueOf(category.getString("mpath").substring(1).split("\\.")[0])));
    }
}