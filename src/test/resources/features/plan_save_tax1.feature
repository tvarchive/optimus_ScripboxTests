Feature: Advice on how to plan and save tax

  In order to save tax
  As a registered user and a working professional
  I want to get advice on how to plan and save tax
  so that I have a ton of money to spend at the end of the year

  Background:
    Given I login as a valid registered user with email mayank.gupta804@gmail.com and password dcba4321
    When I choose to plan and save tax
    Then I should be taken to "Plan and Save tax" page

  @taxable @fd
  Scenario: User taxable CTC
    Given I tap on "Let's get started"
    When I enter my CTC below 3 lakhs
    Then I should be told that I am not taxable and "Calculate Again" button should get activated

  @taxable
  Scenario: User taxable since CTC above specified limits
    Given I tap on "Let's get started"
    When I enter my CTC above 3 lakhs
    Then I should be shown my estimated tax


  @non-taxable @retirement
  Scenario: User not taxable since CTC below specified limits
    Given I tap on "Let's get started"
    When I enter my CTC below 3 lakhs
    Then I should be told that I am not taxable and "Calculate Again" button should get activated


  @sip @taxable
  Scenario: Taxable SIP
    Given I tap on "Let's get started"
    When I enter my CTC below 3 lakhs
    Then I should be told that I am not taxable and "Calculate Again" button should get activated
