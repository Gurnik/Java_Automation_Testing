package test.testng.calculator;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.CalculatorJSPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class CalculatorJSTests extends BaseTests {

    @Test
    public void testClickOnCalculatorJSPageHeader() {
        CalculatorJSPage calculatorJSPage = this.homePage.clickCalculatorJSPage();
        this.testClickOnBasePageHeader(calculatorJSPage);
    }

    @Test
    public void testCalculatorJSPageMenuSize() {
        CalculatorJSPage calculatorJSPage = this.homePage.clickCalculatorJSPage();
        Assert.assertEquals(calculatorJSPage.getMenuSize(), 21);
    }

    @Test
    public void testCalculatorJSPageToggleMenuListIsWorking() {
        CalculatorJSPage calculatorJSPage = this.homePage.clickCalculatorJSPage();
        this.testBasePageToggleMenuListIsWorking(calculatorJSPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testCalculatorJSPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        CalculatorJSPage calculatorJSPage = this.homePage.clickCalculatorJSPage();
        Assert.assertEquals(calculatorJSPage.getMenuTitle(index), expected);
    }

    @Test
    public void testCalculatorJSPageTitle() {
        this.homePage.clickCalculatorJSPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Calculator using JavaScript");
    }

    @Test
    public void testCalculatorJSPageUrl() {
        this.homePage.clickCalculatorJSPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/calculator.html");
    }

    @Test
    public void testCalculatorJSPageContent() {
        CalculatorJSPage calculatorJSPage = this.homePage.clickCalculatorJSPage();
        this.softAssert.assertEquals(calculatorJSPage.getPageTestTitleText(), "Calculator using JavaScript");
        this.softAssert.assertEquals(calculatorJSPage.getPageTestDescriptionText(), "The following" +
                " calculator is written using JavaScript:");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testCalculatorJSPageVisually() {
        // TODO
    }
}
