package test.testng.loader;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.LoaderTwoPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class LoaderTwoTests extends BaseTests {

    @Test
    public void testClickOnLoaderTwoPageHeader() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        this.testClickOnBasePageHeader(loaderTwoPage);
    }

    @Test
    public void testLoaderTwoPageMenuSize() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        Assert.assertEquals(loaderTwoPage.getMenuSize(), 21);
    }

    @Test
    public void testLoaderTwoPageToggleMenuListIsWorking() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        this.testBasePageToggleMenuListIsWorking(loaderTwoPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testLoaderTwoPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        Assert.assertEquals(loaderTwoPage.getMenuTitle(index), expected);
    }

    @Test
    public void testLoaderTwoPageTitle() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Loader Two");
    }

    @Test
    public void testLoaderTwoPageUrl() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/loadertwo.html");
    }

    @Test
    public void testLoaderTwoPageContent() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        this.softAssert.assertEquals(loaderTwoPage.getPageTestTitleText(),
                "Loader Two");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testLoaderTwoPageVisually() {
        // TODO
    }
}
