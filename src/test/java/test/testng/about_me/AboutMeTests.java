package test.testng.about_me;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.AboutMePage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class AboutMeTests extends BaseTests {

    @Test
    public void testClickOnAboutMePageHeader() {
        AboutMePage aboutMePage = this.homePage.clickAboutMePage();
        this.testClickOnBasePageHeader(aboutMePage);
    }

    @Test
    public void testAboutMePageMenuSize() {
        AboutMePage aboutMePage = this.homePage.clickAboutMePage();
        Assert.assertEquals(aboutMePage.getMenuSize(), 21);
    }

    @Test
    public void testAboutMePageToggleMenuListIsWorking() {
        AboutMePage aboutMePage = this.homePage.clickAboutMePage();
        this.testBasePageToggleMenuListIsWorking(aboutMePage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testAboutMePageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        AboutMePage aboutMePage = this.homePage.clickAboutMePage();
        Assert.assertEquals(aboutMePage.getMenuTitle(index), expected);
    }

    @Test
    public void testAboutMePageTitle() {
        this.homePage.clickAboutMePage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "About Me");
    }

    @Test
    public void testAboutMePageUrl() {
        this.homePage.clickAboutMePage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/aboutMe.html");
    }

    @Test
    public void testAboutMePageContent() {
        AboutMePage aboutMePage = this.homePage.clickAboutMePage();
        this.softAssert.assertEquals(aboutMePage.getPageTestTitleText(), "Who we are");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testAboutMePageVisually() {
        // TODO
    }
}
