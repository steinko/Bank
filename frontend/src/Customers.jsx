import React from 'react';
import {Component} from 'react';
import  {getCustomers} from './CustomersService'
export default class Customers extends Component {
	

	render() {
		const names = getCustomers()
		const listNames =  names.map((name) =>
                 <li key={name} >{name}</li>
		)
		return ( <div>
		           <h1 id="customers">Customers</h1>   
                   <ul>{listNames}</ul>
				 </div>
			   )
	 }

}