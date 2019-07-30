package rozetka.catalog.front;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IVV.FatMenuArea;
import pages.IVV.HeaderArea;
import pages.IVV.SuperPortalPage;
import rozetka.SetupTest;

import static com.codeborne.selenide.Selenide.open;
import static helpers.PropertiesHelper.getProperty;

public class SuperPortalTest extends SetupTest {

    @BeforeMethod
    public void openPage() {
        open(getProperty("superPortal"));
    }

    @Test(testName = "IVV-1027", description = "Проверка открытия фат меню в суперпортале Fashion")
    public void verifyFatMenu() {

        new HeaderArea()
                .openCatalogFatMenu();

        Assert.assertTrue(new FatMenuArea().isFatMenuOpened());
    }

    @Test(testName = "IVV-1029", description = "Проверка брендов на женском суперпортале")
    public void womanBrandsVerify() {

        new SuperPortalPage()
                .clickOnWomenLink();

        Assert.assertTrue(new SuperPortalPage().isBrandOnSuperPortalIsEqualToCatalog(""));
    }

    @Test(testName = "IVV-1030", description = "Проверка брендов на мужском суперпортале")
    public void manBrandsVerify() {

        new SuperPortalPage()
                .clickOnMenLink();

        Assert.assertTrue(new SuperPortalPage().isBrandOnSuperPortalIsEqualToCatalog(""));
    }

    @Test(testName = "IVV-1031", description = "Проверка брендов на детском суперпортале")
    public void childrenBrandsVerify() {

        new SuperPortalPage()
                .clickOnChildrenLink();

        Assert.assertTrue(new SuperPortalPage().isBrandOnSuperPortalIsEqualToCatalog(""));
    }

    @Test(testName = "IVV-1970", description = "Проверка порталов после нажатия на 'активную' гендерную ссылку")
    public void checkActiveGenderLink() {

        Assert.assertEquals(new SuperPortalPage()
                .clickOnWomenLink()
                .getActiveGenderTitle(), "Женщинам");

        Assert.assertEquals(new SuperPortalPage()
                .clickOnMenLink()
                .getActiveGenderTitle(), "Мужчинам");

        Assert.assertEquals(new SuperPortalPage()
                .clickOnChildrenLink()
                .getActiveGenderTitle(), "Детям");
    }

    @Test(testName = "IVV-1974", description = "Проверка всех картинок на главном суперпортале (включая рекламные блоки, актуальные распродажи)")
    public void checkImagesOnMainSuperPortal() {

        Assert.assertTrue(new SuperPortalPage().isMainGenderImagesPresent());
        Assert.assertTrue(new SuperPortalPage().isActualSalesBlockPresent());
        Assert.assertTrue(new SuperPortalPage().isMainAdvertiseBlockPresent());
    }

    @Test(testName = "IVV-1975", description = "Проверка наличия картинок на женском суперпортале (включая рекламные блоки, актуальные распродажи)")
    public void checkImagesOnWomenSuperPortal() {

        new SuperPortalPage()
                .clickOnWomenLink();

        Assert.assertTrue(new SuperPortalPage().isMainWomenImagePresent());
        Assert.assertTrue(new SuperPortalPage().isActualSalesBlockPresent());
        Assert.assertTrue(new SuperPortalPage().isAdvertiseBlocksPresent());
    }

    @Test(testName = "IVV-1976", description = "Проверка наличия картинок на мужском суперпортале (включая рекламные блоки, актуальные распродажи)")
    public void checkImagesOnMenSuperPortal() {

        new SuperPortalPage()
                .clickOnMenLink();

        Assert.assertTrue(new SuperPortalPage().isMainMenImagesPresent());
        Assert.assertTrue(new SuperPortalPage().isActualSalesBlockPresent());
        Assert.assertTrue(new SuperPortalPage().isAdvertiseBlocksPresent());
    }

    @Test(testName = "IVV-1977", description = "Проверка наличия картинок на детском суперпортале (включая рекламные блоки, актуальные распродажи)")
    public void checkImagesOnChildrenSuperPortal() {

        new SuperPortalPage()
                .clickOnChildrenLink();

        Assert.assertTrue(new SuperPortalPage().isMainChildrenImagesPresent());
        Assert.assertTrue(new SuperPortalPage().isActualSalesBlockPresent());
        Assert.assertTrue(new SuperPortalPage().isChildrenAdvertiseBlocksPresent());
    }
}
