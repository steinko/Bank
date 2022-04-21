import  {getCustomers} from './CustomersService'
it.skip('should deliver custeomers', () => {
	expect(getCustomers()).toIncludeAllMembers(['Stein Korsveien', 'Oddmund Korsveien'])
})