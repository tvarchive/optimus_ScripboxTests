Feature: Advice on how to plan and save tax

  In order to save tax
  As a registered user and a working professional
  I want to get advice on how to plan and save tax
  so that I have a ton of money to spend at the end of the year

  Background:

  @not-taxable
  Scenario: User not taxable since CTC below specified limits
    Given I login as a valid registered user
#    When I choose to plan and save tax
#    Then I should be taken to "Plan and Save tax" page
#    And I tap on "Let's get started"
#    When I enter the relevant details
#    Then I should be told that I am not taxable and "Calculate Again" button should get activated

  @taxable
  Scenario: User taxable since CTC above specified  limits