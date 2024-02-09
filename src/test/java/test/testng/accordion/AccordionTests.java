package test.testng.accordion;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.AccordionPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class AccordionTests extends BaseTests {
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
    public void testSelectAndDisSelectAccordions() throws InterruptedException {
        AccordionPage accordionPage = this.homePage.clickAccordionPage();
        Assert.assertFalse(accordionPage.isAccordionSelected(0));
        accordionPage.clickOnAccordion(0);
        Assert.assertTrue(accordionPage.isAccordionSelected(0));
        Assert.assertFalse(accordionPage.isAccordionSelected(1));
        Assert.assertFalse(accordionPage.isAccordionSelected(2));
        Assert.assertEquals(accordionPage.getAccordionContent(0),
                "Testing is a repetitive process. The slightest modification in code must be tested to" +
                        " ensure that the software is providing the desired functionality and result. Repeating" +
                        " tests manually is a time consuming and costly process. Automated tests can be run" +
                        " repetitively at no additional costs. Selenium is a highly portable tool that runs on" +
                        " multiple platforms as well as browsers. It therefore allows automation engineers the" +
                        " ease of writing code without worrying about the platform on which it will run.");
        accordionPage.clickOnAccordion(0);
        Thread.sleep(1000);
        Assert.assertFalse(accordionPage.isAccordionSelected(0));
        //-------------------------------------------------------------------------------------
        Assert.assertFalse(accordionPage.isAccordionSelected(0));
        Assert.assertFalse(accordionPage.isAccordionSelected(1));
        accordionPage.clickOnAccordion(1);
        Assert.assertTrue(accordionPage.isAccordionSelected(1));
        Assert.assertFalse(accordionPage.isAccordionSelected(2));
        Assert.assertEquals(accordionPage.getAccordionContent(1),
                "Software is written in a number of languages. One of the challenges faced by automated" +
                        " testers is integrating the automation tools with the development environment for CI. With" +
                        " Selenium bindings for Java, .NET, Ruby, Perl, Python, PHP, Groovy and JavaScript, it is" +
                        " very easy to integrate with the development environment.");
        accordionPage.clickOnAccordion(1);
        Thread.sleep(1000);
        Assert.assertFalse(accordionPage.isAccordionSelected(1));
        //-------------------------------------------------------------------------------------
        Assert.assertFalse(accordionPage.isAccordionSelected(0));
        Assert.assertFalse(accordionPage.isAccordionSelected(1));
        Assert.assertFalse(accordionPage.isAccordionSelected(2));
        accordionPage.clickOnAccordion(2);
        Assert.assertTrue(accordionPage.isAccordionSelected(2));
        Assert.assertEquals(accordionPage.getAccordionContent(2),
                "The remote control server of Selenium allows automation testers to create a test" +
                        " infrastructure that is spread across multiple locations (including cloud) to drive" +
                        " the scripts on a large set of browsers.");
        accordionPage.clickOnAccordion(2);
        Thread.sleep(1000);
        Assert.assertFalse(accordionPage.isAccordionSelected(2));
        //--------------------------------------------------------------------------------------
    }
}
