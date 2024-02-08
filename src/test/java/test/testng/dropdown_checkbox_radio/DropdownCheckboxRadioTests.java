package test.testng.dropdown_checkbox_radio;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.DropDownCheckboxRadioPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class DropdownCheckboxRadioTests extends BaseTests {

    @Test
    public void testClickOnDropDownCheckboxRadioPageHeader() {
        DropDownCheckboxRadioPage dropDownCheckboxRadioPage = this.homePage.clickDropDownCheckboxRadioPage();
        this.testClickOnBasePageHeader(dropDownCheckboxRadioPage);
    }

    @Test
    public void testDropDownCheckboxRadioPageMenuSize() {
        DropDownCheckboxRadioPage dropDownCheckboxRadioPage = this.homePage.clickDropDownCheckboxRadioPage();
        Assert.assertEquals(dropDownCheckboxRadioPage.getMenuSize(), 21);
    }

    @Test
    public void testDropDownCheckboxRadioPageToggleMenuListIsWorking() {
        DropDownCheckboxRadioPage dropDownCheckboxRadioPage = this.homePage.clickDropDownCheckboxRadioPage();
        this.testBasePageToggleMenuListIsWorking(dropDownCheckboxRadioPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testDropDownCheckboxRadioPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        DropDownCheckboxRadioPage dropDownCheckboxRadioPage = this.homePage.clickDropDownCheckboxRadioPage();
        Assert.assertEquals(dropDownCheckboxRadioPage.getMenuTitle(index), expected);
    }

    @Test
    public void testDropDownCheckboxRadioPageTitle() {
        this.homePage.clickDropDownCheckboxRadioPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Dropdown Menus");
    }

    @Test
    public void testDropDownCheckboxRadioPageUrl() {
        this.homePage.clickDropDownCheckboxRadioPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/dropdown.html");
    }

    @Test
    public void testDropDownCheckboxRadioPageContent() {
        DropDownCheckboxRadioPage dropDownCheckboxRadioPage = this.homePage.clickDropDownCheckboxRadioPage();
        this.softAssert.assertEquals(dropDownCheckboxRadioPage.getPageTestTitleText(),
                "Dropdown Menus, Radio Buttons & Checkboxes");
        this.softAssert.assertEquals(dropDownCheckboxRadioPage.getPageTestDescriptionText(), "Use this" +
                " webpage to interact with dropdown menus, radio buttons and checboxes. Try to instruct your" +
                " Selenium tests to interact with these elements.");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testDropDownCheckboxRadioPageVisually() {
        // TODO
    }
}
