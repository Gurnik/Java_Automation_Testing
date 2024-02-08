package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utils.PageManager;
import utils.WindowManager;

public abstract class BasePage extends PageManager {

    private final By basePageTestTitle = By.id("content");
    private final By toggleButtonLocator = By.className("toggle");
    private final By homePageLocator = By.linkText("Homepage".toUpperCase());
    private final String homePageUrl = "https://automationtesting.co.uk/index.html";
    private final By accordionPageLocator = By.linkText("Accordion".toUpperCase());
    private final By actionsPageLocator = By.linkText("Actions".toUpperCase());
    private final By browserTabPageLocator = By.linkText("Browser Tabs".toUpperCase());
    private final By buttonsPageLocator = By.linkText("Buttons".toUpperCase());
    private final By calculatorJSPageLocator = By.linkText("Calculator (JS)".toUpperCase());
    private final By contactUsFormPageLocator = By.linkText("Contact Us Form Test".toUpperCase());
    private final By datePickerPageLocator = By.linkText("Date Picker".toUpperCase());
    private final By dropDownCheckboxRadioPageLocator = By.linkText("DropDown Checkbox Radio".toUpperCase());
    private final By fileUploadPageLocator = By.linkText("File Upload".toUpperCase());
    private final By hiddenElementsPageLocator = By.linkText("Hidden Elements".toUpperCase());
    private final By iFramesPageLocator = By.linkText("iFrames".toUpperCase());
    private final By loaderPageLocator = By.linkText("Loader".toUpperCase());
    private final By loaderTwoPageLocator = By.linkText("Loader Two".toUpperCase());
    private final By loginPortalTestPageLocator = By.linkText("Login Portal Test".toUpperCase());
    private final By mouseMovementPageLocator = By.linkText("Mouse Movement".toUpperCase());
    private final By popUpsAndAlertsPageLocator = By.linkText("Pop Ups & Alerts".toUpperCase());
    private final By predictiveSearchPageLocator = By.linkText("Predictive Search".toUpperCase());
    private final By tablesPageLocator = By.linkText("Tables".toUpperCase());
    private final By testStorePageLocator = By.linkText("Test Store".toUpperCase());
    private final By aboutMePageLocator = By.linkText("About Me".toUpperCase());

    private final By menuLocator = By.id("menu");
    private final By menuListLocator = By.cssSelector("#menu li");

    private final By headerLocator = By.cssSelector("#header a");

    private WindowManager windowManager;


    public BasePage(WebDriver driver) {
        super(driver);
        windowManager = new WindowManager(driver);
    }


    public String getPageTestTitleText() {
        return this.getWebElementText(this.basePageTestTitle);
    }

    public String getPageTestDescriptionText() {
        WebElement aboveWebElement = this.getWebElement(this.basePageTestTitle);
        return this.getWebDriver().findElement(RelativeLocator.with(By.tagName("p")).below(aboveWebElement)).getText();
    }

    public void clickToggle() {
        if(this.isMenuTitleVisible() == true) {
            this.click(this.toggleButtonLocator);
            this.waitForInVisibility(this.menuLocator);
        } else {
            this.click(this.toggleButtonLocator);
            this.waitForVisibility(this.menuLocator);
        }
    }

    public int getMenuSize() {
        return this.getElementsSize(this.menuListLocator);
    }

    public boolean isMenuTitleVisible() {
        return this.isElementVisible(this.menuLocator);
    }

    public String getMenuTitle(int index) {
        return this.getWebDriver().findElements(this.menuListLocator).get(index).getText();
    }

    public void clickOnHeaderWithTitleAutomationTestingTestArena() {
        this.click(this.headerLocator);
    }

    public String getHeaderWithTitleAutomationTestingTestArenaText() {
        return this.getWebElementText(this.headerLocator);
    }

    public HomePage clickHomePage() {
        this.scrollToElementAndClick(this.homePageLocator);
        return new HomePage(this.getWebDriver());
    }

    public AccordionPage clickAccordionPage() {
        this.scrollToElementAndClick(this.accordionPageLocator);
        return new AccordionPage(this.getWebDriver());
    }

    public ActionsPage clickActionsPage() {
        this.scrollToElementAndClick(this.actionsPageLocator);
        return new ActionsPage(this.getWebDriver());
    }

    public BrowserTabsPage clickBrowserTabsPage() {
        this.scrollToElementAndClick(this.browserTabPageLocator);
        return new BrowserTabsPage(this.getWebDriver());
    }

    public ButtonsPage clickButtonsPage() {
        this.scrollToElementAndClick(this.buttonsPageLocator);
        return new ButtonsPage(this.getWebDriver());
    }

    public CalculatorJSPage clickCalculatorJSPage() {
        this.scrollToElementAndClick(this.calculatorJSPageLocator);
        return new CalculatorJSPage(this.getWebDriver());
    }

    public ContactUsFormTestPage clickContactUsFormTestPage() {
        this.scrollToElementAndClick(this.contactUsFormPageLocator);
        return new ContactUsFormTestPage(this.getWebDriver());
    }

    public DatePickerPage clickDatePickerPage() {
        this.scrollToElementAndClick(this.datePickerPageLocator);
        return new DatePickerPage(this.getWebDriver());
    }

    public DropDownCheckboxRadioPage clickDropDownCheckboxRadioPage() {
        this.scrollToElementAndClick(this.dropDownCheckboxRadioPageLocator);
        return new DropDownCheckboxRadioPage(this.getWebDriver());
    }

    public FileUploadPage clickFileUploadPage() {
        this.scrollToElementAndClick(this.fileUploadPageLocator);
        return new FileUploadPage(this.getWebDriver());
    }

    public HiddenElementsPage clickHiddenElementsPage() {
        this.scrollToElementAndClick(this.hiddenElementsPageLocator);
        return new HiddenElementsPage(this.getWebDriver());
    }

    public IFramesPage clickIFramesPage() {
        this.scrollToElementAndClick(this.iFramesPageLocator);
        return new IFramesPage(this.getWebDriver());
    }

    public LoaderPage clickLoaderPage() {
        this.scrollToElementAndClick(this.loaderPageLocator);
        return new LoaderPage(this.getWebDriver());
    }

    public LoaderTwoPage clickLoaderTwoPage() {
        this.scrollToElementAndClick(this.loaderTwoPageLocator);
        return new LoaderTwoPage(this.getWebDriver());
    }

    public LoginPortalTestPage clickLoginPortalTestPage() {
        this.scrollToElementAndClick(this.loginPortalTestPageLocator);
        return new LoginPortalTestPage(this.getWebDriver());
    }

    public MouseMovementPage clickMouseMovementPage() {
        this.scrollToElementAndClick(this.mouseMovementPageLocator);
        return new MouseMovementPage(this.getWebDriver());
    }

    public PopUpsAndAlertsPage clickPopUpsAndAlertsPage() {
        this.scrollToElementAndClick(this.popUpsAndAlertsPageLocator);
        return new PopUpsAndAlertsPage(this.getWebDriver());
    }

    public PredictiveSearchPage clickPredictiveSearchPage() {
        this.scrollToElementAndClick(this.predictiveSearchPageLocator);
        return new PredictiveSearchPage(this.getWebDriver());
    }

    public TablesPage clickTablesPage() {
        this.scrollToElementAndClick(this.tablesPageLocator);
        return new TablesPage(this.getWebDriver());
    }

    public TestStorePage clickTestStorePage() {
        this.scrollToElementAndClick(this.testStorePageLocator);
        return new TestStorePage(this.getWebDriver());
    }

    public AboutMePage clickAboutMePage() {
        this.scrollToElementAndClick(this.aboutMePageLocator);
        return new AboutMePage(this.getWebDriver());
    }
}
