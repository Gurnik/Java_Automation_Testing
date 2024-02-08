package test.testng.buttons;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.ButtonsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class ButtonsTests extends BaseTests {

    @Test
    public void testClickOnButtonsPageHeader() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();

        this.testClickOnBasePageHeader(buttonsPage);
    }

    @Test
    public void testButtonsPageMenuSize() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        Assert.assertEquals(buttonsPage.getMenuSize(), 21);
    }

    @Test
    public void testButtonsPageToggleMenuListIsWorking() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        this.testBasePageToggleMenuListIsWorking(buttonsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testButtonsPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        Assert.assertEquals(buttonsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testButtonsPageTitle() {
        this.homePage.clickButtonsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Buttons");
    }

    @Test
    public void testButtonsPageUrl() {
        this.homePage.clickButtonsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/buttons.html");
    }

    @Test
    public void testButtonPageContent() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        this.softAssert.assertEquals(buttonsPage.getPageTestTitleText(), "Testing Buttons");
        this.softAssert.assertEquals(buttonsPage.getPageTestDescriptionText(), "Attempt to click the buttons" +
                " using the instructions for each button below. There are various ways you can click buttons.");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testButtonsPageVisually() {
        // TODO
    }
}
