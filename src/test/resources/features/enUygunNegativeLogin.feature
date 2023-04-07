Feature: En Uygun Negative Login

  Background: common steps
    Given the user is on the "enUygunUrl" homepage
    When user clicks the sign up button

  Scenario: Can't login to the website with invalid information
    Then enters valid e-mail address
    And enters missing password
    And user clicks the second sign up button
    Then tests that it can't login to the website with the missing password
    And ends the page

    Scenario: Can't login with invalid email address
      Then enters an invalid email address
      And enters valid password
      And user clicks the second sign up button
      Then Tests that it can't login to the site with the wrong email
      And ends the page

      Scenario: Cant login to the website with an invalid facebook mail
        Then user clicks facebook sign up button
        And enters invalid facebook email address
        And enters facebook valid password
        And clicks facebook login button
        Then Tests that it can't login to the site with the wrong facebook email
        And ends the page

        Scenario: Cant login to the website with an invalid facebook password
          Then user clicks facebook sign up button
          And enters facebook valid e-mail address
          And enters invalid facebook password
          And clicks facebook login button
          Then Tests that it can't login to the site with the wrong facebook password
          And ends the page






