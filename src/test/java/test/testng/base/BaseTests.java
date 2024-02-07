package test.testng.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import pages.page_object.BasePage;
import pages.page_object.HomePage;
import utils.WindowManager;

public class BaseTests {

    private WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome() {
        this.driver.get("https://automationtesting.co.uk/index.html");
        this.homePage = new HomePage(this.driver);
    }


    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(this.driver);
    }

    protected void testClickOnBasePageHeader(BasePage basePage) {
        this.softAssert.assertEquals(basePage.getHeaderWithTitleAutomationTestingTestArenaText(),
                "Automation Testing Test Arena");
        basePage.clickOnHeaderWithTitleAutomationTestingTestArena();
        this.softAssert.assertEquals(getWindowManager().getPageTitle(), "Homepage");
        this.softAssert.assertEquals(getWindowManager().getPageUrl(),
                "https://automationtesting.co.uk/index.html");
        this.softAssert.assertAll();
    }

    protected void testBasePageToggleMenuListIsWorking(BasePage basePage) {
        softAssert.assertEquals(basePage.isMenuTitleVisible(), true);
        homePage.clickToggle();
        softAssert.assertEquals(basePage.isMenuTitleVisible(), false);
        homePage.clickToggle();
        softAssert.assertEquals(basePage.isMenuTitleVisible(), true);
        softAssert.assertAll();
    }

}
