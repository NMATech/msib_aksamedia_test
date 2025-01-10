@All
Feature: Edit User

  @editUser @positive
  Scenario Outline: Edit user's role
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click action button on user data that want to edit
    And User click edit button
    And User edit user's <role> to writer
    And User click update button
    Then User got <success> message

  Examples:
    | role | success |
    | writer | User has been updated |

  @editUser @negative
  Scenario Outline: Edit user's email with invalid email format
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click action button on user data that want to edit
    And User click edit button
    And User edit user's <email> with invalid email format
    And User click update button
    Then User got <error> email message

    Examples:
      | email | error |
      | test123@yaho.com | The email format does not acceptable. |

  @editUser @negative
  Scenario Outline: Edit user's name and username with number only
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click action button on user data that want to edit
    And User click edit button
    And User edit user's <name> and <username>
    And User click update button
    Then User got <error> form message

    Examples:
      | name  | username | error |
      | 69124 | 69124    | Name and Username should be contains alphabet. |

  @editUser @positive
  Scenario Outline: Edit user's profile with png file
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click action button on user data that want to edit
    And User click edit button
    And User edit user's profile
    And User click update button
    Then User got <success> message

    Examples:
      | success |
      | User has been updated |

  @editUser @negative
  Scenario Outline: Edit user's data with empty field form
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click action button on user data that want to edit
    And User click edit button
    And User fill form with empty data
    And User click update button
    Then User got <error> form message

    Examples:
      | error |
      | The name field is required. |