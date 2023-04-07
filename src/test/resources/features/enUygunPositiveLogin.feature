Feature: En Uygun Positive Login

  Background: common steps
    Given the user is on the "enUygunUrl" homepage
    When user clicks the sign up button

  Scenario: User should be able to sign up to enuygun site
    Then enters valid e-mail address
    And enters valid password
    And user clicks the second sign up button
    Then tests that its logged into the site correctly
    And ends the page


    Scenario: the user should be able to sign up to the enuygun site with facebook
      Then user clicks facebook sign up button
      And enters facebook valid e-mail address
      And enters facebook valid password
      And clicks facebook login button
      Then tests that its logged into facebook correctly
      And ends the page






