package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IVV.HeaderArea;
import pages.IVV.CatalogPage;
import pages.IVV.FiltersArea;
import rozetka.SetupTest;

import java.util.List;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static helpers.PropertiesHelper.getProperty;

public class BonusTest extends SetupTest {

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {
        open(manShoesCategoryURL);
    }

    @Test(testName = "IVV-1797",
            description = "Наличие фильтра 'Товары с бонусами' и фильтрация товара (для участника программы лояльности)",
            priority = 1)
    public void bonusFilterIsPresentForLoyaltyProgramAccount() {

        List<String> goodsTitlesBefore = new CatalogPage()
                .getSeveralGoodsTitle(20);

        new HeaderArea()
                .openLoginPopup()
                .loginAs(getProperty("bonusUser"), getProperty("bonusPassword"))
                .selectFilterByTitle("Программа лояльности", "С бонусами");

        boolean isBonusPresentInAllGoods = new CatalogPage()
                .checkDataOnGoodsCard("bonus");

        new FiltersArea()
                .selectFilterByTitle("Программа лояльности", "С бонусами");

        List<String> goodsTitlesAfter = new CatalogPage()
                .getSeveralGoodsTitle(20);

        Assert.assertTrue(isBonusPresentInAllGoods);
        Assert.assertEquals(goodsTitlesBefore, goodsTitlesAfter);

        new HeaderArea()
                .logout();
    }

    @Test(testName = "IVV-1798",
            description = "Отсутствие фильтра 'Товары с бонусами' (для не участника программы лояльности)",
            priority = 2)
    public void bonusFilterIsAbsentForCommonAccount() {

        new HeaderArea()
                .openLoginPopup()
                .loginAs(getProperty("commonUserLogin"), getProperty("commonUserPassword"));

        Assert.assertTrue(new HeaderArea().bonusIcon.is(not(visible)));
        Assert.assertTrue(new CatalogPage().goodsWithBonusCheckbox.is(not(visible)));

        new HeaderArea()
                .logout();
    }

    @Test(testName = "tests.IVV-1799",
            description = "Проверка фильтрации при выходе из учетки (только фильтр 'Товары с бонусами')",
            priority = 3)
    public void goodsFilterAfterLogoutWithOnlyBonus() {

        List<String> goodsTitlesBefore = new CatalogPage()
                .getSeveralGoodsTitle(30);

        new HeaderArea()
                .openLoginPopup()
                .loginAs(getProperty("bonusUser"), getProperty("bonusPassword"))
                .selectFilterByTitle("Программа лояльности", "С бонусами");

        new HeaderArea()
                .logout();

        List<String> goodsTitlesAfter = new CatalogPage()
                .getSeveralGoodsTitle(30);

        Assert.assertEquals(goodsTitlesBefore, goodsTitlesAfter);
    }

    @Test(testName = "tests.IVV-1800",
            description = "Проверка фильтрации при выходе из учетки (фильтр 'Товары с бонусами' + фильтр 'Бренд')",
            priority = 4)
    public void goodsFilterAfterLogoutWithBonusAndBrand() {

        new HeaderArea()
                .openLoginPopup()
                .loginAs(getProperty("bonusUser"), getProperty("bonusPassword"));

        new FiltersArea()
                .searchFilterItemAndSelectIt("Бренд", "Crocs")
                .selectFilterByTitle("Программа лояльности", "С бонусами");

        Assert.assertTrue(new CatalogPage()
                .checkDataOnGoodsCard("bonus"));

        new HeaderArea()
                .logout();

        Assert.assertFalse(new CatalogPage()
                .checkDataOnGoodsCard("bonus"));  //Проверяем отсутствие бонусов
    }
}
