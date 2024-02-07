package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutMePage extends BasePage {

    private final By aboutMePageTestTitleLocator = By.cssSelector(".content h2");

    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTestTitleText() {
        return this.getWebElementText(this.aboutMePageTestTitleLocator);
    }
}
