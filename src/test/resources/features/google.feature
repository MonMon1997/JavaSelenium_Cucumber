Feature: Access Google

  @UAT
  Scenario Outline: User Enter Google and Search Keys
    Given User Nav to Google Main Page
    When User Click TextArea
    And User Enter the "<search Item>"
    And User Click Enter
    Then User Move to the new Search Page

    Examples:
      | search Item      |
      | All of the Light |
      | Kanye West       |
      | Rihanna          |

  @Regression
  Scenario: User Send Keys
    Given User Nav to Main Page
    When User Enter TextArea
    And User Enter TWICE
    Then User Should See the Results

