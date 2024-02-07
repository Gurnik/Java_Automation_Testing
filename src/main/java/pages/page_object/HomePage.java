package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final By homePageTestTitleLocator = By.cssSelector(".content h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTestTitleText() {
        return this.getWebElementText(this.homePageTestTitleLocator);
    }
}
