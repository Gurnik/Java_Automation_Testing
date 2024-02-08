package test.testng.home;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class HomeTests extends BaseTests {

    @Test
    public void testClickOnHomePageHeader() {
        this.testClickOnBasePageHeader(this.homePage);
    }

    @Test
    public void testHomePageMenuSize() {
        Assert.assertEquals(homePage.getMenuSize(), 21);
    }

    @Test
    public void testHomePageToggleMenuListIsWorking() {
        this.testBasePageToggleMenuListIsWorking(this.homePage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testHomePageMenuTitlesAreCorrectAndOrdered(String expected, int index) {
        Assert.assertEquals(this.homePage.getMenuTitle(index), expected);
    }

    @Test
    public void testHomePageTitle() {
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Homepage");
    }

    @Test
    public void testHomePageUrl() {
        Assert.assertEquals(this.getWindowManager().getPageUrl(), "https://automationtesting.co.uk/index.html");
    }

    @Test
    public void testHomePageContent() {
        this.softAssert.assertEquals(this.homePage.getPageTestTitleText(), "Testing Arena");
        this.softAssert.assertEquals(this.homePage.getPageTestDescriptionText(), "This website has been" +
                " designed to help you practice your test automation skills by providing various scenarios that" +
                " you will find across the web. Use the menu on the left to navigate across the website.");
        this.softAssert.assertEquals(this.homePage.getCheckOutSisterSiteText(),
                "Check out our sister site at webdriveruniversity.com");
        this.softAssert.assertEquals(this.homePage.getDiscountText(), "Courses by us!\n" +
                "50%+ discount code automatically applied\n" +
                "Updated regularly");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testHomePageVisually() {
        // TODO
    }

    @Test(dataProviderClass = HomeData.class, dataProvider = "goToWebsiteWithoutCAPTCHA")
    public void testGoToWebDriverUniversityWebsite(String pageLinkText, String pageUrl)  {
        this.homePage.clickLink(pageLinkText);
        this.softAssert.assertEquals(this.getWindowManager().getPageUrl(), pageUrl);
        this.softAssert.assertAll();
    }
}
