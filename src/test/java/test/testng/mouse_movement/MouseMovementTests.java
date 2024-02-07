package test.testng.mouse_movement;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.MouseMovementPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class MouseMovementTests extends BaseTests {

    @Test
    public void testClickOnMouseMovementPageHeader() {
        MouseMovementPage mouseMovementPage = this.homePage.clickMouseMovementPage();
        this.testClickOnBasePageHeader(mouseMovementPage);
    }

    @Test
    public void testMouseMovementPageMenuSize() {
        MouseMovementPage mouseMovementPage = this.homePage.clickMouseMovementPage();
        Assert.assertEquals(mouseMovementPage.getMenuSize(), 21);
    }

    @Test
    public void testMouseMovementPageToggleMenuListIsWorking() {
        MouseMovementPage mouseMovementPage = this.homePage.clickMouseMovementPage();
        this.testBasePageToggleMenuListIsWorking(mouseMovementPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testMouseMovementPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        MouseMovementPage mouseMovementPage = this.homePage.clickMouseMovementPage();
        Assert.assertEquals(mouseMovementPage.getMenuTitle(index), expected);
    }

    @Test
    public void testMouseMovementPageTitle() {
        this.homePage.clickMouseMovementPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Mouse Clicks");
    }

    @Test
    public void testMouseMovementPageUrl() {
        this.homePage.clickMouseMovementPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/mouse.html");
    }

    @Test
    public void testMouseMovementPageContent() {
        MouseMovementPage mouseMovementPage = this.homePage.clickMouseMovementPage();
        this.softAssert.assertEquals(mouseMovementPage.getPageTestTitleText(),
                "Mouse Movement");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testMouseMovementPageVisually() {
        // TODO
    }
}
