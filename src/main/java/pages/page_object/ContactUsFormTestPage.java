package pages.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsFormTestPage extends BasePage {

    private By firstNameLocator = By.name("first_name");
    private By lastNameLocator = By.name("last_name");
    private By emailLocator = By.name("email");
    private By messageLocator = By.name("message");
    private By resetButtonLocator = By.xpath("//div[@id='form_buttons']/input[1]");
    private By submitButtonLocator = By.cssSelector("div#form_buttons input:nth-child(2)");

    public ContactUsFormTestPage(WebDriver driver) {
        super(driver);
    }

    public String getPlaceHolder(ContactForm contactForm) {
        switch (contactForm) {
            case FIRST_NAME:
                return this.getWebElementAttributeValue(this.firstNameLocator, "placeholder");
            case LAST_NAME:
                return this.getWebElementAttributeValue(this.lastNameLocator, "placeholder");
            case EMAIL_ADDRESS:
                return this.getWebElementAttributeValue(this.emailLocator, "placeholder");
            case COMMENTS:
                return this.getWebElementAttributeValue(this.messageLocator, "placeholder");
            default:
                return "";
        }
    }

    public void sendText(ContactForm contactForm, String text) {
        switch (contactForm) {
            case FIRST_NAME:
                this.sendText(this.firstNameLocator, text);
                return;
            case LAST_NAME:
                this.sendText(this.lastNameLocator, text);
                return;
            case EMAIL_ADDRESS:
                this.sendText(this.emailLocator, text);
                return;
            case COMMENTS:
                this.sendText(this.messageLocator, text);
                return;
        }
    }

    public String getText(ContactForm contactForm) {
        switch (contactForm) {
            case FIRST_NAME:
                return this.getWebElementAttributeValue(this.firstNameLocator, "value");
            case LAST_NAME:
                return this.getWebElementAttributeValue(this.lastNameLocator, "value");
            case EMAIL_ADDRESS:
                return this.getWebElementAttributeValue(this.emailLocator, "value");
            case COMMENTS:
                return this.getWebElementAttributeValue(this.messageLocator, "value");
            default:
                return "";
        }
    }

    public void clickReset() {
        this.click(this.resetButtonLocator);
    }

    public SubmittedContactUsFormPage clickSubmit() {
        this.click(this.submitButtonLocator);
        return new SubmittedContactUsFormPage(this.getWebDriver());
    }

    public String getResetButtonText() {
        return this.getWebElementAttributeValue(this.resetButtonLocator, "value");
    }

    public String getSubmitButtonText() {
        return this.getWebElementAttributeValue(this.submitButtonLocator, "value");
    }

    public enum ContactForm {
        FIRST_NAME,
        LAST_NAME,
        EMAIL_ADDRESS,
        COMMENTS
    }
}
