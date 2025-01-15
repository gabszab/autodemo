Feature: Page elements

Scenario: As a default user I am able to click on "Click Me" button.
  Given The user is navigated to "Buttons" page
  When Scrolls down
  And Clicks on "Click Me" button
  Then "You have done a dynamic click" text message should be displayed