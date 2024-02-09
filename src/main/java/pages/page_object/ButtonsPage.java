package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {

    private final int MIN_TEST_LINE_INDEX = 0;
    private final int MAX_TEST_LINE_INDEX = 1;

    private final By header3TestLocators = By.xpath("//div[@class='row']//div/h3");
    private final By divWithClassEqualsRowLocators = By.className("row");

    private final String BAD_INPUT = "BAD INPUT";

    private final By buttonOneLocator = By.xpath("//button[@id='btn_one']");
    private final By buttonTwoLocator = By.cssSelector("button#btn_two");
    private final By buttonThreeLocator = By.id("btn_three");
    private final By buttonFourLocator = By.xpath("//div[@class='row'][2]//button");
    // private final By buttonFourLocator = By.xpath(".//button[text()=='Button Four'");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public int getHeader3TitleSize() {
        return this.getWebElements(this.header3TestLocators).size();
    }

    public String getButtonsPageContentText(int lineIndex) {
        if(lineIndex < this.MIN_TEST_LINE_INDEX || lineIndex > this.MAX_TEST_LINE_INDEX) {
            return this.BAD_INPUT;
        }

        return this.getWebElements(this.divWithClassEqualsRowLocators).get(lineIndex).getText();
    }

    public void clickOnButtonNumber(int number) {
        switch (number) {
            case 1:
                this.click(this.buttonOneLocator);
                break;
            case 2:
                this.clickJS(this.buttonTwoLocator);
                break;
            case 3:
                Actions actions = new Actions(this.getWebDriver());
                actions.moveToElement(this.getWebElement(this.buttonThreeLocator)).click().perform();
                break;
            case 4:
                this.click(this.buttonFourLocator);
                break;
        }
    }

    public boolean isButtonEnabled(int number) {
        switch (number) {
            case 1:
                return this.isEnabled(this.buttonOneLocator);
            case 2:
                return this.isEnabled(this.buttonTwoLocator);
            case 3:
                return this.isEnabled(this.buttonThreeLocator);
            case 4:
                return this.isEnabled(this.buttonFourLocator);
        }

        return false;
    }

    public String getAlertText() {
        return this.getWebDriver().switchTo().alert().getText();
    }

    public void acceptAlert() {
        this.getWebDriver().switchTo().alert().accept();
    }

    public void enableButtonFour() {
        JavascriptExecutor js = (JavascriptExecutor)this.getWebDriver();
        js.executeScript("document.getElementById('btn_four').disabled=false;");
    }

    public void disableButtonFour() {
        JavascriptExecutor js = (JavascriptExecutor)this.getWebDriver();
        js.executeScript("document.getElementById('btn_four').disabled=true;");
    }
}
