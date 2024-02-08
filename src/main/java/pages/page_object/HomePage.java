package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage extends BasePage{

    private final By homePageTestTitleLocator = By.cssSelector(".content h1");
    private final By homePageTestDescriptionLocator = By.cssSelector(".content p");
    private final By homePageDiscountLocator = By.cssSelector(".content header h3");
    private final By webDriverUniversityLocator = By.linkText("webdriveruniversity.com");
    private final By seleniumWebDriverAndJavaLocator = By.linkText("Selenium Webdriver & Java");
    private final By cucumberBddWithSeleniumAndJavaLocator = By.linkText("Cucumber BDD with Selenium & Java");
    private final By cypressIo10UsingJavaScriptLocator = By.linkText("Cypress.io 10 using Javascript");
    private final By webDriverIoUsingJavaScriptLocator = By.linkText("Webdriver IO using Javascript");
    private final By masteringSelectorsOrLocatorsLocator = By.linkText("Mastering Selectors/Locators");
    private final By seleniumWebDriver4NewFeaturesLocator = By.linkText("Selenium Webdriver 4 - New Features");
    private final By introToCucumberBddSeleniumAndJavaLocator =
            By.linkText("Intro to Cucumber BDD, Selenium & Java (Free - 2.5hrs)");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTestTitleText() {
        return this.getWebElementText(this.homePageTestTitleLocator);
    }

    @Override
    public String getPageTestDescriptionText() { return this.getWebElementText(this.homePageTestDescriptionLocator); }

    public String getCheckOutSisterSiteText() {
        return this.getWebDriver().findElement(RelativeLocator.with(By.tagName("p"))
                .below(this.homePageTestDescriptionLocator)).getText();
    }

    public String getDiscountText() {
        return this.getWebElementText(this.homePageDiscountLocator);
    }

    public void clickLink(String text) {
        switch (text) {
            case "webdriveruniversity.com":
                this.click(this.webDriverUniversityLocator);
                break;
            case "Selenium Webdriver & Java":
                this.click(this.seleniumWebDriverAndJavaLocator);
                break;
            case "Cucumber BDD with Selenium & Java":
                this.click(this.cucumberBddWithSeleniumAndJavaLocator);
                break;
            case "Cypress.io 10 using Javascript":
                this.click(this.cypressIo10UsingJavaScriptLocator);
                break;
            case "Webdriver IO using Javascript":
                this.click(this.webDriverIoUsingJavaScriptLocator);
                break;
            case "Mastering Selectors/Locators":
                this.click(this.masteringSelectorsOrLocatorsLocator);
                break;
            case "Selenium Webdriver 4 - New Features":
                this.click(this.seleniumWebDriver4NewFeaturesLocator);
                break;
            case "Intro to Cucumber BDD, Selenium & Java (Free - 2.5hrs)":
                this.click(this.introToCucumberBddSeleniumAndJavaLocator);
                break;
        }
    }
}
