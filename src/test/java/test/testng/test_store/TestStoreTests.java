package test.testng.test_store;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.TestStorePage;
import test.testng.base.BaseTests;

public class TestStoreTests extends BaseTests {

    @Test
    public void testClickOnTestStorePageHeader() {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        this.softAssert.assertEquals(testStorePage.getHeaderWithTitleAutomationTestingTestArenaText(),
                "Automation Testing Test Arena");
        testStorePage.clickOnHeaderWithTitleAutomationTestingTestArena();
        this.softAssert.assertEquals(getWindowManager().getPageTitle(), "HomePage");
        this.softAssert.assertEquals(getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/index.html");
    }

    @Test
    public void testTestStorePageMenuSize() {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        Assert.assertEquals(testStorePage.getMenuSize(), 21);
    }

    @Test
    public void testTestStorePageToggleMenuListIsWorking() {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        softAssert.assertEquals(testStorePage.isMenuTitleVisible(), true);
        homePage.clickToggle();
        softAssert.assertEquals(testStorePage.isMenuTitleVisible(), false);
        homePage.clickToggle();
        softAssert.assertEquals(testStorePage.isMenuTitleVisible(), true);
        softAssert.assertAll();
    }

    @Test(dataProviderClass = BaseTests.class, dataProvider = "provideMenuListTitles")
    public void testTestStorePageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        Assert.assertEquals(testStorePage.getMenuTitle(index), expected);
    }

    @Test
    public void testTestStorePageTitle() {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Accordion");
    }

    @Test
    public void testTestStorePageUrl() {
        TestStorePage testStorePage = this.homePage.clickTestStorePage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "http://teststore.automationtesting.co.uk/");
    }

    @Test
    public void testTestStorePageVisually() {
        // TODO
    }
}
