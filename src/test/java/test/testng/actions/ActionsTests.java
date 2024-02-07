package test.testng.actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.ActionsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class ActionsTests extends BaseTests {


    @Test
    public void testClickOnActionsPageHeader() {
        ActionsPage actionsPage = this.homePage.clickActionsPage();
        this.testClickOnBasePageHeader(actionsPage);
    }

    @Test
    public void testActionsPageMenuSize() {
        ActionsPage actionsPage = this.homePage.clickActionsPage();
        Assert.assertEquals(actionsPage.getMenuSize(), 21);
    }

    @Test
    public void testActionsPageToggleMenuListIsWorking() {
        ActionsPage actionsPage = this.homePage.clickActionsPage();
        this.testBasePageToggleMenuListIsWorking(actionsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testActionsPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        ActionsPage actionsPage = this.homePage.clickActionsPage();
        Assert.assertEquals(actionsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testActionsPageTitle() {
        this.homePage.clickActionsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Actions");
    }

    @Test
    public void testActionsPageUrl() {
        this.homePage.clickActionsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/actions.html");
    }

    @Test
    public void testActionsPageContent() {
        ActionsPage actionsPage = this.homePage.clickActionsPage();
        this.softAssert.assertEquals(actionsPage.getPageTestTitleText(), "Actions");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testActionsPageVisually() {
        // TODO
    }
}
