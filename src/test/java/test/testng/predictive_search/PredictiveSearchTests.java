package test.testng.predictive_search;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.PredictiveSearchPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class PredictiveSearchTests extends BaseTests {

    @Test
    public void testClickOnPredictiveSearchPageHeader() {
        PredictiveSearchPage predictiveSearchPage = this.homePage.clickPredictiveSearchPage();
        this.testClickOnBasePageHeader(predictiveSearchPage);
    }

    @Test
    public void testPredictiveSearchPageMenuSize() {
        PredictiveSearchPage predictiveSearchPage = this.homePage.clickPredictiveSearchPage();
        Assert.assertEquals(predictiveSearchPage.getMenuSize(), 21);
    }

    @Test
    public void testPredictiveSearchPageToggleMenuListIsWorking() {
        PredictiveSearchPage predictiveSearchPage = this.homePage.clickPredictiveSearchPage();
        this.testBasePageToggleMenuListIsWorking(predictiveSearchPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testPredictiveSearchPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        PredictiveSearchPage predictiveSearchPage = this.homePage.clickPredictiveSearchPage();
        Assert.assertEquals(predictiveSearchPage.getMenuTitle(index), expected);
    }

    @Test
    public void testPredictiveSearchPageTitle() {
        this.homePage.clickPredictiveSearchPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Predictive Search");
    }

    @Test
    public void testPredictiveSearchPageUrl() {
        this.homePage.clickPredictiveSearchPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/predictive.html");
    }

    @Test
    public void testPredictiveSearchPageContent() {
        PredictiveSearchPage predictiveSearchPage = this.homePage.clickPredictiveSearchPage();
        this.softAssert.assertEquals(predictiveSearchPage.getPageTestTitleText(),
                "Predictive Text Search");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testPredictiveSearchPageVisually() {
        // TODO
    }
}
