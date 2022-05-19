import { Given,When, Then } from 'cypress-cucumber-preprocessor/steps'

Given('that the bank is open' , () =>   {
	
	cy.visit('/')
	
})

Given('it contains customer with name "Stein Korsveien" and personId "26076144574"', () =>  {
	cy.contains("26076144574")
})



Given('it contains customer with name {string} and personId {string}', (peronName,personId) => {
	
})

When ('I acivate display customer', () =>  {})

When('I want the create a customer with personId {string}' , (personId) => {

  cy.contains(personId)

})

Then('a savings account with the amount {int} is displayed', (amount) => {

  cy.contains(amount)

})

Then('a credit account with the amount {int} is displayed', (amount) => {

  cy.contains(amount)

})

Then('the personId  {string} is displayed ', (personId) => {

   cy.contans(personId)
})

Then ('name "Stein Korsveien and personId "26076144574" is displayed in the Customer list', ()=> {
	 cy.contains("26076144574")
	   })
Then (  'name "Oddmund Korsveien" and personId 26076144554" is displayed in the Customer list', ()=> {
	      cy.contains("26076144554")
	})

Then( 'name {string} and personId {string} is displayed in the Customer list', (personName,personId) => {
	cy.contains(personId)
})