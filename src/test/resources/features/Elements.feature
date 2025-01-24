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

  Scenario: As a default user I am able to fill out a text form.
      Given The user is navigated to Text Box page
       When The user enters data to the given fields
        And Clicks on 'Submit' button
       Then The user is able to see the entered data under the input fields

  Scenario: As a default user I am able to click on both radio buttons.
      Given The user is navigated to Radio Buttons page
       When The user clicks on 'Yes' radio button
       Then The user sees an applied verifying message
       When The user clicks on 'Impressive' radio button
       Then The user sees another applied verifying message

  Scenario: As a default user I am able to add new entries to the Web Table.
      Given The user is navigated to Web Tables page
       When The users clicks on 'Add' button
        And The user adds new entries to the displayed fields of 'Registration Form' modal
       Then The new content gets added to the table content
