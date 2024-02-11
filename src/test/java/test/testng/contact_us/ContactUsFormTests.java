package test.testng.contact_us;

import org.junit.jupiter.api.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.ContactUsFormTestPage;
import pages.page_object.SubmittedContactUsFormPage;
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

        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "");

        this.softAssert.assertEquals(contactUsFormPage.getPlaceHolder(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "First Name");
        this.softAssert.assertEquals(contactUsFormPage.getPlaceHolder(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "Last Name");
        this.softAssert.assertEquals(contactUsFormPage.getPlaceHolder(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "Email Address");
        this.softAssert.assertEquals(contactUsFormPage.getPlaceHolder(ContactUsFormTestPage.ContactForm.COMMENTS),
                "Comments");

        this.softAssert.assertEquals(contactUsFormPage.getResetButtonText(), "Reset".toUpperCase());
        this.softAssert.assertEquals(contactUsFormPage.getSubmitButtonText(), "Submit".toUpperCase());
        this.softAssert.assertAll();
    }

    @Test
    public void testContactUsFormTestPageVisually() {
        // TODO
    }

    @Test
    public void testResetButton() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();

        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "");

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, "Tom");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, "Cruise");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, "tom.cruise@gmail.com");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, "I am Tom Cruise!");

        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "Tom");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "Cruise");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "tom.cruise@gmail.com");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "I am Tom Cruise!");

        contactUsFormPage.clickReset();

        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "");
        this.softAssert.assertAll();
    }

    @Test
    public void testSuccessfulFillContactUsForm() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, "Tom");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, "Cruise");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, "tom.cruise@gmail.com");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, "I am Tom Cruise!");

        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "Tom");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "Cruise");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "tom.cruise@gmail.com");
        this.softAssert.assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "I am Tom Cruise!");

        SubmittedContactUsFormPage submittedContactUsFormPage = contactUsFormPage.clickSubmit();
        this.softAssert.assertEquals(submittedContactUsFormPage.getSuccessMessageHeader(),
                "Thank you for your mail!");
        this.softAssert.assertEquals(submittedContactUsFormPage.getSuccessMessage(),
                "We will be in contact shortly with a response. We aim to reply within 48 hours but our" +
                        " responses can sometimes be delayed during times of peak demand.");

        this.softAssert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/contact-form-thank-you.html");

        this.softAssert.assertAll();
    }

    @Tag("Bug")
    @Test(dataProviderClass = ContactUsFormData.class, dataProvider = "checkForWrongFilledContactForm", priority = 1)
    public void testFailedFillContactUsForm(String firstName, String lastName, String email, String comment,
                                            String expectedMessage) {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, firstName);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, lastName);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, email);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, comment);

        SubmittedContactUsFormPage submittedContactUsFormPage = contactUsFormPage.clickSubmit();

        this.softAssert.assertEquals(submittedContactUsFormPage.getErrorMessage(),
                expectedMessage);

        this.softAssert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/contact_us.php");

        if(this.getWindowManager().getPageTitle().equals("https://automationtesting.co.uk/contact_us.php") == false) {
            this.getWindowManager().goBack();
        }

        this.softAssert.assertAll();
    }
}
