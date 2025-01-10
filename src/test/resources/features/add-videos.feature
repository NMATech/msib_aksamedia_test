@All
Feature: Add video

  @addVideo @positive
  Scenario Outline: Add videos with valid data
    Given User is in aksamedia admin page
    When User login as admin
    And User click galleries menu on sidebar
    And User click video
    And User click add video button
    And User fill <title> video
    And User fill <desc> video desc
    And User fill <url> video link
    And User click save button
    Then User got <success> message

  Examples:
    | title | desc | url | success |
    | QA Engineer | Video QA | https://youtu.be/jC0h6qN7FR0?si=4IteV0B2RuXSJZij | Save Successfully |
    | ReactJS Tutorial | Ini adalah video tutorial reactjs | https://youtu.be/RJrffp8PkKA?si=GzUCFsPsHoLivzbM | Save Successfully |

  @addVideo @negative
  Scenario Outline: Add videos with empty title
    Given User is in aksamedia admin page
    When User login as admin
    And User click galleries menu on sidebar
    And User click video
    And User click add video button
    And User fill <desc> video desc
    And User fill <url> video link
    And User click save button
    Then User got <error> message

    Examples:
      | desc | url | error |
      | ini adalah video tutorial | https://youtu.be/w5swBq6h7gI?si=W13g77ZNT9rYsG39 | The title field is required. |

  @addVideo @negative
  Scenario Outline: Add videos with invalid link video format
    Given User is in aksamedia admin page
    When User login as admin
    And User click galleries menu on sidebar
    And User click video
    And User click add video button
    And User fill <title> video
    And User fill <desc> video desc
    And User fill <url> video link
    And User click save button
    Then User got <error> message

    Examples:
      | title | desc | url | error |
      | Google Video | search engine google | google.com | The url is not a valid URL. |

  @addVideo @negative
  Scenario Outline: Add videos with empty link form
    Given User is in aksamedia admin page
    When User login as admin
    And User click galleries menu on sidebar
    And User click video
    And User click add video button
    And User click save button
    Then User got <error> message

    Examples:
      | error |
      | The title field is required. |