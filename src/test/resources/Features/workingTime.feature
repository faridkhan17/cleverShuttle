@ProductFeature
Feature: Clever Shuttle portal

  @TimerStartStop
  Scenario Outline: Add a product to the cart and login
    Given User opens the <url> Page
    When User logs in with the credentials <email> and <password>
    Then User should see the calendar view
    #When User clicks on the shift
    #Then User sees running shift at the given time
    #When User clicks the button to start the working time
    #Then User should see a timer
    #When User clicks the button to stop the working time
    #Then User should not see the timer

    Examples:
      | url                                             |  email                  | password     |
      | "https://cleverportal.test.clevershuttle.tech/" | "cityshuttleschedule30" | "qwertz123!" |
