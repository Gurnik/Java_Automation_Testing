package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class BrowserTabsPage extends BasePage {

    private final By contentLocator = By.id("content");
    private final By openNewTabUsingButtonBelowLocator = By.xpath("//div[@class='row']//p");

    public BrowserTabsPage(WebDriver driver) {
        super(driver);
    }

    public String getOpenNewTabUsingButtonBelowTitleText() {
        return this.getWebDriver().findElement(RelativeLocator.with(By.tagName("h3"))
                .below(this.contentLocator)).getText();
    }

    public String getOpenNewTabUsingButtonBelowDescriptionText() {
       // return this.getWebElementText(this.openNewTabUsingButtonBelowLocator);
        WebElement upperElement = this.getWebDriver().findElement(RelativeLocator.with(By.tagName("h3"))
                .below(this.contentLocator));
        return this.getWebDriver().findElement(RelativeLocator.with(By.tagName("p"))
                .below(upperElement)).getText();
    }

    public String getOpenTabButtonText() {
        WebElement upperElement = this.getWebDriver().findElement(RelativeLocator.with(By.tagName("h3"))
                .below(this.contentLocator));
        return this.getWebDriver().findElement(RelativeLocator.with(By.tagName("input"))
                .below(upperElement)).getAttribute("value");
    }

    public void clickOpenTabButton() {
        this.click(this.getWebDriver().findElement(RelativeLocator.with(By.tagName("input"))
                .below(this.contentLocator)));
    }
}
