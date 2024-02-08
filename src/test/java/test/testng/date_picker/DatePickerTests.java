package test.testng.date_picker;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.DatePickerPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class DatePickerTests extends BaseTests {

    @Test
    public void testClickOnDatePickerPageHeader() {
        DatePickerPage datePickerPage = this.homePage.clickDatePickerPage();
        this.testClickOnBasePageHeader(datePickerPage);
    }

    @Test
    public void testDatePickerPageMenuSize() {
        DatePickerPage datePickerPage = this.homePage.clickDatePickerPage();
        Assert.assertEquals(datePickerPage.getMenuSize(), 21);
    }

    @Test
    public void testDatePickerPageToggleMenuListIsWorking() {
        DatePickerPage datePickerPage = this.homePage.clickDatePickerPage();
        this.testBasePageToggleMenuListIsWorking(datePickerPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testDatePickerPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        DatePickerPage datePickerPage = this.homePage.clickDatePickerPage();
        Assert.assertEquals(datePickerPage.getMenuTitle(index), expected);
    }

    @Test
    public void testDatePickerPageTitle() {
        this.homePage.clickDatePickerPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Date Picker");
    }

    @Test
    public void testDatePickerPageUrl() {
        this.homePage.clickDatePickerPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/datepicker.html");
    }

    @Test
    public void testDatePickerPageContent() {
        DatePickerPage datePickerPage = this.homePage.clickDatePickerPage();
        this.softAssert.assertEquals(datePickerPage.getPageTestTitleText(), "Date Picker");
        this.softAssert.assertEquals(datePickerPage.getPageTestDescriptionText(), "On this page you can run" +
                " various tests against calendars using date pickers, date range and time selection.");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testDatePickerPageVisually() {
        // TODO
    }
}
