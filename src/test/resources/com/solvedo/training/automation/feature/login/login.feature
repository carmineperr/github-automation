Feature: Login feature
	I want to use this file to test login

Scenario: Login with wrong user
Given I am in the application main page
When I navigate to login page
And I login in the application using wrong credentials
Then I get an error message