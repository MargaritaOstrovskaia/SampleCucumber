@run
Feature: test sample page

  Scenario: check error messages
    Given I open sample page
    When I click the submit button
    Then username error message should be presented
    Then name error message should be presented
    Then password error message should be presented
    Then email error message should be presented
    Then privacy error message should be presented

  Scenario: check accept privacy policy checkbox
    Given I open sample page
    When I click accept privacy policy
    Then accept privacy policy is checked

  Scenario: check input username field
    Given I open sample page
    When I click on username field
    Then username element should be presented
    When I type "margarita_ostrovskaia" to username

  Scenario: check input name field
    Given I open sample page
    When I click on name field
    When I type first name "Margarita"
    When I type middle name "V"
    When I type last name "Ostrovskaia"
    When I click the save button
    Then name field should contain text "Margarita V Ostrovskaia"

  Scenario: check country of origin dropdown menu
    Given I open sample page
    When I click on country of origin field
    When I choose "Russia" option
    Then country of origin field contain text "Russia"

  Scenario: check that Confirm Password field disabled
    Given I open sample page
    When I clear password field
    Then confirm password field disabled

  Scenario: check that we can select multiple car
    Given I open sample page
    When I select two elements "Toyota" and "BMW"
    Then both elements selected

  Scenario: check calendar
    Given I open sample page
    When I click on date of birth
    When I set year 1988
    When I set month "April"
    When I set day 30
    Then date of birth field contain text "4/30/1988"