package bindings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Helper {
    static final String url = "http://skryabin.com/webdriver/html/sample.html";

    static final String errorMessage = "This field is required.";
    static final String privacyXpath = "//input[@name='agreedToPrivacyPolicy']";
    static final String nameErrorXpath = "//label[@id='name-error']";
    static final String userNameErrorXpath = "//label[@id='username-error']";
    static final String passwordErrorXpath = "//label[@id='password-error']";
    static final String emailErrorXpath = "//label[@id='email-error']";
    static final String privacyErrorXpath = "//label[@id='agreedToPrivacyPolicy-error']";
    static final String nameXpath = "//input[@name='name']";
    static final String passwordXpath = "//input[@name='password']";
    static final String confirmPasswordXpath = "//input[@name='confirmPassword']";
    static final String usernameXpath = "//input[@name='username']";
    static final String firstNameXpath = "//input[@id='firstName']";
    static final String middleNameXpath = "//input[@id='middleName']";
    static final String lastNameXpath = "//input[@id='lastName']";
    static final String saveButtonXpath = "//*[text()='Save']/..";
    static final String cancelButtonXpath = "//*[text()='Cancel']/..";
    static final String countryOfOriginXpath = "//select[@name='countryOfOrigin']";
    static final String carMakeXpath = "//select[@name='carMake']";
    static final String dateOfBirthXpath = "//input[@id='dateOfBirth']";
    static final String yearXpath = "//select[@class='ui-datepicker-year']";
    static final String monthXpath = "//select[@class='ui-datepicker-month']";
    static final String dayXpath = "//table[@class='ui-datepicker-calendar']";
    static final String selectedDataXpath = "//table[@class='ui-datepicker-calendar']//*[contains(@class,'ui-state-active')]";

    public static void inputValue(WebDriver driver, String path, String text) {
        driver.findElement(By.xpath(path)).sendKeys(text);
    }

    public static void closeElementMenu(WebDriver driver) {
        (new Actions(driver)).moveToElement(driver.findElement(By.xpath("//body"))).click().perform();
    }

    public static int getNumberOfMonth(String month) {
        if ("January".equals(month)) {
            return 0;
        } else if ("February".equals(month)) {
            return 1;
        } else if ("March".equals(month)) {
            return 2;
        } else if ("April".equals(month)) {
            return 3;
        } else if ("May".equals(month)) {
            return 4;
        } else if ("June".equals(month)) {
            return 5;
        } else if ("July".equals(month)) {
            return 6;
        } else if ("August".equals(month)) {
            return 7;
        } else if ("September".equals(month)) {
            return 8;
        } else if ("October".equals(month)) {
            return 9;
        } else if ("November".equals(month)) {
            return 10;
        } else if ("December".equals(month)) {
            return 11;
        }
        return 0;
    }
}
