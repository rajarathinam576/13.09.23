Feature: Open Facebook page

  Background: Facebook url
    Given Load Facebook Url 
  Scenario: Facebook Login 
    Given user enter username and password
      | UserName | Password |
      |  8388686 | raju     |
    When Clik LoginButton
  Scenario: Facebook Newaccount 
    Given User click Create New Account
    And User enter FirstName and LastName
      | FirstName | LastName |
      | Raju      | A        |
    And User enter MobileNumber and Newpassword
      | MobileNum | 9876543217 |
      | Newpass   | rahhh      |
    And User enter Dob and Gender

  Scenario: Facebook ForgotPassword  
    Given User click ForgotPassword
    And User enter MobileNumber
    