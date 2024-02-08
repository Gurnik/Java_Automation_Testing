package test.testng.home;

import org.testng.annotations.DataProvider;

public class HomeData {

    @DataProvider(name = "goToWebsite")
    public static Object[][] goToWebsite() {
        Object[][] data = new Object[8][2];
        //
        data[0][0] = "webdriveruniversity.com";
        data[0][1] = "https://webdriveruniversity.com/";
        //
        data[1][0] = "Selenium Webdriver & Java";
        data[1][1] = "https://www.udemy.com/course/selenium-webdriver-java-using-real-examples/" +
                "?couponCode=18A0F1CBC18809BFA84C";
        //
        data[2][0] = "Cucumber BDD with Selenium & Java";
        data[2][1] = "https://www.udemy.com/course/selenium-webdriver-java-using-real-examples/" +
                "?couponCode=18A0F1CBC18809BFA84C";
        //
        data[3][0] = "Cypress.io 10 using Javascript";
        data[3][1] = "https://www.udemy.com/course/cypress-io-master-class/?couponCode=718B90C762791AA2595C";
        //
        data[4][0] = "Webdriver IO using Javascript";
        data[4][1] = "https://www.udemy.com/course/automation-testing-javascript-webdriverio-selenium-more/" +
                "?couponCode=C7B01D0D3A49F832C40F";
        //
        data[5][0] = "Mastering Selectors/Locators";
        data[5][1] = "https://www.udemy.com/course/mastering-locators/?couponCode=449EE5EA4094E6D7A41B";
        //
        data[6][0] = "Selenium Webdriver 4 - New Features";
        data[6][1] = "https://www.udemy.com/course/selenium-webdriver-4-new-features-in-detail/" +
                "?couponCode=9E6A662A70FD0BA5DE0F";
        //
        data[7][0] = "Intro to Cucumber BDD, Selenium & Java (Free - 2.5hrs)";
        data[7][1] = "https://www.udemy.com/course/cucumber-selenium-java-develop-a-framework-in-25-hours/";
        //
        return data;
    }

    @DataProvider(name = "goToWebsiteWithoutCAPTCHA")
    public static Object[][] goToWebsiteWithoutCAPTCHA() {
        Object[][] data = new Object[1][2];
        //
        data[0][0] = "webdriveruniversity.com";
        data[0][1] = "https://webdriveruniversity.com/";
        //
        return data;
    }
}
