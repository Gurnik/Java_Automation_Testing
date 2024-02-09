package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccordionPage extends BasePage {

    private final By accordionHeaderLocators = By.cssSelector(".accordion-header");
    private final By accordionContentLocators = By.cssSelector(".accordion-content");

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAccordion(int index) {
        int size = this.getWebDriver().findElements(this.accordionHeaderLocators).size();

        if(index >= 0 && index < size) {
            boolean isAccordionSelected = this.isAccordionSelected(index);
            this.getWebDriver().findElements(this.accordionHeaderLocators).get(index).click();
            WebElement element = (this.getWebDriver().findElements(this.accordionContentLocators).get(index));
            if(isAccordionSelected) {
                this.waitForInVisibility(element);
            } else {
                this.waitForVisibility(element);
            }
        }
    }

    public String getAccordionContent(int index) {
        int size = this.getWebDriver().findElements(this.accordionContentLocators).size();

        if(index >= 0 && index < size) {
             if(this.getWebDriver().findElements(this.accordionContentLocators).get(index).isDisplayed()) {
                 return this.getWebDriver().findElements(this.accordionContentLocators).get(index).getText();
             } else {
                 return "";
             }
        }

        return "";
    }

    public boolean isAccordionSelected(int index) {
        int size = this.getWebDriver().findElements(this.accordionHeaderLocators).size();

        if(index >= 0 && index < size) {
            return this.getWebDriver().findElements(this.accordionContentLocators).get(index).isDisplayed();
        }

        return false;
    }
}
