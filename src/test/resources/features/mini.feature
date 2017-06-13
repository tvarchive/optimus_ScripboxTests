Feature: Selection of departure time
  Select date

  @minicab
  Scenario: generic example
    Given user on home screen taps on departureTime
#    And user on date screen types 14 into day
#    And user on date screen types Aug into month
#    And user on date screen types 2018 into year
    And user on date screen sets day by tapping on decreaseDay or increaseDay until it is set to 08
#    And user on date screen sets month as August by tapping on decreaseMonth or increaseMonth until it is set
#    And user on date screen sets year as 2017 by tapping on decreaseYear or increaseYear until it is set