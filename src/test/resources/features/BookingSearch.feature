Feature: Booking search tests

  Scenario Outline: Search hotels with rating
    Given I am on www.booking.com page
    When I set city "<searchValue>" into search bar
    And I click search button
    Then Should be present "<result>" with <index>
    Then Hotel with <index> should have been "<rating>"
    Examples:
      |searchValue|result|rating|index|
    |London|President Hotel|7.3|1|
    |London|CitySpace Tower Bridge|6.6|2|