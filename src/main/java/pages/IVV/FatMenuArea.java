package pages.IVV;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FatMenuArea extends BasePage {

    SelenideElement firstLevelLinksBlock = $("ul.menu-categories");

    public boolean isFatMenuOpened() {
        return $(byXpath("//div[@class='menu__hidden-content']")).shouldBe(visible).isDisplayed();
    }
}
