package test.testng.hidden_elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.HiddenElementsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class HiddenElementsTests extends BaseTests {

    @Test
    public void testClickOnHiddenElementsPageHeader() {
        HiddenElementsPage hiddenElementsPage = this.homePage.clickHiddenElementsPage();
        this.testClickOnBasePageHeader(hiddenElementsPage);
    }

    @Test
    public void testHiddenElementsPageMenuSize() {
        HiddenElementsPage hiddenElementsPage = this.homePage.clickHiddenElementsPage();
        Assert.assertEquals(hiddenElementsPage.getMenuSize(), 21);
    }

    @Test
    public void testHiddenElementsPageToggleMenuListIsWorking() {
        HiddenElementsPage hiddenElementsPage = this.homePage.clickHiddenElementsPage();
        this.testBasePageToggleMenuListIsWorking(hiddenElementsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testHiddenElementsPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        HiddenElementsPage hiddenElementsPage = this.homePage.clickHiddenElementsPage();
        Assert.assertEquals(hiddenElementsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testHiddenElementsPageTitle() {
        this.homePage.clickHiddenElementsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Hidden Elements");
    }

    @Test
    public void testHiddenElementsPageUrl() {
        this.homePage.clickHiddenElementsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/hiddenElements.html");
    }

    @Test
    public void testHiddenElementsPageContent() {
        HiddenElementsPage hiddenElementsPage = this.homePage.clickHiddenElementsPage();
        this.softAssert.assertEquals(hiddenElementsPage.getPageTestTitleText(),
                "Hidden Elements");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testHiddenElementsPageVisually() {
        // TODO
    }
}
