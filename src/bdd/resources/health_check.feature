Feature: Health Check
  Check the health of the whole system

  Scenario: GET the url for the health check
    When I perform a GET request to the health check url
    Then The application response with a 200 status code