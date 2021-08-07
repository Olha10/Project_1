package testcases;

import org.testng.annotations.Test;
import pages.MainPageLocators;
import testbase.TestBase;

public class MainPageTests extends TestBase {
    MainPageLocators mainPageLocators = new MainPageLocators();

    @Test
    public void checkIcecatSearchButton() {
        elementsHelper.clickOnVisibleAndClickableElement(mainPageLocators.IcecatSearchButton,15);
    }
}
