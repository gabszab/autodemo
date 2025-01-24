Feature: Page elements

  Scenario: As a default user I am able to double click on " Double Click Me" button.
      Given The user is navigated to Buttons page
       When The user double clicks on corresponding button
       Then 'You have done a double click' message is displayed

  Scenario: As a default user I am able to right click on "Right Click Me" button.
      Given The user is navigated to Buttons page
       When The user right clicks on corresponding button
       Then 'You have done a right click' message is displayed

  Scenario: As a default user I am able to click on "Click Me" button.
      Given The user is navigated to Buttons page
       When The user clicks on corresponding button
       Then 'You have done a dynamic click' message is displayed