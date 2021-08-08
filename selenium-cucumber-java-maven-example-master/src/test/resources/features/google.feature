@RunAll
Feature: Google Search
        As a user I should be able to search some shit in Google
 
 Scenario: Navigate to google and search something
 	Given Launch google.com
 	Then Enter the string "cucumber" in the search box
 	And Click search
 	Then Verify the output
 	And Click on wikipedia link and take a snap
