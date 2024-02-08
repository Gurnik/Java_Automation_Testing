package test.testng.contact_us;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.ContactUsFormTestPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class ContactUsFormTests extends BaseTests {

    @Test
    public void testClickOnContactUsFormTestPageHeader() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        this.testClickOnBasePageHeader(contactUsFormPage);
    }

    @Test
    public void testContactUsFormTestPageMenuSize() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        Assert.assertEquals(contactUsFormPage.getMenuSize(), 21);
    }

    @Test
    public void testContactUsFormTestPageToggleMenuListIsWorking() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        this.testBasePageToggleMenuListIsWorking(contactUsFormPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testContactUsFormTestPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        Assert.assertEquals(contactUsFormPage.getMenuTitle(index), expected);
    }

    @Test
    public void testContactUsFormTestPageTitle() {
        this.homePage.clickContactUsFormTestPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Contact Form");
    }

    @Test
    public void testContactUsFormTestPageUrl() {
        this.homePage.clickContactUsFormTestPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/contactForm.html");
    }

    @Test
    public void testContactUsFormTestPageContent() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        this.softAssert.assertEquals(contactUsFormPage.getPageTestTitleText(), "Contact Form Test");
        this.softAssert.assertEquals(contactUsFormPage.getPageTestDescriptionText(), "Use this contact us" +
                " form to practise form input combinations (all fields are mandatory):");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testContactUsFormTestPageVisually() {
        // TODO
    }
}
