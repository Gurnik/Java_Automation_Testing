package test.testng.tables;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.TablesPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class TablesTests extends BaseTests {

    @Test
    public void testClickOnTablesPageHeader() {
        TablesPage tablesPage = this.homePage.clickTablesPage();
        this.testClickOnBasePageHeader(tablesPage);
    }

    @Test
    public void testTablesPageMenuSize() {
        TablesPage tablesPage = this.homePage.clickTablesPage();
        Assert.assertEquals(tablesPage.getMenuSize(), 21);
    }

    @Test
    public void testTablesPageToggleMenuListIsWorking() {
        TablesPage tablesPage = this.homePage.clickTablesPage();
        this.testBasePageToggleMenuListIsWorking(tablesPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testTablesPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        TablesPage tablesPage = this.homePage.clickTablesPage();
        Assert.assertEquals(tablesPage.getMenuTitle(index), expected);
    }

    @Test
    public void testTablesPageTitle() {
        this.homePage.clickTablesPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Tables");
    }

    @Test
    public void testTablesPageUrl() {
        this.homePage.clickTablesPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/tables.html");
    }

    @Test
    public void testTablesPageContent() {
        TablesPage tablesPage = this.homePage.clickTablesPage();
        this.softAssert.assertEquals(tablesPage.getPageTestTitleText(),
                "Tables");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testTablesPageVisually() {
        // TODO
    }
}
