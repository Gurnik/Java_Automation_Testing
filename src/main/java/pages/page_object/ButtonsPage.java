package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
                this.click(this.buttonTwoLocator);
                break;
            case 3:
                this.click(this.buttonThreeLocator);
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
}
