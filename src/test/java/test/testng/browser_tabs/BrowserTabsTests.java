package test.testng.browser_tabs;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.BrowserTabsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class BrowserTabsTests extends BaseTests {

    @Test
    public void testClickOnBrowserTabsPageHeader() {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        this.testClickOnBasePageHeader(browserTabsPage);
    }

    @Test
    public void testBrowserTabsPageMenuSize() {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        Assert.assertEquals(browserTabsPage.getMenuSize(), 21);
    }

    @Test
    public void testBrowserTabsPageToggleMenuListIsWorking() {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        this.testBasePageToggleMenuListIsWorking(browserTabsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testBrowserTabsPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        Assert.assertEquals(browserTabsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testBrowserTabsPageTitle() {
        this.homePage.clickBrowserTabsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Browser Tabs");
    }

    @Test
    public void testBrowserTabsPageUrl() {
        this.homePage.clickBrowserTabsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/browserTabs.html");
    }

    @Test
    public void testBrowserTabsPageContent() {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        this.softAssert.assertEquals(browserTabsPage.getPageTestTitleText(), "Browser Tabs");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testBrowserTabsPageVisually() {
        // TODO
    }
}
