Feature: Login Functionality

  In order to do online shopping
  As an AskOmDch user
  I want to login successfully

  Scenario: Login Successful

    Given I am on the Account page of AskOmDch website
    When I enter valid <username> and <password>
    Then I should be taken to Dashboard

  Scenario Outline: Login Unsuccessful with invalid credentials

    Given I am on the Account page of AskOmDch website
    When I enter "<username>" and "<password>"
    Then I should see an error "<message>"
    And I should remain on the Account page

    Examples:
      | username        | password     | message |
      | User101         | user12       | Error: The password you entered for the username User101 is incorrect. Lost your password?|
      | User111         | user123      | Error: The username User111 is not registered on this site. If you are unsure of your username, try your email address instead.|
      | User            | use123       | Error: The username User111 is not registered on this site. If you are unsure of your username, try your email address instead.|
