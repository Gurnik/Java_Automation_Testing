package test.testng.contact_us;

import org.junit.jupiter.api.Tag;
import org.testng.annotations.Test;
import pages.page_object.ContactUsFormTestPage;
import pages.page_object.SubmittedContactUsFormPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class ContactUsFormTests extends BaseTests {

    @Test
    public void testClickOnContactUsFormTestPageHeader() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        this.testClickOnBasePageHeader(contactUsFormPage);
    }

    @Test
    public void testContactUsFormTestPageMenuSize() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        assertEquals(contactUsFormPage.getMenuSize(), 21);
    }

    @Test
    public void testContactUsFormTestPageToggleMenuListIsWorking() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        this.testBasePageToggleMenuListIsWorking(contactUsFormPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testContactUsFormTestPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();
        assertEquals(contactUsFormPage.getMenuTitle(index), expected);
    }

    @Test
    public void testContactUsFormTestPageTitle() {
        this.homePage.clickContactUsFormTestPage();
        assertEquals(this.getWindowManager().getPageTitle(), "Contact Form");
    }

    @Test
    public void testContactUsFormTestPageUrl() {
        this.homePage.clickContactUsFormTestPage();
        assertEquals(this.getWindowManager().getPageUrl(),
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

        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "");

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, "Tom");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, "Cruise");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, "tom.cruise@gmail.com");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, "I am Tom Cruise!");

        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "Tom");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "Cruise");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "tom.cruise@gmail.com");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "I am Tom Cruise!");

        contactUsFormPage.clickReset();

        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "");
    }

    @Test
    public void testSuccessfulFillContactUsForm() {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, "Tom");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, "Cruise");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, "tom.cruise@gmail.com");
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, "I am Tom Cruise!");

        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.FIRST_NAME),
                "Tom");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.LAST_NAME),
                "Cruise");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS),
                "tom.cruise@gmail.com");
        assertEquals(contactUsFormPage.getText(ContactUsFormTestPage.ContactForm.COMMENTS),
                "I am Tom Cruise!");

        SubmittedContactUsFormPage submittedContactUsFormPage = contactUsFormPage.clickSubmit();
        assertEquals(submittedContactUsFormPage.getSuccessMessageHeader(),
                "Thank you for your mail!");
        assertEquals(submittedContactUsFormPage.getSuccessMessage(),
                "We will be in contact shortly with a response. We aim to reply within 48 hours but our" +
                        " responses can sometimes be delayed during times of peak demand.");

        assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/contact-form-thank-you.html");
    }

    @Tag("Bug")
    @Test(dataProviderClass = ContactUsFormData.class, dataProvider = "checkForWrongFilledContactForm")
    public void testFailedFillContactUsForm(String firstName, String lastName, String email, String comment,
                                            String expectedMessage) {
        ContactUsFormTestPage contactUsFormPage = this.homePage.clickContactUsFormTestPage();

        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.FIRST_NAME, firstName);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.LAST_NAME, lastName);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.EMAIL_ADDRESS, email);
        contactUsFormPage.sendText(ContactUsFormTestPage.ContactForm.COMMENTS, comment);

        SubmittedContactUsFormPage submittedContactUsFormPage = contactUsFormPage.clickSubmit();

        assertEquals(submittedContactUsFormPage.getErrorMessage(),
                expectedMessage);

        assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/contact_us.php");
    }
}
