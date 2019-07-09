@RunAll
Feature: Google Search
        As a user I should be able to search some shit in Google
 
 Scenario: Navigate to google and search something
 	Given Launch google.com
 	Then Enter the string "Serenity-Cucumber" in the search box
 	And Click search
 	Then Verify the output
 	And Click on wikipedia link and take a snapa
 	Then Click on Github link
 	Then Click on pom xml link
 	And Get content of the pom