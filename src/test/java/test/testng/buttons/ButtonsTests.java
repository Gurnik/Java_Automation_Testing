package test.testng.buttons;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.page_object.ButtonsPage;
import test.testng.base.BaseData;
import test.testng.base.BaseTests;

public class ButtonsTests extends BaseTests {

    @Test
    public void testClickOnButtonsPageHeader() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();

        this.testClickOnBasePageHeader(buttonsPage);
    }

    @Test
    public void testButtonsPageMenuSize() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        Assert.assertEquals(buttonsPage.getMenuSize(), 21);
    }

    @Test
    public void testButtonsPageToggleMenuListIsWorking() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        this.testBasePageToggleMenuListIsWorking(buttonsPage);
    }

    @Test(dataProviderClass = BaseData.class, dataProvider = "provideMenuListTitles")
    public void testButtonsPageMenuTitlesAreCorrectAndOrdered(String expected, int index) {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        Assert.assertEquals(buttonsPage.getMenuTitle(index), expected);
    }

    @Test
    public void testButtonsPageTitle() {
        this.homePage.clickButtonsPage();
        Assert.assertEquals(this.getWindowManager().getPageTitle(), "Buttons");
    }

    @Test
    public void testButtonsPageUrl() {
        this.homePage.clickButtonsPage();
        Assert.assertEquals(this.getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/buttons.html");
    }

    @Test
    public void testButtonPageContent() {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        this.softAssert.assertEquals(buttonsPage.getPageTestTitleText(), "Testing Buttons");
        this.softAssert.assertEquals(buttonsPage.getPageTestDescriptionText(), "Attempt to click the buttons" +
                " using the instructions for each button below. There are various ways you can click buttons.");
        this.softAssert.assertEquals(buttonsPage.getHeader3TitleSize(), 4);

        this.softAssert.assertEquals(buttonsPage.getButtonsPageContentText(0), "WebElement.click()\n" +
                "Try interacting with the button below\n" +
                "Use an XPATH locator\n" +
                "Try method: click()\n" +
                "\n" +
                "BUTTON ONE\n" +
                "JavaScript click\n" +
                "Try interacting with the button below\n" +
                "Use a CSS locator\n" +
                "Try method: JavaScript click\n" +
                "\n" +
                "BUTTON TWO\n" +
                "Action Move & Click\n" +
                "Try interacting with the button below\n" +
                "Use a locator of your choice\n" +
                "Try method: Action Move & Click\n" +
                "\n" +
                "BUTTON THREE");
        this.softAssert.assertEquals(buttonsPage.getButtonsPageContentText(1), "Disabled Button\n" +
                "Try interacting with the button below\n" +
                "Use a locator of your choice\n" +
                "Try method: isEnabled()\n" +
                "\n" +
                "BUTTON FOUR");

        this.softAssert.assertAll();
    }

    @Test
    public void testButtonsPageVisually() {
        // TODO
    }

    @Test(dataProviderClass = ButtonsData.class, dataProvider = "checkButtonEnabled")
    public void testButtonIsEnabled(int buttonNumber, boolean expectedButtonStatus) {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        if(expectedButtonStatus == true) {
            Assert.assertTrue(buttonsPage.isButtonEnabled(buttonNumber),
                    "Button " + buttonNumber + " is not enabled");
        } else {
            Assert.assertFalse(buttonsPage.isButtonEnabled(buttonNumber),
                    "Button " + buttonNumber + " is enabled");
        }

    }

    @Test(dataProviderClass = ButtonsData.class, dataProvider = "checkButtonClick")
    public void testClickingOnButton(int number, boolean isButtonEnabled, String alertMessage) {
        ButtonsPage buttonsPage = this.homePage.clickButtonsPage();
        if(isButtonEnabled) {
            Assert.assertTrue(buttonsPage.isButtonEnabled(number));
            buttonsPage.clickOnButtonNumber(number);
            Assert.assertEquals(buttonsPage.getAlertText(), alertMessage);
            buttonsPage.acceptAlert();
        } else {
            Assert.assertFalse(buttonsPage.isButtonEnabled(number));
            buttonsPage.enableButtonFour();
            Assert.assertTrue(buttonsPage.isButtonEnabled(number));
            buttonsPage.clickOnButtonNumber(number);
            Assert.assertEquals(buttonsPage.getAlertText(), alertMessage);
            buttonsPage.acceptAlert();
            buttonsPage.disableButtonFour();
            Assert.assertFalse(buttonsPage.isButtonEnabled(number));
        }
    }
}
