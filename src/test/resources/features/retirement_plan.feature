Feature: Advice on how to plan for retirement

  In order to plan for my retirement
  As a registered user
  I want to get advice on how to plan and see how i am doing for my retirement
  so that I live peacefully after I get retired

  Background:
    Given I login as a valid registered user with email mayank.gupta804@gmail.com and password dcba4321
    When I choose to see "How am I doing for my retirement"
    Then I should be taken to "Retirement Readiness" page

  @retirement @taxable
  Scenario: User chooses to see how she is doing for her retirement
    Given I tap on "Let's get started" tab
    When I enter the required relevant details
    Then I should be given advice regarding my plan


  @mutualfund @sip
  Scenario: User chooses to see how she is doing in her mutual funds
    Given I tap on "Let's get started" tab
    When I enter the required relevant details
    Then I should be given advice regarding my plan


  @fd
  Scenario: User Fixed Deposits
    Given I tap on "Let's get started" tab
    When I enter the required relevant details
    Then I should be given advice regarding my plan