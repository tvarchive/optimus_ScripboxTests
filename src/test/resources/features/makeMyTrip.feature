Feature: Planning my trip

  In order to travel economically
  As a registered user and a frequent traveller
  I want to get advice on how to plan my trips
  so that my experience is wonderful

  Background:
    Given traveller on splash screen taps 2 times on moveToNextScreen
    And traveller on splash screen taps on skip
    And traveller on home screen taps 2 times on grantPermission
    And traveller on home screen navigates back

  @trip
  Scenario: generic step example
    When traveller on home screen taps on flights
    And traveller on flights screen taps on fromCity
    And traveller on citySelector screen types Delhi into city
    And traveller on citySelector screen taps on cityPicker
    And traveller on flights screen taps on class
    And traveller on class screen taps on economyClass
    And traveller on flights screen taps on departureDate
    And traveller on calendar screen taps on 9
    And traveller on calendar screen navigates back