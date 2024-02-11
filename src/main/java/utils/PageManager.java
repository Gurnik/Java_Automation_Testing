package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class PageManager {

    // TODO - Make Webdriver driver as Singleton

    private WebDriver driver;

    private static final long WAIT = 10;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getWebDriver() {
        return this.driver;
    }
    protected WebElement getWebElement(By by) {
        return this.driver.findElement(by);
    }

    protected List<WebElement> getWebElements(By by) {
        return this.driver.findElements(by);
    }

    protected int getElementsSize(By by) {
        return this.driver.findElements(by).size();
    }

    // Used when applying Page Factory
    protected void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Used when applying Page Object
    protected void waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(this.getWebElement(by)));
    }

    // Used when applying Page Factory
    protected void waitForInVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Used when applying Page Object
    protected void waitForInVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.invisibilityOf(this.getWebElement(by)));
    }

    // Used when applying Page Factory
    protected void click(WebElement element) {
        this.waitForVisibility(element);
        element.click();
    }

    // Used when applying Page Object
    protected void click(By by) {
        this.waitForVisibility(by);
        this.getWebElement(by).click();
    }

    protected void clickJS(WebElement element) {
        this.waitForVisibility(element);
        JavascriptExecutor executor = (JavascriptExecutor)this.driver;
        executor.executeScript("arguments[0].click();", element);
    }
    protected void clickJS(By by) {
        this.waitForVisibility(by);
        WebElement element = this.getWebElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)this.driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void scrollToElementAndClick(WebElement element) {
        this.scrollToElement(element);
        this.click(element);
    }

    protected void scrollToElementAndClick(By by) {
        this.scrollToElement(by);
        this.click(by);
    }

    protected void scrollToElement(WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)this.driver).executeScript(script, element);
    }

    protected void scrollToElement(By by){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)this.driver).executeScript(script, this.getWebElement(by));
    }

    protected String getWebElementText(WebElement element) {
        this.waitForVisibility(element);
        return element.getText();
    }

    protected String getWebElementText(By by) {
        this.waitForVisibility(by);
        return getWebElement(by).getText();
    }

    protected String getWebElementAttributeValue(WebElement element, String attribute) {
        this.waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    protected String getWebElementAttributeValue(By by, String attribute) {
        this.waitForVisibility(this.getWebElement(by));
        return this.getWebElement(by).getAttribute(attribute);
    }

    protected void sendText(WebElement element, String text) {
        this.scrollToElement(element);
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    protected void sendText(By by, String text) {
        this.scrollToElement(by);
        this.waitForVisibility(by);
        this.getWebElement(by).sendKeys(text);
    }

    protected boolean isEnabled(By by) {
        this.waitForVisibility(by);
        return this.getWebElement(by).isEnabled();
    }

    protected boolean isEnabled(WebElement element) {
        this.waitForVisibility(element);
        return element.isEnabled();
    }

    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    protected boolean isElementVisible(By by) {
        return this.getWebElement(by).isDisplayed();
    }
}
