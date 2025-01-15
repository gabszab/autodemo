Scenario: As a default user I am able to click on "Click Me" button.
  When The user navigates to "Buttons" page
  And Scrolls down
  And Clicks on "Click Me" button
  Then "You have done a dynamic click" text message should be displayed