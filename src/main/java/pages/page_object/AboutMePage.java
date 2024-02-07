package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AboutMePage extends BasePage {

    private final By contentLocator = By.className("content");

    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTestTitleText() {
        WebElement element = this.getWebDriver().findElement(RelativeLocator.with(By.tagName("h2"))
                .below(this.getWebElement(this.contentLocator)));
        return this.getWebElementText(element);
    }
}
