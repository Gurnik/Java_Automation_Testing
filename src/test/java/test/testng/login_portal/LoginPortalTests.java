package test.testng.login_portal;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.LoaderTwoPage;
import pages.page_object.LoginPortalTestPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class LoginPortalTests extends BaseTests {

    @Test
    public void testClickOnLoginPortalTestPageHeader() {
        LoginPortalTestPage loginPortalPage = this.homePage.clickLoginPortalTestPage();
        this.testClickOnBasePageHeader(loginPortalPage);
    }

    @Test
    public void testLoginPortalTestPageMenuSize() {
        LoginPortalTestPage loginPortalPage = this.homePage.clickLoginPortalTestPage();
        Assert.assertEquals(loginPortalPage.getMenuSize(), 21);
    }

    @Test
    public void testLoginPortalTestPageToggleMenuListIsWorking() {
        LoginPortalTestPage loginPortalPage = this.homePage.clickLoginPortalTestPage();
        this.testBasePageToggleMenuListIsWorking(loginPortalPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testLoginPortalTestPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        LoginPortalTestPage loginPortalPage = this.homePage.clickLoginPortalTestPage();
        Assert.assertEquals(loginPortalPage.getMenuTitle(index), expected);
    }

    @Test
    public void testLoginPortalTestPageTitle() {
        this.homePage.clickLoginPortalTestPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Login Portal");
    }

    @Test
    public void testLoginPortalTestPageUrl() {
        this.homePage.clickLoginPortalTestPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/loginPortal.html");
    }

    @Test
    public void testLoginPortalTestPageContent() {
        LoaderTwoPage loaderTwoPage = this.homePage.clickLoaderTwoPage();
        this.softAssert.assertEquals(loaderTwoPage.getPageTestTitleText(),
                "Login Portal Test");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testLoginPortalTestPageVisually() {
        // TODO
    }
}
