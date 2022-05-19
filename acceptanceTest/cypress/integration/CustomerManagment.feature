Feature: Manage Customers
  Management of the banks customers
   
   Scenario: Display Customers
     Given that the bank is open
     And it contains customer with name "Stein Korsveien" and personId "26076144574"
     And it contains customer with name "Oddmund Korsveien" and personId "26076144554"
     When I acivate display customer 
     Then name "Stein Korsveien and personId "26076144574" is displayed in the Customer list
     And name "Oddmund Korsveien" and personId 26076144554" is displayed in the Customer list