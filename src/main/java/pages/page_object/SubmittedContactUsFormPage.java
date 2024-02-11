package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmittedContactUsFormPage extends BasePage {

    private By errorMessageLocator = By.tagName("body");
    private By successMessageHeaderLocator = By.tagName("h3");
    private By successMessageLocator = By.tagName("p");

    public SubmittedContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage() {
        return this.getWebElementText(this.errorMessageLocator);
    }

    public String getSuccessMessageHeader() {
        return this.getWebElementText(this.successMessageHeaderLocator);
    }

    public String getSuccessMessage() {
        return this.getWebElementText(this.successMessageLocator);
    }
}
