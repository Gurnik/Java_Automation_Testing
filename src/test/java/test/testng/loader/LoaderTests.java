package test.testng.loader;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.LoaderPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class LoaderTests extends BaseTests {

    @Test
    public void testClickOnLoaderPageHeader() {
        LoaderPage loaderPage = this.homePage.clickLoaderPage();
        this.testClickOnBasePageHeader(loaderPage);
    }

    @Test
    public void testLoaderPageMenuSize() {
        LoaderPage loaderPage = this.homePage.clickLoaderPage();
        Assert.assertEquals(loaderPage.getMenuSize(), 21);
    }

    @Test
    public void testLoaderPageToggleMenuListIsWorking() {
        LoaderPage loaderPage = this.homePage.clickLoaderPage();
        this.testBasePageToggleMenuListIsWorking(loaderPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testLoaderPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        LoaderPage loaderPage = this.homePage.clickLoaderPage();
        Assert.assertEquals(loaderPage.getMenuTitle(index), expected);
    }

    @Test
    public void testLoaderPageTitle() {
        this.homePage.clickLoaderPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Loader");
    }

    @Test
    public void testLoaderPageUrl() {
        this.homePage.clickLoaderPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/loader.html");
    }

    @Test
    public void testLoaderPageContent() {
        LoaderPage loaderPage = this.homePage.clickLoaderPage();
        this.softAssert.assertEquals(loaderPage.getPageTestTitleText(),
                "Loader");
        this.softAssert.assertEquals(loaderPage.getPageTestDescriptionText(), "Use this webpage by waiting" +
                " for an element to appear after to loader completes (wait 5 seconds).");
        this.softAssert.assertAll();
    }

    @Test
    public void testLoaderPageVisually() {
        // TODO
    }
}
