package test.testng.file_upload;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.FileUploadPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class FileUploadTests extends BaseTests {

    @Test
    public void testClickOnFileUploadPageHeader() {
        FileUploadPage fileUploadPage = this.homePage.clickFileUploadPage();
        this.testClickOnBasePageHeader(fileUploadPage);
    }

    @Test
    public void testFileUploadPageMenuSize() {
        FileUploadPage fileUploadPage = this.homePage.clickFileUploadPage();
        Assert.assertEquals(fileUploadPage.getMenuSize(), 21);
    }

    @Test
    public void testFileUploadPageToggleMenuListIsWorking() {
        FileUploadPage fileUploadPage = this.homePage.clickFileUploadPage();
        this.testBasePageToggleMenuListIsWorking(fileUploadPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testFileUploadPageMenuTitlesAreCorrectAndOrderedAlphabetically(String expected, int index) {
        FileUploadPage fileUploadPage = this.homePage.clickFileUploadPage();
        Assert.assertEquals(fileUploadPage.getMenuTitle(index), expected);
    }

    @Test
    public void testFileUploadPageTitle() {
        this.homePage.clickFileUploadPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "File Upload");
    }

    @Test
    public void testFileUploadPageUrl() {
        this.homePage.clickFileUploadPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/fileupload.html");
    }

    @Test
    public void testFileUploadPageContent() {
        FileUploadPage fileUploadPage = this.homePage.clickFileUploadPage();
        this.softAssert.assertEquals(fileUploadPage.getPageTestTitleText(),
                "File Upload");
        // TODO - Continue to add rest of content tests
        this.softAssert.assertAll();
    }

    @Test
    public void testFileUploadPageVisually() {
        // TODO
    }
}
