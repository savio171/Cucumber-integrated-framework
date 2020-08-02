Feature: Login into Application 

Scenario: Positive test validation login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com/" site
And Click on login link in homepage and navigate to secure signin page
When User enters "tester99@gmail.com" and "123456" and logs in
Then Verify that user is successfully logged in