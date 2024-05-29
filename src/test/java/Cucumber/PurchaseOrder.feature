
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use purchase the order from Ecommerce Website

	Background:
	Given I landed on Ecommerce page
	

  @Regression_cucumber
  Scenario Outline: Positive test of submitting the order 
    Given Logged in with <name> and <password>
    When I add the product <productName> to Cart
    And  Checkout <productName> and submit the order by selecting <countryName>
    Then "THANKYOU FOR THE ORDER." message is displayed in Confirmationpage

    Examples: 
      |name							|password			|productName	|countryName|
      |Efgh123@gmail.com|Selenium@123	|ZARA COAT 3	|Indi				|