#I have added listeners and failed runner in testng.xml
#You can run the whole framework from testng.xml
#all the configs are present in configs/config.properties
#log4j will generate log file in build folder
#testrunner will genearte rerun.txt and failed runner will pick the failed scenarios from rerun.txt
@SportsTakAssignMent
Feature: Sportstak functionalities validations

  Scenario Outline: Validating and verifying the functionality of Sportstak
    Given Open the browser and enter SportsTak URL
    Then Click on each thumbnail and verify that links are not broken on Home
    And Click on "<tab>"
    Then scroll to the page "<PageNo>" and click on the links and verify the links are not broken.
    And Change the theme from "<Col1>" to "<Col2>".
    And Change the theme from "<Col3>" to "<Col4>".
    And Click on "<tab1>"
    And Capture the text on each Web Stories on page "<Page_number>".
    And Click on "<WebStoryNo>" webstory displayed.
    Then click on the next webstory and return to the homepage.

    Examples: 
      | tab     | PageNo | Col1  | Col2 | Col3 | Col4  | tab1        | Page_number | WebStoryNo |
      | Cricket |      3 | Light | Dark | Dark | Light | Web Stories |           1 |          1 |
