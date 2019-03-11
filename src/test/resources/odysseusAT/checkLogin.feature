Feature: Check login page


  Scenario:  Homepage check incorrect credentials
    When open project page
    When click to LogIn link
    When click QA Arachne
    When login "daf" and password "das" Entered and submitted
    Then see message "Bad credentials"

  Scenario:  Homepage check correct credentials
    When open project page
    When click to LogIn link
    When click QA Arachne
    When login with correct credentionas as QA
    Then see success message
    Then close login window
    Then check authorise user as QA



