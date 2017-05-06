#Sample Feature Definition Template
@Flipkart @Men
Feature: Verify Shirt Module
  I want to use this template for my feature file

  @Flipkart @Men @Shirt @Size
  Scenario: Check the Size of T-Shirt
    Given Create firefox driver session
    And Open the website "http://flipkart.com" in firefox browser
    And Maximize the Window
    When We wait for 3000 millisecond
    And Keep the hover on "MEN" Tab
    And Click on "T-Shirts" Link
    And We wait for 3000 millisecond
    And Select the "S" Size from Size Section
    And We wait for 3000 millisecond
    And Click on "Highlander Men's Solid Casual Grey Shirt" from filtered Men T-Shirts Section
    And We wait for 6000 millisecond
    Then Verify the Size of T-Shirt should be "S"
    And Close the driver Session
