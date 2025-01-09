@All @User
Feature: Add User

  @addUser @positive
  Scenario Outline: Add User with valid credentials
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click add user button
    And User fill <name>, <username>, <email>, <pass>, and <confirmPass>
    And User click create button
    Then User got success message

  Examples:
  | Ash Dyland | Ash | ash123@gmail.com | password123 | password123

  @addUser @negative
  Scenario Outline: Add User with invalid format email
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click add user button
    And User fill <name>, <username>, <email>, <pass>, and <confirmPass>
    And User click create button
    Then User got <error> email message

  Examples:
  | Dyland Pros | Dyland | dyland@yahoo.com | password123 | password123 | invalid format

  @addUser @negative
  Scenario Outline: Add User with mismatch password
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click add user button
    And User fill <name>, <username>, <email>, <pass>, and <confirmPass>
    And User click create button
    Then User got <error> password message

  Examples:
  | Maxhill William | Maxy | maxy123@gmail.com | pass1234 | pass12345 | missmatch password

  @addUser @negative
  Scenario Outline: Add User with password less than 8 char
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click add user button
    And User fill <name>, <username>, <email>, <pass>, and <confirmPass>
    And User click create button
    Then User got <error> password message

  Examples:
  | Simon Minter | Minter | simonn@gmail.com | mypas12 | mypas12 | less than 8 char

  @addUser @negative
  Scenario Outline: Add User with an email that already registered
    Given User is in aksamedia admin page
    When User login as admin
    And User click users menu on sidebar
    And User click users data
    And User click add user button
    And User fill <name>, <username>, <email>, <pass>, and <confirmPass>
    And User click create button
    Then User got <error> email message

  Examples:
  | TOby Dyland | Toby | ash123@gmail.com | pass1234 | pass1234 | already registered