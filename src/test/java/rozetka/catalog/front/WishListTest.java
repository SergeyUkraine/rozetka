package rozetka.catalog.front;

import helpers.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IVV.HeaderArea;
import pages.IVV.CatalogPage;
import pages.IVV.WishListPage;
import rozetka.SetupTest;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class WishListTest extends SetupTest {

    private List<String> goodsFromCatalog;
    private List<String> goodsFromWishList;
    private String mainEmail = PropertiesHelper.getDataFromTxt("wishListTest.txt", "mainEmail");
    private String mainPassword = PropertiesHelper.getDataFromTxt("wishListTest.txt", "mainPassword");
    private String additionalEmail = PropertiesHelper.getDataFromTxt("wishListTest.txt", "additionalEmail");
    private String additionalPassword = PropertiesHelper.getDataFromTxt("wishListTest.txt", "additionalPassword");
    private String customWishListTitle = PropertiesHelper.getDataFromTxt("wishListTest.txt", "customWishListTitle");
    private int goodsQuantity = Integer.parseInt(PropertiesHelper.getDataFromTxt("wishListTest.txt", "goodsQuantity"));

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {

        open(manShoesCategoryURL);

        new HeaderArea()
                .checkStatusAndLogout();
    }

    @Test(testName = "IVV-989",
            description = "Добавление в WishList с каталога (в список по умолчанию, с авторизацией)")
    public void addToWishListAndCompareName() {
        int goodsQuantity = 2;

        new CatalogPage()
                .openLoginPopup()
                .loginAs(mainEmail, mainPassword)
                .addGoodsToWishList(goodsQuantity);

        Assert.assertTrue(new HeaderArea().isWishListCounterEquals(goodsQuantity));
    }

    @Test(testName = "IVV-990",
            description = "Добавление в WishList с каталога (в список по умолчанию, без авторизации)")
    public void addToWishListWithoutAuthorization() {

        new CatalogPage()
                .addGoodsToWishList(1)
                .setEmailAndClickOnSaveButton(mainEmail)
                .setPasswordAndClickOnEnterButton(mainPassword);

        Assert.assertEquals(goodsFromCatalog, goodsFromWishList);
    }

    @Test(testName = "IVV-993",
            description = "Добавление в WishList с каталога (в кастомный список, без авторизации)")
    public void addToCustomWishListWithoutAuthorization() {

        goodsFromCatalog = new CatalogPage()
                .getSeveralGoodsTitle(goodsQuantity);

        new CatalogPage()
                .addGoodsToWishList(1)
                .changeWishListTitle(customWishListTitle)
                .setEmailAndClickOnSaveButton(mainEmail)
                .setPasswordAndClickOnEnterButton(mainPassword);

        goodsFromWishList = new HeaderArea()
                .openWishListPage()
                .getSeveralGoodsTitle(goodsQuantity);

        new WishListPage()
                .clearWishList();

        Assert.assertEquals(goodsFromCatalog, goodsFromWishList);
    }

    @Test(testName = "IVV-1738",
            description = "Добавление в WishList с каталога (в список по умолчанию, смена учетки на этапе авторизации)")
    public void addToDefaultWishListAndChangeEmailFromCatalog() {

        goodsFromCatalog = new CatalogPage()
                .getSeveralGoodsTitle(goodsQuantity);

        new CatalogPage()
                .addGoodsToWishList(1)
                .setEmailAndClickOnSaveButton(mainEmail)
                .setEmailAndPasswordAndClickOnEnterButton(additionalEmail, additionalPassword);

        goodsFromWishList = new HeaderArea()
                .openWishListPage()
                .getSeveralGoodsTitle(goodsQuantity);

        new WishListPage()
                .clearWishList()
                .backToPreviousPage();

        new HeaderArea()
                .logout()
                .openLoginPopup()
                .loginAs(mainEmail, mainPassword);

        Assert.assertTrue(new HeaderArea().isWishListCounterAbsent());
        Assert.assertEquals(goodsFromCatalog, goodsFromWishList);
    }

    @Test(testName = "IVV-1739",
            description = "Добавление в WishList с каталога (в кастомный список, смена учетки на этапе авторизации)")
    public void addToCustomWishListAndChangeEmailFromCatalog() {

        goodsFromCatalog = new CatalogPage()
                .getSeveralGoodsTitle(goodsQuantity);

        new CatalogPage()
                .addGoodsToWishList(1)
                .changeWishListTitle(customWishListTitle)
                .setEmailAndClickOnSaveButton(mainEmail)
                .setEmailAndPasswordAndClickOnEnterButton(additionalEmail, additionalPassword);

        goodsFromWishList = new HeaderArea()
                .openWishListPage()
                .getSeveralGoodsTitle(goodsQuantity);

        Assert.assertEquals(new WishListPage().getWishListTitle(), customWishListTitle);

        Assert.assertEquals(goodsFromCatalog, goodsFromWishList);

        new WishListPage()
                .clearWishList()
                .backToPreviousPage();

        new HeaderArea()
                .logout()
                .openLoginPopup()
                .loginAs(mainEmail, mainPassword);

        Assert.assertTrue(new HeaderArea().isWishListCounterAbsent());
    }

    @Test(testName = "IVV-1740",
            description = "Отмена добавления в WishList с каталога и проверка, что товар не добавлен")
    public void cancelAddToDefaultWishListFromCatalog() {

        new CatalogPage()
                .addGoodsToWishList(goodsQuantity)
                .setEmailAndClickOnSaveButton(mainEmail)
                .closeAddToWishListPopup();

        new HeaderArea()
                .openLoginPopup()
                .loginAs(mainEmail, mainPassword);

        Assert.assertTrue(new HeaderArea().isWishListCounterAbsent());
    }

    @Test(testName = "IVV-1759",
            description = "Добавление в WishList с каталога (в список по умолчанию, смена учетки на этапе авторизации). Проверка без открытия вишлиста")
    public void addToDefaultWishListAndChangeEmailCheckSecondAccount() {

        new CatalogPage()
                .addGoodsToWishList(1)
                .setEmailAndClickOnSaveButton(mainEmail)
                .setEmailAndPasswordAndClickOnEnterButton(additionalEmail, additionalPassword);

        new HeaderArea()
                .logout()
                .openLoginPopup()
                .loginAs(mainEmail, mainPassword);

        Assert.assertTrue(new HeaderArea().isWishListCounterAbsent());
    }
}
