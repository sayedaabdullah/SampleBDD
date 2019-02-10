Feature: Feature of problem-1
	Scenario Outline: Verify the right count of values appear on the screen
		Given User can go to values page
		And User can see all the values
		Then verify the value of entry 1 is "<value1>"
		And verify the value of entry 2 is "<value2>"
		And verify the value of entry 3 is "<value3>"
		And verify the value of entry 4 is "<value4>"
		And verify the value of entry 5 is "<value5>"
		Examples: 
		| 	value1 		| value2	| value3 		| value4		| value5	|
		| $122,365.24	| $599.00	| $150,139.99	| $23,329.50	| $566.27	|

	Scenario: Verify the values on the screen are greater than zero 	
		Given User can go to values page
		And User can see all the values
		Then verify all values are greater then zero

	Scenario: verify the total balance is correct based on the values listed on the screen
	    Given User can go to values page
	    And User can see all the values
	    Then Sum of all value should match the total value

	Scenario: Verify the values are formatted as currencies 
		Given User can go to values page
	    And User can see all the values
	    Then All values should be in currency format


