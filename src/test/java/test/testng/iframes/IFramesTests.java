package test.testng.iframes;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.IFramesPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class IFramesTests extends BaseTests {

    @Test
    public void testClickOnIFramesPageHeader() {
        IFramesPage iFramesPage = this.homePage.clickIFramesPage();
        this.testClickOnBasePageHeader(iFramesPage);
    }

    @Test
    public void testIFramesPageMenuSize() {
        IFramesPage iFramesPage = this.homePage.clickIFramesPage();
        Assert.assertEquals(iFramesPage.getMenuSize(), 21);
    }

    @Test
    public void testIFramesPageToggleMenuListIsWorking() {
        IFramesPage iFramesPage = this.homePage.clickIFramesPage();
        this.testBasePageToggleMenuListIsWorking(iFramesPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testIFramesPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        IFramesPage iFramesPage = this.homePage.clickIFramesPage();
        Assert.assertEquals(iFramesPage.getMenuTitle(index), expected);
    }

    @Test
    public void testIFramesPageTitle() {
        this.homePage.clickIFramesPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "IFrames");
    }

    @Test
    public void testIFramesPageUrl() {
        this.homePage.clickIFramesPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/iframes.html");
    }

    @Test
    public void testIFramePageContent() {
        IFramesPage iFramesPage = this.homePage.clickIFramesPage();
        this.softAssert.assertEquals(iFramesPage.getPageTestTitleText(),
                "IFrame");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testIFramesPageVisually() {
        // TODO
    }
}
