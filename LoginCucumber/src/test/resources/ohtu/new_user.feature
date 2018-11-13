Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  valid username "vanamo" and password " alainen" are entered
        Then  system will respond with success message "new user registered"
    
    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  already taken username "pekka" and password "?alainen" are entered
        Then  system will inform "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  too short username "pe" and password "sala1nen" are entered
        Then  system says "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new user is selected
        When  valid username "esko" and too short password "esko981" are entered
        Then  system fails to create user "new user not registered"

    Scenario: creation fails with valid username and password enough long but consisting of only letters
        Given command new user is selected
        When  valid username "nella" and password with only letters "nellapii" are entered
        Then  system will say "new user not registered"

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" is created
        And   command login is selected
        When  username "eero" and password "salainen1" are entered
        Then  login is successful and system will respond with "logged in"