package bindings;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {
    private WebDriver driver;

    @Before
    public void beforeScenario()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {
        driver.close();
    }

    @Given("^I open sample page$")
    public void openSamplePage() {
        driver.get(Helper.url);
    }

    @When("^I click the submit button$")
    public void clickTheSubmitButton() {
        driver.findElement(By.id("formSubmit")).click();
    }

    @Then("^username error message should be presented$")
    public void usernameErrorMessageShouldBePresented() {
        WebElement error = driver.findElement(By.xpath(Helper.userNameErrorXpath));
        Assert.assertTrue(error.isDisplayed());
        Assertions.assertThat(error.getText()).isEqualTo(Helper.errorMessage);
    }

    @Then("^name error message should be presented$")
    public void nameErrorMessageShouldBePresented() {
        WebElement error = driver.findElement(By.xpath(Helper.nameErrorXpath));
        Assert.assertTrue(error.isDisplayed());
        Assertions.assertThat(error.getText()).isEqualTo(Helper.errorMessage);
    }

    @Then("^password error message should be presented$")
    public void passwordErrorMessageShouldBePresented() {
        WebElement error = driver.findElement(By.xpath(Helper.passwordErrorXpath));
        Assert.assertTrue(error.isDisplayed());
        Assertions.assertThat(error.getText()).isEqualTo(Helper.errorMessage);
    }

    @Then("^email error message should be presented$")
    public void emailErrorMessageShouldBePresented() {
        WebElement error = driver.findElement(By.xpath(Helper.emailErrorXpath));
        Assert.assertTrue(error.isDisplayed());
        Assertions.assertThat(error.getText()).isEqualTo(Helper.errorMessage);
    }

    @Then("^privacy error message should be presented$")
    public void privacyErrorMessageShouldBePresented() {
        WebElement error = driver.findElement(By.xpath(Helper.privacyErrorXpath));
        Assert.assertTrue(error.isDisplayed());
        Assertions.assertThat(error.getText()).contains("Must check");
    }

    @When("^I click accept privacy policy$")
    public void clickAcceptPrivacyPolicy() {
        driver.findElement(By.xpath(Helper.privacyXpath)).click();
    }

    @Then("^accept privacy policy is checked$")
    public void acceptPrivacyPolicyIsChecked() {
        Assert.assertTrue(driver.findElement(By.xpath(Helper.privacyXpath)).isSelected());
    }

    @When("^I click on username field$")
    public void iClickOnUsernameField() {
        WebElement element = driver.findElement(By.xpath(Helper.usernameXpath));
        new Actions(driver).moveToElement(element).click().perform();
    }

    @Then("^username element should be presented$")
    public void usernameElementShouldBePresented() {
        Assert.assertEquals(driver.findElement(By.xpath(Helper.usernameXpath)), driver.switchTo().activeElement());
    }

    @When("^I type \"([^\"]*)\" to username$")
    public void iTypeToUsername(String name) {
        Helper.inputValue(driver, Helper.usernameXpath, name);
    }

    @When("^I click on name field$")
    public void iClickOnNameField() {
        driver.findElement(By.xpath(Helper.nameXpath)).click();
    }

    @When("^I type first name \"([^\"]*)\"$")
    public void iTypeFirstName(String name) {
        Helper.inputValue(driver, Helper.firstNameXpath, name);
    }

    @When("^I type middle name \"([^\"]*)\"$")
    public void iTypeMiddleName(String name) {
        Helper.inputValue(driver, Helper.middleNameXpath, name);
    }

    @When("^I type last name \"([^\"]*)\"$")
    public void iTypeLastName(String name) {
        Helper.inputValue(driver, Helper.lastNameXpath, name);
    }

    @When("^I click the save button$")
    public void iClickTheSaveButton() {
        driver.findElement(By.xpath(Helper.saveButtonXpath)).click();
    }

    @Then("^name field should contain text \"([^\"]*)\"$")
    public void nameFieldShouldContainText(String name) {
        Assertions.assertThat(driver.findElement(By.xpath(Helper.nameXpath)).getAttribute("value")).isEqualTo(name);
    }

    @When("^I click on country of origin field$")
    public void iClickOnCountryOfOriginField() {
        driver.findElement(By.xpath(Helper.countryOfOriginXpath)).click();
        Helper.closeElementMenu(driver);
    }

    @When("^I choose \"([^\"]*)\" option$")
    public void iChooseOption(String name) {
        String path = String.format("%1$s/option[@value='%2$s']", Helper.countryOfOriginXpath, name);
        driver.findElement(By.xpath(path)).click();
    }

    @Then("^country of origin field contain text \"([^\"]*)\"$")
    public void countryOfOriginFieldContainText(String region) {
        WebElement selectElement = driver.findElement(By.xpath(Helper.countryOfOriginXpath));
        Select select = new Select(selectElement);
        WebElement optionElement = select.getFirstSelectedOption();
        Assertions.assertThat(optionElement.getText()).isEqualTo(region);
    }

    @When("^I clear password field$")
    public void clearPasswordField() {
        driver.findElement(By.xpath(Helper.passwordXpath)).clear();
    }

    @Then("^confirm password field disabled$")
    public void confirmPasswordFieldDisabled() {
        Assert.assertFalse(driver.findElement(By.xpath(Helper.confirmPasswordXpath)).isEnabled());
    }

    @When("^I select two elements \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectTwoElements(String first, String second) {
        //Select select = new Select(driver.findElement(By.xpath(Helper.carMakeXpath)));

        String firstPath = String.format(Helper.carMakeXpath + "/option[@value='%1$s']", first);
        String secondPath = String.format(Helper.carMakeXpath + "/option[@value='%1$s']", second);

        (new Actions(driver)).keyDown(Keys.COMMAND);
        driver.findElement(By.xpath(firstPath)).click();
        driver.findElement(By.xpath(secondPath)).click();
    }

    @Then("^both elements selected$")
    public void bothElementsSelected() {
        Select select = new Select(driver.findElement(By.xpath(Helper.carMakeXpath)));
        Assertions.assertThat(select.getAllSelectedOptions().size()).isEqualTo(2);
    }

    @When("^I click on date of birth$")
    public void clickOnDateOfBirth() {
        driver.findElement(By.xpath(Helper.dateOfBirthXpath)).click();
    }

    @When("^I set year (\\d+)$")
    public void setYear(int year) {
        String path = String.format(Helper.yearXpath + "/option[@value='%1$d']", year);
        driver.findElement(By.xpath(path)).click();
    }

    @When("^I set month \"([^\"]*)\"$")
    public void setMonth(String month) {
        String path = String.format(Helper.monthXpath + "/option[@value='%1$d']", Helper.getNumberOfMonth(month));
        driver.findElement(By.xpath(path)).click();
    }

    @When("^I set day (\\d+)$")
    public void setDay(int day) {
        String path = String.format(Helper.dayXpath + "//a[text()='%1$d']", day);
        driver.findElement(By.xpath(path)).click();
    }

    @Then("^date of birth field contain text \"([^\"]*)\"$")
    public void dateOfBirthFieldContainText(String data) {
        driver.findElement(By.xpath(Helper.dateOfBirthXpath)).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Helper.selectedDataXpath)));

        WebElement element = driver.findElement(By.xpath(Helper.selectedDataXpath));
        String selectedDay = element.getText();

        element = driver.findElement(By.xpath(Helper.selectedDataXpath + "/.."));
        String selectedMonth = String.format("%1$d", Integer.parseInt(element.getAttribute("data-month")) + 1);
        String selectedYear = element.getAttribute("data-year");

        String selectedData = String.format("%1$s/%2$s/%3$s", selectedMonth, selectedDay, selectedYear);
        Assert.assertEquals(selectedData, data);
    }
}