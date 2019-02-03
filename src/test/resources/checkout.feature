Feature: checkout items

As a shopper,
I want to be able to checkout items,
So that i can pay for the items i buy

	Background: 
		Given the following price list:
			| apple  | 1 |
			| milk   | 2 |
			| bread  | 1 |

	Scenario: checkout items
	
	This scenario is a positive basic case where the items have no special offers
	
		Given i have the following items in my basket:
			| apple | 3 |
			| milk  | 1 |
		When i checkout those items
		Then the total price of the items should be £4
		
	Scenario: checkout items (with special offers)
	
	This scenario take into account items that have special offers
	
		Given i have the following items in my basket:
			| apple | 3 |
			| milk  | 1 |
		And with the following special offers:
			| apple | 50% 					|
			| milk 	| 2 for the price of 1	|
		When i checkout the items
		Then the total price of the items with special offers applied should be £4