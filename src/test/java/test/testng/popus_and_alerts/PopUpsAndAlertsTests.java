package test.testng.popus_and_alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.PopUpsAndAlertsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class PopUpsAndAlertsTests extends BaseTests {

    @Test
    public void testClickOnPopUpsAndAlertsPageHeader() {
        PopUpsAndAlertsPage popUpsAndAlertsPage = this.homePage.clickPopUpsAndAlertsPage();
        this.testClickOnBasePageHeader(popUpsAndAlertsPage);
    }

    @Test
    public void testPopUpsAndAlertsPageMenuSize() {
        PopUpsAndAlertsPage popUpsAndAlertsPage = this.homePage.clickPopUpsAndAlertsPage();
        Assert.assertEquals(popUpsAndAlertsPage.getMenuSize(), 21);
    }

    @Test
    public void testPopUpsAndAlertsPageToggleMenuListIsWorking() {
        PopUpsAndAlertsPage popUpsAndAlertsPage = this.homePage.clickPopUpsAndAlertsPage();
        this.testBasePageToggleMenuListIsWorking(popUpsAndAlertsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testPopUpsAndAlertsPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        PopUpsAndAlertsPage popUpsAndAlertsPage = this.homePage.clickPopUpsAndAlertsPage();
        Assert.assertEquals(popUpsAndAlertsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testPopUpsAndAlertsPageTitle() {
        this.homePage.clickPopUpsAndAlertsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Pop Ups");
    }

    @Test
    public void testPopUpsAndAlertsPageUrl() {
        this.homePage.clickPopUpsAndAlertsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/popups.html");
    }

    @Test
    public void testPopUpsAndAlertsPageContent() {
        PopUpsAndAlertsPage popUpsAndAlertsPage = this.homePage.clickPopUpsAndAlertsPage();
        this.softAssert.assertEquals(popUpsAndAlertsPage.getPageTestTitleText(),
                "Popup & Alerts");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testPopUpsAndAlertsPageVisually() {
        // TODO
    }
}
