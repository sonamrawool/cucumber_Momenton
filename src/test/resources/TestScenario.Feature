Feature: order creation
  
  Scenario: place order
     
    Given Set testcase name to "PlaceOrder"
    And user  is on Homepage url "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/"
    When user is able to Login with username "Tester" and password "test"
    Then user is able to place order
    And user is able to update order
    And user is able to delete order
    And user is able to logout