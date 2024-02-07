package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class PopUpsAndAlertsPage extends BasePage {

    private final By headerLocator = By.id("header");
    public PopUpsAndAlertsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTestTitleText() {
        WebElement element = this.getWebDriver().findElement(RelativeLocator.with(By.tagName("h2"))
                .near(this.getWebElement(this.headerLocator)));
        return this.getWebElementText(element);
    }
}
