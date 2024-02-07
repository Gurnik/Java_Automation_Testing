package test.testng.home;

import org.testng.Assert;
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
    public void testHomePageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
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
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testHomePageVisually() {
        // TODO
    }
}
