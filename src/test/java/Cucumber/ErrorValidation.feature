
@tag
Feature: Error Validation
  I want to Validate the negetive scenarios

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Logged in with <name> and <password>
    Then "Incorrect email or password." message is displayed in ErrorPage

   Examples: 
      |name							|password			|
      |Efgh123@gmail.com|Selenium@	|