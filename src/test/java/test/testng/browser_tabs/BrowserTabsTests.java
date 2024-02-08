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
    public void testBrowserTabsPageMenuTitlesAreCorrectAndOrdered(String expected, int index) {
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
        this.softAssert.assertEquals(browserTabsPage.getPageTestDescriptionText(),
                "Sometimes we need to test webpages that reside in a different tab. Use this page to click" +
                        " the button below, which will open a webpage in a new tab. Then try to get your Selenium" +
                        " test to switch to the new tab to perform an action on the new webpage. Then, get Selenium" +
                        " to switch back to the original tab.");
        this.softAssert.assertEquals(browserTabsPage.getOpenNewTabUsingButtonBelowTitleText(),
                "Open a new tab using the button below");
        this.softAssert.assertEquals(browserTabsPage.getOpenNewTabUsingButtonBelowDescriptionText(),
                "This button will open Google.com in a new tab.");
        this.softAssert.assertEquals(browserTabsPage.getOpenTabButtonText(), "Open Tab");
        this.softAssert.assertAll();
    }

    @Test
    public void testBrowserTabsPageVisually() {
        // TODO
    }

    @Test
    public void testOpenTab() {
        BrowserTabsPage browserTabsPage = this.homePage.clickBrowserTabsPage();
        this.softAssert.assertEquals(this.getWindowManager().getPageTitle(), "Browser Tabs");
        this.softAssert.assertEquals(this.getWindowManager().getNumberOfTabs(), 1);
        browserTabsPage.clickOpenTabButton();
        this.getWindowManager().switchToTab("Google");
        this.softAssert.assertEquals(this.getWindowManager().getPageTitle(), "Google");
        this.softAssert.assertEquals(this.getWindowManager().getNumberOfTabs(), 2);
        getWindowManager().closeTab("Google");
        getWindowManager().switchToTab("Browser Tabs");
        this.softAssert.assertEquals(this.getWindowManager().getPageTitle(), "Browser Tabs");
        this.softAssert.assertEquals(this.getWindowManager().getNumberOfTabs(), 1);
        this.softAssert.assertAll();
    }
}
