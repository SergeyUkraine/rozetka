package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IVV.HorizontalMenu;
import rozetka.SetupTest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static helpers.PropertiesHelper.getProperty;
import static java.nio.file.Files.readAllLines;

public class HorizontalMenuTest extends SetupTest {

    private List<String> getListDataFromTxt(String file) {
        List<String> list = new ArrayList<>();
        try {
            list = readAllLines(Paths.get("src", "test", "resources", "data", "horizontalMenu", file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Parameters({"manShoesCategoryURL"})
    @BeforeMethod
    public void openPage(String manShoesCategoryURL) {
        open(manShoesCategoryURL);
    }

    @Test(testName = "IVV-1527", description = "Тексты главных кнопок Fashion меню")
    public void checkMainButtons() {

        Assert.assertEquals(new HorizontalMenu().getWomenLinkTitle(), "Женщинам");
        Assert.assertEquals(new HorizontalMenu().getMenLinkTitle(), "Мужчинам");
        Assert.assertEquals(new HorizontalMenu().getGirlsLinkTitle(), "Девочкам");
        Assert.assertEquals(new HorizontalMenu().getBoysLinkTitle(), "Мальчикам");
        Assert.assertEquals(new HorizontalMenu().getChildrenLinkTitle(), "Малышам");
    }


    @Test(testName = "IVV-1528", description = "Проверка тайтлов ссылок в категории 'Мужчинам', в Fashion меню")
    public void checkTitlesOfMenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnMenLink()
                .isLinksTitleEqualTo(getListDataFromTxt("menTitles.txt")));
    }

    @Test(testName = "IVV-1529", description = "Проверка ссылок в категории 'Мужчинам', в Fashion меню")
    public void checkLinksOfMenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnMenLink()
                .isLinksHrefEqualTo(getListDataFromTxt("menLinks.txt")));
    }

    @Test(testName = "IVV-1530", description = "Работоспособность ссылок категории 'Мужчинам', в Fashion меню")
    public void checkUrlsOfMenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnMenLink()
                .isLinksHaveStatusCode200(""));
    }

    @Test(testName = "IVV-1987", description = "Проверка тайтлов ссылок в категории 'Женщинам', в Fashion меню")
    public void checkTitlesOfWomenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnWomenLink()
                .isLinksTitleEqualTo(getListDataFromTxt("womenTitles.txt")));
    }

    @Test(testName = "IVV-1988", description = "Проверка ссылок в категории 'Женщинам', в Fashion меню")
    public void checkLinksOfWomenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnWomenLink()
                .isLinksHrefEqualTo(getListDataFromTxt("womenLinks.txt")));
    }

    @Test(testName = "IVV-1989", description = "Работоспособность ссылок категории 'Женщинам', в Fashion меню")
    public void checkUrlsOfWomenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnWomenLink()
                .isLinksHaveStatusCode200(""));
    }

    @Test(testName = "IVV-1990", description = "Проверка тайтлов ссылок в категории 'Малышам', в Fashion меню")
    public void checkTitlesOfChildrenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnChildrenLink()
                .isLinksTitleEqualTo(getListDataFromTxt("childrenTitles.txt")));
    }

    @Test(testName = "IVV-1991", description = "Проверка ссылок в категории 'Малышам', в Fashion меню")
    public void checkLinksOfChildrenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnChildrenLink()
                .isLinksHrefEqualTo(getListDataFromTxt("childrenLinks.txt")));
    }

    @Test(testName = "IVV-1992", description = "Работоспособность ссылок категории 'Малышам', в Fashion меню")
    public void checkUrlsOfChildrenMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnChildrenLink()
                .isLinksHaveStatusCode200(""));
    }

    @Test(testName = "IVV-1993", description = "Проверка тайтлов ссылок в категории 'Мальчикам', в Fashion меню")
    public void checkTitlesOfBoysMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnBoysLink()
                .isLinksTitleEqualTo(getListDataFromTxt("boysTitles.txt")));
    }

    @Test(testName = "IVV-1994", description = "Проверка ссылок в категории 'Мальчикам', в Fashion меню")
    public void checkLinksOfBoysMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnBoysLink()
                .isLinksHrefEqualTo(getListDataFromTxt("boysLinks.txt")));
    }

    @Test(testName = "IVV-1995", description = "Работоспособность ссылок категории 'Мальчикам', в Fashion меню")
    public void checkUrlsOfBoysMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnBoysLink()
                .isLinksHaveStatusCode200(""));
    }

    @Test(testName = "IVV-1996", description = "Проверка тайтлов ссылок в категории 'Девочкам', в Fashion меню")
    public void checkTitlesOfGirlsMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnGirlsLink()
                .isLinksTitleEqualTo(getListDataFromTxt("girlsTitles.txt")));
    }

    @Test(testName = "IVV-1997", description = "Проверка ссылок в категории 'Девочкам', в Fashion меню")
    public void checkLinksOfGirlsMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnGirlsLink()
                .isLinksHrefEqualTo(getListDataFromTxt("girlsLinks.txt")));
    }

    @Test(testName = "IVV-1998", description = "Работоспособность ссылок категории 'Девочкам', в Fashion меню")
    public void checkUrlsOfGirlsMenu() {

        Assert.assertTrue(new HorizontalMenu()
                .clickOnGirlsLink()
                .isLinksHaveStatusCode200(""));
    }

    @Test(testName = "IVV-1999", description = "Проверка главной ссылки Fashion меню")
    public void checkMainFashionLink() {

        String fashionLink = new HorizontalMenu().getMainFashionLink();

        Assert.assertEquals(new HorizontalMenu().getMainFashionTitle(), "FASHION");
        Assert.assertEquals(fashionLink, getProperty("superPortal"));
        Assert.assertEquals(new HorizontalMenu().getStatusCodeOfResponse(fashionLink), 200);
    }

    @Test(testName = "IVV-2231", description = "Проверка сворачивания горизонтального меню после перехода на суперпортал")
    public void menuIsNotOpenedAfterGoBackFromSuperPortal() {

        new HorizontalMenu()
                .clickOnBoysLink()
                .clickOnFashionMainLink();

        back();

        Assert.assertFalse(new HorizontalMenu().isHorizontalMenuOpened());

        new HorizontalMenu()
                .clickOnChildrenLink();

        Assert.assertEquals($$("button.fashion-menu__genders-button.fashion-menu__genders-button_state_active").size(), 1);
    }
}

