package test.testng.accordion;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.AccordionPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class AccordionTests extends BaseTests {

    // TODO - Manage initialization of this.accordionPage to be initialized at setup only once
    /*
    @BeforeClass
    public void setUp() {
       //  this.accordionPage = this.homePage.clickAccordionPage();
    }

    @AfterClass
    public void tearDown() {

    }
    */

    @Test
    public void testClickOnAccordionPageHeader() {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        this.testClickOnBasePageHeader(accordionPage);
    }

    @Test
    public void testAccordionPageMenuSize() {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        Assert.assertEquals(accordionPage.getMenuSize(), 21);
    }

    @Test
    public void testAccordionPageToggleMenuListIsWorking() {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        this.testBasePageToggleMenuListIsWorking(accordionPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testAccordionPageMenuTitlesAreCorrectAndOrdered(String expected, int index) {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        Assert.assertEquals(accordionPage.getMenuTitle(index), expected);
    }

    @Test
    public void testAccordionPageTitle() {
        this.homePage.clickAccordionPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Accordion");
    }

    @Test
    public void testAccordionPageUrl() {
        this.homePage.clickAccordionPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/accordion.html");
    }

    @Test
    public void testAccordionPageContent() {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        this.softAssert.assertEquals(accordionPage.getPageTestTitleText(), "Accordion Test");
        this.softAssert.assertEquals(accordionPage.getPageTestDescriptionText(),
                "Use this accordion test page to practise interacting with accordions.");
        this.softAssert.assertAll();
    }

    @Test
    public void testAccordionPageVisually() {
        // TODO
    }

    @Test
    public void testNoAccordionIsSelected() {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(0), false);
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(1), false);
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(2), false);
        this.softAssert.assertAll();
    }

    @Test
    public void testSelectFirstAccordion() throws InterruptedException {
        // TODO
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(0), false);
        accordionPage.clickOnAccordion(0);
        Thread.sleep(1000);
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(0), true);
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(1), false);
        this.softAssert.assertEquals(accordionPage.isAccordionSelected(2), false);
        this.softAssert.assertAll();
    }
}
