package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;
    private static final long WAIT = 10;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        this.navigate = driver.navigate();
    }

    public String getPageTitle() {
        return driver.getTitle().trim();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl().trim();
    }

    public void goBack() {
        this.navigate.back();
    }

    public void goForward() {
        this.navigate.forward();
    }

    public void refreshPage() {
        this.navigate.refresh();
    }

    public void goTo(String url) {
        this.navigate.to(url);
    }
}
